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

---

## Input JSON Format
Example:

```json
{
    "keys": { "n": 4, "k": 3 },
    "1": { "base": "10", "value": "4" },
    "2": { "base": "2", "value": "111" },
    "3": { "base": "10", "value": "12" },
    "6": { "base": "4", "value": "213" },
    "x_value": "2"
}
keys.n : number of roots in JSON

keys.k : minimum roots required for polynomial (not used in calculation)

Each numbered key represents a root with base and value

x_value : the x at which to evaluate the polynomial

How to Run
Compile the Java program:

bash
Copy code
javac -cp ".;json-20210307.jar" PolynomialSolver.java
Run the program with your JSON input file:

bash
Copy code
java -cp ".;json-20210307.jar" PolynomialSolver input1.json
Output will be the evaluated polynomial value at x_value.

Test Cases
Test Case 1
input1.json

json
Copy code
{
    "keys": { "n": 4, "k": 3 },
    "1": { "base": "10", "value": "4" },
    "2": { "base": "2", "value": "111" },
    "3": { "base": "10", "value": "12" },
    "6": { "base": "4", "value": "213" },
    "x_value": "2"
}
Output: 3700

Test Case 2
input2.json

json
Copy code
{
  "keys": { "n": 10, "k": 7 },
  "1": { "base": "6", "value": "13444211440455345511" },
  "2": { "base": "15", "value": "aed7015a346d635" },
  "3": { "base": "15", "value": "6aeeb69631c227c" },
  "4": { "base": "16", "value": "e1b5e05623d881f" },
  "5": { "base": "8", "value": "316034514573652620673" },
  "6": { "base": "3", "value": "2122212201122002221120200210011020220200" },
  "7": { "base": "3", "value": "20120221122211000100210021102001201112121" },
  "8": { "base": "6", "value": "20220554335330240002224253" },
  "9": { "base": "12", "value": "45153788322a1255483" },
  "10": { "base": "7", "value": "1101613130313526312514143" },
  "x_value": "2"
}
Output: Positive evaluated constant

Dependencies
json-20210307.jar : JSON parsing library

Java 8+ (BigInteger required)

Author
Mani Chandrika Charugundla

yaml
Copy code
