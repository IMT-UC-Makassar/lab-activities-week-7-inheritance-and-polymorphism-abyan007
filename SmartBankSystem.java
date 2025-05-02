// Interface: OnlineService
interface OnlineService {
    void transferFunds();
    void payBills(double amount);
}

// Interface: LoanService
interface LoanService {
    void applyForLoan(double amount);
    String checkLoanStatus();
}

// Abstract class: BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public abstract void calculateInterest();
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Calculating interest for Savings Account...");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Calculating interest for Checking Account...");
    }
}

// Subclass: BusinessAccount
class BusinessAccount extends BankAccount implements OnlineService, LoanService {
    private String loanStatus;

    public BusinessAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
        this.loanStatus = "No loan yet";
    }

    @Override
    public void calculateInterest() {
        System.out.println("Calculating interest for Business Account...");
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount > 0) {
            loanStatus = "Loan of $" + amount + " applied successfully.";
            System.out.println(loanStatus);
        } else {
            System.out.println("Invalid loan amount.");
        }
    }

    @Override
    public String checkLoanStatus() {
        return loanStatus;
    }

    @Override
    public void transferFunds() {
        System.out.println("Transferring funds from Business Account...");
    }

    @Override
    public void payBills(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            withdraw(amount);
            System.out.println("Paid bills: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance for bill payment.");
        }
    }
}

// Abstract class: Card
abstract class Card {
    private String cardNumber;
    private String cardHolder;

    public Card(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public abstract double getInterestRate();
}

// Subclass: DebitCard
class DebitCard extends Card {
    public DebitCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder);
    }

    @Override
    public double getInterestRate() {
        return 0.0;
    }
}

// Subclass: CreditCard
class CreditCard extends Card {
    public CreditCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder);
    }

    @Override
    public double getInterestRate() {
        return 1.5;
    }
}

// Subclass: PlatinumCard
class PlatinumCard extends CreditCard {
    public PlatinumCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder);
    }

    @Override
    public double getInterestRate() {
        return 2.0;
    }
}

// Main class to test the system
public class SmartBankSystem {
    public static void main(String[] args) {
        BusinessAccount ba = new BusinessAccount("BA001", "Andi", 10000);
        System.out.println("Account Holder: " + ba.getAccountHolder());
        ba.deposit(5000);
        ba.withdraw(2000);
        System.out.println("Current Balance: $" + ba.getBalance());
        ba.calculateInterest();

        ba.applyForLoan(100000);
        System.out.println("Loan Status: " + ba.checkLoanStatus());
        ba.transferFunds();
        ba.payBills(300);

        Card card = new PlatinumCard("PC001", "Andi");
        System.out.println("Card Holder: " + card.getCardHolder());
        System.out.println("Platinum Card Interest Rate: " + card.getInterestRate() + "%");
    }
}
