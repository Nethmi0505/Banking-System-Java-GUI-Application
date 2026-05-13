
package banking_1;


public class Transaction {
    public void transfer(Account acc1, Account acc2, int amount) {
        if (amount < 0) {
            System.out.println("Invalid transfer amount.");
        } else if (acc1.getBalance() < amount) {
            System.out.println("Insufficient funds for transfer.");
        } else {
            acc1.withdraw(amount);
            acc2.deposit(amount);
        }
    }
}
