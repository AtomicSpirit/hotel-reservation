package ui;
//import scanner from scanner;
/*
1. Find and reserve a room
2. See my reservations
3. Create an account
4. Admin (open the admin menu described below)
5. Exit (exit the application)
When should the customer enter data about themselves?
*/


//The main menu should only be in communication with the api.
import api.AdminResource;
import api.HotelResource;
//import model.Customer;
//import service.CustomerService;

import java.util.Scanner;


public class MainMenu {
    static boolean exit;

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.runMenu();
        //mainMenu.getInput();
    }

    public static void printHeader() {
        System.out.println("welcome to our Hotel Reservation Application");

    }

    public static void printMenu() {
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin (open the admin menu described below)");
        System.out.println("5. Exit (exit the application)");
    }

    public static void runMenu() {
        while (!exit) {
            printHeader();
            printMenu();
            getInput();

            exit = true;
        }

    }

    public static void exitApp() {
        exit = true;
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //int intChoice = Integer.parseInt(choice);
        //System.out.println(choice);
        if (choice == 1) {
        System.out.println("You picked 1");

        } else if (choice == 2) {

        } else if (choice == 3) {



                System.out.println("what is your email?");
                String customerEmail = scanner.next();
                System.out.println("what is your first name?");
                String customerFirst = scanner.next();
                System.out.println("what is your last name?");
                String customerlast = scanner.next();

                HotelResource hotelResource = new HotelResource();
                hotelResource.getInstance();
                hotelResource.createACustomer(customerEmail,customerFirst,customerlast);

                runMenu();
            }


         else if (choice == 4) {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.runAdminMenu();

        } else if (choice == 5) {
            exitApp();
        } else {


        }

    }
}