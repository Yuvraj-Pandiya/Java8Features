# Stream API - Revision Notes

## Topic Overview

- **Definition**: A **Stream** in Java (`java.util.stream.Stream<T>`) is a sequence of elements supporting sequential and parallel aggregate operations. Introduced in Java 8, it provides a functional programming layer over collections and data sources.
- **Why it is used**:
  - Allows declarative processing of collections (focusing on *what* to do rather than *how* to do it).
  - Significantly reduces code length (replacing 8-10 lines of explicit loops/conditionals with concise 1-2 line pipelines).
  - Supports pipeline optimization through **Lazy Evaluation**.
  - Provides built-in support for parallel execution (`parallelStream()`) without low-level thread management.

---

## Important Rules

1. **Streams Do Not Store Data**:
   - A stream is **not** a data structure. It does not store elements in memory; it carries elements from a source (Collection, Array, I/O channel) through a computational pipeline.

2. **Streams Do Not Modify the Source**:
   - Stream operations are functional in nature. Processing a stream produces a result or a new stream without altering the original underlying data source.

3. **Single-Pass (Consumable Only Once)**:
   - A stream can be traversed and operated upon **only once**. Attempting to reuse a stream after a terminal operation triggers `IllegalStateException: stream has already been operated upon or closed`.

4. **Lazy Evaluation**:
   - Intermediate operations (e.g., `filter`, `map`) are **lazy**. They are not executed when defined; execution occurs only when a **Terminal Operation** (e.g., `collect`, `count`, `forEach`) is invoked.

5. **No Direct Index Access**:
   - Stream elements cannot be accessed randomly by index (like `list.get(i)`). Stream processing is sequential/pipeline-driven.

6. **Interference Avoidance**:
   - The data source backing a stream must not be modified during stream pipeline execution to prevent non-deterministic behavior or `ConcurrentModificationException`.

---

## Syntax

### Stream Pipeline Architecture
A Stream pipeline consists of three core phases:
1. **Source Creation**: Obtaining stream from Collection/Array.
2. **Intermediate Operations (0 or more)**: Configuring filters, transformations, and sorting.
3. **Terminal Operation (Exactly 1)**: Executing processing and producing output/result.

```java
import java.util.*;
import java.util.stream.*;

public class StreamSyntaxDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 13, 1, 5, 6, 68, 90, 97, 56);

        // Standard Stream Pipeline
        List<Integer> result = list.stream()               // 1. Stream Source
                                  .filter(i -> i % 2 == 0) // 2. Intermediate Op (Filter)
                                  .map(i -> i * 10)        // 2. Intermediate Op (Map)
                                  .sorted()                // 2. Intermediate Op (Sorted)
                                  .collect(Collectors.toList()); // 3. Terminal Op

        System.out.println(result);
    }
}
```

---

## Important Methods / Features

### 1. Intermediate Operations (Lazy - Return `Stream<T>`)

| Method | Argument | Purpose / Description |
| :--- | :--- | :--- |
| `filter(Predicate<T>)` | `Predicate<T>` | Filters elements based on a conditional boolean test. |
| `map(Function<T, R>)` | `Function<T, R>` | Transforms each element into another value/type. |
| `flatMap(Function<T, Stream<R>>)` | `Function` | Flattens nested streams/collections (1-to-many mapping). |
| `sorted()` | None | Sorts elements in **Default Natural Sorting Order** (`Comparable`). |
| `sorted(Comparator<T>)` | `Comparator<T>` | Sorts elements according to **Customized Sorting Order**. |
| `distinct()` | None | Removes duplicate elements (uses `equals()`). |
| `limit(long maxSize)` | `long` | Truncates stream to contain no more than `maxSize` elements. |
| `skip(long n)` | `long` | Discards first `n` elements of the stream. |

### 2. Terminal Operations (Eager - Produce Result or Cause Side-Effect)

| Method | Return Type | Purpose / Description |
| :--- | :--- | :--- |
| `collect(Collector)` | `R` (e.g., `List`, `Set`) | Accumulates elements into a collection using `Collectors`. |
| `count()` | `long` | Returns the total count of elements remaining in the stream. |
| `forEach(Consumer<T>)` | `void` | Performs an operation for each element (e.g., printing). |
| `min(Comparator<T>)` | `Optional<T>` | Returns the minimum element based on given comparator. |
| `max(Comparator<T>)` | `Optional<T>` | Returns the maximum element based on given comparator. |
| `toArray()` / `toArray(IntFunction)`| `Object[]` / `A[]` | Converts stream elements into an array. |
| `reduce(BinaryOperator)` | `Optional<T>` | Performs reduction on elements (e.g., sum, product). |
| `anyMatch(Predicate)` | `boolean` | Checks if any element matches predicate (short-circuiting). |
| `allMatch(Predicate)` | `boolean` | Checks if all elements match predicate. |
| `noneMatch(Predicate)` | `boolean` | Checks if no element matches predicate. |
| `findFirst()` | `Optional<T>` | Returns first element of the stream. |
| `findAny()` | `Optional<T>` | Returns any element from the stream. |

### 3. Static Methods for Stream Creation

- `Stream.of(T... values)`: Creates a stream from individual elements.
- `Stream.of(T[] array)`: Creates a stream from an array.
- `Arrays.stream(T[] array)`: Obtains a stream from an array.
- `Stream.empty()`: Returns an empty sequential stream.

---

## Key Concepts

### 1. Collection vs Stream

| Feature | Collection | Stream |
| :--- | :--- | :--- |
| **Primary Goal** | Data storage and memory management. | Data processing and computation. |
| **Data Retention** | Holds all data elements in memory at once. | Processes data on demand; does not store elements. |
| **Traversal** | Can be iterated multiple times (using for-each, Iterators). | Can be traversed **only once**. |
| **Evaluation** | Eagerly constructed (elements added before access). | Lazily evaluated (processed when terminal op is hit). |
| **Modification** | Elements can be added, modified, or removed. | Elements cannot be added or removed from stream directly. |

### 2. Filtering vs Mapping
- **`filter(Predicate)`**: Element count may decrease or stay same; element type remains unchanged.
- **`map(Function)`**: Element count remains exactly the same; element type can be transformed.

```java
// Filtering: filter even numbers
List<Integer> evens = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

// Mapping: add 5 grace marks to all students
List<Integer> updatedMarks = marks.stream().map(m -> m + 5).collect(Collectors.toList());
```

### 3. Natural vs Custom Sorting
- **`sorted()`**: Uses `Comparable` (`compareTo()` method). Requires elements to implement `Comparable`.
- **`sorted(Comparator)`**: Custom sorting using lambda or `Comparator`.

```java
// Descending Order using Lambda Comparator
List<Integer> sortedDesc = list.stream()
                               .sorted((i1, i2) -> i2.compareTo(i1))
                               .collect(Collectors.toList());

// Custom Comparator by String length
List<String> lenSorted = names.stream()
                             .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                             .collect(Collectors.toList());
```

### 4. Understanding `min()` and `max()` Logic
`min()` and `max()` require a `Comparator` argument and return an `Optional<T>`.

- **Ascending Order Comparator (`i1.compareTo(i2)`)**:
  - `min()` returns the **first/smallest** element.
  - `max()` returns the **last/largest** element.
- **Descending Order Comparator (`-i1.compareTo(i2)` or `i2.compareTo(i1)`)**:
  - `min()` returns the **largest** element.
  - `max()` returns the **smallest** element.

```java
List<Integer> nums = Arrays.asList(10, 0, 15, 25, 5, 20);

Integer minVal = nums.stream().min((i1, i2) -> i1.compareTo(i2)).get(); // Output: 0
Integer maxVal = nums.stream().max((i1, i2) -> i1.compareTo(i2)).get(); // Output: 25
```

### 5. Collection to Array & Array to Stream Conversion

```java
// 1. List to Array using Constructor Reference
Integer[] arr = list.stream().toArray(Integer[]::new);

// 2. Array to Stream using Stream.of()
Stream.of(arr).forEach(System.out::println);
```

---

## Common Mistakes

1. **Reusing a Consumed Stream**:
   ```java
   Stream<Integer> s = list.stream();
   s.forEach(System.out::println);
   s.filter(i -> i > 10); // ❌ Throws IllegalStateException: stream has already been operated upon or closed
   ```

2. **Forgetting Terminal Operation**:
   ```java
   list.stream().filter(i -> {
       System.out.println(i); // ❌ Will NOT print anything! Pipeline is lazy without terminal operation.
       return i % 2 == 0;
   });
   ```

3. **Modifying Stream Source Inside Pipeline**:
   ```java
   list.stream().forEach(i -> list.add(i * 2)); // ❌ ConcurrentModificationException
   ```

4. **Ignoring `Optional` Return Values**:
   - Calling `.get()` directly on `min()`, `max()`, `findFirst()` without checking `isPresent()` or using `.orElse()` can throw `NoSuchElementException` if stream is empty.

5. **Confusing `map()` and `flatMap()`**:
   - Use `map()` when mapping 1 element to 1 object (`T -> R`).
   - Use `flatMap()` when mapping 1 element to multiple objects/stream (`T -> Stream<R>`).

---

## Quick Revision

- **Stream Definition**: Sequence of elements supporting functional data processing pipelines.
- **Not Data Structure**: Does not store data; carries values from source through operations.
- **Single Traverse**: Streams are single-use only; cannot be reused after terminal operation.
- **Intermediate Operations**: `filter`, `map`, `flatMap`, `sorted`, `distinct`, `limit`, `skip` (Lazy).
- **Terminal Operations**: `collect`, `count`, `forEach`, `min`, `max`, `reduce`, `toArray` (Eager).
- **Lazy Evaluation**: Intermediate operations do not execute until a terminal operation triggers processing.
- **`filter(Predicate)`**: Selects subset of elements matching boolean condition.
- **`map(Function)`**: Transforms each element to a target value or type.
- **`count()`**: Returns total count of elements as `long`.
- **`sorted()`**: Default Natural Sorting Order (`Comparable`).
- **`sorted(Comparator)`**: Customized sorting order via custom lambda comparator.
- **`min(Comp)` / `max(Comp)`**: Returns `Optional<T>` based on comparator evaluation.
- **`forEach(Consumer)`**: Iterates over elements directly without needing explicit loops.
- **`toArray(Integer[]::new)`**: Converts stream back to typed array via constructor reference.
- **`Stream.of(arr)`**: Creates stream directly from array or inline arguments.
- **No Side-Effects**: Avoid mutating external state or source collection during stream operations.
