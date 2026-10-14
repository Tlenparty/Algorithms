# Algorithms

Custom implementations of classic data structures and algorithms in Java,
without using the built-in collections. Each package is a separate topic with its
own `Main` for demonstration.

## Contents

| Package | What is implemented |
|---------|---------------------|
| `arrays` | Dynamic array `MyArrayList`: bubble sort, selection sort and insertion sort with timing; `MySortedArrayList` with sorted insertion and binary search |
| `stacks` | Array-based stack, queue, deque and priority queue; bracket matching check, reversing an input string with a stack |
| `lists` | Singly and doubly linked lists with an iterator; linked-list-based stack and queue |
| `recursion` | Recursion: factorial, Fibonacci, triangular numbers, exponentiation (including negative exponents); knapsack problem (greedy and recursive brute force) |
| `trees` | Binary search tree `MyTreeMap` with a balance check; experiment: the share of balanced trees among 10,000 random trees |
| `graphs` | Adjacency-list graph, depth-first and breadth-first path search |

## Build and run

Requires JDK 11+.

```bash
javac -encoding UTF-8 -d out $(find src -name '*.java')
java -cp out graphs.Main
```
