public class InputDouble {
    //Enter double number from console method
    public static double enterDouble() {
        try {
            System.out.print("Enter a number: ");
            return Double.parseDouble(CalculatorDemo.scan.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a number! Try again!");
            return enterDouble();
        }
    }
}
