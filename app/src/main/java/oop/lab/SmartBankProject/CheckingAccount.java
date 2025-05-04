public class CheckingAccount extends BankAccount implements OnlineService {
    public CheckingAccount(String accNum, String accHolder, double balance) {
        super(accNum, accHolder, balance);
    }

    @Override
    public void calculateInterest() {
        balance += balance * 0.02;
    }

    @Override
    public void transferFunds() {
        System.out.println("Transferring funds from CheckingAccount...");
    }

    @Override
    public void payBills(double amount) {
        withdraw(amount);
        System.out.println("Paid bills of amount: " + amount);
    }
}