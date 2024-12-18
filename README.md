# Truth Table Generator

This Java program generates truth tables for logical formulas involving one, two, or three variables. It supports logical operators like conjunction (`^`), disjunction (`v`), and negation (`~`), and ensures valid formula parsing.

## Features

The program provides a structured and efficient way to analyze logical formulas by generating their truth tables. It includes:

- **Single Variable Support**:
  - Logical negation (`~p`).
- **Two Variables Support**:
  - Conjunction (`p ^ q`).
  - Disjunction (`p v q`).
  - Negation of one or both variables (`~p ^ q`, `p v ~q`).
- **Three Variables Support**:
  - Combination of conjunctions and disjunctions (`p ^ q v r`, `~p v q ^ r`).
  - Negations and nested expressions.

## How It Works

1. **Input Formula Parsing**: The program validates the logical formula provided and determines the number of variables (one, two, or three).
2. **Truth Table Generation**: Based on the formula, it calculates all possible truth values and their corresponding results.
3. **Output Display**: The truth table is printed to the console in a clear and readable format.

### Supported Operators

- **Conjunction (`^`)**: Logical AND.
- **Disjunction (`v`)**: Logical OR.
- **Negation (`~`)**: Logical NOT.

### Sample Input and Output

#### Input Formula:
```java
p ^ q
```

#### Input Formula:
```java
+---+---+---+
| p | q | p^q |
+---+---+---+
| T | T |  T  |
| T | F |  F  |
| F | T |  F  |
| F | F |  F  |
+---+---+---+
```

## Cloning the Repository

To get started, clone the repository:

```bash
git clone https://github.com/ThomasFrentzel/Truth-Table-Generator
```

Modify the main method in TruthTable to test different formulas. For example:

```bash
public static void main(String[] args) {
    TruthTable table = new TruthTable();
    table.oneVariableTable("~p");
    table.twoVariableTable("p^q");
    table.threeVariableTable("p^q^r");
}

```
## Authors

- [Thomas Frentzel](https://github.com/ThomasFrentzel)
- [Théo César](https://github.com/theocesar)

