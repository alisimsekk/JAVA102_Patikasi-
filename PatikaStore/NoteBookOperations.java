package PatikaStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NoteBookOperations {
    ArrayList<Notebook> notebookList = new ArrayList<>();
    int maxID = 0;
    Scanner input = new Scanner(System.in);

    public void run(ArrayList<Brand> brandList){
        int select;
        System.out.println("----------------------------------------------------");
        System.out.println("1- Notebook ekle");
        System.out.println("2- Notebook listeleme");
        System.out.println("3- Notebook silme");
        System.out.println("4- Notebook filtreleyerek listeleme");
        System.out.print("Seçiminiz :");
        select = input.nextInt();
        switch (select){
            case 1:
                addNotebook(brandList);
                break;

            case 2:
                if(notebookList.size()==0){
                    System.out.println("\nListelenecek ürün bulunamadı. Yeni ürün eklemenmesi gerekir.");
                }
                else {
                    printNotebookList();
                }
                break;

            case 3:
                if(notebookList.size()==0){
                    System.out.println("\nSilinecek ürün bulunamadı.");
                }
                else {
                    deleteNotebook(notebookList);
                }
                break;

            case 4:
                if(notebookList.size()==0){
                    System.out.println("\nListelenecek ürün bulunamadı. Yeni ürün eklemenmesi gerekir.");
                }
                else {
                    printNotebookWithFilter();
                }
                break;
        }
    }

    public void addNotebook(ArrayList<Brand> brandList){
        int ID = notebookList.size()+1;
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
            System.out.print("Notebook marka bilgisini yazın : ");

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

        notebookList.add(new Notebook(ID, price, discountRate, stock, productName, brandName, storage, screenSize,ram));
        System.out.println("\nÜrün sisteme başarı ile eklendi.");
    }

    public void printNotebookList(){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                  | Price         | Brand     | Storage   | Screen Size  | RAM        |");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        int i = 1;
        for (Notebook notebook : notebookList) {
            System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                        i, notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                        notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
            i++;
        }
    }

    public void printNotebookWithFilter(){
        System.out.println("ID'ye göre filtreleme için 1'e" +
                            "\nMarkaya göre filtreleme için 2'ye basınız.");
        int select = input.nextInt();
        if(select==1){
            System.out.print("Filtrelemek istediğiniz ID numarasını giriniz : ");
            int ID = input.nextInt();
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                  | Price         | Brand     | Storage   | Screen Size  | RAM        |");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                    notebookList.get(ID-1).getId(), notebookList.get(ID-1).getProductName(), notebookList.get(ID-1).getPrice(), notebookList.get(ID-1).getBrand(),
                    notebookList.get(ID-1).getStorage(), notebookList.get(ID-1).getScreenSize(), notebookList.get(ID-1).getRam());
        }
        else{
            System.out.print("Filtrelemek istediğiniz markayı giriniz : ");
            String brand = input.next();
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                  | Price         | Brand     | Storage   | Screen Size  | RAM        |");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            for (Notebook notebook : notebookList) {
                if(notebook.getBrand().equals(brand)){
                    System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                            notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
                }
            }
        }
    }

    public void deleteNotebook(ArrayList<Notebook> notebookList){
        boolean running = true;
        while (running){
            System.out.println("Çıkış için sıfıra basabilirsiniz");
            System.out.print("Silmek istediğiniz ürünün ID numarasını giriniz : ");
            int deleteID = input.nextInt();

            if(deleteID==0){
                running = false;
            }
            else{
                if (deleteID <= notebookList.size()){
                    System.out.println( notebookList.get(deleteID-1).getBrand() +" "+notebookList.get(deleteID-1).getProductName() + " ürünü başarı ile silindi");
                    notebookList.remove((deleteID-1));
                }
                else if(deleteID > notebookList.size()){
                    System.out.print("Hatalı giriş yaptınız tekrar ID numarası giriniz : ");
                }
            }
        }
    }
}
