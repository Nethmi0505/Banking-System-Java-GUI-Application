
package banking_2;


public class Account extends Customer {
    private int balance;
    private int accountNumber;

    public Account(String FName, String LName, int accNum, int accBal) {
        setFirstName(FName);
        setLastName(LName);
        this.accountNumber = accNum;
        this.balance = accBal;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (this.balance < amount) {
            System.out.println("Insufficient funds for withdrawal."); 
        } else {
            this.balance -= amount;
        }
    }
}
