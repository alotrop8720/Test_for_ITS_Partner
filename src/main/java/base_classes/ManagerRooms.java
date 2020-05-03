package base_classes;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ManagerRooms implements Serializable {
    private static Logger logger = Logger.getLogger(ManagerRooms.class.getName());
    private static int count = 0;
    private Map<Integer, Room> rooms = new HashMap<>();

    public ManagerRooms() {
        deserialization();
    }

    public synchronized void createRoom(String name, String country){
        rooms.put(count++, new Room(name, country));
    }

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


    public List<Room> getListRoom(){
        List<Room> roomList = new ArrayList<>();
        for (Room item: rooms.values()){
            roomList.add(item);
        }
        return roomList;
    }
}
