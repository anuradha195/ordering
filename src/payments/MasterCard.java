package payments;

public class MasterCard extends CreditCard {
    @Override
    public void purchase(double cost) {
        System.out.println("Contacting MasterCard servers...");
        limit -= cost;
        System.out.println("Success!");
    }
}
