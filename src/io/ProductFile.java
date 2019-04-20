package io;

import productTypes.Drink;
import productTypes.Food;
import productTypes.Product;
import productTypes.Utensil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductFile {
    private static String fileName = "products.csv";

    public static ArrayList<Product> parseFile() throws FileNotFoundException {
        ArrayList<Product> result = new ArrayList<>();
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
                result.add(food);
            } else if (cols[3].equals("d")) {
                Drink drink = new Drink();
                parseLine(cols, drink);
                drink.volume = Double.parseDouble(cols[5]);
                result.add(drink);
            } else if (cols[3].equals("u")) {
                Utensil utensil = new Utensil();
                parseLine(cols, utensil);
                utensil.count = Integer.parseInt(cols[6]);
                result.add(utensil);
            }
        }

        return result;
    }

    private static void parseLine(String[] cols, Product target) {
        target.name = cols[0];
        target.price = Double.parseDouble(cols[1]);
        target.description = cols[2];
    }
}
