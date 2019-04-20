package products;

public abstract class Product {
    public String name;
    public double price;
    public String description;

    protected String toString(String variable) {
        StringBuilder output = new StringBuilder();
        output.append(name + ":" + "\n");
        output.append("  " + variable + price + " eur" + "\n");
        output.append("  " + description);
        return output.toString();
    }

    public abstract String toString();
}
