package user;

import payments.PaymentMethod;
import products.Product;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> contents = new ArrayList<Product>();

    public void addProduct(Product product) {
        contents.add(product);
    }

    public void removeProduct(int index) {
        contents.remove(index);
    }

    public boolean checkout(PaymentMethod method) {
        double cost = 0;
        for (Product item : contents) {
            cost += item.price;
        }

        if (method.canPurchase(cost)) {
            method.purchase(cost);
            contents.clear();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < contents.size(); i++) {
            result.append((i + 1) + ". ");
            result.append(contents.get(i) + "\n");
        }
        return result.toString();
    }
}
