# PolynomialSolver

## Description
PolynomialSolver is a Java program that dynamically evaluates polynomials from JSON input files. The program reads roots from a JSON file with varying bases, handles missing or non-consecutive keys, and calculates the polynomial value at a specified `x_value`. The output is always a positive constant.

This project demonstrates:
- Reading and parsing JSON in Java
- Handling numbers in different bases
- Using BigInteger for large integer arithmetic
- Dynamic computation without hardcoding values

---

## Features
- Accepts JSON input with roots in any base
- Automatically handles missing keys
- Evaluates polynomial `(x - r1)*(x - r2)*...*(x - rn)`
- Supports very large numbers using BigInteger
- Outputs only the evaluated constant (positive)

