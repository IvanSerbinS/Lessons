import java.util.Scanner;

public class Calculator {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        double result;
        System.out.println("Starting calculation:");
        result = calculate(enterDouble(), enterOperation(), enterDouble());
        System.out.println("Result: "+ result); //Output result
    }

    //Calculation method
    private static double calculate (double a, char operation, double b){
        switch (operation) {
            case ('+') -> {return add(a, b);}
            case ('-') -> {return subtract(a, b);}
            case ('*') -> {return multiply(a, b);}
            case ('/') -> {
                    try {
                        return divide(a, b);
                    } catch (ArithmeticException e){//Catch division by 0. Enter new divider
                        System.out.println(e.getMessage()+" Enter new divider.");
                        return calculate(a, operation, enterDouble());
                    }
            }
            default -> {//Enter new operation
                System.out.println("Unknown operation: \""+ operation+"\"");
                return calculate(a, enterOperation(), b);
            }
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
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a/divider;
    }

    //Enter operation
    private static char enterOperation() {
        System.out.print("Enter operation (+,-,*,/): ");
        String str = Calculator.scan.nextLine();
        if (str.length()==1){
            return str.charAt(0);
        }
        System.out.println("Wrong operation. Enter one symbol.");
        return enterOperation();
    }

    //Enter double number from console method
    private static double enterDouble() {
        try{
            System.out.print("Enter a number: ");
            return Double.parseDouble(Calculator.scan.nextLine().replace(',','.'));
        }catch (NumberFormatException e) {
            System.out.println("Your input is not a number! Try again!");
            return enterDouble();
        }
    }
}
