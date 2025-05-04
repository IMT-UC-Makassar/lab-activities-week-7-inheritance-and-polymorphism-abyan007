public class DebitCard extends Card {
    public DebitCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder);
    }

    @Override
    public double getInterestRate() {
        return 0.01;
    }
}