package banking_1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        
        String file = "Accounts.csv";

        
        ReadAccounts readAccounts = new ReadAccounts(file);

        
        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balanceList = readAccounts.getBalances();

        
        LinkedList<Account> accounts = new LinkedList<>();
        for (int i = 0; i < firstNames.size(); i++) {
            accounts.add(new Account(
                firstNames.get(i),
                lastNames.get(i),
                accountList.get(i),
                balanceList.get(i)
            ));
        }

        
        for (Account account : accounts) {
            System.out.println("Balance of account " + account.getAccountNum() + ": " + account.getBalance());
        }

        
        accounts.get(0).deposit(250);
        System.out.println("Balance of account " + accounts.get(0).getAccountNum() + " after deposit: " + accounts.get(0).getBalance());

        accounts.get(1).withdraw(500);
        System.out.println("Balance of account " + accounts.get(1).getAccountNum() + " after withdrawal: " + accounts.get(1).getBalance());

        Transaction t = new Transaction();
        t.transfer(accounts.get(0), accounts.get(1), 250);
        System.out.println("Balance of account " + accounts.get(0).getAccountNum() + " after transfer: " + accounts.get(0).getBalance());
        System.out.println("Balance of account " + accounts.get(1).getAccountNum() + " after transfer: " + accounts.get(1).getBalance());
    }
}
