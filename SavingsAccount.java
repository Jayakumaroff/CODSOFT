import java.util.Scanner;

class SavingsAccount {
    private double balance;

    // Constructor to initialize the account with a starting balance
    public SavingsAccount(double initialAmount) {
        if (initialAmount >= 0) {
            this.balance = initialAmount;
        } else {
            System.out.println("Initial amount cannot be negative. Starting with a balance of 0.");
            this.balance = 0;
        }
    }

    // Retrieves the current balance
    public double checkBalance() {
        return balance;
    }

    // Adds a specified amount to the balance if valid
    public void depositFunds(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully added %.2f to your account.\n", amount);
        } else {
            System.out.println("Amount to deposit must be positive.");
        }
    }

    // Withdraws a specified amount from the balance if valid
    public boolean withdrawFunds(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You have withdrawn %.2f from your account.\n", amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Withdrawal failed: Insufficient funds.");
            return false;
        } else {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }
}

class ATMInterface {
    private SavingsAccount account;

    // Constructor to set up the ATM with a linked bank account
    public ATMInterface(SavingsAccount account) {
        this.account = account;
    }

    // Shows the main menu
    public void displayOptions() {
        System.out.println("\n--- ATM Options ---");
        System.out.println("1. Withdraw Funds");
        System.out.println("2. Deposit Funds");
        System.out.println("3. View Current Balance");
        System.out.println("4. Exit");
    }

    // Handles the withdrawal option
    public void handleWithdrawal() {
        double amount = InputHelper.getAmountFromUser("Enter the amount to withdraw: ");
        account.withdrawFunds(amount);
    }

    // Handles the deposit option
    public void handleDeposit() {
        double amount = InputHelper.getAmountFromUser("Enter the amount to deposit: ");
        account.depositFunds(amount);
    }

    // Shows the current balance
    public void showBalance() {
        System.out.printf("Your current balance is: %.2f\n", account.checkBalance());
    }

    // Runs the ATM interface
    public void start() {
        int option;

        do {
            displayOptions();
            option = (int) InputHelper.getAmountFromUser("Select an option: ");

            switch (option) {
                case 1:
                    handleWithdrawal();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (option != 4);
    }
}

class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    // Gets a double value from the user with a custom prompt
    public static double getAmountFromUser(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print(prompt);
            scanner.next(); // clear invalid input
        }
        return scanner.nextDouble();
    }
}

public class MainApp {
    public static void main(String[] args) {
        double startingBalance = InputHelper.getAmountFromUser("Enter your starting balance: ");

        SavingsAccount userAccount = new SavingsAccount(startingBalance);
        ATMInterface atmInterface = new ATMInterface(userAccount);
        atmInterface.start();
    }
}
