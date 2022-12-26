package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AdminResource {
    public static CustomerService customerService = CustomerService.getInstance();
    public static AdminResource adminResource = null;


    public static ReservationService reservationService = ReservationService.getInstance();


    public static AdminResource getInstance () {
        if (adminResource == null) {
            AdminResource adminResource = new AdminResource();


        }
        return adminResource;

    }

        public AdminResource() {}




        public Customer getCustomer (String email){
            return customerService.getCustomer(email);
        }
        public void addRoom (List < IRoom > rooms) {
            for (IRoom r : rooms) {
                reservationService.addRoom(r);
            }
        }
        public static Set<IRoom> getAllRooms () {
            return reservationService.getAllRooms();
        }
        public static Set<Customer> getAllCustomers () {
            return customerService.getAllCustomers();
        }
        public void displayAllReservations () {
            reservationService.printAllReservation();
        }

        /*  FIRST:  MainMenu3. Being able to create an Account.  Already Can do it with Regex email working.
            Now I need to connect it to the UI.(frontend and backend ?See the Intro video for reference to the layout)
            THEN:  AdminMenu1. See all Customers as Admin
            THEN:  AdminMenu4. Being Able to Add a Room as Admin
            THEN:  AdminMenu2. See all Rooms created.

            THEN:  MainMenu1. Deciding whether to be a Guest or Customer.  Search feature for dates in finding a room?
            Being able to reserve the room.

            THEN:  MainMenu2. displaying the reservation.

            b vn



            AdminMenu3.See All Reservations
            MainMenu1 MainMenu2
        * */


}
