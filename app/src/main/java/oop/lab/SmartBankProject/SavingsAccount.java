public class SavingsAccount extends BankAccount implements OnlineService {
    public SavingsAccount(String accNum, String accHolder, double balance) {
        super(accNum, accHolder, balance);
    }

    @Override
    public void calculateInterest() {
        balance += balance * 0.04;
    }

    @Override
    public void transferFunds() {
        System.out.println("Transferring funds from SavingsAccount...");
    }

    @Override
    public void payBills(double amount) {
        withdraw(amount);
        System.out.println("Paid bills of amount: " + amount);
    }
}