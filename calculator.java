import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getChoice(sc);

            switch (choice) {
                case 1 -> basicArithmetic(sc);
                case 2 -> advancedMath(sc);
                case 3 -> trigonometry(sc);
                case 4 -> {
                    System.out.println("Exiting calculator. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n===== Calculator Menu =====");
        System.out.println("1. Basic Arithmetic (+, -, *, /)");
        System.out.println("2. Advanced Math (%, ^, sqrt, factorial)");
        System.out.println("3. Trigonometry (sin, cos, tan)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    static int getChoice(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // ===== Basic Arithmetic =====
    static void basicArithmetic(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        switch (op) {
            case '+' -> System.out.println("Result: " + (a + b));
            case '-' -> System.out.println("Result: " + (a - b));
            case '*' -> System.out.println("Result: " + (a * b));
            case '/' -> {
                if (b == 0) System.out.println("Error: Division by zero.");
                else System.out.println("Result: " + (a / b));
            }
            default -> System.out.println("Invalid operator.");
        }
    }

    // ===== Advanced Math =====
    static void advancedMath(Scanner sc) {
        System.out.println("\nChoose operation: %, ^, sqrt, factorial");
        System.out.print("Enter operation: ");
        String op = sc.next();

        switch (op) {
            case "%" -> {
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();
                if (b == 0) System.out.println("Error: Modulus by zero.");
                else System.out.println("Result: " + (a % b));
            }
            case "^" -> {
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = sc.nextDouble();
                System.out.println("Result: " + Math.pow(base, exp));
            }
            case "sqrt" -> {
                System.out.print("Enter number: ");
                double x = sc.nextDouble();
                if (x < 0) System.out.println("Error: Square root of negative number.");
                else System.out.println("Result: " + Math.sqrt(x));
            }
            case "factorial" -> {
                System.out.print("Enter a non-negative integer: ");
                int n = sc.nextInt();
                if (n < 0) System.out.println("Error: Factorial of negative number.");
                else System.out.println("Result: " + factorial(n));
            }
            default -> System.out.println("Invalid operation.");
        }
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    // ===== Trigonometry =====
    static void trigonometry(Scanner sc) {
        System.out.println("\nChoose trig function: sin, cos, tan");
        System.out.print("Enter function: ");
        String func = sc.next();
        System.out.print("Enter angle (degrees): ");
        double degrees = sc.nextDouble();
        double radians = Math.toRadians(degrees);

        switch (func) {
            case "sin" -> System.out.println("Result: " + Math.sin(radians));
            case "cos" -> System.out.println("Result: " + Math.cos(radians));
            case "tan" -> {
                if (Math.abs(Math.cos(radians)) < 1e-10)
                    System.out.println("Error: Tangent undefined at " + degrees + " degrees.");
                else
                    System.out.println("Result: " + Math.tan(radians));
            }
            default -> System.out.println("Invalid function.");
        }
    }
}
