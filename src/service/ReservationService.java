package service;

import model.Customer;
import model.Room;
import model.Reservation;
import model.RoomType;

//import java.util.*;  // Does this import everything?

//import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReservationService {
    //Static variable
    public static ReservationService reservationService = null;

   public  ReservationService() {

    }

    //Default Constructor
    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public static Set<Room> roomSet = new HashSet<>();
    public static Set<Reservation> reservationSet = new HashSet<Reservation>();


    public void addRoom(String roomNumber, Double roomPrice, RoomType roomType, Boolean isFree) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setPrice(roomPrice);
        room.setRoomType(roomType);
        room.setIsFree(isFree);
        roomSet.add(room);
    }

    public Room getARoom(String roomId) {
        for (Room room : roomSet) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public  Set<Room> getAllRooms() {
        return roomSet;
    }

    public Reservation reserveARoom(Customer customer, Room room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationSet.add(reservation);
        return reservation;

    }


    //this methodneeds to be finished public Collection<IRoom>
    // findRooms(Date checkInDate, Date checkOutDate){}




    public Set<Room> findRooms(Date checkInDate, Date checkOutDate) {
        Set<Room> availableRooms = new HashSet<>(roomSet);
        if (reservationSet.size() != 0) {
            for (Room room : roomSet) {
                for (Reservation reservation : reservationSet) {
                    if (room.getRoomNumber().equals(reservation.getRoom().getRoomNumber())) {
                        if ((reservation.getCheckInDate().before(checkOutDate) && reservation.getCheckOutDate().after(checkInDate))) {
                            availableRooms.remove(room);
                        } else {
                        }
                    }
                }
            }
        }
        return availableRooms;
    }

    public static Set<Reservation> getCustomersReservation(Customer customer) {
        Set<Reservation> set = new HashSet<Reservation>();
        for (Reservation reservation : reservationSet) {
            if (reservation.getCustomer().equals(customer)) {
                set.add(reservation);
            }
        }
        return set;
    }

    public void printAllReservation() {
        for (Reservation reservation : reservationSet) {
            System.out.println(reservation);
        }
    }

}
