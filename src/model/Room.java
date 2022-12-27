package model;

public class Room implements IRoom {
    public String roomNumber;
    public Double price;
    public RoomType roomType;

    public boolean isFree;

    public Room(String roomNumber, Double price, RoomType roomType, boolean isFree) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.isFree = isFree;
    }

    public Room() {

    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean getIsFree() {
        return isFree;
    }


    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Room Number:# " + roomNumber + " Price : $" + price
                + " Room Type:" + roomType + " Is the room free? " + isFree;
    }
}