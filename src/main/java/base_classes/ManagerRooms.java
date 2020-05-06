package base_classes;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * There are methods for interactions with base class Room.
 */
public class ManagerRooms implements Serializable {
    private static Logger logger = Logger.getLogger(ManagerRooms.class.getName());
    private int count = 0;
    private Map<Integer, Room> rooms = new HashMap<>();

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public ManagerRooms() {
        deserialization();
    }

    public synchronized Room createRoom(String name, String country){
        rooms.put(count++, new Room(name, country));
        return rooms.get(count-1);
    }

    /**
     * Serialisable object reference.
     */
    public synchronized void serialization(){
        File serFile = new File("Rooms.txt");
        try {
            if (!serFile.exists())
                serFile.createNewFile();
            ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream("Rooms.txt"));
            o.write(count);
            o.writeObject(rooms);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * Deserialisable object reference.
     */
    @SuppressWarnings("unchecked")
    public synchronized void deserialization(){
        if (new File("Rooms.txt").exists()){
            try {
                ObjectInputStream o = new ObjectInputStream(new FileInputStream("Rooms.txt"));
                count = o.read();
                rooms = (Map<Integer, Room>)o.readObject();
            }catch (IOException e){
                logger.info(e.getMessage());
            }catch (ClassNotFoundException e){
                logger.info(e.getMessage());
            }
        }
    }

    /**
     * Create list Room from Map
     * @return List of base class Room
     */
    public List<Room> getListRoom(){
        List<Room> roomList = new ArrayList<>();
        for (Room item: rooms.values()){
            roomList.add(item);
        }
        return roomList;
    }
}
