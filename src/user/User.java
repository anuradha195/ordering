package user;

import payments.GiftCard;
import payments.MasterCard;
import payments.PaymentMethod;
import payments.Visa;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public Cart cart;
    private ArrayList<PaymentMethod> methods;
    private String name;

    private Scanner sc;

    public User(String username) {
        name = username;
        methods = new ArrayList<>();
        cart = new Cart();
    }

    // Only adds methods. TODO: remove methods
    public void setUpPayments() {
        sc = new Scanner(System.in);
        String input = "";

        do {
            System.out.println("Hello, " + name + ", please add payment methods!");
            System.out.println("(G) Gift card");
            System.out.println("(M) MasterCard");
            System.out.println("(V) Visa");
            System.out.println("(Q) Done");

            input = sc.next();

            if (input.toLowerCase().startsWith("g"))
                methods.add(newGiftCard());
            else if (input.toLowerCase().startsWith("m"))
                methods.add(newMasterCard());
            else if (input.toLowerCase().startsWith("v"))
                methods.add(newVisa());
        } while (!input.toLowerCase().startsWith("q") || methods.size() == 0);
    }

    private PaymentMethod newMasterCard() {
        MasterCard mc = new MasterCard();
        System.out.println("Please input your credit limit!");
        mc.deposit(sc.nextDouble());
        return mc;
    }

    private PaymentMethod newGiftCard() {
        System.out.println("Please input the gift card amount!");
        return new GiftCard(sc.nextDouble());
    }

    private PaymentMethod newVisa() {
        Visa mc = new Visa();
        System.out.println("Please input your credit limit!");
        mc.deposit(sc.nextDouble());
        return mc;
    }

    public boolean checkout() {
        System.out.println("Choose payment method:");
        for (int i = 0; i < methods.size(); i++) {
            System.out.println((i + 1) + ". " + methods.get(i));
        }
        int index = sc.nextInt();
        PaymentMethod method = methods.get(index - 1);
        return cart.checkout(method);
    }
}
