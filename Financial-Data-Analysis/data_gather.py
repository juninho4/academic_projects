# import libraries
import pandas as pd, yfinance as yf

# select assets and benchmark
TICKER = ["NVDA", "AMD", "INTC"]
BENCH  = ["QQQ"] 
TICKER = TICKER + BENCH

# 3 year period
end = pd.Timestamp.today().normalize()
start = end - pd.DateOffset(months=36)

# download adjusted close prices
df = yf.download(TICKER, start=start, end=end, interval="1d", auto_adjust=True)[["Close"]]

# flatten column names if multi-index
# i am not sure why the template appends an extra index on the columns
df.columns = [col if isinstance(col, str) else col[1] for col in df.columns]

# reset index to make Date a column
df = df.reset_index()

# sort values by date
df = df.sort_values("Date")

# forward fill and drop any NAs
df = df.ffill().dropna()

# compute returns
df_returns = df[TICKER].pct_change().rename(columns=lambda x: x+ "_Return")

# align return columns to match df
price_cols = df.columns[1:]
df_returns = df_returns[[col + "_Return" for col in price_cols]]

# concatting two datas
df = pd.concat([df, df_returns], axis=1)

# fill returns of the first row to 0
df.fillna(0, inplace=True)

# convert necessary variables to numeric
# consumes a lot of time despite values being numeric already
variables = TICKER + [t + "_Return" for t in TICKER]
for v in variables:
    df[v] = pd.to_numeric(df[v], errors='coerce')

# save files
df.to_csv("prices_clean.csv", index=False)

# ==============================
# TRANSFORMING QUANTITATIVE DATA
# ==============================

# compress wide-format returns into long format
long_df = df.melt(id_vars="Date", value_vars=[t + "_Return" for t in TICKER], var_name="Ticker", value_name="Return")

# clean ticker names
long_df["Ticker"] = long_df["Ticker"].str.replace("_Return", "")

# convert ticker to categorical variables
long_df["Ticker"] = long_df["Ticker"].astype("category")

# save files
long_df.to_csv("returns_long_format.csv", index=False)