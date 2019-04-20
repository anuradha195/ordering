package payments;

public interface PaymentMethod {
    boolean canPurchase(double cost);
    void purchase(double cost);
}
