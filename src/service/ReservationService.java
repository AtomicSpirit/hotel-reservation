package service;

import model.*;

//import java.util.*;  // Does this import everything?

//import java.util.Collection;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public static Set<Room> roomSet = new HashSet<>(); //  A list of all the rooms
    public static Set<Reservation> reservationSet = new HashSet<Reservation>(); // A list of all the reservations

//Takes in the input from admin and creates a room.  That room is added to the list of all the rooms
    public void addRoom(String roomNumber, Double roomPrice, RoomType roomType, Boolean isFree) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setPrice(roomPrice);
        room.setRoomType(roomType);
        room.setIsFree(isFree);
        roomSet.add(room);
    }

    //Lookin up the info of a room by its Number
    public Room getARoom(String roomId) {
        for (Room room : roomSet) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }


    // getAllRooms should it be getAllRoomsThatAreAvailable?
    public  Set<Room> getAllRooms() {
        Set availableRooms = new HashSet<>();
        for(Room room : roomSet){
            if(room.isFree = true){
                availableRooms.add(room);
            }

        }
        return availableRooms;
    }
    

    public Reservation reserveARoom(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationSet.add(reservation);
        room.isFree = false;
        return reservation;

    }


    //this methodneeds to be finished public Collection<IRoom>
    // findRooms(Date checkInDate, Date checkOutDate){}




    public Set<IRoom> findRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        Set<IRoom> availableRooms = new HashSet<>(roomSet);
        if (reservationSet.size() != 0) {
            for (Room room : roomSet) {
                for (Reservation reservation : reservationSet) {
                    if (room.getRoomNumber().equals(reservation.getRoom().getRoomNumber())) {
                        if ((reservation.getCheckInDate().isBefore(checkOutDate) && reservation.getCheckOutDate().isAfter(checkInDate))) {
                            availableRooms.remove(room);
                        } else {
                        }
                    }
                }
            }
        }
        return availableRooms;
    }

    public Set<Reservation> getCustomersReservation(Customer customer) {
        Set<Reservation> customersRez = new HashSet<>();

        for(Reservation rez : reservationSet) {
            if(rez.getCustomer().getEmail().equals(customer.getEmail())) {
               customersRez.add(rez);
        }

    }
        return customersRez;
    }



    public void printAllReservation() {
        for (Reservation reservation : reservationSet) {
            System.out.println(reservation);
        }
    }

//   public ArrayList getCustomersReservation(){
//        return (ArrayList) reservationSet;}
   }





