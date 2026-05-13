package banking_1;

import java.io.*;
import java.util.LinkedList;

public class ReadAccounts {
    private LinkedList<String> firstNames = new LinkedList<>();
    private LinkedList<String> lastNames = new LinkedList<>();
    private LinkedList<Integer> accounts = new LinkedList<>();
    private LinkedList<Integer> balances = new LinkedList<>();

    public ReadAccounts(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 4) {
                    firstNames.add(values[0].trim());
                    lastNames.add(values[1].trim());
                    accounts.add(Integer.parseInt(values[2].trim()));
                    balances.add(Integer.parseInt(values[3].trim()));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers in file: " + e.getMessage());
        }
    }

    public LinkedList<String> getFirstNames() {
        return firstNames;
    }

    public LinkedList<String> getLastNames() {
        return lastNames;
    }

    public LinkedList<Integer> getAccounts() {
        return accounts;
    }

    public LinkedList<Integer> getBalances() {
        return balances;
    }
}
