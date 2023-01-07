package ui;
/*
1. See all Customers
2. See all Rooms
3. See all Reservations
4. Add a Room
5, Back to Main Menu (returns back to the MainMenu)
*/
import api.AdminResource;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Scanner;

import static ui.MainMenu.runMenu;

public class AdminMenu {
     boolean exit;
     AdminResource admin = new AdminResource();

    public  void runAdminMenu(){
      while(!exit){
          printHeader();
          printMenu();
          getInput();
          exit = true;
      }


    }

    public void printHeader() {
        System.out.println("Welcome to AdminMenu");
        System.out.println("++++++++++++++++++++");

    }

    public  void printMenu() {
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu (returns back to the MainMenu)");

    }
    public  void getInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //int intChoice = Integer.parseInt(choice);
        //System.out.println(choice);
        if (choice == 1) {
          CustomerService customerService = new CustomerService();
          customerService.getInstance();
          System.out.println(customerService.getAllCustomers());
          runAdminMenu();

        } else if (choice == 2) {
            AdminResource adminResource = new AdminResource();
            adminResource.getInstance();
            System.out.println(adminResource.getAllRooms());
            runAdminMenu();
        } else if (choice == 3) {
    ReservationService reservationService = new ReservationService();
    reservationService.printAllReservation();
            runAdminMenu();
        } else if (choice == 4) {
AdminResource adminResource = new AdminResource();
adminResource.getInstance();


//Room Number, Price, Type SINGLE or DOUBLE, vacancy isFree()

            try{System.out.println("Room number?  Please enter:");
                String roomNumber = scanner.next();
                System.out.println("Room price?");
                double roomPrice = scanner.nextDouble();
                System.out.println("Room type?");
                RoomType roomType = RoomType.valueOf(scanner.next().toUpperCase());


            System.out.println("Keep the room free or no vacancy?  True or False:");
            boolean isFree = scanner.nextBoolean();
            adminResource.addRoom(roomNumber, roomPrice, roomType, isFree );
            System.out.println("Room was successfully added");
        }
            catch(Exception e){
                System.out.println("There was an error in your input please try again.");
                runAdminMenu();}
            runAdminMenu();





        } else if (choice == 5) {
            runMenu();
        } else {


        }

    }


}
