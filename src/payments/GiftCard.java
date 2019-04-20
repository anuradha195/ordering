package payments;

public class GiftCard implements PaymentMethod {
    private double sum;

    public GiftCard(double sum) {
        this.sum = sum;
    }

    @Override
    public boolean canPurchase(double cost) {
        return cost <= sum;
    }

    @Override
    public void purchase(double cost) {
        sum = 0;
    }
}
