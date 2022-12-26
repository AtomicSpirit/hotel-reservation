package ui;
/*
1. See all Customers
2. See all Rooms
3. See all Reservations
4. Add a Room
5, Back to Main Menu (returns back to the MainMenu)
*/
import api.AdminResource;
import service.CustomerService;
import service.ReservationService;

import java.util.Scanner;
public class AdminMenu {
    static boolean exit;
    static AdminResource admin = AdminResource.getInstance();

    public static void runAdminMenu(){
      while(!exit){
          printHeader();
          printMenu();
          getInput();
          exit = true;
      }


    }

    public static void printHeader() {
        System.out.println("Welcome to AdminMenu");
        System.out.println("++++++++++++++++++++");

    }

    public static void printMenu() {
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu (returns back to the MainMenu)");

    }
    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //int intChoice = Integer.parseInt(choice);
        //System.out.println(choice);
        if (choice == 1) {
          admin.getAllCustomers();

        } else if (choice == 2) {

        } else if (choice == 3) {

        } else if (choice == 4) {


        } else if (choice == 5) {
            MainMenu.runMenu();
        } else {


        }

    }


}
