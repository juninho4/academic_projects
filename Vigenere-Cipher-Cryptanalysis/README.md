# Vigenère Cipher Cryptanalysis

A Python implementation of classical cryptanalysis techniques used to decrypt a Vigenère cipher without prior knowledge of the encryption key. The project combines statistical analysis and frequency-based attacks to recover the key and decrypt an encrypted message.

> This project was completed as part of my Bachelor of Information Technology coursework at James Cook University Singapore.

---

## Overview

The objective of this project was to break a Vigenère cipher using classical cryptographic analysis rather than brute force.

The project demonstrates how statistical methods can be used to infer the encryption key, ultimately recovering the original plaintext from an encrypted message.

The workflow follows the same approach used by historical cryptanalysts before the advent of modern computing.

---

## Features

- Ciphertext preprocessing
- Kasiski Examination
- Index of Coincidence (IoC)
- Chi-Square frequency analysis
- Key recovery
- Vigenère decryption
- Statistical analysis using Python

---

## Cryptanalysis Workflow

### 1. Ciphertext Validation

Before analysis, the ciphertext is cleaned by:

- Removing non-alphabetic characters
- Converting all text to uppercase
- Verifying input consistency

---

### 2. Kasiski Examination

Repeated character sequences are identified to estimate the probable key length.

The implementation:

- Searches repeated 3–5 character sequences
- Computes distances between repeated sequences
- Uses the Greatest Common Divisor (GCD) to identify likely key lengths

---

### 3. Index of Coincidence (IoC)

Several candidate key lengths are evaluated by computing the average Index of Coincidence for each.

This helps determine which candidate most closely resembles normal English text.

---

### 4. Chi-Square Analysis

Each key position is treated as an independent Caesar cipher.

For every possible letter shift:

- Letter frequencies are calculated
- Chi-Square statistics are computed
- The lowest Chi-Square value is selected as the most probable key character

---

### 5. Decryption

After recovering the encryption key, the ciphertext is decrypted using the Vigenère decryption formula:

```
Di = Ci − Ki (mod 26)
```

The recovered plaintext is then reconstructed into readable English.

---

## Technologies

- Python
- Jupyter Notebook
- NumPy
- Collections
- Math
- Matplotlib (optional visualization)

---

## Skills Demonstrated

- Classical Cryptography
- Cryptanalysis
- Frequency Analysis
- Statistical Analysis
- Algorithm Design
- Python Programming
- Data Processing
- Problem Solving

---

## Learning Outcomes

Through this project, I gained practical experience in:

- Understanding the Vigenère cipher
- Implementing statistical cryptanalysis techniques
- Applying frequency analysis
- Recovering encryption keys without brute force
- Translating mathematical concepts into Python algorithms
- Debugging and validating cryptographic implementations

---

## Results

The implemented cryptanalysis pipeline successfully:

- Estimated the encryption key length
- Recovered the encryption key using statistical analysis
- Decrypted the ciphertext into readable English

This project demonstrates how classical encryption methods can be broken using mathematical and statistical techniques rather than exhaustive search.

---

## Disclaimer

This repository contains coursework completed as part of my Bachelor of Information Technology at James Cook University Singapore.

The project is intended for educational purposes to demonstrate classical cryptography and cryptanalysis techniques.