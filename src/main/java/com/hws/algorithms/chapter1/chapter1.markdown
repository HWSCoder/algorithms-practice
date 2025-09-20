# Algorithms (Princeton) – Chapter 1 Summary

## Overview
- Chapter 1 introduces fundamental data structures and abstract data types (ADTs).
- Focus on **API design**, **implementation choices**, and **performance analysis**.
- Key structures studied: **Stack**, **Queue**, **Deque**, **Union-Find**.

---

## Stack
- Implemented with **arrays** and **linked lists**.
- Core operations:
    - `push(item)`
    - `pop()`
    - `peek()`
    - `isEmpty()`
    - `size()`

**Array-based stack**
- Fast access, requires resizing when full.

**Linked-list stack**
- No resizing needed, but more memory overhead.

---

## Queue
- Implemented with **linked lists**.
- Core operations:
    - `enqueue(item)` → insert at tail
    - `dequeue()` → remove from head
    - `peek()`
    - `isEmpty()`
    - `size()`

---

## Deque (Double-Ended Queue)
- Implemented with **doubly linked lists**.
- Supports operations at both ends:
    - `pushLeft(item)` / `pushRight(item)`
    - `popLeft()` / `popRight()`

---

## Josephus Problem
- A classical elimination problem.
- Can be solved by:
    - **Linked lists** (simulate a circle)
    - **Queues** (rotation)
- Demonstrates connections between **circular structures** and **modular arithmetic**.

---

## Iterators
- Provide a safe way to traverse data structures without destroying them.
- Difference from competitive programming style:
    - In LeetCode-like problems → often traverse with `pop()`/`dequeue()`.
    - In API design → iterator is preferred for clean, reusable traversal.

---

## Union-Find (Dynamic Connectivity)

### Core API
- `find(p)` → root of `p`
- `union(p,q)` → connect `p` and `q`
- `connected(p,q)` → check if same component
- `count()` → number of components

### Key Insight
> **My own realization**:  
> In Quick-Union, the **array index = node**, and the **array value = parent of that node**.  
> A root is a node where `id[p] == p`.

---

### Implementations

#### 1. Quick-Find
- `find(p)` → O(1)
- `union(p,q)` → O(n) (scan entire array)
- Total complexity with m operations: **O(m·n)**, quadratic when m≈n.

#### 2. Quick-Union
- Represent components as **trees**.
- `find(p)` → follow parent links until `id[p] == p`.
- Problem: Trees can become very tall → worst case with m operations O(n*m) because find in Quick-Union can degenerate into a linked list situation
#### 3. Weighted Quick-Union
- Always attach smaller tree to larger tree.
- Guarantees height ≤ log n.
- Complexity: O(m log n).

#### 4. Weighted Quick-Union + Path Compression
- During `find`, make nodes point directly to the root (flatten the tree).
- Nearly constant-time operations: O(m α(n)), where α(n) is inverse Ackermann function. Almost O(1)
