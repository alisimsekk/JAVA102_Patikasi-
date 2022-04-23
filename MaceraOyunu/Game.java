package MaceraOyunu;
import java.util.Random;
import java.util.Scanner;


public class Game {
    
    
    public void start(){
        Scanner input = new Scanner(System.in);
        
        System.out.println ("\nMacera Oyununa Hoşgeldiniz!");
        System.out.println("Amacın tüm bölgelerdeki canavarları öldürüp, her bölgenin ödülünü toplayıp güvenli eve gitmek.");

        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();


        Player player = new Player(playerName);
        
        System.out.println("\n" + player.getPlayerName() + " artık sisli ve puslu macera patikasındasın\n");

        System.out.println("---------------------------------------------------------");

        System.out.println("Savaşmak için karakterini seç");
        
        player.selectCharActor();

        
        
        while(true){
            if(BattleLocation.isWin ==true){
                break;
            }
            player.printInfo();
            Location [] locList = {new SafeHouse(player), new ToolStore(player), new Cave(player), 
                                    new Forest(player), new River(player), new Mine(player,snakeDamage())};

            System.out.println("---------------------------------------------------------");
            System.out.println("\nGitmek istediğiniz bölgeyi seçiniz.\n");
            for (Location location : locList) {
                System.out.print(location.getId() + "\t" +
                                location.getLocationName());
                if(location.getId()==1){
                    System.out.print("\tBurada canavar yok ayrıca canın yenilenir." );
                }
                if(location.getId()==3){
                    System.out.print("\t\tÖdül : Yemek" );
                }
                if(location.getId()==4){
                    System.out.print("\t\tÖdül : Odun");
                }
                if(location.getId()==5){
                    System.out.print("\t\tÖdül : Su" );
                }
                System.out.println();
            }
            
            System.out.println("0 \tÇıkış yap.");

            int selectLoc;
            Location location = null;
            do{
                System.out.print("\nLütfen bölge seçiminizi giriniz : ");
                selectLoc = input.nextInt();

                System.out.println();

                switch(selectLoc){
                    case 0:
                        location = null;
                        break;

                    case 1:
                        location = new SafeHouse(player);
                        break;

                    case 2:
                        location = new ToolStore(player);
                        break;

                    case 3:
                        if(player.getInventory().getCaveAward()== null){
                            location = new Cave(player);
                        }
                        else{
                            System.out.println("Mağara ödülü kazanıldı. Lütfen başka bir bölge seçiniz.");
                            System.out.println();
                            location = new SafeHouse(player);
                        }
                        break;

                    case 4:
                        if(player.getInventory().getForestAward() == null){
                            location = new Forest(player);
                        }
                        else{
                            System.out.println("Orman ödülü kazanıldı. Lütfen başka bir bölge seçiniz.");
                            System.out.println();
                            location = new SafeHouse(player);
                        }
                        break;

                    case 5:
                        if(player.getInventory().getRiverAward() == null){
                            location = new River(player);
                        }
                        else{
                            System.out.println("Nehir ödülü kazanıldı. Lütfen başka bir bölge seçiniz.");
                            System.out.println();
                            location = new SafeHouse(player);
                        }
                        break;

                    case 6:
                        location = new Mine(player,snakeDamage());

                        break;

                    default:
                    location = new SafeHouse(player);
                }

            }while( selectLoc<0 && selectLoc>5);

            if(location == null){
                System.out.println("Oyun sonlandırıldı.");
                break;
            }
            

            if(!location.onLocation()){                 // !location.onLocation()  demek location.onLocation() == false ile aynı anlamdadır.
                System.out.println("GAME OVER");
                break;
            }

        }    

        
    }

    public static int snakeDamage(){
        Random r = new Random();
        int d = r.nextInt(3, 7);
        return d;
    }

   /* public String mineAward(){
        String a = "Silah";
        return a;
    }
    */
}
