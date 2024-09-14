import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Successfully depoeited : $" + amount);

        }else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public boolean withdraw(double amount){
        if (amount > balance){
            System.out.println("Insufficient balance.");
            return false;
        }
        else if(amount <= 0){
            System.out.println("Withdrawal amount must be greater then zero.");
            return false;
        }
        else{
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            return true;
        }
    }
    public double checkBalance(){
        return balance;
    }
}
class ATM{
    private BankAccount account;
    public ATM(BankAccount account)
    {
        this.account = account;
    }

    public void showmenu(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposite");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Choose an option : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.println("Enter deposit amount : $");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Enter Withdrawal amount : $");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
            
                default:
                System.out.println("Invalid option. Please try again.");
                    break;
            }
            

        }
        scanner.close();
    }
    private void deposit(double amount){
        account.deposit(amount);
    }
    private void withdraw(double amount){
        account.withdraw(amount);
    }
    private void checkBalance(){
        double balance = account.checkBalance();
        System.out.println("Your current balance is : $" + balance);
    }
}

public class main{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.0);

        ATM atm = new ATM(userAccount);

        atm.showmenu();
    }
    
}