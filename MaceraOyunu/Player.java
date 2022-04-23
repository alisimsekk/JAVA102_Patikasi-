package MaceraOyunu;

import java.util.Scanner;

public class Player {
    private int id;
    private int damage;
    private int healt;
    private int originalHealt;
    private int coin;
    private String playerName;
    private String charName;
    private int select =0;
    Scanner input = new Scanner(System.in);
    private Inventory inventory;
    
    public Player (String playerName){
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public void selectCharActor(){

        CharacterActor [] charList = {new Samurai(),new Archer(), new Knight()};
        System.out.println();
        for (CharacterActor characterActor : charList) {
            System.out.println(  characterActor.getId() +
                                 "   " + characterActor.getName() +
                                 "\t Hasar : " + characterActor.getDamage() +
                                 "\t Sağlık : " + characterActor.getHealt() + 
                                 "\t Coin : " + characterActor.getCoin());
        }
        System.out.println();
       
        do{
            System.out.print("Lütfen karakter seçiminizi giriniz : ");
            select=input.nextInt();
        }while(select !=1 && select !=2 && select !=3);

        System.out.println("---------------------------------------------------------");
        switch(select){
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println(this.getCharName() + " karakterini seçtiniz. Macera oyununda başarılar.\n ");
    }

    public void initPlayer(CharacterActor gameChar){
        this.setId(gameChar.getId());
        this.setDamage(gameChar.getDamage());
        this.setHealt(gameChar.getHealt());
        this.setOriginalHealt(gameChar.getHealt());
        this.setCoin(gameChar.getCoin());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(  "Silah : " + this.getInventory().getWeapon().getName() + 
                                 "\t Hasar : " + getTotalDamage() +
                                 "\t Sağlık : " + getHealt() + 
                                 "\t Coin : " + getCoin());
        
        System.out.println("Zırh  : " + this.getInventory().getArmor().getName() + 
                            "\t Engelleme : " + this.getInventory().getArmor().getBlock());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        if(healt <=0 ){
            healt = 0;
        }
        this.healt = healt;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory(){
        return inventory;
    }
    
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public int getOriginalHealt() {
        return originalHealt;
    }

    public void setOriginalHealt(int originalHealt) {
        this.originalHealt = originalHealt;
    }

    

    

    
    
}
