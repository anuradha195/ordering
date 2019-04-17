package productTypes;

public abstract class Product {
    public String name;
    public double price;
    public String description;

    protected String toString(String variable) {
        String output = "";
        output += name + ":" + "\n";
        output += "  " + variable + price + " eur" + "\n";
        output += "  " + description;
        return output;
    }

    public abstract String toString();
}
