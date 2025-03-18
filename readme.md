# Java Functional Programming Concepts

This project demonstrates various functional programming concepts and patterns in Java, focusing on modern Java features and best practices.

## 🚀 Project Overview

This codebase serves as a comprehensive reference for functional programming concepts in Java, including:

-   Functional Interfaces
-   Stream API
-   Method References
-   Behavior Parameterization
-   Parallel Stream Processing
-   Custom Functional Operations

## 📚 Core Concepts

### 1. Functional Interfaces

-   **Predicate**: Takes input and returns boolean
    ```java
    Predicate<Integer> isEven = x -> x % 2 == 0;
    ```
-   **Function**: Takes input and returns output
    ```java
    Function<Integer, Integer> square = x -> x * x;
    ```
-   **Consumer**: Takes input but returns nothing
    ```java
    Consumer<Integer> printer = System.out::println;
    ```
-   **Supplier**: Takes no input but returns value
    ```java
    Supplier<Integer> random = () -> new Random().nextInt(1000);
    ```
-   **BinaryOperator**: Takes two inputs of same type and returns same type
    ```java
    BinaryOperator<Integer> sum = (x, y) -> x + y;
    ```

### 2. Stream API Operations

-   **Intermediate Operations**

    -   `filter()`: Filter elements based on predicate
    -   `map()`: Transform elements
    -   `flatMap()`: Flatten nested structures
    -   `sorted()`: Sort elements
    -   `distinct()`: Remove duplicates
    -   `limit()`: Limit number of elements
    -   `skip()`: Skip elements
    -   `takeWhile()`: Take elements until predicate is false
    -   `dropWhile()`: Drop elements until predicate is false

-   **Terminal Operations**
    -   `forEach()`: Perform action on each element
    -   `collect()`: Collect results into collection
    -   `reduce()`: Reduce stream to single value
    -   `count()`: Count elements
    -   `anyMatch()`, `allMatch()`, `noneMatch()`: Match operations
    -   `findFirst()`, `findAny()`: Find elements
    -   `min()`, `max()`: Find min/max elements

### 3. Method References

-   **Static Method Reference**: `ClassName::staticMethod`
-   **Instance Method Reference**: `instance::method`
-   **Constructor Reference**: `ClassName::new`
-   **Arbitrary Object Method Reference**: `ClassName::instanceMethod`

### 4. Behavior Parameterization

-   Passing behavior as parameters
-   Enables flexible and reusable code
-   Example:
    ```java
    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
    ```

### 5. Parallel Stream Processing

-   Enable parallel processing of streams
-   Use `parallel()` method
-   Example:
    ```java
    LongStream.range(0, 1000000000).parallel().sum()
    ```

### 6. Collectors

-   **Grouping**: `Collectors.groupingBy()`
-   **Counting**: `Collectors.counting()`
-   **Mapping**: `Collectors.mapping()`
-   **Max/Min**: `Collectors.maxBy()`, `Collectors.minBy()`

## 🎯 Best Practices

1. **Lazy Evaluation**

    - Stream operations are lazy until terminal operation is called
    - Enables efficient processing of large datasets

2. **Immutability**

    - Prefer immutable collections and objects
    - Use `List.of()` for immutable lists

3. **Method References**

    - Use method references over lambda expressions when possible
    - Improves code readability

4. **Parallel Processing**
    - Use parallel streams for computationally intensive operations
    - Consider overhead of parallelization for small datasets

## 📝 Quick Reference

### Common Stream Patterns

```java
// Filter and map
list.stream()
    .filter(x -> x > 0)
    .map(x -> x * 2)
    .collect(Collectors.toList());

// Group by
list.stream()
    .collect(Collectors.groupingBy(Function::apply));

// Reduce
list.stream()
    .reduce(initialValue, BinaryOperator::apply);
```

### Functional Interface Examples

```java
// Predicate
Predicate<String> isEmpty = String::isEmpty;

// Function
Function<String, Integer> length = String::length;

// Consumer
Consumer<String> print = System.out::println;

// Supplier
Supplier<String> newString = String::new;
```

## 📚 Additional Resources

-   [Java Stream API Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
-   [Java Functional Interfaces](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
-   [Java Method References](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html)
