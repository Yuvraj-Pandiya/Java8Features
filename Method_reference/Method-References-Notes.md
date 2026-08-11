# Method References - Revision Notes

## Topic Overview

- **Definition**: A **Method Reference** is a compact, readable shorthand syntax introduced in Java 8 (using the double colon operator `::`) to refer to an existing method or constructor without executing it immediately.
- **Why it is used**:
  - Reuses pre-existing methods instead of writing redundant lambda expressions.
  - Improves code readability, clarity, and conciseness.
  - Enhances code reusability across functional pipelines.
  - Functions as a direct alternative syntax for lambda expressions whenever a lambda simply forwards its parameters to an existing method or constructor.

---

## Important Rules

1. **Functional Interface Context Mandatory**:
   - Method references can **only** be used where a **Functional Interface** is expected.

2. **Parameter / Argument Matching Rule**:
   - The argument list (number and types of parameters) of the target method **must match strictly** with the Single Abstract Method (SAM) parameter list of the functional interface.

3. **Return Type Compatibility**:
   - The return type of the referenced method does not need to be identical to the SAM return type, provided the referenced method's return type is assignment-compatible (subclass, primitive widening, or auto-boxed) with the SAM return type. If the SAM return type is `void`, any return value from the referenced method is simply discarded.

4. **No Arguments in Syntax**:
   - Method reference syntax does **not** allow parameter passing or parentheses inside the reference.
   - Example: `System.out::println` ✅ | `System.out::println()` ❌ | `System.out::println(x)` ❌.

5. **`invokedynamic` Bytecode Execution**:
   - Under the hood, method references are resolved using the JVM `invokedynamic` instruction, avoiding synthetic inner class overhead.

---

## Syntax

There are **four distinct types** of Method References in Java:

```
TargetReference::MethodName
```

### Classification & Syntax Table

| Type | Classification | Syntax | Equivalent Lambda Expression |
| :--- | :--- | :--- | :--- |
| **Type 1** | **Static Method Reference** | `ClassName::staticMethodName` | `(args) -> ClassName.staticMethodName(args)` |
| **Type 2** | **Instance Method of a Particular Object** | `instanceRef::instanceMethodName` | `(args) -> instanceRef.instanceMethodName(args)` |
| **Type 3** | **Instance Method of an Arbitrary Object of a Type** | `ClassName::instanceMethodName` | `(obj, args) -> obj.instanceMethodName(args)` |
| **Type 4** | **Constructor Reference** | `ClassName::new` / `ArrayType[]::new` | `(args) -> new ClassName(args)` |

---

## Syntax Examples Code Snippets

```java
import java.util.function.*;

class Sample {
    Sample() {
        System.out.println("No-arg Constructor Executed");
    }
    Sample(String msg) {
        System.out.println("Arg Constructor Executed: " + msg);
    }
    
    public static void staticMethod() {
        System.out.println("Static method executed");
    }
    
    public void instanceMethod(String msg) {
        System.out.println("Instance method executed: " + msg);
    }
}

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 1. Static Method Reference
        Runnable r1 = Sample::staticMethod;
        r1.run();

        // 2. Instance Method of a Specific Object
        Sample obj = new Sample();
        Consumer<String> c1 = obj::instanceMethod;
        c1.accept("Hello World");
        
        // System.out::println is Type 2
        Consumer<Object> printer = System.out::println;
        printer.accept("Printing via method ref");

        // 3. Instance Method of an Arbitrary Object
        Function<String, Integer> lenFunc = String::length; // Equivalent to: (s) -> s.length()
        System.out.println("Length: " + lenFunc.apply("Java"));

        // 4. Constructor Reference (No-arg)
        Supplier<Sample> s1 = Sample::new;
        Sample sampleObj1 = s1.get();

        // 4. Constructor Reference (With String arg)
        Function<String, Sample> s2 = Sample::new;
        Sample sampleObj2 = s2.apply("Custom Message");

        // 4. Array Constructor Reference
        IntFunction<Integer[]> arrayCreator = Integer[]::new; // Equivalent to: (len) -> new Integer[len]
        Integer[] arr = arrayCreator.apply(5);
    }
}
```

---

## Important Methods / Features

Method references are extensively used with standard Java Functional Interfaces and the Stream API:

1. **`System.out::println` (Instance Method Reference)**:
   - Replaces `x -> System.out.println(x)`.
   - Used frequently in `forEach`: `list.stream().forEach(System.out::println);`.

2. **`Math::sqrt` / `Math::max` (Static Method Reference)**:
   - Replaces `x -> Math.sqrt(x)` or `(a, b) -> Math.max(a, b)`.

3. **`String::compareTo` / `String::toUpperCase` (Arbitrary Object Instance Method Reference)**:
   - Replaces `(s1, s2) -> s1.compareTo(s2)`.
   - Used in streams sorting: `names.stream().sorted(String::compareTo);`.

4. **`Collectors.toList()` / `ArrayList::new` (Constructor Reference)**:
   - Used in stream collection and supplier factory methods: `Supplier<List<String>> listSupplier = ArrayList::new;`.

5. **`Integer[]::new` (Array Constructor Reference)**:
   - Used in Stream to Array conversions: `list.stream().toArray(Integer[]::new);`.

---

## Key Concepts

### 1. Advantage Over Lambda Expressions
- In Lambda expressions, code must be written inline even if an exact method already exists elsewhere:
  ```java
  Runnable r = () -> MyClass.myMethod();
  ```
- Method Reference directly maps the functional interface method to the existing method:
  ```java
  Runnable r = MyClass::myMethod;
  ```
  **Benefit**: Code reusability, maximum readability, clean syntax.

### 2. Matching Parameters in Constructor References (`ClassName::new`)
When using `ClassName::new`, the compiler selects which constructor to call based on the parameter types of the SAM in the Functional Interface:

```java
interface Inter1 {
    Sample get1(); // Maps to Sample() default constructor
}

interface Inter2 {
    Sample get2(String s); // Maps to Sample(String s) parameterized constructor
}

// Compiler automatically binds to matching constructor:
Inter1 i1 = Sample::new; // Calls Sample()
Inter2 i2 = Sample::new; // Calls Sample(String s)
```

### 3. Array Constructor Reference (`Type[]::new`)
- In Java streams, `toArray()` requires an array constructor reference.
- Under the hood, `Type[]::new` maps to `IntFunction<Type[]>`, taking array size as `int` argument and returning a new array instance `new Type[size]`.

### 4. Instance Method from Static Context Restriction
Attempting to refer to an instance method using `ClassName::methodName` without an object context or without SAM taking the target object as first argument results in compile error: *non-static method cannot be referenced from a static context*.

---

## Common Mistakes

1. **Including Arguments in Syntax**:
   - `Runnable r = InterDemo7::m1();` ❌ (*Compilation Error: cannot find symbol / invalid syntax*).
   - `Runnable r = InterDemo7::m1;` ✅.

2. **Parameter Mismatch**:
   - Attempting to map a functional interface method `void run()` (0 args) to a method `void process(int x)` (1 arg).
   - Error: *incompatible types: bad return type or parameter mismatch*.

3. **Wrong Object Context for Instance Methods**:
   - `MyClass::instanceMethod` when the functional interface takes 0 parameters.
   - Fix: Use `objectRef::instanceMethod` if referring to a specific object.

4. **Confusing Constructor Selection**:
   - Passing arguments to constructor reference syntax `Sample::new("ram")` ❌.
   - Arguments are supplied when calling the Functional Interface method (e.g., `i2.apply("ram")`), not during reference creation!

---

## Quick Revision

- **Operator**: `::` (Double Colon Operator).
- **Core Purpose**: Shorthand syntax for lambda expression calling existing methods/constructors.
- **Context**: Can ONLY be used with Functional Interfaces.
- **Rule 1 (Arguments)**: Parameter list of target method MUST strictly match SAM of Functional Interface.
- **Rule 2 (No Args in Syntax)**: Never include parentheses `()` or argument lists in `::` reference syntax.
- **Type 1 (Static)**: `ClassName::staticMethod` (`Math::sqrt`).
- **Type 2 (Instance of Particular Object)**: `instanceRef::methodName` (`System.out::println`).
- **Type 3 (Instance of Arbitrary Object)**: `ClassName::methodName` (`String::length`, `String::compareTo`).
- **Type 4 (Constructor)**: `ClassName::new` (`Sample::new`).
- **Array Constructor**: `Integer[]::new` (Used in `stream.toArray(Integer[]::new)`).
- **Overload Selection**: Constructor reference overloaded constructor choice is automatically inferred from Functional Interface SAM parameters.
- **Reusability**: Promotes DRY (Don't Repeat Yourself) principle by referencing tested existing methods.
