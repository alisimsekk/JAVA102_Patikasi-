package PatikaStore;
import java.util.*;

public class ManagementPanel {
    private ArrayList<Brand> brandList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private NoteBookOperations noteBookOperations = new NoteBookOperations();
    private SmartPhoneOperations smartPhoneOperations = new SmartPhoneOperations();
    boolean running = true;

    public void run(){
        allBrandsAdd();
        while(running){
            System.out.println();
            System.out.println("PatikaStore Ürün Yönetim Paneline Hoşgeldiniz!");
            System.out.println("1 - Notebook İşlemleri\n" +
                                "2 - Cep Telefonu İşlemleri\n" +
                                "3 - Marka Listele\n" +
                                "0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            int select = input.nextInt();

            switch (select){
                case 1:
                    noteBookOperations.run(brandList);
                    break;
                case 2:
                    smartPhoneOperations.run(brandList);
                    break;

                case 3:
                    printBrand();
                    break;

                case 0:
                    System.out.println("Sistemden çıkış yapılıyor.");
                    running = false;
                    break;
            }
        }
    }

    private void allBrandsAdd() {
        brandList.add(new Brand(1,"Samsung"));
        brandList.add(new Brand(2,"Lenovo"));
        brandList.add(new Brand(3,"Apple"));
        brandList.add(new Brand(4,"Huawei"));
        brandList.add(new Brand(5,"Casper"));
        brandList.add(new Brand(6,"Asus"));
        brandList.add(new Brand(7,"HP"));
        brandList.add(new Brand(8,"Xiaomi"));
        brandList.add(new Brand(9,"Monster"));
    }

    private void printBrand(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Sisteme kayıtlı markalarımız : ");
        Collections.sort(brandList);
        for(Brand brand : brandList){
            System.out.println("- " + brand.getName());
        }
        System.out.println();
    }
}
