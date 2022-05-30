/*
Программа последовательно запрашивает ввод первого операнда, затем операцию, затем второй операнд.
При неверном вводе операнда, программа прекращает работу.
При неверном вводе операции - предлагает повторно ввести операцию.
Если при вводе операции введено более одного символа, то учитывается только первый
При вводе операции деления и втором операнде равном нулю -
                сообщает о невозможности деления на ноль и прекращает работу.

 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        double a, b;    //operands
        double res;     //result field
        char oper;      //operator field

        a=enterNumber();            //Enter first double number
        oper=enterOperation();      //Enter operation
        b=enterNumber();            //Enter second double number
        res=calculate(a, oper, b);  //Calculate result
        System.out.println("Result: "+a+oper+b+'='+res); //Output result
    }

    //Calculation method
    private static double calculate (double a, char oper, double b){
        double res=0;
        switch (oper) {
            case ('+'): {
                res=a+b;
                break;
            }
            case ('-'): {
                res=a-b;
                break;
            }
            case ('*'): {
                res=a*b;
                break;
            }
            case ('/'): {
                if (b == 0) {
                    System.out.println("Division by zero is not possible. Exit!");
                    System.exit(0);

                } else {
                    res=a/b;
                    break;
                }
            }

        }
        return res;
    }

    //Enter operation from console
    private static char enterOperation() {
        char oper;
        for (;;){ // If you entered not the expected operator, the cycle prompts you to enter again
            Scanner in = new Scanner(System.in);
            System.out.print("Enter operation (+,-,*,/): ");
            oper = in.next().charAt(0);
            if (oper=='+'){
                break;
            }else if (oper=='-'){
                break;
            }else if (oper=='*'){
                break;
            }else if (oper=='/'){
                break;
            }else {
                System.out.println("You entered unexpected symbol, try again.");
            }
        }
        return oper;
    }

    //Enter double number from console method
    private static double enterNumber() {
        double num;
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter a number: ");
                num = in.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Your input is not a number! Try again!");
            }
        }
        return (num);
    }

}
