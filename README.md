# PART I — PROGRAMMING FOUNDATIONS WITH JAVA

> **Weeks 1–4 | Goal:** Write programs confidently using variables, control flow, methods, arrays, and strings. Understand what happens in memory. Be able to read and debug code.

---

## Chapter 1: Your Environment and First Program

### 1.1 — What You Need to Install

You need exactly two things:

1. **JDK (Java Development Kit)** — version 17 or 21 (LTS versions). The JDK contains the compiler (`javac`) that turns your code into bytecode, and the JVM (Java Virtual Machine) that runs it.
    
2. **A text editor or IDE** — Use **IntelliJ IDEA Community Edition** (free). It is the industry standard for Java development in ESN companies. Do not use Eclipse unless your university forces you to. Do not use Notepad.
    

**To verify your installation**, open a terminal (Command Prompt on Windows, Terminal on Linux/Mac) and type:

```bash
java -version
javac -version
```

You should see version numbers like `17.0.x` or `21.0.x`. If you get "command not found", the JDK is not installed or not in your PATH.

### 1.2 — How Java Works: From Code to Execution

Understanding this flow is not optional. Interviewers ask about it.

```
YourFile.java  →  javac (compiler)  →  YourFile.class (bytecode)  →  JVM  →  Execution
```

**Step by step:**

1. You write a `.java` file. This is **source code** — human-readable text.
2. The `javac` compiler reads your `.java` file and produces a `.class` file containing **bytecode**. Bytecode is not machine code — it is an intermediate representation.
3. The **JVM (Java Virtual Machine)** reads the `.class` file and interprets/compiles the bytecode into machine code for your specific operating system.

**Why does this matter?** This is why Java is called "write once, run anywhere" (WORA). The same `.class` file runs on Windows, Linux, or macOS because each OS has its own JVM that translates bytecode to native instructions.

**French terminology:** The compiler is _le compilateur_. The JVM is _la machine virtuelle Java_. Bytecode is _le bytecode_ (same term used in French).

### 1.3 — Your First Program

Create a file called `HelloWorld.java` (the filename **must** match the class name exactly, including capitalization):

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Compile and run from terminal:**

```bash
javac HelloWorld.java
java HelloWorld
```

Output:

```
Hello, World!
```

### 1.4 — Dissecting Every Word

Let us break down every single word in this program. You must be able to explain each one.

|Code|Meaning|
|---|---|
|`public`|Access modifier — this class/method is visible to everything|
|`class`|Declares a class. In Java, ALL code lives inside a class.|
|`HelloWorld`|The name of the class. Must match the filename.|
|`{` `}`|Curly braces define a block of code (the body of the class or method)|
|`static`|This method belongs to the class itself, not to an instance/object|
|`void`|This method returns nothing|
|`main`|The entry point. The JVM looks for exactly this method signature to start.|
|`String[] args`|An array of strings — command-line arguments passed to the program|
|`System.out.println()`|Prints text to the console followed by a newline|

> **🔒 WHAT YOU MUST MEMORIZE**
> 
> The exact signature of the main method: `public static void main(String[] args)`
> 
> This is non-negotiable. If you change any word (remove `static`, change `String[]` to `String`), the JVM will not find your entry point and will throw an error. You will be asked this in interviews.

### 1.5 — Common Mistakes (Chapter 1)

|Mistake|What Happens|Fix|
|---|---|---|
|File named `helloworld.java` but class is `HelloWorld`|Compilation error|Filename must exactly match class name (case-sensitive)|
|Missing semicolon `;` at end of statement|Compilation error|Every statement in Java ends with `;`|
|Using `System.out.Println` (capital P)|Compilation error|It is `println` (lowercase p)|
|Running `java HelloWorld.class`|Error|Run `java HelloWorld` (no `.class` extension)|
|Writing code outside of a method|Compilation error|All executable code must be inside a method|

### 1.6 — Exercises (Chapter 1)

**Exercise 1.1** — Write a program that prints your name, your university, and your target job title on three separate lines.

<details> <summary>Hint</summary> Use three separate `System.out.println()` calls. Each call prints one line. </details> <details> <summary>Solution</summary>

```java
public class AboutMe {
    public static void main(String[] args) {
        System.out.println("Name: Youssef");
        System.out.println("University: Université Hassan II");
        System.out.println("Target: Junior Backend Developer (Java/Spring Boot)");
    }
}
```

</details>

**Exercise 1.2** — What is the difference between `System.out.println()` and `System.out.print()`? Write a program that demonstrates the difference.

<details> <summary>Hint</summary> `println` adds a newline character at the end. `print` does not. Try printing two things with each and observe where the next output appears. </details> <details><summary>Solution</summary>

```java
public class PrintVsPrintln {
    public static void main(String[] args) {
        System.out.print("A");
        System.out.print("B");
        System.out.println();  // just a newline
        System.out.println("C");
        System.out.println("D");
    }
}
// Output:
// AB
// C
// D
```

`print("A")` and `print("B")` appear on the same line because `print` does not add a newline. `println("C")` prints C and then moves to the next line.

</details>

**Exercise 1.3** — Compile and run a program from the command line (not from IntelliJ). Take note of the exact commands you used. You must be comfortable with this.

---

## Chapter 2: Variables, Types, and Operators

### 2.1 — What is a Variable?

A variable is a named container that holds a value in memory. In Java, every variable has a **type** that is declared once and cannot change. This is called **static typing** (_typage statique_).

```java
int age = 22;
String name = "Youssef";
double salary = 8500.50;
boolean isEmployed = false;
```

The general pattern is:

```
type variableName = value;
```

### 2.2 — Primitive Types

Java has 8 primitive types. You need to know these for interviews:

|Type|Size|Range / Description|Example|
|---|---|---|---|
|`byte`|1 byte|-128 to 127|`byte b = 100;`|
|`short`|2 bytes|-32,768 to 32,767|`short s = 30000;`|
|`int`|4 bytes|-2.1 billion to 2.1 billion|`int x = 42;`|
|`long`|8 bytes|Very large integers|`long pop = 7900000000L;` (note the `L`)|
|`float`|4 bytes|Decimal numbers (less precision)|`float f = 3.14f;` (note the `f`)|
|`double`|8 bytes|Decimal numbers (more precision)|`double d = 3.14159;`|
|`char`|2 bytes|A single Unicode character|`char c = 'A';` (single quotes)|
|`boolean`|1 bit*|`true` or `false` only|`boolean done = false;`|

**Critical distinctions:**

- `int` is the default for whole numbers. Use `int` unless you have a reason not to.
- `double` is the default for decimal numbers. Use `double` unless you have a reason for `float`.
- `long` literals require an `L` suffix: `long x = 100L;`
- `float` literals require an `f` suffix: `float x = 3.14f;`
- `char` uses single quotes: `'A'`. Strings use double quotes: `"A"`. These are different types.

### 2.3 — Reference Types vs. Primitives

This is a concept that separates beginners from people who understand Java.

**Primitives** store the actual value directly in the variable:

```java
int a = 5;   // the variable 'a' literally holds the number 5
int b = a;   // 'b' gets a COPY of 5. Changing b does NOT change a.
b = 10;
System.out.println(a);  // prints 5 — a is unchanged
```

**Reference types** (any object, including `String`, arrays, classes you create) store a **reference** (memory address) pointing to the actual object on the heap:

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = arr1;  // arr2 points to the SAME array as arr1
arr2[0] = 99;
System.out.println(arr1[0]);  // prints 99 — both point to the same object!
```

> **🔒 WHAT YOU MUST MEMORIZE**
> 
> Primitives hold values. Reference types hold addresses.
> 
> When you assign a primitive, you copy the value. When you assign a reference, you copy the address — both variables point to the same object.
> 
> This is asked in interviews. Draw it on paper: boxes for variables, arrows for references.
---
>**🔒 WHAT YOU MUST MEMORIZE**
>
>The **heap** is where **all objects** live in memory (arrays, Strings, and any object you create with `new`).  
>
>When you create an object, it's stored on the heap, and **variables hold only the memory address** (reference) to that object, not the object itself.
>
>**Multiple references can point to the same heap object** – changing it through one reference changes it for all.

### 2.4 — String is Special

`String` is a reference type (a class), but Java gives it special treatment:

```java
String greeting = "Hello";  // String literal — stored in the String Pool
String name = new String("Hello");  // Explicitly created — on the heap (avoid this)
```

**Strings are immutable.** Once created, a String object's content cannot change. When you "modify" a string, Java creates a new String object:

```java
String s = "Hello";
s = s + " World";  // This creates a NEW String "Hello World". 
                    // The old "Hello" still exists in memory (until garbage collected).
```

**String comparison — a classic trap:**

```java
String a = "Hello";
String b = "Hello";
String c = new String("Hello");

System.out.println(a == b);       // true — same object in String Pool
System.out.println(a == c);       // false — different objects (pool vs heap)
System.out.println(a.equals(c));  // true — same CONTENT
```

**Rule:** Always use `.equals()` to compare String content. Never use `==` for Strings unless you specifically want to check if they are the exact same object in memory.

### 2.5 — Operators

**Arithmetic operators:**

|Operator|Meaning|Example|Result|
|---|---|---|---|
|`+`|Addition|`5 + 3`|`8`|
|`-`|Subtraction|`5 - 3`|`2`|
|`*`|Multiplication|`5 * 3`|`15`|
|`/`|Division|`7 / 2`|`3` (integer division!)|
|`%`|Modulo (remainder)|`7 % 2`|`1`|

**Integer division trap:**

```java
int result = 7 / 2;  // result is 3, NOT 3.5
// Java truncates the decimal when both operands are int
double correct = 7.0 / 2;  // result is 3.5 — at least one operand must be double
```

**Comparison operators:** `==`, `!=`, `<`, `>`, `<=`, `>=` — these return `boolean`.

**Logical operators:** `&&` (AND), `||` (OR), `!` (NOT).

```java
boolean isAdult = age >= 18;
boolean canWork = isAdult && hasPermit;
boolean isWeekend = (day == 6) || (day == 7);
boolean isNotDone = !isDone;
```

**Short-circuit evaluation:** `&&` stops evaluating if the left side is `false`. `||` stops if the left side is `true`. This matters when the right side has side effects or could throw an error.

### 2.6 — Type Casting

**Widening (implicit)** — smaller type to larger type. Safe, automatic:

```java
int x = 42;
double d = x;  // 42 → 42.0 automatically
```

**Narrowing (explicit)** — larger type to smaller type. Requires a cast, may lose data:

```java
double d = 3.99;
int x = (int) d;  // x is 3 — the decimal part is TRUNCATED (not rounded)
```

### 2.7 — Reading User Input

Use the `Scanner` class:

```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.println("Hello " + name + ", you are " + age + " years old.");
        
        scanner.close();
    }
}
```

**Scanner trap:** After calling `nextInt()` (or `nextDouble()`), the newline character `\n` remains in the input buffer. If you then call `nextLine()`, it reads that leftover `\n` and returns an empty string. Fix:

```java
int age = scanner.nextInt();
scanner.nextLine();  // consume the leftover newline
String city = scanner.nextLine();  // now this works correctly
```

### 2.8 — Common Mistakes (Chapter 2)

|Mistake|What Happens|Fix|
|---|---|---|
|`String s = 'hello';`|Compilation error|Strings use double quotes: `"hello"`. Single quotes are for `char`.|
|`int x = 3.14;`|Compilation error|`3.14` is a `double`. Use `double x = 3.14;` or cast.|
|Comparing Strings with `==`|Unexpected `false`|Use `.equals()` for content comparison.|
|`7 / 2` expecting `3.5`|Gets `3`|Use `7.0 / 2` or cast: `(double) 7 / 2`.|
|Uninitialized local variable|Compilation error|Java requires you to assign a value before using a local variable.|

### 2.9 — Exercises (Chapter 2)

**Exercise 2.1** — Write a program that asks the user for two integers and prints their sum, difference, product, quotient, and remainder.

<details> <summary>Hint</summary> Use `Scanner` to read two `int` values. Apply each operator. Be careful: for quotient, if the second number is 0, you will get an ArithmeticException. </details> <details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();
        
        System.out.println("Sum:        " + (a + b));
        System.out.println("Difference: " + (a - b));
        System.out.println("Product:    " + (a * b));
        
        if (b != 0) {
            System.out.println("Quotient:   " + (a / b));
            System.out.println("Remainder:  " + (a % b));
        } else {
            System.out.println("Cannot divide by zero.");
        }
        
        scanner.close();
    }
}
```

</details>

**Exercise 2.2** — Write a program that converts a temperature from Celsius to Fahrenheit. Formula: `F = C × 9/5 + 32`. The user enters Celsius as a decimal number.

<details> <summary>Hint</summary> Use `double` for the temperature. Use `scanner.nextDouble()` to read it. </details> <details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        scanner.close();
    }
}
```

</details>

**Exercise 2.3** — Predict the output WITHOUT running the code. Then verify.

```java
int a = 10;
int b = a;
b = 20;
System.out.println(a);
System.out.println(b);

String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
System.out.println(s1 == s2);
System.out.println(s1 == s3);
System.out.println(s1.equals(s3));
```

<details> <summary>Solution</summary>

```
10
20
true
false
true
```

`a` is unchanged because `int` is a primitive (copied by value). `s1 == s2` is `true` because both reference the same String Pool object. `s1 == s3` is `false` because `new String()` creates a separate object on the heap. `.equals()` compares content, so it returns `true`.

</details>

**Exercise 2.4** — Write a program that asks for a number of seconds and converts it to hours, minutes, and remaining seconds. Example: 3661 seconds → 1 hour, 1 minute, 1 second.

<details> <summary>Hint</summary> Use integer division `/` to get the larger units and modulo `%` to get the remainder. Start with total seconds. Hours = total / 3600. Remaining = total % 3600. Minutes = remaining / 60. Seconds = remaining % 60. </details> <details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total seconds: ");
        int totalSeconds = scanner.nextInt();
        
        int hours = totalSeconds / 3600;
        int remaining = totalSeconds % 3600;
        int minutes = remaining / 60;
        int seconds = remaining % 60;
        
        System.out.println(totalSeconds + " seconds = " 
            + hours + "h " + minutes + "m " + seconds + "s");
        scanner.close();
    }
}
```

</details>

---

## Chapter 3: Control Flow — Decisions and Loops

### 3.1 — if / else if / else

```java
int grade = 75;

if (grade >= 90) {
    System.out.println("Excellent");
} else if (grade >= 70) {
    System.out.println("Good");
} else if (grade >= 50) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

**Rules:**

- The condition must evaluate to a `boolean`. `if (x)` does NOT work if `x` is an `int` (unlike C/JavaScript).
- `else if` and `else` are optional.
- Once a condition is `true`, its block executes and all remaining `else if` / `else` blocks are skipped.
- Always use braces `{}` even for single-line blocks. Omitting them is a source of bugs.

### 3.2 — switch Statement

Use `switch` when comparing one variable against multiple specific values:

```java
int dayNumber = 3;
String dayName;

switch (dayNumber) {
    case 1:
        dayName = "Monday";
        break;
    case 2:
        dayName = "Tuesday";
        break;
    case 3:
        dayName = "Wednesday";
        break;
    case 4:
        dayName = "Thursday";
        break;
    case 5:
        dayName = "Friday";
        break;
    case 6:
        dayName = "Saturday";
        break;
    case 7:
        dayName = "Sunday";
        break;
    default:
        dayName = "Invalid";
        break;
}
System.out.println(dayName);
```

**The `break` trap:** If you forget `break`, execution "falls through" to the next case. This is a common bug.

**Java 14+ enhanced switch** (you may see this in modern codebases):

```java
String dayName = switch (dayNumber) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    // ...
    default -> "Invalid";
};
```

### 3.3 — while Loop

Repeats a block **while** a condition is true. The condition is checked **before** each iteration:

```java
int count = 1;
while (count <= 5) {
    System.out.println("Count: " + count);
    count++;
}
```

**Infinite loop trap:** If the condition never becomes `false`, the loop runs forever:

```java
while (true) {
    // runs forever unless you break
}
```

### 3.4 — do-while Loop

Same as `while`, but the body executes **at least once** because the condition is checked **after**:

```java
Scanner scanner = new Scanner(System.in);
int number;
do {
    System.out.print("Enter a positive number: ");
    number = scanner.nextInt();
} while (number <= 0);  // keeps asking until input is positive
```

This is useful for input validation — you need to get the input at least once before you can check it.

### 3.5 — for Loop

Use `for` when you know (or can calculate) the number of iterations:

```java
for (int i = 0; i < 10; i++) {
    System.out.println("Iteration: " + i);
}
```

The structure is: `for (initialization; condition; update)`.

- **Initialization:** `int i = 0` — runs once before the loop starts
- **Condition:** `i < 10` — checked before each iteration; if `false`, loop exits
- **Update:** `i++` — runs after each iteration

**Common patterns:**

```java
// Count from 0 to 9
for (int i = 0; i < 10; i++) { }

// Count from 1 to 10
for (int i = 1; i <= 10; i++) { }

// Count down from 10 to 1
for (int i = 10; i >= 1; i--) { }

// Count by 2s
for (int i = 0; i < 20; i += 2) { }
```

### 3.6 — Nested Loops

A loop inside a loop. The inner loop completes all its iterations for each single iteration of the outer loop:

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.println("i=" + i + " j=" + j);
    }
}
```

Output:

```
i=1 j=1
i=1 j=2
i=1 j=3
i=2 j=1
i=2 j=2
i=2 j=3
i=3 j=1
i=3 j=2
i=3 j=3
```

Total iterations: outer × inner = 3 × 3 = 9.

### 3.7 — break and continue

- `break` — exits the loop immediately
- `continue` — skips the rest of the current iteration and goes to the next one

```java
// Print only odd numbers from 1 to 10
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // skip even numbers
    }
    System.out.println(i);
}

// Find the first number divisible by 7 in 1-100
for (int i = 1; i <= 100; i++) {
    if (i % 7 == 0) {
        System.out.println("Found: " + i);
        break;  // stop searching
    }
}
```

> **🔒 WHAT YOU MUST MEMORIZE**
> 
> - `while` — check condition first, may execute zero times
> - `do-while` — execute first, check condition after, always executes at least once
> - `for` — best when number of iterations is known
> - `break` exits the innermost loop
> - `continue` skips to the next iteration of the innermost loop

### 3.8 — Common Mistakes (Chapter 3)

|Mistake|What Happens|Fix|
|---|---|---|
|`if (x = 5)`|Compilation error (in Java, thankfully)|Use `==` for comparison, `=` is assignment|
|Forgetting `break` in switch|Fall-through to next case|Always include `break` (or use arrow syntax)|
|Off-by-one errors in loops|Loop runs one too many or too few times|Check: does your loop include or exclude the boundary?|
|Modifying loop variable inside the loop body carelessly|Unexpected behavior, possible infinite loop|Be deliberate about what changes `i`|
|`while (scanner.hasNext())` without consuming input|Infinite loop|Make sure the loop body actually reads input|

### 3.9 — Exercises (Chapter 3)

**Exercise 3.1** — Write a program that asks the user for an integer and says whether it is positive, negative, or zero.

<details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        
        if (n > 0) {
            System.out.println("Positive");
        } else if (n < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
        scanner.close();
    }
}
```

</details>

**Exercise 3.2** — Write a program that prints the multiplication table for a number entered by the user (from 1 to 10).

<details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
        scanner.close();
    }
}
```

</details>

**Exercise 3.3** — Write a program that calculates the sum of all integers from 1 to N, where N is entered by the user.

<details> <summary>Hint</summary> Use a `for` loop and an accumulator variable initialized to 0. Add each number to it. </details> <details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class SumToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum from 1 to " + n + " = " + sum);
        scanner.close();
    }
}
```

</details>

**Exercise 3.4** — Write a program that checks if a number is prime. A prime number is greater than 1 and divisible only by 1 and itself.

<details> <summary>Hint</summary> Check if any number from 2 to the square root of N divides N evenly. If yes, it is not prime. You only need to check up to the square root because if N = a × b, then one of a or b must be ≤ √N. </details> <details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        boolean isPrime = true;
        
        if (n <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        if (isPrime) {
            System.out.println(n + " is prime.");
        } else {
            System.out.println(n + " is not prime.");
        }
        scanner.close();
    }
}
```

</details>

**Exercise 3.5** — FizzBuzz. Print numbers from 1 to 100. For multiples of 3, print "Fizz". For multiples of 5, print "Buzz". For multiples of both, print "FizzBuzz". This is a classic screening question in coding interviews.

<details> <summary>Solution</summary>

```java
public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
```

**Important:** The check for "both" (`% 3 == 0 && % 5 == 0`) must come FIRST. If you check for 3 first, 15 would print "Fizz" and never reach the "both" check.

</details>

**Exercise 3.6** — Write a number guessing game. The program picks a random number between 1 and 100, and the user guesses. After each guess, say "Higher" or "Lower". Count the number of attempts.

<details> <summary>Hint</summary> Use `Random random = new Random(); int target = random.nextInt(100) + 1;` to generate a random number from 1 to 100. Use a `while` loop that continues until the guess matches. </details> <details> <summary>Solution</summary>

```java
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        int attempts = 0;
        
        System.out.println("I picked a number between 1 and 100. Guess it!");
        
        while (guess != target) {
            System.out.print("Your guess: ");
            guess = scanner.nextInt();
            attempts++;
            
            if (guess < target) {
                System.out.println("Higher!");
            } else if (guess > target) {
                System.out.println("Lower!");
            } else {
                System.out.println("Correct! You got it in " + attempts + " attempts.");
            }
        }
        scanner.close();
    }
}
```

</details>

---

## Chapter 4: Methods, Scope, and the Call Stack

### 4.1 — What is a Method?

A method is a named block of code that performs a specific task. Methods allow you to **reuse** code, **organize** your program into logical pieces, and **name** operations so code reads like a story.

In French ESN contexts, methods are sometimes called _fonctions_ or _méthodes_.

```java
public static int add(int a, int b) {
    return a + b;
}
```

**Anatomy:**

```
public static int add(int a, int b) {
│      │      │   │   └── parameters (inputs)
│      │      │   └── method name
│      │      └── return type (what the method gives back)
│      └── static (belongs to the class, not an object — more in OOP chapters)
└── access modifier
```

### 4.2 — Return Types

|Return type|Meaning|
|---|---|
|`int`, `double`, `String`, etc.|The method must return a value of that type using `return`|
|`void`|The method returns nothing|

```java
// Returns an int
public static int square(int n) {
    return n * n;
}

// Returns nothing
public static void greet(String name) {
    System.out.println("Hello, " + name);
    // no return statement needed (or you can use 'return;' to exit early)
}
```

**Once `return` executes, the method stops immediately.** Code after `return` is unreachable and causes a compilation error.

### 4.3 — Calling Methods

```java
public class MethodDemo {
    public static void main(String[] args) {
        int result = add(5, 3);       // call add, store the returned value
        System.out.println(result);    // prints 8
        
        greet("Youssef");             // call greet, it prints directly
        
        System.out.println(add(10, add(2, 3)));  // nested calls: add(2,3)=5, then add(10,5)=15
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static void greet(String name) {
        System.out.println("Hello, " + name);
    }
}
```

### 4.4 — Parameters vs. Arguments

- **Parameter:** The variable name declared in the method signature: `int a, int b`
- **Argument:** The actual value passed when calling: `add(5, 3)` — here 5 and 3 are arguments

Java is **pass-by-value**. For primitives, the method receives a copy. Modifying the parameter inside the method does NOT affect the original:

```java
public static void tryToChange(int x) {
    x = 999;  // only changes the local copy
}

public static void main(String[] args) {
    int num = 5;
    tryToChange(num);
    System.out.println(num);  // still 5
}
```

For reference types, the reference is copied (not the object). The method can modify the object through the reference, but cannot make the original variable point to a different object:

```java
public static void modifyArray(int[] arr) {
    arr[0] = 999;  // modifies the original array (same reference)
}

public static void main(String[] args) {
    int[] myArr = {1, 2, 3};
    modifyArray(myArr);
    System.out.println(myArr[0]);  // prints 999
}
```

### 4.5 — Variable Scope

A variable exists only within the block `{}` where it is declared:

```java
public static void main(String[] args) {
    int x = 10;  // x is in scope for the entire main method
    
    if (x > 5) {
        int y = 20;  // y is in scope only within this if-block
        System.out.println(x + y);  // OK: x is accessible here
    }
    
    // System.out.println(y);  // COMPILATION ERROR: y does not exist here
}
```

**Each method has its own scope.** Variables in one method cannot be accessed from another method. This is why you pass data through parameters and return values.

### 4.6 — The Call Stack (Intuition)

When a method is called, Java creates a **stack frame** — a block of memory that holds the method's local variables and parameters. When the method returns, its frame is destroyed.

```
main() calls add(5, 3):

CALL STACK:
┌──────────────┐
│ add()        │ ← currently executing
│  a = 5       │
│  b = 3       │
├──────────────┤
│ main()       │ ← waiting for add() to return
│  result = ?  │
└──────────────┘

After add() returns 8:
┌──────────────┐
│ main()       │ ← now executing again
│  result = 8  │
└──────────────┘
```

If method A calls method B which calls method C, the stack grows deeper. If it grows too deep (usually from infinite recursion), you get a **StackOverflowError**.

### 4.7 — Method Overloading

You can have multiple methods with the **same name** but **different parameter lists**. Java picks the correct one based on the arguments:

```java
public static int add(int a, int b) {
    return a + b;
}

public static double add(double a, double b) {
    return a + b;
}

public static int add(int a, int b, int c) {
    return a + b + c;
}
```

The return type alone does NOT distinguish overloaded methods. The parameter types and/or count must differ.

> **🔒 WHAT YOU MUST MEMORIZE**
> 
> - Methods have: access modifier, optional `static`, return type, name, parameters, body
> - `void` means "returns nothing"
> - Java is pass-by-value (copies the value for primitives, copies the reference for objects)
> - Variables only exist within their declaring block (scope)
> - Overloading = same method name, different parameters

### 4.8 — Exercises (Chapter 4)

**Exercise 4.1** — Write a method `isEven(int n)` that returns `true` if n is even, `false` otherwise. Call it from `main` with several test values.

<details> <summary>Solution</summary>

```java
public class EvenCheck {
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(isEven(4));   // true
        System.out.println(isEven(7));   // false
        System.out.println(isEven(0));   // true
        System.out.println(isEven(-2));  // true
    }
}
```

</details>

**Exercise 4.2** — Write a method `factorial(int n)` that returns n! (n factorial). Use a loop, not recursion. Handle the case where n is 0 (0! = 1).

<details> <summary>Solution</summary>

```java
public class Factorial {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(factorial(0));   // 1
        System.out.println(factorial(5));   // 120
        System.out.println(factorial(10));  // 3628800
        System.out.println(factorial(20));  // 2432902008176640000
    }
}
```

Note: We use `long` because factorials grow extremely fast. `int` overflows around 13!.

</details>

**Exercise 4.3** — Write a method `max(int a, int b, int c)` that returns the largest of three integers. Do NOT use `Math.max`. Then write another overloaded version `max(int a, int b)` for two integers.

<details> <summary>Solution</summary>

```java
public class MaxFinder {
    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }
    
    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }
    
    public static void main(String[] args) {
        System.out.println(max(3, 7));        // 7
        System.out.println(max(10, 4, 8));    // 10
        System.out.println(max(-1, -5, -2));  // -1
    }
}
```

</details>

**Exercise 4.4** — Write a method `isPalindrome(String s)` that returns true if the string reads the same forwards and backwards (ignore case). Examples: "racecar" → true, "hello" → false, "Madam" → true.

<details> <summary>Hint</summary> Convert to lowercase first. Compare characters from the start and end moving inward. Or reverse the string and compare with `.equals()`. </details> <details> <summary>Solution</summary>

```java
public class Palindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));  // true
        System.out.println(isPalindrome("hello"));    // false
        System.out.println(isPalindrome("Madam"));    // true
        System.out.println(isPalindrome("A"));        // true
    }
}
```

</details>

---

## Chapter 5: Arrays and Strings

### 5.1 — Arrays

An array is a fixed-size, ordered collection of elements of the same type.

**Declaring and creating arrays:**

```java
// Method 1: declare size, fill later
int[] numbers = new int[5];   // creates an array of 5 ints, all initialized to 0
numbers[0] = 10;
numbers[1] = 20;

// Method 2: declare with values
int[] scores = {85, 92, 78, 95, 88};

// Method 3: declare type and create separately
int[] data;
data = new int[3];
```

**Accessing elements:** Arrays are zero-indexed. `arr[0]` is the first element.

```java
int[] arr = {10, 20, 30, 40, 50};
System.out.println(arr[0]);    // 10
System.out.println(arr[4]);    // 50
System.out.println(arr.length); // 5 (not a method — no parentheses!)
// arr[5] would throw ArrayIndexOutOfBoundsException at runtime
```

**Iterating over arrays:**

```java
int[] arr = {10, 20, 30, 40, 50};

// Standard for loop (use when you need the index)
for (int i = 0; i < arr.length; i++) {
    System.out.println("Index " + i + ": " + arr[i]);
}

// Enhanced for loop / for-each (use when you only need the values)
for (int value : arr) {
    System.out.println(value);
}
```

**Default values:** When you create an array with `new`, elements are initialized:

- `int[]` → all 0
- `double[]` → all 0.0
- `boolean[]` → all `false`
- `String[]` (or any object array) → all `null`

### 5.2 — Common Array Operations

```java
// Find the maximum value
public static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

// Calculate the average
public static double average(int[] arr) {
    int sum = 0;
    for (int value : arr) {
        sum += value;
    }
    return (double) sum / arr.length;
}

// Reverse an array in place
public static void reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```

### 5.3 — 2D Arrays

A 2D array is an array of arrays:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matrix[0][0]);  // 1 (row 0, column 0)
System.out.println(matrix[1][2]);  // 6 (row 1, column 2)
System.out.println(matrix.length);    // 3 (number of rows)
System.out.println(matrix[0].length); // 3 (number of columns in row 0)

// Iterating
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        System.out.print(matrix[row][col] + " ");
    }
    System.out.println();
}
```

### 5.4 — Strings in Depth

Strings are objects. Here are the methods you will use constantly:

```java
String s = "Hello, World!";

s.length()               // 13
s.charAt(0)              // 'H'
s.substring(0, 5)        // "Hello" (from index 0, up to but NOT including 5)
s.substring(7)           // "World!" (from index 7 to end)
s.toLowerCase()          // "hello, world!"
s.toUpperCase()          // "HELLO, WORLD!"
s.trim()                 // removes leading/trailing whitespace
s.contains("World")      // true
s.indexOf("World")       // 7
s.indexOf("xyz")         // -1 (not found)
s.startsWith("Hello")    // true
s.endsWith("!")          // true
s.replace("World", "Java")  // "Hello, Java!"
s.split(", ")            // ["Hello", "World!"]
s.isEmpty()              // false
s.toCharArray()          // char[] {'H','e','l','l','o',',',' ','W','o','r','l','d','!'}
```

**String concatenation and StringBuilder:**

```java
// Simple concatenation with + (fine for small amounts)
String full = "Hello" + " " + "World";

// PROBLEM: In a loop, + creates many intermediate String objects (wasteful)
String result = "";
for (int i = 0; i < 10000; i++) {
    result += i;  // BAD: creates a new String object each iteration
}

// SOLUTION: Use StringBuilder for building strings in loops
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append(i);
}
String result = sb.toString();
```

> **🔒 WHAT YOU MUST MEMORIZE**
> 
> - Arrays are fixed-size, zero-indexed
> - `arr.length` (no parentheses) for arrays
> - `str.length()` (with parentheses) for Strings
> - Strings are immutable — every "modification" creates a new String
> - Use `StringBuilder` for building strings in loops
> - Use `.equals()` to compare String content, never `==`

### 5.5 — Exercises (Chapter 5)

**Exercise 5.1** — Write a method that takes an array of integers and returns a new array containing only the even numbers.

<details> <summary>Hint</summary> First, count how many even numbers there are (to know the size of the new array). Then create the new array and fill it. </details> <details> <summary>Solution</summary>

```java
public class FilterEvens {
    public static int[] filterEvens(int[] arr) {
        int count = 0;
        for (int val : arr) {
            if (val % 2 == 0) count++;
        }
        
        int[] result = new int[count];
        int index = 0;
        for (int val : arr) {
            if (val % 2 == 0) {
                result[index] = val;
                index++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] evens = filterEvens(data);
        for (int val : evens) {
            System.out.print(val + " ");
        }
        // Output: 2 4 6 8
    }
}
```

</details>

**Exercise 5.2** — Write a method `countWords(String sentence)` that returns the number of words in a sentence (words separated by spaces).

<details> <summary>Solution</summary>

```java
public class WordCount {
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }
    
    public static void main(String[] args) {
        System.out.println(countWords("Hello World"));          // 2
        System.out.println(countWords("  spaces  everywhere ")); // 2
        System.out.println(countWords(""));                      // 0
        System.out.println(countWords("OneWord"));               // 1
    }
}
```

`\\s+` is a regex meaning "one or more whitespace characters". `trim()` removes leading/trailing spaces so they don't create empty splits.

</details>

**Exercise 5.3** — Write a program that reads 5 student grades into an array, then prints the highest grade, lowest grade, and average.

<details> <summary>Solution</summary>

```java
import java.util.Scanner;

public class GradeStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }
        
        double max = grades[0];
        double min = grades[0];
        double sum = 0;
        
        for (double grade : grades) {
            if (grade > max) max = grade;
            if (grade < min) min = grade;
            sum += grade;
        }
        
        System.out.println("Highest: " + max);
        System.out.println("Lowest:  " + min);
        System.out.println("Average: " + (sum / grades.length));
        scanner.close();
    }
}
```

</details>

---

## Chapter 6: Debugging and Thinking Like a Programmer

### 6.1 — Types of Errors

|Error Type|When It Happens|Example|
|---|---|---|
|**Compilation error** (_erreur de compilation_)|Before the program runs. Syntax/type mistake.|Missing semicolon, wrong type assignment|
|**Runtime error** (_erreur d'exécution_)|While the program runs. It crashes.|Dividing by zero, array index out of bounds, NullPointerException|
|**Logic error** (_erreur de logique_)|Program runs but gives wrong results.|Using `<` instead of `<=`, wrong formula|

**Logic errors are the hardest** because the compiler cannot catch them. You must test your code with known inputs and expected outputs.

### 6.2 — Reading Error Messages

Java error messages look scary but follow a pattern:

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    at MyProgram.main(MyProgram.java:8)
```

**Read it bottom-up:**

1. `at MyProgram.main(MyProgram.java:8)` — the error is on line 8 of MyProgram.java
2. `ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5` — you tried to access index 5 in an array that only has indices 0–4
3. `Exception in thread "main"` — it happened in the main thread (your program)

**Most common runtime exceptions:**

|Exception|Cause|
|---|---|
|`NullPointerException`|Calling a method on a variable that is `null`|
|`ArrayIndexOutOfBoundsException`|Accessing an array index that doesn't exist|
|`ArithmeticException`|Dividing an integer by zero|
|`NumberFormatException`|Trying to parse "abc" as an integer|
|`StackOverflowError`|Infinite recursion|
|`StringIndexOutOfBoundsException`|Accessing a character at an invalid index in a String|

### 6.3 — Debugging Strategy

When your program doesn't work:

1. **Read the error message.** It tells you the line number and error type. Go to that line.
2. **Check your assumptions.** Print the value of every variable near the problem. `System.out.println("DEBUG: x = " + x);`
3. **Simplify.** Remove code until the error goes away. Then add code back piece by piece.
4. **Rubber duck debugging.** Explain your code line by line out loud (or in writing). The act of explaining often reveals the bug.
5. **Check boundary conditions.** What happens when the array is empty? When the number is 0? When the string is null?

### 6.4 — Writing Testable Code

Good methods are easier to debug because they have clear inputs and outputs:

```java
// HARD TO DEBUG: does many things, uses global state
public static void processEverything() { ... }

// EASY TO DEBUG: clear input → clear output
public static double calculateAverage(int[] numbers) { ... }
public static boolean isValidEmail(String email) { ... }
public static int[] sortArray(int[] arr) { ... }
```

Test each method independently with known values before combining them.

---

## PART I — CHECKPOINT EXAM

Answer these without looking at the chapter. Write code on paper.

1. What is the exact signature of the main method in Java?
2. What are the 8 primitive types?
3. What is the difference between `==` and `.equals()` for Strings?
4. What is the output of `int result = 7 / 2;`?
5. Write a method `countDigits(int n)` that returns the number of digits in a positive integer.
6. What does "pass-by-value" mean for primitive types? For reference types?
7. Write a complete program that reads N integers from the user, stores them in an array, and prints them in reverse order.
8. What is the difference between a compilation error and a runtime error? Give an example of each.
9. Why should you use `StringBuilder` instead of `String` concatenation in a loop?
10. Write a method `isPrime(int n)` from memory.

**Passing standard:** You should be able to answer at least 8 of these correctly and completely. If you cannot, re-read Part I before moving on.

---
