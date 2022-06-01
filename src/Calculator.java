import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) throws Exception {
        double a, b;    //operands
        double res;     //result field
        char oper;      //operator field

                System.out.println("Starting new calculation:");
                a = enterNumber();            //Enter first double number
                oper = enterOperation();      //Enter operation
        while (true) {                        //Catch "division by 0" Exception and enter new divider.
            try {
                b = enterNumber();            //Enter second double number
                res = calculate(a, oper, b);  //Calculate result
                break;
            } catch (ArithmeticException e) { //Exception in Calculate method. "Division by 0. Enter another divider:"
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Result: " + a + oper + b + '=' + res); //Output result
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
                return multiplicate(a, b);
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
    private static double multiplicate(double a, double b){
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
    private static char enterOperation() {
        char oper;
        while(true){ // If you entered not the expected operator, the cycle prompts you to enter again
            Scanner in = new Scanner(System.in);
            System.out.print("Enter operation (+,-,*,/): ");
            oper = in.next().charAt(0);
            switch (oper){
                case '+', '-', '*', '/' -> { return oper;}
                default -> System.out.println("Unknown operation: "+oper);
            }
        }
    }

    //Enter double number from console method
    private static double enterNumber() {
        while(true) {
            try{
                Scanner in = new Scanner(System.in);
                System.out.print("Enter a number: ");
                return in.nextDouble();
            }catch (InputMismatchException e) {
                System.out.println("Your input is not a number! Try again!");
            }
        }
    }
}
