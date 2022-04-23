package GenericClassProject;

public class Main {
    public static void main (String[] args){
        MyList<Integer> List = new MyList<>();
        System.out.println("Dizinin kapasitesi : " + List.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + List.size());
        System.out.println("Liste durumu : " + (List.isEmpty() ? "Boş" : "Dolu"));
        List.add(10);
        List.add(20);
        List.add(30);
        List.add(40);

        System.out.println("Dizinin kapasitesi : " + List.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + List.size());
        System.out.println("Liste durumu : " + (List.isEmpty() ? "Boş" : "Dolu"));
        List.add(50);
        List.add(60);
        List.add(70);
        List.add(80);
        List.add(10);
        List.add(100);
        List.add(110);
        System.out.println("Dizinin kapasitesi : " + List.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + List.size());
       // List.remove(0);
        System.out.println("4. indisteki değer : " + List.get(4));
        System.out.println("Dizinin kapasitesi : " + List.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + List.size());

        List.set(22,333);
        System.out.println("2. indisteki değer : " + List.get(2));

        System.out.println(List.toString());

        System.out.println("indeks : " + List.indexOf(100));
        System.out.println("son indeks : " + List.lastIndexOf(10));

        Object[] dizi = List.toArray();
        System.out.println("Object dizisinin 3. elemanı : " + dizi[2]);

        List.clear();
        System.out.println("Liste temizlendi");
        System.out.println("Dizinin kapasitesi : " + List.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + List.size());
        System.out.println("Liste durumu : " + (List.isEmpty() ? "Boş" : "Dolu"));

        List.add(5);
        List.add(15);
        List.add(25);
        List.add(35);
        List.add(45);
        List.add(55);
        List.add(65);
        System.out.println("Dizinin kapasitesi : " + List.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + List.size());
        System.out.println("Liste durumu : " + (List.isEmpty() ? "Boş" : "Dolu"));

        System.out.println("Alt liste oluşturuldu");
        MyList<Integer> altListem = List.subList(0, 2);
        System.out.println(altListem.toString());

        System.out.println("Listede 20 var mı : " + List.contains(20));
        System.out.println("Listede 25 var mı : " + List.contains(25));

    }
}
