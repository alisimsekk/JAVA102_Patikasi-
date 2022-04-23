package MaceraOyunu;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player){
        super(player, "Mağaza", 2);
    }

    @Override
    public boolean onLocation(){
        boolean showMenu = true;
        System.out.println("Mağazaya Hoşgeldiniz. Silah veya zırh satın alabilirsiniz.");
        while(showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış");
            System.out.print("Seçiminiz : ");
            int selectcase = input.nextInt();    //Location ata sınıfında Scanner ı public static tanımladık. Burada kullanabilmek için.
    
            while(selectcase < 1 || selectcase > 3){
                System.out.print("Hatalı seçim yaptınız. Lütden tekrar seçim yapınız : ");
                selectcase = input.nextInt();
            }
    
            switch(selectcase){
    
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
    
                case 2:
                    printArmor();
                    buyArmor();
                    break;
    
                case 3:
                System.out.println("Tekrar görüşmek üzere. Yine bekleriz.");
                System.out.println();
                showMenu = false;
                break;
            }
        }
        return true;
    }
        
    public void printWeapon(){
        System.out.println("-------  Silahlar  -------");

        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + 
                                "\t" + w.getName() + 
                                "\t\tHasar : " + w.getDamage() +  
                                "\tFiyatı : " + w.getPrice());
        }
        System.out.println("0 \t Çıkış yap.");
    }

    public void buyWeapon(){
        System.out.println();
        System.out.print("Satın almak istediğiniz silahı seçiniz : ");
        int selectWeaponID = input.nextInt();
        
        while(selectWeaponID < 0 || selectWeaponID > ( Weapon.weapons().length)){
            System.out.print("Geçersiz seçim. Tekrar giriş yapınız : ");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if(selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getCoin()){
                    System.out.println();
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                    System.out.println();
                }
                else{
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();  // oyuncunun mevcut parasından silah parası çıkarılıyor ve kalan para bulunuyor.
                    this.getPlayer().setCoin(balance);
                    System.out.println();
                    System.out.println("Kalan paranız : " + this.getPlayer().getCoin());

                    System.out.println("---------------------------------------------------------");
                    System.out.println("önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println("---------------------------------------------------------");

                }
            }
        }
    }

    public void printArmor(){
        System.out.println("-------  Zırhlar  -------");

        for(Armor a : Armor.armors()){
            System.out.println(a.getId() + 
                                "\t" + a.getName() + 
                                "\tEngelleme : " + a.getBlock() +  
                                "\tFiyatı : " + a.getPrice());
        }
        System.out.println("0 \tÇıkış yap.");

    }

    public void buyArmor(){
        System.out.println();
        System.out.print("Satın almak istediğiniz zırhı seçiniz : ");
        int selectArmorID = input.nextInt();
        
        while(selectArmorID < 0 || selectArmorID > ( Armor.armors().length)){
            System.out.print("Geçersiz seçim. Tekrar giriş yapınız : ");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getCoin()){
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                }
                else{
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız.");
                    int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();  // oyuncunun mevcut parasından ZIRH parası çıkarılıyor ve kalan para bulunuyor.
                    this.getPlayer().setCoin(balance);
                    System.out.println();
                    System.out.println("Kalan paranız : " + this.getPlayer().getCoin());

                    System.out.println("---------------------------------------------------------");
                    System.out.println("önceki zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("yeni zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                    System.out.println("---------------------------------------------------------");
                }
            }
        }
    }
}
