package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// Copy of one of our lessons, but changed main to authenticate
// authenticate now returns the username
public class Authenticator {
    private static Scanner scanner;
    private static String fileName = "userData.txt";

    /**
     * Tries to authenticate a user
     * @return The username that was authenticated or null if unsuccessful
     */
    public static String authenticate()
    {
        System.out.println("Please log in or register!");
        scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.toLowerCase().startsWith("r")) {
            try {
                String username = registerUser();
                System.out.println("Registered successfully!");
                return username;
            } catch (IOException ex) {
                System.out.println("File error: " + ex.getMessage());
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (choice.toLowerCase().startsWith("l")) {
            try {
                String username = login();
                if (username != null) {
                    System.out.println("Logged in successfully!");
                    return username;
                } else {
                    System.out.println("Incorrect username/password!");
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Please register before logging in!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
        return null;
    }

    /**
     * Tries to log in a user.
     * @return The username that was logged in or null.
     */
    private static String login() throws FileNotFoundException {
        System.out.println("Please input your user name!");
        String username = scanner.next();
        System.out.println("Please input your password!");
        String password = scanner.next();

        File f = new File(fileName);
        Scanner fileScan = new Scanner(f);

        while (fileScan.hasNext()) {
            String userPassPair = fileScan.nextLine();
            String[] result = userPassPair.split(",");
            if (username.equals(result[0])
                && password.equals(result[1])) {
                return result[0];
            }
        }

        return null;
    }

    /**
     * Tries to register a new user.
     * @return The username that was registered.
     * @throws IOException on file system errors
     * @throws RuntimeException on user errors (check message for more details)
     */
    private static String registerUser() throws IOException, RuntimeException {
        System.out.println("Please input your user name!");
        String username = scanner.next();
        System.out.println("Please input your password!");
        String password = scanner.next();
        System.out.println("Please confirm your password!");
        String confirmation = scanner.next();

        if (userExists(username)) {
            throw new RuntimeException("The user exists already!");
        }

        if (!password.equals(confirmation)) {
            throw new RuntimeException("The passwords do not match!");
        }

        File f = new File(fileName);
        FileWriter fw = new FileWriter(f, true);
        fw.write(username + "," + password + System.lineSeparator());
        fw.flush();

        return username;
    }

    private static boolean userExists(String username) {
        File f = new File(fileName);
        Scanner fileScan;

        try {
            fileScan = new Scanner(f);
        } catch (FileNotFoundException ex) {
            return false;
        }

        while (fileScan.hasNext()) {
            String userPassPair = fileScan.nextLine();
            String[] result = userPassPair.split(",");
            if (username.equals(result[0])) {
                return true;
            }
        }

        return false;
    }
}
