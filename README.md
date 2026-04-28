# INTRODUCTION TO JAVA

> In Java, in order to get a code to run, you need a method

```java
    public static void main (String[] args){
    }
```

## Header function

```java
      public static class UI {
        public static void printHeader(String title) {
            System.out.println("=================================");
            System.out.println(title.toUpperCase());
            System.out.println("=================================");
        }
    }
```

- To get the current datetime include these header files

```java
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;

   public static class DateTimeExample {
        public static void showDateTime() {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            System.out.println("Current Time: " + now.format(formatter));
        }
    }
```

### ANSI Colors

```java
 public static class ANSI {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
}
```

### Spinner

```java
        public static class Spinner {
        public static void spin(int durationMs) throws InterruptedException {

            char[] frames = {'|', '/', '-', '\\'};
            int i = 0;
            long end = System.currentTimeMillis() + durationMs;

            while (System.currentTimeMillis() < end) {
                System.out.print("\rLoading " + frames[i++ % frames.length]);
                Thread.sleep(100);
            }

            System.out.print(ANSI. YELLOW + "\rDone!      \n");
        }
    }
```

### Main

```java
    public static void main(String[] args) {

        try {
            Runtime.getRuntime().exec("cmd /c color 03");
            new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()
                .start()
                .waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print(ANSI.YELLOW);
        DateTimeExample.showDateTime();
        UI.printHeader(" Introduction to Java");

        System.out.print(ANSI.CYAN);
        System.out.println("[1] I like rice");
        System.out.println("[2] Rice is really good");
        System.out.println("[3] Buy some rice for me");
        System.out.print(ANSI.RESET);

        try {
            Spinner.spin(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

## VARIABLES

> A `variable`
>
> - Is a reusable container for a value
> - A variable behaves as if it was the value it contains

### Types of Variable in Java

1. 🧧 Primitive. It is a simple values stored directly in memory (stack).
2. 🟢 Reference -> memory address (stack) that points to the (heep).

### Data Types

| No  | Primitive | Reference |
| --- | --------- | --------- |
| 1.  | int       | string    |
| 2.  | double    | array     |
| 3.  | char      | object    |
| 4.  | boolean   | -         |

> Note that in Java, there are two ways to creating a variable
>
> 1. declaration
> 2. assignment

```java
    //creating int variables
    int age = 26;
    int year = 2026;
    int quantity = 10;

    SUB.subTitles("Integers");
    System.out.println(ANSI.DEFAULT_COLOR);
    System.out.print("[1] You are " + age + " years old\n");
    System.out.print("[2] The year is " + year +" \n");
    System.out.print("[3] The total quantity is " + quantity +" \n\n");

    //creating double variables
    double price = 19.99;
    double gpa = 3.99;
    double temperature = -30.19;

    SUB.subTitles("Double");
    System.out.println(ANSI.PURPLE);
    System.out.print("[1] The price is $"+ price + "\n");
    System.out.print("[2] Your gpa is "+ gpa + "\n");
    System.out.print("[3] Today's temperature is "+ temperature + "\n\n");

    //creating char variables
    char currency = '$';
    char grade = 'A';
    char symbol = '!';

    SUB.subTitles("Char");
    System.out.println(ANSI.PURPLE);
    System.out.print("[1] The currency is"+ currency + "\n");
    System.out.print("[2] Your grade is " + grade + "\n");
    System.out.print("[3] Come back here"+ symbol + "\n\n");

    //creating boolean variables
    boolean isStudent = true;
    boolean isForSale = false;
    boolean isOnline = true;


    SUB.subTitles("Boolean");
    System.out.println(ANSI.PURPLE);
    System.out.print((isStudent) ? "[1] John is a student\n" :
                                    "[1] Ama is a student\n");
    System.out.print((isForSale) ? "[2] The iPhone 11 Pro is for sale\n" :
                                    "[2] The iPhone 11 Pro is not for sale\n");
    System.out.print((isOnline) ? "[3] Jacquelyn is online\n\n" :
                                "[3] Jacquelyn is offline" + "\n\n");

  //creating string variables
   String name = "James Dukes";
   String country = "The Republic of Congo";
   String email = "jdukes@gmail.com";

   SUB.subTitles("Strings");
   System.out.println(ANSI.PURPLE);
   System.out.print("[1] Your name is "+ name + "\n");
   System.out.print("[2] "+ name + " comes from " + country + "\n");
   System.out.print("[3] His email address is " + email + "\n\n");
```

```java

  int age = 21;
```

## NOTES

> To suppress warnings, use

```java
      @SuppressWarnings("deprecation")
```

> The shortcut for `System.out.println()` is `sout + tab`
>
> - In programming, your variables should be descriptive.
