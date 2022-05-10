package RaceOfThreads;
import java.util.*;

public class Race implements Runnable{
    public ArrayList<Integer> list;
    private final Object LOCK = new Object();

    public Race(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public synchronized void run() {
        synchronized (LOCK){
        oddEven(this.list);
        }
    }

    public synchronized void oddEven(List<Integer> a){
        for(Integer element : a){
            if(element %2 ==0){
                Main.even.add(element);
            }
            else{
                Main.odd.add(element);
            }
        }  
    }
}
