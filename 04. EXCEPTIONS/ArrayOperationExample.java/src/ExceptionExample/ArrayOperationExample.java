package ExceptionExample;

import java.util.Scanner;

public class ArrayOperationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // You can toggle this between a real array or null to test
        Integer[] numbers = {10, 20, 30, 40, 50}; // Change to null to test NullPointerException
        // Integer[] numbers = null;

        System.out.print("Enter the index to retrieve: ");
        int index = scanner.nextInt();

        try {
            int value = numbers[index];  // May throw exceptions
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }

        scanner.close();
    }
}
