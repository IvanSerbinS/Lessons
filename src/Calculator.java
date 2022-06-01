import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static double a, b;    //operands
    private static double res;     //result field
    private static char operation;      //operator field
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {


                System.out.println("Starting new calculation:");
                a = setNumber();            //Enter first double number
                Calculator.setOperation();      //Enter operation
        while (true) {                        //Catch "division by 0" Exception and enter new divider.
            try {
                b = setNumber();            //Enter second double number
                res = calculate(a, operation, b);  //Calculate result
                break;
            } catch (ArithmeticException e) { //Exception in Calculate method. "Division by 0. Enter another divider:"
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Result: " + a + operation + b + '=' + res); //Output result
    }

    //Calculation method
    private static double calculate (double a, char oper, double b) throws Exception{
        switch (oper) {
            case ('+') -> {
                return add(a, b);
            }
            case ('-') -> {
                return subtract(a, b);
            }
            case ('*') -> {
                return multiply(a, b);
            }
            case ('/') -> {
                return divide(a, b);
            }
            default -> throw new Exception("Unknown operation: \""+ oper+"\". Try again!");
        }

    }

    //Addition method
    private static double add(double a, double b){
        return a+b;
    }

    //Subtraction method
    private static double subtract(double a, double b){
        return a-b;
    }

    //Multiplication method
    private static double multiply(double a, double b){
        return a*b;
    }

    //Division method
    private static double divide (double a, double b) throws ArithmeticException{
        if (b==0){
            throw new ArithmeticException("Division by 0. Enter another divider: ");
        }
        return a/b;
    }

    //Enter operation from console
    private static void setOperation() {
        char oper;
        System.out.print("Enter operation (+,-,*,/): ");
        oper = in.next().charAt(0);
        switch (oper){
            case '+', '-', '*', '/' -> Calculator.operation=oper;
            default -> {
                System.out.println("Unknown operation: "+oper+"-> Try again!");
                setOperation();
            }
        }

    }

    //Enter double number from console method
    private static double setNumber() {
        while(true) {
            try{
                System.out.print("Enter a number: ");
                return in.nextDouble();
            }catch (InputMismatchException e) {
                System.out.println("Your input is not a number! Try again!");
            }
        }
    }
}
