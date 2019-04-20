import payments.Cheque;
import productTypes.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductList list = new ProductList();
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        String input = "";
        // A, R, C
        while (!input.equals("C")) {
            System.out.println("Add or remove?");
            input = sc.next();
            if (input.equals("A")) {
                list.printProducts();
                int index = sc.nextInt();
                Product prod = list.getProduct(index - 1);
                cart.addProduct(prod);
            } else if (input.equals("R")) {
                System.out.println(cart);
                int index = sc.nextInt();
                cart.removeProduct(index);
            }
        }

        Cheque cheque;
        do {
            System.out.println("How much money do you have?");
            double money = sc.nextDouble();
            cheque = new Cheque(money);
        } while (!cart.checkout(cheque));
    }
}
