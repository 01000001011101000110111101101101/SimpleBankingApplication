import java.util.Scanner;

public class BankingApplication {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount customer = new BankAccount("John D. Roosevelt", "A352");
        customer.showMenu();
    }
}

class BankAccount {
    int balance;
    int prevTransaction;
    String customerName;
    String customerID;

    BankAccount(String cName, String cID) {
        customerName = cName;
        customerID = cID;
    }

    void deposit (int amount)
    {
        if (amount != 0) {
            if (amount < 0) {
                System.out.println("You can't deposit negative amount! Try again...");
                return;
            }
            balance += amount;
            prevTransaction = amount;
        }
    }

    void withDraw(int amount)
    {
        if (amount != 0) {
            balance -= amount;
            prevTransaction = -amount;
        }
    }

    void getPrevTransaction(){
        if (prevTransaction > 0) {
            System.out.println("Successful Process, deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Successful Process, withdrawn: " + Math.abs(prevTransaction));
        } else {
            System.out.println("Fail. No transaction is occurred!");
        }
    }

    void showMenu()
    {
        char option = '\0';
        int amount;
        int withdraw;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerID);
        System.out.println();
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=".repeat(25));
            System.out.println("Enter the option");
            System.out.println("=".repeat(25));

            option = scanner.next().charAt(0);
            option = Character.toUpperCase(option);

            switch (option) {
                case 'A':
                    System.out.println("=".repeat(25));
                    System.out.println("Balance is " + balance);
                    System.out.println("=".repeat(25));
                    System.out.println();
                    break;

                    case 'B':
                        System.out.println("=".repeat(25));
                        System.out.println("Enter the amount to deposit: ");
                        System.out.println("=".repeat(25));
                        amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println();
                        break;

                        case 'C':
                            System.out.println("=".repeat(25));
                            System.out.println("Enter the amount to withdraw: ");
                            System.out.println("=".repeat(25));
                            withdraw = scanner.nextInt();
                            withDraw(withdraw);
                            System.out.println();
                            break;

                            case 'D':
                                System.out.println("=".repeat(25));
                                getPrevTransaction();
                                System.out.println("=".repeat(25));
                                System.out.println();
                                break;

                                case 'E':
                                    System.out.println("=".repeat(25));
                                    break;

                default:
                    System.out.println("Invalid option! Please try again...");
                    break;
            }
        } while (option != 'E');
    }

}
