//  Create a program that works as a calculator.
//  The program should ask the user for the operation to be performed (addition, subtraction, multiplication or division) and should also give the user the option to quit.
//  After choosing the operation, the program should ask for the operands of that operation, and print the result along with the operands and the operator.
//  The program should only exit when the user chooses to quit.

import java.util.Scanner;

public class Calculator {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean debug = false;
        int option;
        boolean end = false;
        double operand1 = 0;
        double operand2 = 0;

        while(!end) {
            printMenu();
            option = askOption();
            switch(option) {
                case 1:
                    // add
                    if(debug) {
                        System.out.println("DEBUG: adding");
                    }

                    operand1 = askOperand1();
                    operand2 = askOperand2();
                    System.out.printf("%f + %f = %f\n", operand1, operand2, operand1+operand2);

                    break;
                case 2:
                    // subtract
                    if(debug) {
                        System.out.println("DEBUG: subtracting");
                    }

                    operand1 = askOperand1();
                    operand2 = askOperand2();
                    System.out.printf("%f - %f = %f\n", operand1, operand2, operand1-operand2);

                    break;
                case 3:
                    // multiply
                    if(debug) {
                        System.out.println("DEBUG: multiplying");
                    }

                    operand1 = askOperand1();
                    operand2 = askOperand2();
                    System.out.printf("%f * %f = %f\n", operand1, operand2, operand1*operand2);

                    break;
                case 4:
                    // divide
                    if(debug) {
                        System.out.println("DEBUG: dividing");
                    }

                    operand1 = askOperand1();
                    operand2 = askOperand2();
                    System.out.printf("%f / %f = %f\n", operand1, operand2, operand1/operand2);

                    break;
                case 5:
                    // quit
                    if(debug) {
                        System.out.println("DEBUG: quitting");
                    }
                    end = true;
                    System.out.println("Thank you for using me..");
                    break;
            }
        }



    }

    public static double askOperand1() {
         System.out.print("Operand 1:");
         // int operand1 = sc.nextDouble();
         // return operand1;
         return sc.nextDouble();
    }

    public static double askOperand2() {
         System.out.print("Operand 2:");
         // int operand2 = sc.nextDouble();
         // return operand2;
         return sc.nextDouble();
    }

    public static int askOption() {
        System.out.print("Option: ");
        // int selection = sc.nextInt();
        // return selection;
        return sc.nextInt();
    }

    public static void printMenu() {
        System.out.println("1 - add");
        System.out.println("2 - subtract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
        System.out.println("5 - quit");
    }
}
