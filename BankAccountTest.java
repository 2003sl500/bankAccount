import java.text.DecimalFormat;

public class BankAccountTest{
    public static void main(String[] args) {
        DecimalFormat f = new DecimalFormat("$###,##0.00");
        BankAccount account = new BankAccount();
        BankAccount account2 = new BankAccount();

        account.deposit("checking", 1000);
        account.deposit("checking", 500);
        account.deposit("savings", 250);
        account.deposit("Savings", 150);
        System.out.println("Checking Balance: " + f.format(account.getCheckingBalance()));
        System.out.println("Savings Balance: " + f.format(account.getSavingsBalance()));

        account.withdrawl("checking", 100);
        account.withdrawl("savings", 500);
        System.out.println("Checking Balance: " + f.format(account.getCheckingBalance()));
        System.out.println("Savings Balance: " + f.format(account.getSavingsBalance()));

        System.out.println("Combined balance: " + f.format(account.totalBalances()));
        System.out.println("Account Number: " + account.getAccountNumber());

        account2.deposit("Savings", 150);
        System.out.println("\nCombined balance: " + f.format(account2.totalBalances()));
        System.out.println("Account Number: " + account2.getAccountNumber());

        System.out.println("Total Balance of Bank: " + BankAccount.totalAmount);
    }
}