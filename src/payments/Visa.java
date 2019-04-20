package payments;

public class Visa extends CreditCard {
    @Override
    public void purchase(double cost) {
        System.out.println("Contacting Visa...");
        limit -= cost;
        System.out.println("Success!");
    }
}
