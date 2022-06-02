import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws Exception {
        double num1, num2;              //operands
        double result;                  //result field
        char operation;      //operator field
        System.out.println("Starting new calculation:");
        num1 = enterDouble();             //Enter first double number
        operation=enterOperation();                 //Enter operation
        while (true) {                  //Catch "division by 0" Exception and enter new divider.
            try {
                num2 = enterDouble();            //Enter second double number
                result = calculate(num1, operation, num2);  //Calculate result
                break;
            } catch (ArithmeticException e) { //Exception in Calculate method. "Division by 0. -> Enter another divider."
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Result: " + num1 + operation + num2 + '=' + result); //Output result
    }

    //Calculation method
    private static double calculate (double a, char oper, double b) throws Exception{
        switch (oper) {
            case ('+') -> {return add(a, b);}
            case ('-') -> {return subtract(a, b);}
            case ('*') -> {return multiply(a, b);}
            case ('/') -> {return divide(a, b);}
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
    private static double divide (double a, double divider) throws ArithmeticException{
        if (divider==0){
            throw new ArithmeticException("Division by 0. Enter another divider: ");
        }
        return a/divider;
    }

    //Enter operation from console
    private static char enterOperation() {
        char oper;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter operation (+,-,*,/): ");
        oper=in.next().charAt(0);
        switch (oper){
            case '+', '-', '*', '/' -> {return oper;}
            default -> {
                System.out.println("Unknown operation: "+oper+" -> Try again!");
                return enterOperation();
            }
        }
    }

    //Enter double number from console method
    private static double enterDouble() {
            try{
                Scanner in = new Scanner(System.in);
                System.out.print("Enter a number: ");
                return in.nextDouble();
            }catch (InputMismatchException e) {
                System.out.println("Your input is not a number! Try again!");
                return enterDouble();
            }

    }
}
