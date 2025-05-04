public class SmartBankApp {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA123", "Alice", 1000);
        sa.calculateInterest();
        sa.transferFunds();
        sa.payBills(100);
        System.out.println("Savings Account Balance: " + sa.getBalance());

        CheckingAccount ca = new CheckingAccount("CA456", "Bob", 2000);
        ca.calculateInterest();
        ca.transferFunds();
        ca.payBills(200);
        System.out.println("Checking Account Balance: " + ca.getBalance());

        BusinessAccount ba = new BusinessAccount("BA789", "Charlie", 5000);
        ba.calculateInterest();
        ba.applyForLoan(10000);
        System.out.println("Business Account Balance: " + ba.getBalance());
        System.out.println("Loan Status: " + ba.checkLoanStatus());

        DebitCard dc = new DebitCard("D001", "Alice");
        System.out.println("Debit Card Interest Rate: " + dc.getInterestRate());

        PlatinumCard pc = new PlatinumCard("P001", "Bob");
        System.out.println("Platinum Card Interest Rate: " + pc.getInterestRate());
    }
}