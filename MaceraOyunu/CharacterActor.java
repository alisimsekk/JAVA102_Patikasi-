package MaceraOyunu;

public abstract class CharacterActor {
    private String name;
    private int id;
    private int damage;
    private int healt;
    private  int coin;

    public CharacterActor (String name, int id, int damage, int healt, int coin){
        this.coin=coin;
        this.damage=damage;
        this.healt=healt;
        this.id=id;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.healt = healt;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
    
    
}
