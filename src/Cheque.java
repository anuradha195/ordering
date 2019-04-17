public class Cheque implements PaymentMethod {
    private double sum;

    public Cheque(double sum) {
        this.sum = sum;
    }

    @Override
    public boolean canPurchase(double cost) {
        return cost <= sum;
    }

    @Override
    public void purchase(double cost) {
        sum = sum - cost;
    }
}
