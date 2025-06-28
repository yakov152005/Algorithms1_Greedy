# Algorithms 1 – Assignment 3

**Semester B • Second Year • B.Sc. in Computer Science**

**Instructor: Dr. Paul Avrahami**

---

## Overview

This assignment explores greedy algorithms and their limitations. You will implement two problems:

1. **Coin Change Problem** – Demonstrates where a greedy algorithm fails and a dynamic programming (DP) solution succeeds.
2. **Word Wrapping (Line Breaking) Problem** – Finds the optimal way to split a list of words into lines of limited length, minimizing the penalty.

---

## Question 1 – Coin Change Problem

**Goal:** Show a case where the greedy algorithm does not produce the optimal solution and compare it with a DP solution.

### Example Input:

```
Enter The size of arr: 3
Enter value of coin 1 : 1
Enter value of coin 2 : 6
Enter value of coin 3 : 10
Enter the amount to be changed: 12
```

### Output:

```
Min coins for greedy: 3
Min coins for Dp: 2
```

### Explanation:

* The greedy algorithm picks the largest coins first (10 + 1 + 1 = 3 coins).
* The DP algorithm finds the optimal combination (6 + 6 = 2 coins).

### Edge Case Demonstrated:

Greedy fails because it makes local optimal choices (largest coin), while the global minimum uses a smarter combination.

---

## Question 2 – Word Wrapping Problem

**Goal:** Break a sequence of words into lines of length at most `L` such that the total penalty is minimized. The penalty of a line of length `K` is `L - K`.

### Constraints:

* Words cannot be reordered.
* No line can exceed length `L`.
* The algorithm should return the minimum total penalty.

### Example Input (hardcoded):

```java
String[] words = {"I", "love", "dynamic", "programming"};
int L = 15;
```

### Output:

```
Penalty using greedy: 5
Penalty using dynamic programming: 5
```

### Explanation:

In this specific example, both greedy and DP yield the same penalty. However, in general, DP guarantees the optimal penalty using subproblem structure and recursion with memoization.

---

## Code Files

* `QuestionOne.java`: Implements the coin change comparison between Greedy and DP.
* `QuestionTwo.java`: Implements word wrapping using both Greedy and DP strategies.

---

## Time Complexities

### Coin Change:

* **Greedy:** `O(n)` worst-case (if `n` coins are used).
* **DP:** `O(n * amount)` – iterates over all coins for every amount up to target.

### Word Wrapping:

* **Greedy:** `O(n)` – one pass through the words.
* **DP:** `O(n^2)` – examines all word break combinations using nested loops.

---

## How to Compile and Run

```bash
javac QuestionOne.java
java QuestionOne

javac QuestionTwo.java
java QuestionTwo
```

---

## Author

| Name           | Contribution                               |
| -------------- | ------------------------------------------ |
| Yakov Ben-Hamo | Full implementation, testing, and write-up |

---

## Notes

* The assignment demonstrates the importance of understanding when greedy algorithms fail.
* In both problems, dynamic programming provides a reliable and optimal alternative.
* The structure and logic align with the course material on greedy algorithms and optimization problems.
