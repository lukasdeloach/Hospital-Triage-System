
import java.util.ArrayList;

/**
 * A class representing a Room.
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */

public class Room {
    // instance variable roomList
    protected static ArrayList<Integer> roomList = new ArrayList<>();
    // instance variable rooms
    private ArrayList<Integer> rooms;

    /**
     * Costructor of the Room class.
     */
    public Room() {
        rooms = new ArrayList<>();
    }

    /**
     * Public mutator method, addRoom, that adds a room.
     * 
     * @param number
     */
    public void addRoom(Integer number) {
        rooms.add(number);
    }

    /**
     * Public getter method, getTotalRooms, of return type int that returns the
     * number of rooms.
     * 
     * @return roomList.size()
     */
    public static int getTotalRooms() {
        return roomList.size();
    }

    /**
     * Public mutator method, removeRoom, that removes a room if it exists.
     * 
     * @param number
     */
    public void removeRoom(Integer number) {
        try {
            rooms.remove(number);
        } catch (Exception e) {
            System.out.println("Invalid Room Number: " + number);
        }
    }

}