import java.util.Scanner;

public class Calculator {
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

    //Enter operation from console
    private static char enterOperation() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter next operation (+,-,*,/) or 'c' to cancel: ");
        return in.next().charAt(0);
    }

    //Enter double number from console method
    private static double enterDouble() {
        try{
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a number: ");
            String str = in.nextLine().replace(',','.');
            return Double.parseDouble(str);
        }catch (NumberFormatException e) {
            System.out.println("Your input is not a number! Try again!");
            return enterDouble();
        }
    }
}
