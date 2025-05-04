public class PlatinumCard extends CreditCard {
    public PlatinumCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder);
    }

    @Override
    public double getInterestRate() {
        return 0.02;
    }
}