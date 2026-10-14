# Object-Oriented Programming in Java — Lab 9: Nested Types, Enums, Records and the Object Contract

**Author:** Divine Mark Makhomeya  
**Registration Number:** H250333E  
**Course:** Object Oriented Programming  


This repository contains my solutions for **Lab 9** of the OOP in Java lab manual.
The lab covers the four kinds of nested classes, enums with fields and methods,
records, and the `equals`/`hashCode`/`toString` contract.

## Lab Objectives
- Distinguish static nested, inner (member), local, and anonymous classes.
- Model fixed sets of constants with `enum`, including fields, constructors and methods.
- Create immutable data carriers with `record`.
- Override `equals`, `hashCode` and `toString` correctly and explain why they must be consistent.

## Exercises

### Exercise 1: `Level` Enum and Advice Switch
- `enum Level { LOW, MEDIUM, HIGH }`.
- A switch expression prints advice for each level.
- Demonstrates exhaustive switch checking by the compiler.

**Expected Output:**
LOW -> Relax, everything is fine
MEDIUM -> Keep an eye on things
HIGH -> Take immediate action

### Exercise 2: `record Student(String name, int age)`
- Record generates constructor, accessors, `equals`, `hashCode`, `toString`.
- Demonstrates value equality vs reference equality.
- Shows accessors are named after components (`name()`, not `getName()`).

**Expected Output:**
s1: Student[name=Tariro, age=21]
s1.equals(s2): true
s1.equals(s3): false
s1 == s2: false
s1.name(): Tariro
s1.age(): 21

### Exercise 3: `Book` with `equals`/`hashCode` by ISBN
- `equals` and `hashCode` both use the `isbn` field.
- A `HashSet<Book>` rejects a duplicate ISBN.

**Expected Output:**
add b1: true
add b2: false
add b3: true
Library size: 2
Book[978-0132350884 "Clean Code"]
Book[978-0134685991 "Effective Java"]

### Exercise 4: `LinkedList<T>` with Static Nested `Node` and Inner `Iterator`
- `Node<T>` is a static nested helper class.
- `LinkedListIterator` is an inner class that reads the outer's `head` field.
- The list implements `Iterable<T>` so it works in a for-each loop.

**Expected Output:**
Size: 3
Contents: alpha beta gamma

### Exercise 5: `Coin` Enum — Fewest Coins
- Enum with a `cents` field and private constructor.
- Greedy algorithm iterates `Coin.values()` in declaration order (largest first).

**Expected Output:**
Amount: 87 cents
QUARTER x3
DIME x1
PENNY x2

Amount: 41 cents
QUARTER x1
DIME x1
NICKEL x1
PENNY x1

Amount: 6 cents
NICKEL x1
PENNY x1


## Files
- `LevelAdvice.java` — Exercise 1
- `RecordDemo.java` — Exercise 2
- `BookSetDemo.java` — Exercise 3
- `LinkedListDemo.java` — Exercise 4
- `CoinChange.java` — Exercise 5
