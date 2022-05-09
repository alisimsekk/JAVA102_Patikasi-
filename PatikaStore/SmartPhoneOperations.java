package PatikaStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SmartPhoneOperations {
    ArrayList<SmartPhone> phoneList = new ArrayList<>();
    int maxID = 0;
    Scanner input = new Scanner(System.in);

    public void run(ArrayList<Brand> brandList){
        int select;
        System.out.println("----------------------------------------------------");
        System.out.println("1- Cep telefonu ekle");
        System.out.println("2- Cep telefonu listeleme");
        System.out.println("3- Cep telefonu silme");
        System.out.println("4- Cep telefonu filtreleyerek listeleme");
        System.out.print("Seçiminiz :");
        select = input.nextInt();
        switch (select){
            case 1:
                addSmartPhone(brandList);
                break;

            case 2:
                if(phoneList.size()==0){
                    System.out.println("\nListelenecek ürün bulunamadı. Yeni ürün eklemenmesi gerekir.");
                }
                else {
                    printNotebookList();
                }
                break;

            case 3:
                if(phoneList.size()==0){
                    System.out.println("\nSilinecek ürün bulunamadı.");
                }
                else {
                    deletePhone(phoneList);
                }
                break;
                
            case 4:
                if(phoneList.size()==0){
                    System.out.println("\nListelenecek ürün bulunamadı. Yeni ürün eklemenmesi gerekir.");
                }
                else {
                    printPhoneWithFilter();
                }
                break;
        }
    }
    public void addSmartPhone(ArrayList<Brand> brandList){
        int ID = phoneList.size()+1;
        System.out.print("Fiyat bilgisini giriniz : ");
        double price = input.nextDouble();

        System.out.print("İndirim oranını giriniz : ");
        double discountRate = input.nextDouble();

        System.out.print("Stok miktarını giriniz : ");
        int stock = input.nextInt();

        System.out.print("Ürün modelini giriniz : ");
        String productName = input.next();

        String brandName=null;
        while (brandName == null){
            System.out.print("Giriş yapılabilir markalar listesi : ");
            Collections.sort(brandList);
            for(Brand brand : brandList){
                System.out.print(brand.getName() + ", ");
            }
            System.out.println();
            System.out.print("Telefon marka bilgisini yazın : ");

            String tempBrand = input.next().toUpperCase();
            for(Brand brand : brandList){
                if(tempBrand.equals(brand.getName().toUpperCase())){
                    brandName = tempBrand.substring(0,1).toUpperCase()+tempBrand.substring(1).toLowerCase();
                }
            }
        }

        System.out.print("Depolama bilgisini giriniz : ");
        int storage = input.nextInt();

        System.out.print("Ekran boyutunu giriniz : ");
        int screenSize = input.nextInt();

        System.out.print("RAM bilgisini giriniz : ");
        int ram = input.nextInt();

        System.out.print("Kamera bilgisini giriniz : ");
        int camera = input.nextInt();

        System.out.print("Batarya kapasitesini giriniz : ");
        int batteryCapacity = input.nextInt();

        System.out.print("Renk bilgisini giriniz : ");
        String color = input.next();

        phoneList.add(new SmartPhone(ID, price, discountRate, stock, productName, brandName, storage, screenSize, ram, camera, batteryCapacity, color));
        System.out.println("\nÜrün sisteme başarı ile eklendi.");
    }

    public void printNotebookList(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                  | Price         | Brand     | Storage   | Screen Size  | Camera     | Battery    | RAM        | Color      |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        int i = 1;
        for (SmartPhone phone : phoneList) {
            System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                    i, phone.getProductName(), phone.getPrice(), phone.getBrand(),
                    phone.getStorage(), phone.getScreenSize(), phone.getCamera(), phone.getBatteryCapacity(), phone.getRam(), phone.getColor());
            i++;
        }
    }

    public void printPhoneWithFilter(){
        System.out.println("ID'ye göre filtreleme için 1'e" +
                "\nMarkaya göre filtreleme için 2'ye basınız.");
        int select = input.nextInt();
        if(select==1){
            System.out.print("Filtrelemek istediğiniz ID numarasını giriniz : ");
            int ID = input.nextInt();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                  | Price         | Brand     | Storage   | Screen Size  | Camera     | Battery    | RAM        | Color      |");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                    phoneList.get(ID-1).getId(), phoneList.get(ID-1).getProductName(), phoneList.get(ID-1).getPrice(), phoneList.get(ID-1).getBrand(),
                    phoneList.get(ID-1).getStorage(), phoneList.get(ID-1).getScreenSize(), phoneList.get(ID-1).getCamera(), phoneList.get(ID-1).getBatteryCapacity(), phoneList.get(ID-1).getRam(), phoneList.get(ID-1).getColor());
        }
        else{
            System.out.print("Filtrelemek istediğiniz markayı giriniz : ");
            String brand = input.next();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                  | Price         | Brand     | Storage   | Screen Size  | Camera     | Battery    | RAM        | Color      |");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            for (SmartPhone phone : phoneList) {
                if(phone.getBrand().equals(brand)){
                    System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                            phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand(),
                            phone.getStorage(), phone.getScreenSize(), phone.getCamera(), phone.getBatteryCapacity(), phone.getRam(), phone.getColor());
                }
            }
        }
    }

    public void deletePhone(ArrayList<SmartPhone> phoneList){
        boolean running = true;
        while (running){
            System.out.println("Çıkış için sıfıra basabilirsiniz");
            System.out.print("Silmek istediğiniz ürünün ID numarasını giriniz : ");
            int deleteID = input.nextInt();

            if(deleteID==0){
                running = false;
            }
            else{
                if (deleteID <= phoneList.size()){
                    System.out.println( phoneList.get(deleteID-1).getBrand() +" "+phoneList.get(deleteID-1).getProductName() + " ürünü başarı ile silindi");
                    phoneList.remove((deleteID-1));
                }

                else if(deleteID > phoneList.size()){
                    System.out.print("Hatalı giriş yaptınız tekrar ID numarası giriniz : ");
                }
            }
        }
    }
}
