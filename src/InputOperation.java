public class InputOperation {
    //Enter operation
    public static char enterOperation() {
        System.out.print("Enter operation (+,-,*,/): ");
        String str = CalculatorDemo.scan.nextLine();
        if (str.length() == 1) {
            switch (str.charAt(0)) {
                case '+', '-', '*', '/' -> {
                    return str.charAt(0);
                }
                default -> {//Enter new operation
                    System.out.println("Unknown operation: \"" + str + "\"");
                    return enterOperation();
                }
            }
        }
        System.out.println("Wrong operation. Enter one symbol.");
        return enterOperation();
    }
}
