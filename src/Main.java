import io.Authenticator;
import products.Product;
import products.ProductList;
import user.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductList list = new ProductList();

        String username;
        do {
            username = Authenticator.authenticate();
        } while (username == null);

        User user = new User(username);
        user.setUpPayments();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome!");
        String input = "";
        while (!input.toLowerCase().startsWith("c")) {
            System.out.println("Do you want to:");
            System.out.println("(A) Add products");
            System.out.println("(R) Remove products");
            System.out.println("(C) Checkout");

            input = sc.next();
            if (input.toLowerCase().startsWith("a")) {
                System.out.println(list);
                int index = sc.nextInt();
                Product prod = list.getProduct(index - 1);
                user.cart.addProduct(prod);
            } else if (input.toLowerCase().startsWith("r")) {
                System.out.println(user.cart);
                int index = sc.nextInt();
                user.cart.removeProduct(index - 1);
            }
        }

        while (!user.checkout()) {
            System.out.println("Purchase failed! Add payment methods?");
            input = sc.next();
            if (input.toLowerCase().startsWith("y")) {
                user.setUpPayments();
            }
        }

        System.out.println("Purchase successful!");
    }
}
