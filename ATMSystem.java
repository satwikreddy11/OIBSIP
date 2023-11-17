import java.util.Scanner;

class User {
    private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public boolean isValidUser(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }
}

class TransactionHistory {
    // This class can be extended to store transaction history details
    // such as date, time, transaction type, amount, etc.
}

class ATM {
    private User currentUser;
    private TransactionHistory transactionHistory;

    public ATM(User user) {
        this.currentUser = user;
        this.transactionHistory = new TransactionHistory();
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void processTransaction(int choice) {
        switch (choice) {
            case 1:
                displayTransactionHistory();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                transfer();
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private void displayTransactionHistory() {
        // Logic to display transaction history
        System.out.println("Transaction History:");
        // Implement this based on your requirements
    }

    private void withdraw() {
        // Logic for withdrawing money
        // Update transaction history
        System.out.println("Withdrawal successful.");
    }

    private void deposit() {
        // Logic for depositing money
        // Update transaction history
        System.out.println("Deposit successful.");
    }

    private void transfer() {
        // Logic for transferring money
        // Update transaction history
        System.out.println("Transfer successful.");
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample user
        User sampleUser = new User("12345", "6789");

        System.out.println("Welcome to the ATM System");

        // Login
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();
        System.out.print("Enter pin: ");
        String pin = scanner.nextLine();

        if (sampleUser.isValidUser(userId, pin)) {
            ATM atm = new ATM(sampleUser);

            while (true) {
                atm.displayMenu();

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                atm.processTransaction(choice);
            }
        } else {
            System.out.println("Invalid user id or pin. Exiting...");
        }
    }
}
