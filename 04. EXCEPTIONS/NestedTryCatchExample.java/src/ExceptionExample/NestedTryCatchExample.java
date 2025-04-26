package ExceptionExample;

import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {12, 24, 36, 48, 60};

        try {
            System.out.print("Enter array index: ");
            int index = scanner.nextInt();

            try {
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                int result = numbers[index] / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}
