package MaceraOyunu;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String locationName;
    private int id;
    public static Scanner input = new Scanner(System.in);


    public Location(Player player, String locationName, int id){
        this.locationName = locationName;
        this.player = player;
        this.id = id;
    }

    public abstract boolean onLocation();


    public String getLocationName (){
        return locationName;
    }

    public void setLocationName(String locationName){
        this.locationName = locationName;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
