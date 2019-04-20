import productTypes.Drink;
import productTypes.Food;
import productTypes.Product;
import productTypes.Utensil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {
    private ArrayList<Product> products;
    private static String fileName = "products.csv";

    public ProductList() {
        try {
            parseFile();
        } catch (FileNotFoundException e) {
            System.out.println("Could not read product file!");
        }
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public void printProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    private void parseFile() throws FileNotFoundException {
        products = new ArrayList<Product>();
        File f = new File(fileName);
        Scanner fileScan = new Scanner(f);

        fileScan.nextLine(); // skips header

        while (fileScan.hasNext()) {
            String row = fileScan.nextLine();
            String[] cols = row.split(";");

            if (cols[3].equals("f")) {
                Food food = new Food();
                parseLine(cols, food);
                food.mass = Double.parseDouble(cols[4]);
                products.add(food);
            } else if (cols[3].equals("d")) {
                Drink drink = new Drink();
                parseLine(cols, drink);
                drink.volume = Double.parseDouble(cols[5]);
                products.add(drink);
            } else if (cols[3].equals("u")) {
                Utensil utensil = new Utensil();
                parseLine(cols, utensil);
                utensil.count = Integer.parseInt(cols[6]);
                products.add(utensil);
            }
        }
    }

    private void parseLine(String[] cols, Product target) {
        target.name = cols[0];
        target.price = Double.parseDouble(cols[1]);
        target.description = cols[2];
    }
}
