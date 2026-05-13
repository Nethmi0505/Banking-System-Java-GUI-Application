package banking_2;

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
            accounts.add(new Account(firstNames.get(i), lastNames.get(i),
                                     accountList.get(i), balanceList.get(i)));
        }

        GUI gui = new GUI(accounts);
        gui.setSize(1000, 1000);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
    }
}
