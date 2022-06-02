import java.util.Scanner;

public class Operations {
    private static final Scanner in = new Scanner(System.in);
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
    public static void calculate(){
        double num1=Calculator.setDouble();
        setOperation();
        double num2=Calculator.setDouble();
        double result;
        switch (getOperation()) {
            case ('+') -> {
                result= add(num1, num2);
                System.out.println("Result: " + num1 + getOperation() + num2 + '='+result); //Output result
            }
            case ('-') -> {
                result= subtract(num1, num2);
                System.out.println("Result: " + num1 + getOperation() + num2 + '='+result); //Output result
            }
            case ('*') -> {
                result= multiply(num1, num2);
                System.out.println("Result: " + num1 + getOperation() + num2 + '='+result); //Output result
            }
            case ('/') -> {
                while(num2==0){
                    System.out.println("Division by 0. Try another divider!");
                    num2=Calculator.setDouble();
                }
                result=divide(num1, num2);
                System.out.println("Result: " + num1 + getOperation() + num2 + '='+result); //Output result
            }
        }
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
