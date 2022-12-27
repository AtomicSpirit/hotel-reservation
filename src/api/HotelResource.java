package api;

import model.Customer;
import model.Reservation;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

//import java.util.Collection;
import java.util.Date;
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

//    public IRoom getRoom(String roomNumber){
//        return reservationService.getARoom(roomNumber);
//    }

    public Reservation bookARoom(String customerEmail, Room room, Date checkInDate, Date checkOutDate){
        Customer customer = customerService.getCustomer(customerEmail);
        if( customer == null){
            return null;
        }
        return reservationService.reserveARoom(customer,room, checkInDate, checkOutDate);
    }

    public Set<Reservation> getCustomersReservation(String customerEmail){
        Customer customer = customerService.getCustomer(customerEmail);
        if( customer == null){
            return null;
        }
        return reservationService.getCustomersReservation(customer);
    }

    public Set<Room> findARoom(Date checkInDate, Date checkOutDate){
        return reservationService.findRooms(checkInDate, checkOutDate);
    }

}