package MaceraOyunu;

public class Monster {
    private int id;
    private int damage;
    private int healt;
    private String name;
    private int monsAward;
    private String snakeAward;
    private int originalHealt;


    public Monster(int id, int damage, int healt, String name, int monsAward) {
        this.id = id;
        this.damage = damage;
        this.healt = healt;
        this.name = name;
        this.monsAward = monsAward;
        this.originalHealt = healt;
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
        if(healt < 0){
            healt = 0;
        }
        this.healt = healt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonsAward(){
        return monsAward;
    }

    public void setMonsAward(int monsAward){
        this.monsAward = monsAward;
    }
    
    public int getOriginalHealt(){
        return originalHealt;
    }

    public void setOriginalHealt(int originalHealt){
        this.originalHealt = originalHealt;
    }
    
    
}
