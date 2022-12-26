package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

//import java.util.*;  // Does this import everything?

//import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReservationService {
    //Static variable
    private static ReservationService reservationService = null;

    private  ReservationService() {

    }

    //Default Constructor
    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    private static Set<IRoom> roomSet = new HashSet<>();
    private static Set<Reservation> reservationSet = new HashSet<Reservation>();


    public void addRoom(IRoom room) {
        roomSet.add(room);
    }

    public IRoom getARoom(String roomId) {
        for (IRoom room : roomSet) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public static Set<IRoom> getAllRooms() {
        return roomSet;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationSet.add(reservation);
        return reservation;

    }


    //this methodneeds to be finished public Collection<IRoom>
    // findRooms(Date checkInDate, Date checkOutDate){}




    public Set<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Set<IRoom> availableRooms = new HashSet<>(roomSet);
        if (reservationSet.size() != 0) {
            for (IRoom room : roomSet) {
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
