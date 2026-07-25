# Portfolio Analytics Using Statistical Learning

A financial data analytics project that applies statistical analysis and machine learning techniques to analyze stock market returns using historical market data. The project explores relationships between market variables through hypothesis testing, regression analysis, and classification models.

> This project was completed as part of my Bachelor of Information Technology coursework at James Cook University Singapore.

---

## Overview

This project investigates historical stock market behaviour by applying multiple statistical and machine learning techniques to real financial data collected from Yahoo Finance.

Using Python and various data science libraries, the project demonstrates an end-to-end analytics workflow including:

- Data collection
- Data preprocessing
- Exploratory data analysis
- Statistical hypothesis testing
- Regression modelling
- Classification
- Result interpretation

---

## Dataset

Historical stock price data was collected directly from **Yahoo Finance** using the `yfinance` Python library.

The analysis primarily focuses on:

- NVIDIA (NVDA)
- AMD
- Intel (INTC)
- NASDAQ-100 ETF (QQQ) as the benchmark

Additional macroeconomic indicators include:

- VIX (Market Volatility)
- Oil Prices
- US Treasury Bond ETF
- US Dollar Index ETF

---

## Project Structure

| Notebook | Description |
|----------|-------------|
| Task 1 | One-Way ANOVA |
| Task 2 | Chi-Square Test of Independence |
| Task 3 | Simple Linear Regression |
| Task 4 | Multiple Linear Regression |
| Task 5 | Polynomial Regression |
| Task 6 | Logistic Regression |

---

## Statistical Techniques

### One-Way ANOVA

Investigates whether average stock returns differ significantly across different days of the trading week.

Topics covered:

- Hypothesis testing
- F-statistic
- p-value
- Effect size (η²)
- Boxplot visualization

---

### Chi-Square Test

Examines whether the direction of daily stock movement (Up/Down) is independent of the day of the week.

Topics covered:

- Contingency tables
- Expected frequencies
- Chi-Square statistic
- p-value

---

### Simple Linear Regression

Builds regression models to examine relationships between individual stock returns and benchmark market returns.

Metrics evaluated include:

- R²
- Mean Squared Error (MSE)
- Root Mean Squared Error (RMSE)

---

### Multiple Linear Regression

Expands the regression model by incorporating macroeconomic indicators such as market volatility and economic factors.

The objective is to evaluate how multiple variables jointly influence stock returns.

---

### Polynomial Regression

Applies second-degree polynomial regression to capture potential non-linear relationships in stock price movements.

---

### Logistic Regression

Predicts whether a stock will close higher or lower based on selected market variables.

Model evaluation includes:

- Classification accuracy
- Confusion matrix
- Probability estimation

---

## Technologies

- Python
- Jupyter Notebook
- Pandas
- NumPy
- Matplotlib
- Seaborn
- Scikit-learn
- Statsmodels
- SciPy
- yfinance

---

## Skills Demonstrated

- Financial Data Analysis
- Data Cleaning
- Feature Engineering
- Statistical Hypothesis Testing
- Regression Analysis
- Classification
- Data Visualization
- Machine Learning
- Exploratory Data Analysis (EDA)
- Python Programming

---

## Key Learning Outcomes

Throughout this project, I gained practical experience in:

- Collecting financial market data using APIs
- Performing statistical hypothesis testing
- Building predictive regression models
- Applying classification techniques
- Interpreting statistical significance
- Visualizing financial datasets
- Communicating analytical findings

---

## Disclaimer

This repository contains coursework completed as part of my Bachelor of Information Technology at James Cook University Singapore.

The project is intended for educational purposes only and should not be interpreted as financial or investment advice.

---

## References

- Yahoo Finance — Historical Market Data
- yfinance Python Library
- Pandas Documentation
- Statsmodels Documentation
- Scikit-learn Documentation