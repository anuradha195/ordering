import io.ProductFile;
import productTypes.Product;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> products;

    public ProductList() {
        try {
            products = ProductFile.parseFile();
        } catch (FileNotFoundException e) {
            System.out.println("Could not read product file!");
        }
    }

    // This is encapsulation
    public Product getProduct(int index) {
        return products.get(index);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            output.append((i + 1) + ". ");
            output.append(products.get(i) + "\n");
        }
        return output.toString();
    }
}
