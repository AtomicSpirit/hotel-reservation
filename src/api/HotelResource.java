package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class HotelResource {
    public  HotelResource hotelResource = null;
    public  HotelResource getInstance() {
        if (hotelResource == null){
            HotelResource hotelResource = new HotelResource();
        }
        return hotelResource;
    }

   CustomerService customerService = new CustomerService();
    ReservationService reservationService = new ReservationService();



    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        try{
            customerService.addCustomer(email, firstName, lastName);
            System.out.println("Welcome, Your account has been successfully  created");
        }
        catch(IllegalArgumentException exception){
            System.out.println(exception.getMessage());

        }
    }

    public IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, Room room, LocalDate checkInDate, LocalDate checkOutDate){
        //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        Customer customer = customerService.getCustomer(customerEmail);
//        if( customer == null){
//            return null;
//        }
        return reservationService.reserveARoom(customer,room, checkInDate, checkOutDate);
    }

//    public ArrayList<Reservation> getCustomersReservation(String customerEmail){
//        ArrayList rezs = new ArrayList() ;
//
//        for(Reservation rez : reservationSet) {
//            if(rez.getCustomer().getEmail() == email) {
//                rezs.add(rez);
//            }
//            return rezs;
//    }}

    public Set<IRoom> findARoom(LocalDate checkInDate, LocalDate checkOutDate){
        return reservationService.findRooms(checkInDate, checkOutDate);
    }

}