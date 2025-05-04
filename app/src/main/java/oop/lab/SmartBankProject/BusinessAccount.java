public class BusinessAccount extends BankAccount implements LoanService {
    private String loanStatus = "No loan applied.";

    public BusinessAccount(String accNum, String accHolder, double balance) {
        super(accNum, accHolder, balance);
    }

    @Override
    public void calculateInterest() {
        balance += balance * 0.03;
    }

    @Override
    public void applyForLoan(double amount) {
        loanStatus = "Loan applied for: " + amount;
    }

    @Override
    public String checkLoanStatus() {
        return loanStatus;
    }
}