# US Accidents Data Mining Project

A data mining project analysing the **US Accidents (2016–2023)** dataset from Kaggle. The project applies data preprocessing, association rule mining, classification, and clustering techniques to identify patterns and insights related to road accidents in the United States.

> This project was completed as part of my Bachelor of Information Technology coursework at James Cook University Singapore.

---

## Overview

The objective of this project was to perform an end-to-end data mining workflow on a real-world dataset.

The project covers:

- Data cleaning and preprocessing
- Exploratory data analysis
- Association Rule Mining (Apriori & FP-Growth)
- Classification models
- Clustering analysis
- Interpretation of results and business insights

---

## Dataset

**US Accidents (2016–2023)**

A nationwide traffic accident dataset containing millions of accident records collected from various traffic APIs across the United States.

**Source**

https://www.kaggle.com/datasets/sobhanmoosavi/us-accidents

### Dataset Information

- Millions of accident records
- Multiple years of historical data
- Weather information
- Road conditions
- Geographic information
- Traffic features
- Temporal information

For this coursework, a subset of the dataset was used to ensure the analyses could be completed within available computing resources.

---

## Project Workflow

### 1. Data Preprocessing

- Initial data inspection
- Missing value handling
- Removal of irrelevant features
- Datetime conversion
- Categorical encoding
- Feature scaling
- Data validation

---

### 2. Association Rule Mining

Algorithms used:

- Apriori
- FP-Growth

This stage discovers relationships between accident characteristics and identifies frequently occurring combinations of features.

---

### 3. Classification

Machine learning models:

- K-Nearest Neighbours (KNN)
- Random Forest

Performance was evaluated using confusion matrices and standard classification metrics.

---

### 4. Clustering

Algorithms used:

- K-Means
- DBSCAN

These models were used to identify natural groupings within accident records.

---

## Technologies

- Python
- Jupyter Notebook
- Pandas
- NumPy
- Matplotlib
- Scikit-learn
- mlxtend

---

## Repository Structure

```
.
├── cp3403-5634-project-v2025a.ipynb
└── README.md
```

---

## Skills Demonstrated

- Data preprocessing
- Feature engineering
- Data cleaning
- Association Rule Mining
- Classification
- Clustering
- Machine Learning
- Data visualization
- Statistical analysis

---

## Results

This project demonstrates an end-to-end data mining pipeline on a large real-world dataset, including:

- Preparing raw data for analysis
- Discovering relationships using Association Rule Mining
- Predicting outcomes using supervised learning
- Identifying hidden patterns through clustering
- Interpreting findings to generate meaningful insights

---

## Disclaimer

This project was completed for academic purposes as part of coursework at James Cook University Singapore.

The dataset belongs to its original authors and is available through Kaggle.

---

## References

Moosavi, S. (2023). *US Accidents (2016–2023)*. Kaggle.

https://www.kaggle.com/datasets/sobhanmoosavi/us-accidents