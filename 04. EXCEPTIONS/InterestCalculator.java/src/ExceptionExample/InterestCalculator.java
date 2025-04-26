package ExceptionExample;

import java.util.Scanner;

public class InterestCalculator {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter rate of interest: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}
