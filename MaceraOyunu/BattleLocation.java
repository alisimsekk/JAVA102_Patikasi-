package MaceraOyunu;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;
    public static boolean isWin = false;

    public BattleLocation(Player player, String locationName, int id, Monster monster, String award, int maxMonster){
        super(player, locationName, id);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation(){
        int monsNumber = this.randomMonsterNumb();
        System.out.println("Şu an buradasınız : "  + this.getLocationName() + "\nBölge ödülü \t  : " + this.getAward() );
        System.out.println("Dikkatli ol! Burada " + monsNumber + " tane " + this.getMonster().getName() + " yaşıyor.");
        System.out.println();
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            System.out.println("Savaşa hazırsın.");
            System.out.println();
            if(combat(monsNumber)){
                System.out.println("######### " + this.getLocationName() + " bölgesindeki tüm canavarları yendiniz! #########");
                if(this.getMonster().getId()==4){
                    System.out.println();
                } 
                else{
                    System.out.println(this.getAward() + " ödülü kazanıldı");
                    System.out.println();
                }
                
                if(this.getLocationName().equals("Mağara")){
                    this.getPlayer().getInventory().setCaveAward(this.getAward());
                }

                if(this.getLocationName().equals("Orman")){
                    this.getPlayer().getInventory().setForestAward(this.getAward());
                }

                if(this.getLocationName().equals("Nehir")){
                    this.getPlayer().getInventory().setRiverAward(this.getAward());
                }

                isGameWin();
               
                return true;
            }
        }

        if(this.getPlayer().getHealt() <= 0){
            System.out.println("Öldünüz.");
            return false;
        }
        
        return true;
    }

    public void isGameWin(){
        if(this.getPlayer().getInventory().getCaveAward() != null && this.getPlayer().getInventory().getForestAward() != null && this.getPlayer().getInventory().getRiverAward() != null){
            System.out.println("######################################################################################");
            System.out.println("TEBRİKLER! TÜM BÖLGE ÖDÜLLERİNİ TOPLADINIZ. OYUNU KAZANMAK İÇİN GÜVENLİ EVE DÖNMELİSİN");
            System.out.println("######################################################################################");
            System.out.println();
        }
    }

    public boolean combat(int monsNumber){
        for (int i = 1; i <= monsNumber; i++){
            this.getMonster().setHealt(this.getMonster().getOriginalHealt());
            playerStats();
            monsterStats(i);

            Random r = new Random();
            int firstPunch = r.nextInt(2);

            while(this.getPlayer().getHealt() > 0 && this.getMonster().getHealt() > 0){

                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();
                System.out.println("---------------------------------------------------------");
                if(selectCombat.equals("V")){
                    if(firstPunch == 0){
                        // oyuncunun ilk vuruş yaptığı durum
                        System.out.println("Oyuncu vurdu");
                        this.getMonster().setHealt(this.getMonster().getHealt() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getMonster().getHealt() > 0){
                            System.out.println();
                            System.out.println("Canavar vurdu");
                            int monsDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(monsDamage < 0){
                                monsDamage = 0;
                            }
                            this.getPlayer().setHealt(this.getPlayer().getHealt() - monsDamage);
                            if(this.getPlayer().getHealt() < 0){
                                this.getPlayer().setHealt(0);
                            }
                            afterHit();
                        }
                    }
                    if(firstPunch ==1){
                        // canavarın ilk vuruşu yaptığı durum
                        System.out.println("Canavar vurdu");
                        int monsDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(monsDamage < 0){
                            monsDamage = 0;
                        }
                        this.getPlayer().setHealt(this.getPlayer().getHealt() - monsDamage);
                        if(this.getPlayer().getHealt() < 0){
                            this.getPlayer().setHealt(0);
                        }
                        afterHit();
                            
                        if(this.getPlayer().getHealt()>0){
                            System.out.println();
                            System.out.println("Oyuncu vurdu");
                            this.getMonster().setHealt(this.getMonster().getHealt() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                }
                else if(selectCombat.equals("K")) {
                    return false;
                }
                else{
                    continue;
                }
            }


            if(this.getMonster().getHealt() < this.getPlayer().getHealt()){
                System.out.println("Canavarı öldürdünüz!");
                this.getMonster().setDamage(snakeDamage());
                if(this.getMonster().getId()==4){
                    Random rnd = new Random();
                    int possibilityAward = rnd.nextInt(100);
                    String select;
                    if(possibilityAward>=0 && possibilityAward<15){
                        System.out.println("Yılandan silah çıktı");
                        switch(possibility()) {
                            
                            case 1:
                                System.out.print("Tüfek kazandınız. Almak istiyor musunuz? -->  <E>vet   <H>ayır : ");
                                select = input.nextLine().toUpperCase();
                                if(select.equals("E")){
                                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                                }
                            break;

                            case 2:
                            System.out.print("Kılıç kazandınız. Almak istiyor musunuz? -->  <E>vet   <H>ayır : ");
                                select = input.nextLine().toUpperCase();
                                if(select.equals("E")){
                                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                                }
                            break;

                            case 3:
                            System.out.print("Tabanca kazandınız. Almak istiyor musunuz? -->  <E>vet   <H>ayır : ");
                                select = input.nextLine().toUpperCase();
                                if(select.equals("E")){
                                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                                }
                            break;
                        }
                    }
                    if(possibilityAward>=15 && possibilityAward<30){
                        System.out.println("Yılandan zırh çıktı");
                        switch(possibility()) {
                            
                            case 1:
                                System.out.print("Ağır zırh kazandınız. Almak istiyor musunuz? -->  <E>vet   <H>ayır : ");
                                select = input.nextLine().toUpperCase();
                                if(select.equals("E")){
                                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
                                }
                            break;

                            case 2:
                            System.out.print("Orta zırh kazandınız. Almak istiyor musunuz? -->  <E>vet   <H>ayır : ");
                                select = input.nextLine().toUpperCase();
                                if(select.equals("E")){
                                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                                }
                            break;

                            case 3:
                            System.out.print("Hafif zırh kazandınız. Almak istiyor musunuz? -->  <E>vet   <H>ayır : ");
                                select = input.nextLine().toUpperCase();
                                if(select.equals("E")){
                                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                                }
                            break;
                        }
                    }
                    if(possibilityAward>=30 && possibilityAward<55){
                        System.out.println("Yılandan para kazandınız");
                        switch(possibility()) {
                            
                            case 1:
                                this.getMonster().setMonsAward(10);
                                System.out.println(this.getMonster().getMonsAward() + " coin kazandınız!");
                                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getMonsAward());
                                System.out.println("Güncel paranız : " + this.getPlayer().getCoin());
                                System.out.println();
                            break;

                            case 2:
                                this.getMonster().setMonsAward(5);
                                System.out.println(this.getMonster().getMonsAward() + " coin kazandınız!");
                                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getMonsAward());
                                System.out.println("Güncel paranız : " + this.getPlayer().getCoin());
                                System.out.println();
                            break;

                            case 3:
                                this.getMonster().setMonsAward(1);
                                System.out.println(this.getMonster().getMonsAward() + " coin kazandınız!");
                                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getMonsAward());
                                System.out.println("Güncel paranız : " + this.getPlayer().getCoin());
                                System.out.println();
                            break;
                        }
                    }
                    if(possibilityAward>=55 && possibilityAward<100){
                        System.out.println("Hiç birşey kazanamadınız");
                    }
                    
                }
                else{
                    System.out.println(this.getMonster().getMonsAward() + " coin kazandınız!");
                    this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getMonsAward());
                    System.out.println("Güncel paranız : " + this.getPlayer().getCoin());
                    System.out.println();
                }
                
            }
            else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Kalan canınız : " + this.getPlayer().getHealt());
        System.out.println(this.getMonster().getName() + " canı : " + this.getMonster().getHealt());
        System.out.println();
    }

    public static int snakeDamage(){
        Random r = new Random();
        int d = r.nextInt(3, 7);
        return d;
    }

    public void playerStats(){
        System.out.println("#### Savaş öncesi karakter özellikleri : ####");
        System.out.println("---------------------------------------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealt() + 
                            "\tSilah : " + this.getPlayer().getInventory().getWeapon().getName() + 
                            "\tZırh : " + this.getPlayer().getInventory().getArmor().getName() + 
                            "\tEngelleme : " + this.getPlayer().getInventory().getArmor().getBlock() +
                            "\tHasar : " + this.getPlayer().getTotalDamage() + 
                            "\tPara :" + this.getPlayer().getCoin() + "\n");       
    }

    public void monsterStats(int i){
        System.out.println("#### " +i + "." + this.getMonster().getName() + " değerleri ####");
        System.out.println("---------------------------------------------------------");
        System.out.println("Sağlık : " + getMonster().getHealt() + 
                            "\tHasar : " + getMonster().getDamage() +
                            "\tÖdül : " + getMonster().getMonsAward() + "\n");

    }

    public int possibility(){
        Random r = new Random();
        int x = r.nextInt(100);
        if(x>=0 && x<20){
            return 1;
        }
        if(x>=20 && x<50){
            return 2;
        }
        return 3;
    }

    public int randomMonsterNumb(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
    
    
    
}
