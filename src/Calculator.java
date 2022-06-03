import java.util.Scanner;

public class Calculator {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Start new calculation.");
        calculate(enterDouble(), enterOperation());  //Calculate result
    }

    //Calculation method
    private static void calculate (double a,char operation){
        switch (operation) {
                case ('+') -> a=a+enterDouble();
                case ('-') -> a=a-enterDouble();
                case ('*') -> a=a*enterDouble();
                case ('/') -> {
                        double divider = enterDouble();
                        if (divider==0){
                            System.out.println("Division by 0. Enter another divider: ");
                            calculate (a, operation);
                        }else {
                            a=a/divider;
                        }
                }
                case ('c') -> {
                    System.out.println("Start new calculation.");
                    a=enterDouble();
                }
                default -> {
                    System.out.println("Unknown operation: \"" + operation + "\"");
                    calculate (a, enterOperation());
                }
        }
        System.out.println("Result: "+a);
        calculate (a,enterOperation());
    }

    //Enter operation
    private static char enterOperation() {
        System.out.print("Enter operation (+,-,*,/) or 'c' to cancel: ");
        String str = Calculator.in.nextLine();
        if (str.length()==1){
            return str.charAt(0);
        }
        System.out.println("Wring operation. Enter one symbol.");
        return enterOperation();
    }

    //Enter double
    private static double enterDouble() {
        try{
            System.out.print("Enter a number: ");
            return Double.parseDouble(Calculator.in.nextLine().replace(',','.'));
        }catch (NumberFormatException e) {
            System.out.println("Your input is not a number! Try again!");
            return enterDouble();
        }
    }
}
