package ExceptionExample;

import java.util.Scanner;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw amount
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0); // Initial balance

        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance!");
        } finally {
            scanner.close();
        }
    }
}
