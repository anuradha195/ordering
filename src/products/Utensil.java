package products;

public class Utensil extends Product {
    public int count;

    @Override
    public String toString() {
        return toString(count + " for ");
    }
}
