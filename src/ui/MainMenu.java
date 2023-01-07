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
import api.HotelResource;
import model.Customer;
import model.Room;
import service.ReservationService;
//import model.Customer;
//import service.CustomerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

   //Takes in a checkin Date and a checkout Date and returns a list of rooms available
    public static LocalDate[] whichDates(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CheckIn Date mm/dd/yyy example 03/14/2022");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String checkInString = scanner.next();
        LocalDate checkInDate = LocalDate.parse(checkInString, dtf);

        //System.out.println(checkInDate);

        System.out.println("Enter CheckOut  Date mm/dd/yyy example 03/21/2022");
        String checkOutString = scanner.next();
        LocalDate checkOutDate = LocalDate.parse(checkOutString, dtf);

        //getAllRooms   Only display the ones that are  relevant to the checkin and checkout dates?
        //If non are available move the date a few days to search for other options.  If not return nothing.
        ReservationService reservationService = new ReservationService();
        
        System.out.println(reservationService.findRooms(checkInDate, checkOutDate));
        LocalDate[] dateInputs = {checkInDate, checkOutDate};
        return dateInputs;

    }


    //Do you want to book a room? if not return to main menu.     account info or create one, whichRoom#
    public static void askingToBookARoom(){
        Scanner scanner = new Scanner(System.in);
        LocalDate[] inOut = whichDates();

        System.out.println("Would you like to book a room? y/n");
        String bookYes = scanner.next();
        bookYes.toLowerCase();
        if(bookYes.equals("y")){

            Customer customer = accountSituation();
            Room roomNum = whichRoom();
            HotelResource hotelResource = new HotelResource();
            hotelResource.bookARoom(customer.getEmail(), roomNum, inOut[0],inOut[1]);
            // THere needs to be a check to verify the reservations were legit.  refer to hotel resources
            System.out.println("reservation for " + customer + " has booked room number : " + roomNum);
            runMenu();
        }



        else{ runMenu();}
    }






    public static  Customer accountSituation(){
        //if client doesnt have an account with us it prompts to create one.
        Scanner scanner = new Scanner(System.in);
            System.out.println("Do you have an account with us? y/n");
            String accountYes = scanner.next();
            accountYes.toLowerCase();

            if(accountYes.equals("y")){
                System.out.println("what is your Email?");
                String email = scanner.next();
                HotelResource hotelResource = new HotelResource();
                Customer customer = hotelResource.getCustomer(email);
                return customer;
            }


return signUp();



    }

    
    
    
    
    //Asks which Room the customer would like to reserve and returns the confirmation information

    public static Room whichRoom(){

        Scanner scanner = new Scanner(System.in);
        ReservationService reservationService = new ReservationService();
        System.out.println("Which room number would you like to reserve?  :");
        String requestedRoomNumber = scanner.next();


        return reservationService.getARoom(requestedRoomNumber);


    }
    
    public static Customer signUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your email?");
        String customerEmail = scanner.next();
        System.out.println("what is your first name?");
        String customerFirst = scanner.next();
        System.out.println("what is your last name?");
        String customerlast = scanner.next();

        HotelResource hotelResource = new HotelResource();
        hotelResource.getInstance();
        hotelResource.createACustomer(customerEmail,customerFirst,customerlast);

        return hotelResource.getCustomer(customerEmail);
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

           askingToBookARoom();



        } else if (choice == 2) {//mainmenu see my reservations
            System.out.println("what is your email?");
            String customerEmail = scanner.next();
            ReservationService reservationService = new ReservationService();
            HotelResource hotelResource = new HotelResource();
            System.out.println(reservationService.getCustomersReservation(hotelResource.getCustomer(customerEmail)));
            runMenu();
        } else if (choice == 3) {

            signUp();
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