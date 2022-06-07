import java.util.Scanner;

public class CalculatorDemo {
    static Scanner scan = new Scanner(System.in);
    static double num1;
    static char operation;
    static double num2;

    public static void main(String[] args) {
        double result;
        System.out.println("Starting calculation:");
        num1 = InputDouble.enterDouble();
        operation = InputOperation.enterOperation();
        num2 = InputDouble.enterDouble();
        do {
            try {
                result = calculate(num1, operation, num2);
                break;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage()+" Enter new divider!");
                num2 = InputDouble.enterDouble();
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
                operation = InputOperation.enterOperation();
            }
        } while (true);
        System.out.println("Result: " + result); //Output result
    }

    //Calculation method
    private static double calculate(double a, char operation, double b) throws UnsupportedOperationException, ArithmeticException {
        switch (operation) {
            case ('+') -> {
                return Calculator.add(a, b);
            }
            case ('-') -> {
                return Calculator.subtract(a, b);
            }
            case ('*') -> {
                return Calculator.multiply(a, b);
            }
            case ('/') -> {
                try {
                    return Calculator.divide(a, b);
                } catch (ArithmeticException e) {//Catch division by 0. Enter new divider
                    throw new ArithmeticException(e.getMessage());
                }
            }
            default -> throw new UnsupportedOperationException("UnsupportedOperationException");
        }
    }
}
