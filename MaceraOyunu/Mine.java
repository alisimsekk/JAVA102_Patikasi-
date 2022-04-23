package MaceraOyunu;

public class Mine extends BattleLocation {
    public Mine(Player player, int damage){
        super(player, "Maden", 6, new Snake(damage), "Canavara özel süpriz ödüller", 4);
        
    }
}
