import java.util.Scanner;

public class Operations {
    private static Scanner in = new Scanner(System.in);
    private static char operation;

    public static char getOperation() {
        return operation;
    }
    //Enter operation from console
    public static void setOperation() {
        char oper;
        System.out.print("Enter operation (+,-,*,/): ");
        oper = in.next().charAt(0);
        switch (oper){
            case '+', '-', '*', '/' -> operation=oper;
            default -> {
                System.out.println("Unknown operation: "+oper+"-> Try again!");
                setOperation();
            }
        }

    }

    //Calculation method
    public static double calculate(double num1, double num2) {
        switch (operation) {
            case ('+') -> {return add(num1, num2);}

            case ('-') -> {return subtract(num1, num2);}

            case ('*') -> {return multiply(num1, num2);}

            case ('/') -> {
                while(num2!=0){
                    return divide(num1, num2);
                }
                System.out.println("Division by 0. Try another divider!");
            }
            default -> {
                System.out.println("Unknown operation: \"" + operation + "\". Try again!");
                break;
            }
        }
        calculate(num1, Calculator.setDouble());
    }

    //Addition method
    static double add(double a, double b){
        return a+b;
    }

    //Subtraction method
    static double subtract(double a, double b){
        return a-b;
    }

    //Multiplication method
    static double multiply(double a, double b){
        return a*b;
    }

    //Division method
    static double divide (double a, double divider) throws ArithmeticException{
        if (divider==0){
            throw new ArithmeticException("Division by 0. Enter another divider: ");
        }
        return a/divider;
    }

}
