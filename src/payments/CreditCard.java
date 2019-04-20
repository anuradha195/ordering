package payments;

public abstract class CreditCard implements PaymentMethod {
    protected double limit;

    public void deposit(double money) {
        limit += money;
    }

    @Override
    public boolean canPurchase(double cost) {
        return limit >= cost;
    }
}
