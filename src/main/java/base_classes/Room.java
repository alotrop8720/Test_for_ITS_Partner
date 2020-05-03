package base_classes;

import java.io.Serializable;

public class Room implements Serializable {
    private String name;
    private String country;
    private boolean light;

    public Room(String name, String country) {
        this.name = name;
        this.country = country;
        this.light = false;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean isLight() {
        return light;
    }

    public boolean turnLight(){
        light = !light;
        return light;
    }
}
