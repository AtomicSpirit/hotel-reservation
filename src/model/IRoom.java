package model;

/*
The interface is a completely "abstract class" that is used to group related methods



*/
public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean getIsFree();
}
