import java.util.Scanner;

public class CalculatorDemo {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        double result;
        System.out.println("Starting calculation:");
        result = calculate(enterDouble(), enterOperation());
        System.out.println("Result: " + result); //Output result
    }

    //Calculation method
    private static double calculate(double a, char operation) {
        switch (operation) {
            case ('+') -> {
                return Calculator.add(a, enterDouble());
            }
            case ('-') -> {
                return Calculator.subtract(a, enterDouble());
            }
            case ('*') -> {
                return Calculator.multiply(a, enterDouble());
            }
            case ('/') -> {
                try {
                    return Calculator.divide(a, enterDouble());
                } catch (ArithmeticException e) {//Catch division by 0. Enter new divider
                    System.out.println(e.getMessage() + " Enter new divider.");
                    return calculate(a, operation);
                }
            }
            default -> {//Enter new operation
                System.out.println("Unknown operation: \"" + operation + "\"");
                return calculate(a, enterOperation());
            }
        }
    }


    //Enter operation
    private static char enterOperation() {
        System.out.print("Enter operation (+,-,*,/): ");
        String str = CalculatorDemo.scan.nextLine();
        if (str.length() == 1) {
            return str.charAt(0);
        }
        System.out.println("Wrong operation. Enter one symbol.");
        return enterOperation();
    }

    //Enter double number from console method
    private static double enterDouble() {
        try {
            System.out.print("Enter a number: ");
            return Double.parseDouble(CalculatorDemo.scan.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a number! Try again!");
            return enterDouble();
        }
    }
}
