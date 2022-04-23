package MaceraOyunu;

public abstract class NormalLocation extends Location {

    public NormalLocation(Player player, String locationName, int id) {
        super(player, locationName, id);
        
    }

    @Override
    public boolean onLocation(){
        return true;
    }
}
