# 🏦 Banking System — Java GUI Application

A Java-based desktop banking application that allows users to manage bank accounts through a graphical user interface. Account data is loaded from a CSV file, and users can perform deposits, withdrawals, and transfers between accounts in real time.

---

## 📋 Features

- **View All Accounts** — Display all account holders with their account numbers and current balances
- **Deposit** — Add funds to any account by entering the account number and amount
- **Withdraw** — Remove funds from an account with insufficient-funds validation
- **Transfer** — Move funds between two accounts with full balance checking
- **CSV Data Loading** — Account data is read from an external `Accounts.csv` file at startup

---

## 🗂️ Project Structure

```
BankingSystemProject4/
├── src/
│   └── banking_2/
│       ├── Main.java           # Entry point — loads CSV and launches GUI
│       ├── GUI.java            # Swing-based graphical user interface
│       ├── Account.java        # Account model with deposit/withdraw methods
│       ├── Customer.java       # Base class for account holder details
│       ├── Transaction.java    # Handles fund transfers between accounts
│       └── ReadAccounts.java   # CSV file parser using BufferedReader
├── Accounts.csv                # Sample account data (account number, name, balance)
└── module-info.java
```

---

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- An IDE such as Eclipse or IntelliJ IDEA *(optional)*

### Running the Application

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/banking-system.git
   cd banking-system
   ```

2. **Compile the source files**
   ```bash
   javac -d bin src/banking_2/*.java
   ```

3. **Ensure `Accounts.csv` is in the project root directory** (same level as `src/`)

4. **Run the application**
   ```bash
   java -cp bin banking_2.Main
   ```

---

## 📄 CSV Format

The `Accounts.csv` file must follow this format (no header row):

```
FirstName,LastName,AccountNumber,Balance
```

Example:
```
John,Smith,1001,5000
Jane,Doe,1002,3200
```

---

## 🛠️ Technologies Used

- **Java** — Core programming language
- **Java Swing** — GUI framework (`javax.swing`, `java.awt`)
- **Java I/O** — CSV file reading (`BufferedReader`, `FileReader`)
- **Java Collections** — `LinkedList` for in-memory data storage

---

## 📐 Class Overview

| Class | Responsibility |
|---|---|
| `Main` | Reads CSV data and launches the GUI window |
| `GUI` | Swing window with buttons for all banking operations |
| `Account` | Stores account data; handles deposit and withdraw logic |
| `Customer` | Superclass holding first name and last name fields |
| `Transaction` | Performs validated fund transfers between two accounts |
| `ReadAccounts` | Parses the CSV file and returns data as `LinkedList` collections |

---

## ⚠️ Notes

- Balances are stored as integers (whole numbers only)
- The application does **not** persist changes back to the CSV file — all updates are in-memory only
- Negative transaction amounts are rejected with an error message

---

## 📜 License

This project was developed as part of a university assignment. Feel free to use it for learning purposes.
The application does not persist changes back to the CSV file — all updates are in-memory only
Negative transaction amounts are rejected with an error message


📜 License
This project was developed as part of a university assignment. Feel free to use it for learning purposes.
