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
    public static void main(String args[]){
        float a, b; //operands fields
        float res;  //result field
        char oper;  //operator field

        a=enter();  //Enter first float number

        //Enter operation
        for (;;){ // If you entered not the expected operator, the cycle prompts you to enter again
            oper=operation();
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

        b=enter();        //Enter second float number
        res=calculate(a, oper, b); //Calculate result
        System.out.println("Result: "+a+oper+b+'='+res); //Output result
    }

    //Calculation method
    private static float calculate (float a, char oper, float b){
        float res=0;
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
    private static char operation() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter operation(+,-,*,/):");
        return in.next().charAt(0);

    }
    private static float enter() {                      //Enter number from console
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number:");
        float num=0;

        try {
            num = in.nextFloat();
        }catch (InputMismatchException e) {
            System.out.println("Your input is not a number! Exit");
            System.exit(1);
        }
        return (num);
    }

}
