import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    private static double num1, num2;           //operands
    private static double res;                  //result field
    static Scanner in = new Scanner(System.in); //Input

    public static void main(String[] args) {
        System.out.println("Starting new calculation.");
        num1 = setDouble();                     //Enter first double number
        Operations.setOperation();              //Enter operation
        Operations.calculate(num1,setDouble()); //Calculate
        System.out.println("Result: " + num1 + Operations.getOperation() + num2 + '=' + res); //Output result
    }
    //Enter double number from console method
    public static double setDouble() {
        do {
            try{
                System.out.print("Enter a number: ");
                return in.nextDouble();
            }catch (InputMismatchException e) {
                System.out.println("Your input is not a number! Try again!");
            }
        }while (!in.hasNextDouble());
        return in.nextDouble();
    }
}
