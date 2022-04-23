package MaceraOyunu;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player){
        super(player, "Güvenli Ev", 1);
    }

    @Override
    public boolean onLocation(){
        if(this.getPlayer().getInventory().getCaveAward() != null && this.getPlayer().getInventory().getForestAward() != null && this.getPlayer().getInventory().getRiverAward() != null){
        System.out.println("####### OYUNU KAZANDINIZ #######");
        BattleLocation.isWin = true;

        }
        if(BattleLocation.isWin == false){
            System.out.println("Güvenli evdesiniz. Burada düşman yoktur.");
            this.getPlayer().setHealt(this.getPlayer().getOriginalHealt());
            System.out.println("Canınız yenilendi. Güncel Sağlık : " + this.getPlayer().getHealt());
            System.out.println();

        
        }
        return true;
    }

}
