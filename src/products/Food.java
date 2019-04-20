package products;

public class Food extends Product {
    public double mass;

    @Override
    public String toString() {
        return toString(mass + "kg for ");
    }
}
