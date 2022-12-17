package api;

import model.Customer;
import model.Reservation;
import model.IRoom;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class HotelResource {
    public Customer getCustomer(String email){}

    public void createACustomer(String email, String firstName, String lastName){}

    public IRoom getRoom(String roomNumber){}

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){}

    public Set<Reservation> getCustomersReservation(String customerEmail){}

    public Set<IRoom> findARoom(Date checkIn, Date checkOut){
        return null;
    }

}