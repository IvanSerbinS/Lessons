public class Calculator {
    //Addition method
    public static double add(double a, double b) {
        return a + b;
    }

    //Subtraction method
    public static double subtract(double a, double b) {
        return a - b;
    }

    //Multiplication method
    public static double multiply(double a, double b) {
        return a * b;
    }

    //Division method
    public static double divide(double a, double divider) throws ArithmeticException {
        if (divider == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / divider;
    }
}
