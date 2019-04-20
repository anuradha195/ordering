package products;

public class Drink extends Product {
    public double volume;

    @Override
    public String toString() {
        return toString(volume + "l for ");
    }
}
