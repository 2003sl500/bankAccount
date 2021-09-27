import java.util.Arrays;
import java.util.Random;

public class BankAccount{

    Random random = new Random();

    BankAccount(){
        numAccountsCreated++;
        randomNumber();
    }

    static int numAccountsCreated;
    static double totalAmount;
    private long accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    final int numDigitsAccount = 10;


    void randomNumber (){
        int temp[] = new int[10];
        for(int i = 0; i < numDigitsAccount; i++){
            temp[i] = random.nextInt(numDigitsAccount);
            while(i == 0 && temp[i] == 0){
                temp[i] = random.nextInt(numDigitsAccount);
            }
        }
        String tempNum = "";
        for(int i = 0; i < temp.length; i++){
            tempNum += String.valueOf(temp[i]);
        }
        setAccountNumber(Long.valueOf(tempNum));
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    void deposit(String accountType, double amount){
        if(accountType.equalsIgnoreCase("savings")){
            setSavingsBalance(amount, "deposit");
        } else if (accountType.equalsIgnoreCase("checking")){
            setCheckingBalance(amount, "deposit");
        }
    }

    void withdrawl (String accountType, double amount){ 
        if(accountType.equalsIgnoreCase("savings") && ((getSavingsBalance() - amount ) > 0)){
            setSavingsBalance(amount, "withdrawl");
        } else if (accountType.equalsIgnoreCase("checking") && ((getCheckingBalance() - amount ) > 0)){
            setCheckingBalance(amount, "withdrawl");
        } else {
            String accountString = accountType.substring(0,1).toUpperCase() + accountType.substring(1);
            System.out.println(accountString + " account, " + "Insufficient funds available");
        }
    }

    double totalBalances (){
        return getCheckingBalance() + getSavingsBalance();
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance, String action) {
        if(action.equalsIgnoreCase("deposit")){
            this.checkingBalance += checkingBalance;
            totalAmount += checkingBalance;
        } else if (action.equalsIgnoreCase("withdrawl")){
            this.checkingBalance -= checkingBalance;
            totalAmount -= checkingBalance;
        }
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance, String action) {
        if(action.equalsIgnoreCase("deposit")){
            this.savingsBalance += savingsBalance;
            totalAmount += savingsBalance;
        } else if (action.equalsIgnoreCase("withdrawl")){
            this.savingsBalance -= savingsBalance;
            totalAmount -= savingsBalance;
        }
    }

}