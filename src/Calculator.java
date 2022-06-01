import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static double num1, num2;    //operands
    private static double result;     //result field
    private static char operation;      //operator field


    public static void main(String[] args) throws Exception {
        System.out.println("Starting new calculation:");
        num1 = setDouble();             //Enter first double number
        setOperation();                 //Enter operation
        while (true) {                  //Catch "division by 0" Exception and enter new divider.
            try {
                num2 = setDouble();            //Enter second double number
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
    private static void setOperation() {
        char oper;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter operation (+,-,*,/): ");
        oper = in.next().charAt(0);
        switch (oper){
            case '+', '-', '*', '/' -> Calculator.operation=oper;
            default -> {
                System.out.println("Unknown operation: "+oper+" -> Try again!");
                setOperation();
            }
        }

    }

    //Enter double number from console method
    private static double setDouble() {
            try{
                Scanner in = new Scanner(System.in);
                System.out.print("Enter a number: ");
                return in.nextDouble();
            }catch (InputMismatchException e) {
                System.out.println("Your input is not a number! Try again!");
            }
    return setDouble();
    }
}
