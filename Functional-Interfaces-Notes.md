 # Functional Interfaces - Revision Notes

## Topic Overview

- **Definition**: A **Functional Interface** in Java is an interface that contains **exactly one abstract method**. It is also known as a **Single Abstract Method (SAM)** interface. Introduced in Java 8, functional interfaces form the foundational core for Functional Programming in Java.
- **Why it is used**:
  - Enables **Lambda Expressions** and **Method References** to provide clean, concise behavior instantiation.
  - Allows passing behavior (functions) as arguments to methods (first-class functions style).
  - Eliminates boilerplate code associated with Anonymous Inner Classes.
  - Forms the structural foundation for the **Stream API**.

---

## Important Rules

1. **Single Abstract Method (SAM) Restriction**:
   - Must contain **exactly one** abstract method.
   - If an interface has zero abstract methods or more than one abstract method, it cannot be used as a functional interface with lambda expressions.

2. **Allowed Interface Members (Java 8+)**:
   - Can contain **any number of `default` methods** (with implementations).
   - Can contain **any number of `static` methods** (with implementations).
   - Can contain `private` and `private static` methods (Java 9+).
   - Constant fields (`public static final`) are allowed.

3. **`java.lang.Object` Method Exception**:
   - Overriding public methods of `java.lang.Object` (e.g., `equals(Object)`, `hashCode()`, `toString()`) as abstract methods inside an interface **does NOT count** toward the single abstract method limit. Every implementation class automatically inherits these methods from `Object`.

4. **The `@FunctionalInterface` Annotation**:
   - Optional but highly recommended.
   - Instructs the Java compiler to enforce the SAM rule at compile time.
   - Triggers a compilation error if:
     - The interface has no abstract method.
     - The interface has multiple non-overriding abstract methods.

5. **Inheritance & Functional Interfaces**:
   - If a child interface extends a functional interface and adds **no new abstract methods**, the child interface remains a functional interface.
   - If a child interface extends a functional interface and declares **another abstract method**, the child interface is NO LONGER a functional interface.
   - If a child interface overrides the abstract method of the parent interface without declaring a new one, it remains a functional interface.

6. **Variable Scope Restrictions (Variable Capture)**:
   - Local variables referenced inside a lambda or anonymous inner class must be `final` or **effectively final** (must not be modified after assignment).

---

## Syntax

### 1. Traditional Implementation vs Anonymous Inner Class vs Lambda Expression

```java
// Functional Interface Definition
@FunctionalInterface
interface Inter1 {
    void show(int x);
}

// 1. Traditional Class Implementation
class Demo implements Inter1 {
    @Override
    public void show(int x) {
        System.out.println("Class Implementation: " + x);
    }
}

public class Main {
    public static void main(String[] args) {
        // 2. Anonymous Inner Class Syntax
        Inter1 i1 = new Inter1() {
            @Override
            public void show(int x) {
                System.out.println("Anonymous Inner Class: " + x);
            }
        };
        i1.show(10);

        // 3. Lambda Expression Syntax (Concise)
        Inter1 i2 = (x) -> System.out.println("Lambda Expression: " + x);
        i2.show(20);
    }
}
```

### 2. Lambda Syntax Variations

| Case | Syntax Example | Rule |
| :--- | :--- | :--- |
| **Single Parameter** | `x -> x * x` | Parentheses around parameter are optional. |
| **Multiple Parameters** | `(x, y) -> x + y` | Parentheses are mandatory. |
| **Single Expression Return** | `(x, y) -> x + y` | `return` keyword and `{}` curly braces are omitted; return is implicit. |
| **Explicit Return Statement** | `(x, y) -> { return x + y; }` | If `{}` are used with a return value, `return` keyword and semicolon `;` are mandatory. |
| **Multiple Statements** | `(x, y) -> { int sum = x + y; return sum; }` | Curly braces `{}` and explicit `return` are mandatory. |

---

## Important Methods / Features

Java 8 provides standard built-in functional interfaces in the `java.util.function` package.

### 1. `Predicate<T>`
- **Purpose**: Represents a boolean-valued conditional check on a single argument of type `T`.
- **Abstract Method**: `boolean test(T t)`
- **Key Methods**:
  - `default Predicate<T> and(Predicate<? super T> other)`: Logical AND chaining.
  - `default Predicate<T> or(Predicate<? super T> other)`: Logical OR chaining.
  - `default Predicate<T> negate()`: Logical NOT inversion.
  - `static <T> Predicate<T> isEqual(Object targetRef)`: Returns a predicate that tests if two arguments are equal according to `Objects.equals(targetRef, object)`.

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
Predicate<Integer> isGreaterThan20 = n -> n > 20;

// Chaining Predicates
Predicate<Integer> combined = isEven.and(isGreaterThan20);
System.out.println(combined.test(30)); // true

// Using negate() and isEqual()
Predicate<Integer> notEven = isEven.negate();
Predicate<String> isRam = Predicate.isEqual("ram");
```

### 2. `Function<T, R>`
- **Purpose**: Transforms an input argument of type `T` into a output result of type `R`.
- **Abstract Method**: `R apply(T t)`
- **Key Methods**:
  - `default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)`: Executes current function first, then applies `after` function to the result.
  - `default <V> Function<V, R> compose(Function<? super V, ? extends T> before)`: Executes `before` function first, then applies current function to the result.
  - `static <T> Function<T, T> identity()`: Returns a function that always returns its input argument.

```java
Function<Integer, Integer> doubleIt = a -> a + a;
Function<Integer, Integer> squareIt = a -> a * a;

// Function Composition
System.out.println(doubleIt.andThen(squareIt).apply(10)); // (10 + 10)^2 = 400
System.out.println(doubleIt.compose(squareIt).apply(10)); // (10^2) + (10^2) = 200
```

### 3. `Consumer<T>`
- **Purpose**: Accepts a single argument of type `T` and performs an operation without returning any result (side-effects).
- **Abstract Method**: `void accept(T t)`
- **Key Methods**: `default Consumer<T> andThen(Consumer<? super T> after)`

```java
Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
printUpper.accept("hello"); // Output: HELLO
```

### 4. `Supplier<T>`
- **Purpose**: Takes no arguments and produces a result of type `T` (factory/supplier pattern).
- **Abstract Method**: `T get()`

```java
Supplier<Double> randomSupplier = () -> Math.random();
System.out.println(randomSupplier.get());
```

### 5. Two-Argument (Bi-) Variants

| Interface | Abstract Method | Description |
| :--- | :--- | :--- |
| `BiPredicate<T, U>` | `boolean test(T t, U u)` | Conditional check on two inputs. |
| `BiFunction<T, U, R>` | `R apply(T t, U u)` | Maps two inputs of types `T` and `U` to result `R`. |
| `BiConsumer<T, U>` | `void accept(T t, U u)` | Consumes two inputs without returning a result. |

### 6. Specializations: `UnaryOperator<T>` & `BinaryOperator<T>`
- `UnaryOperator<T> extends Function<T, T>`: When operand and result types are identical.
- `BinaryOperator<T> extends BiFunction<T, T, T>`: When both operands and result types are identical.

### 7. Primitive Functional Interfaces (Performance Optimization)
To avoid performance overhead from **Autoboxing** and **Unboxing** wrapper objects, Java provides primitive-specialized functional interfaces:

- **Predicates**: `IntPredicate`, `LongPredicate`, `DoublePredicate` (`test(int/long/double)`)
- **Functions**: `IntFunction<R>`, `LongFunction<R>`, `DoubleFunction<R>`, `ToIntFunction<T>`, `ToLongFunction<T>`, `ToDoubleFunction<T>`, `IntToDoubleFunction`, etc.
- **Consumers**: `IntConsumer`, `LongConsumer`, `DoubleConsumer` (`accept(int/long/double)`)
- **Suppliers**: `IntSupplier`, `LongSupplier`, `DoubleSupplier`, `BooleanSupplier` (`getAsInt()`, `getAsLong()`, `getAsDouble()`, `getAsBoolean()`)

---

## Key Concepts

### 1. Anonymous Inner Class vs Lambda Expression

| Feature | Anonymous Inner Class | Lambda Expression |
| :--- | :--- | :--- |
| **Interface Types** | Works with any interface (single or multiple abstract methods) and abstract/concrete classes. | Works ONLY with **Functional Interfaces** (SAM). |
| **Class Generation** | Creates an extra `.class` file at compile time (e.g., `Main$1.class`). | Does NOT generate extra `.class` files. Handled via `invokedynamic` opcode at runtime. |
| **`this` Keyword** | Refers to the anonymous inner class instance itself. | Refers to the enclosing outer class instance (`lexical scoping`). |
| **Memory & Performance** | Higher memory footprint due to class loading and object creation. | Lightweight, faster execution due to JVM runtime dynamic call site optimization. |

### 2. Internal Working of `Predicate.isEqual()`
Under the hood, `isEqual()` returns a lambda expression or anonymous inner class capturing the target object:

```java
// Internal behavior equivalent
public static <T> Predicate<T> isEqual(Object targetRef) {
    return (null == targetRef)
            ? Objects::isNull
            : object -> targetRef.equals(object);
}
```

### 3. Interface Evolution via `default` Methods
Before Java 8, adding a new abstract method to an existing interface broke all implementing classes. Java 8 introduced `default` methods with default implementation bodies to allow interface extension while maintaining **backward compatibility**.

---

## Common Mistakes

1. **Creating Objects of Interfaces**:
   - `Inter1 i = new Inter1();` ❌ (Interfaces cannot be directly instantiated).
   - Must use class implementation, anonymous inner class, or lambda expression.

2. **Invalid Single-Line Return Syntax**:
   - `Inter1 i = (x, y) -> return x + y;` ❌ (*Syntax Error: illegal start of expression*).
   - Correct: `(x, y) -> x + y` ✅ or `(x, y) -> { return x + y; }` ✅.

3. **Multiple Abstract Methods in `@FunctionalInterface`**:
   - Adding a second abstract method triggers compiler error: *unexpected @FunctionalInterface annotation: multiple non-overriding abstract methods found*.

4. **Attempting to Mutate Local Captured Variables**:
   - Modifying a variable declared in the enclosing method inside a lambda triggers: *local variables referenced from a lambda expression must be final or effectively final*.

5. **`NullPointerException` in String Predicates**:
   - Calling `x.endsWith("a")` when `x` is `null` throws `NullPointerException`.
   - Fix with non-null check: `Predicate<String> p = x -> x != null && x.endsWith("a");`.

6. **Confusing `andThen` vs `compose` Execution Order**:
   - `f1.andThen(f2)` executes `f1` first, then `f2`.
   - `f1.compose(f2)` executes `f2` first, then `f1`.

---

## Quick Revision

- **SAM**: Functional interface has exactly ONE abstract method.
- **`@FunctionalInterface`**: Compiler rule validator; optional but best practice.
- **`Object` Methods**: Methods like `equals()`, `hashCode()` don't count toward the SAM limit.
- **Default & Static Methods**: Allowed in unlimited quantities inside functional interfaces.
- **Lambda Purpose**: Short, unnamed block of code providing inline SAM implementation.
- **`Predicate<T>`**: `boolean test(T t)` — used for filtering and condition evaluation.
- **Predicate Chaining**: `and()`, `or()`, `negate()`, `Predicate.isEqual()`.
- **`Function<T, R>`**: `R apply(T t)` — used for transformation/mapping.
- **Function Chaining**: `f1.andThen(f2)`, `f1.compose(f2)`, `Function.identity()`.
- **`Consumer<T>`**: `void accept(T t)` — used for iterating or printing side-effects.
- **`Supplier<T>`**: `T get()` — used for lazy data supply without parameters.
- **Bi-Interfaces**: `BiPredicate`, `BiFunction`, `BiConsumer` take two inputs.
- **Primitive Interfaces**: `IntPredicate`, `LongFunction`, `DoubleConsumer`, `IntSupplier` avoid boxing performance overhead.
- **Class Files**: Lambda does NOT produce `.class` files; Anonymous Inner Classes do (`Outer$1.class`).
- **Variable Scope**: Captured outer variables must be `final` or effectively final.
- **`this` Scoping**: Inside Lambda, `this` refers to the outer class instance. Inside AIC, `this` refers to the AIC instance.
