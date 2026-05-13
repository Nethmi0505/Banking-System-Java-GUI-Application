package banking_2;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.awt.Color;

public class GUI extends JFrame {
    private Transaction transferObject = new Transaction();
    private StringBuilder sbAllData = new StringBuilder();
    private LinkedList<Account> globalAccounts;

    private JLabel showAllData;
    private JButton showAllButton, depositButton, withdrawButton, transferButton;

    private JTextField accDeposit, depositInput;
    private JTextField accWithdraw, withdrawInput;
    private JTextField acc1Transfer, acc2Transfer, transferAmount;
    private JLabel lblNewLabel;

    public GUI(LinkedList<Account> accounts) {
        super("Banking System");
        getContentPane().setBackground(new Color(0, 128, 192));
        getContentPane().setLayout(null);
        globalAccounts = accounts;

        for (Account acc : globalAccounts) {
            sbAllData.append("Account: ").append(acc.getAccountNum())
                     .append(" | ").append(acc.getFirstName()).append(" ")
                     .append(acc.getLastName()).append(" | Balance: £")
                     .append(acc.getBalance()).append("\n");
        }

        showAllData = new JLabel("<html>" + sbAllData.toString().replaceAll("\n", "<br>") + "</html>");
        showAllData.setBounds(0, -4, 900, 200);
        getContentPane().add(showAllData);

        showAllButton = new JButton("Show All");
        showAllButton.setBounds(352, 277, 120, 30);
        getContentPane().add(showAllButton);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(200, 343, 120, 30);
        getContentPane().add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(389, 343, 120, 30);
        getContentPane().add(withdrawButton);

        transferButton = new JButton("Transfer");
        transferButton.setBounds(549, 343, 120, 30);
        getContentPane().add(transferButton);

        accDeposit = new JTextField("Account for Deposit");
        accDeposit.setBounds(190, 383, 150, 30);
        getContentPane().add(accDeposit);

        depositInput = new JTextField("Amount to Deposit");
        depositInput.setBounds(392, 383, 150, 30);
        getContentPane().add(depositInput);

        accWithdraw = new JTextField("Account for Withdraw");
        accWithdraw.setBounds(190, 437, 150, 30);
        getContentPane().add(accWithdraw);

        withdrawInput = new JTextField("Amount to Withdraw");
        withdrawInput.setBounds(392, 437, 150, 30);
        getContentPane().add(withdrawInput);

        acc1Transfer = new JTextField("From Account");
        acc1Transfer.setBounds(190, 488, 150, 30);
        getContentPane().add(acc1Transfer);

        acc2Transfer = new JTextField("To Account");
        acc2Transfer.setBounds(382, 488, 150, 30);
        getContentPane().add(acc2Transfer);

        transferAmount = new JTextField("Amount to Transfer");
        transferAmount.setBounds(557, 488, 150, 30);
        getContentPane().add(transferAmount);
        
        lblNewLabel = new JLabel("WELCOME TO BANKING APP");
        lblNewLabel.setBounds(220, 215, 230, 13);
        getContentPane().add(lblNewLabel);

        HandlerClass handler = new HandlerClass();
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);
    }

    private class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showAllButton) {
                sbAllData.setLength(0);
                for (Account acc : globalAccounts) {
                    sbAllData.append("Account: ").append(acc.getAccountNum())
                             .append(" | ").append(acc.getFirstName()).append(" ")
                             .append(acc.getLastName()).append(" | Balance: £")
                             .append(acc.getBalance()).append("\n");
                }
                showAllData.setText("<html>" + sbAllData.toString().replaceAll("\n", "<br>") + "</html>");
            }

            else if (e.getSource() == depositButton) {
                try {
                    int accNum = Integer.parseInt(accDeposit.getText());
                    int amount = Integer.parseInt(depositInput.getText());
                    Account acc = findAccount(accNum);
                    if (acc != null) {
                        acc.deposit(amount);
                        JOptionPane.showMessageDialog(null, "Deposit Successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }

            else if (e.getSource() == withdrawButton) {
                try {
                    int accNum = Integer.parseInt(accWithdraw.getText());
                    int amount = Integer.parseInt(withdrawInput.getText());
                    Account acc = findAccount(accNum);
                    if (acc != null) {
                        acc.withdraw(amount);
                        JOptionPane.showMessageDialog(null, "Withdrawal Successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }

            else if (e.getSource() == transferButton) {
                try {
                    int from = Integer.parseInt(acc1Transfer.getText());
                    int to = Integer.parseInt(acc2Transfer.getText());
                    int amount = Integer.parseInt(transferAmount.getText());
                    Account accFrom = findAccount(from);
                    Account accTo = findAccount(to);
                    if (accFrom != null && accTo != null) {
                        transferObject.transfer(accFrom, accTo, amount);
                        JOptionPane.showMessageDialog(null, "Transfer Successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Account(s) not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }
        }

        private Account findAccount(int accNum) {
            for (Account acc : globalAccounts) {
                if (acc.getAccountNum() == accNum) {
                    return acc;
                }
            }
            return null;
        }
    }
}
