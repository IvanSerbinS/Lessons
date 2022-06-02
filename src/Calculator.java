import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Starting new calculation.");
        Operations.calculate(); //Calculate
    }
    //Enter double number from console method
    public static double setDouble() {
        Scanner in = new Scanner(System.in);
        try{
            System.out.print("Enter a number: ");
            return in.nextDouble();
        }catch (InputMismatchException e) {
            System.out.println("Your input is not a number! Try again!");
        }
        return setDouble();
    }
}
