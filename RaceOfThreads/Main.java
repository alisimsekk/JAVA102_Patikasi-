package RaceOfThreads;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> odd = new ArrayList<>();
    public static ArrayList<Integer> even = new ArrayList<>();

    public static void main(String [] args){

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> numbs1 = new ArrayList<>();
        ArrayList<Integer> numbs2 = new ArrayList<>();
        ArrayList<Integer> numbs3 = new ArrayList<>();
        ArrayList<Integer> numbs4 = new ArrayList<>();

        for(int i = 1; i <= 10000; i++){
            numbers.add(i);
        }
        //// 1-1000 arası sayıları içeren ArrayList oluşturuldu.

        numbs1.addAll(numbers.subList(0,2500));
        numbs2.addAll(numbers.subList(2500,5000));
        numbs3.addAll(numbers.subList(5000,7500));
        numbs4.addAll(numbers.subList(7500,10000));


        Race r1 = new Race(numbs1);
        Race r2 = new Race(numbs2);
        Race r3 = new Race(numbs3);
        Race r4 = new Race(numbs4);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("1. sleep çalışmadı");
        }
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("2. sleep çalışmadı");
        }
        t3.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("3. sleep çalışmadı");
        }
        t4.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("4. sleep çalışmadı");
        }

        System.out.println("Yarış sona erdi.");
        System.out.println("---------------------------------------");

        //odd.stream().sorted().forEach(i -> System.out.print(i + " "));
        System.out.print("Tek sayıları tutan liste boyutu : ");
        System.out.println(odd.size());
        System.out.println();
        //even.stream().sorted().forEach(i -> System.out.print(i +" "));
        System.out.print("Çift sayıları tutan liste boyutu : ");
        System.out.println(even.size());
    }
}
