package GenericClassProject;

import java.util.Arrays;

public class MyList <T> {
    private T [] arr;

    public MyList() {
        this.arr = (T[]) new Object[10];
    }

    public MyList(int capacity){
        this.arr = (T[]) new Object[capacity];
    }

    public int size(){
        int count = 0;
        for ( T i : arr){
            if(i != null){
                count++;
            }
        }
        return count;
    }

    public int getCapacity(){
        return arr.length;
    }

    public void add(T data){
        for (int i = 0; i< arr.length; i++){
            if (arr[i] == null){
                arr[i] = data;
                break;
            }
            else if(arr[i] != null && i == arr.length-1){
                arr = Arrays.copyOf(arr,arr.length*2);
                arr[arr.length/2] = data;
                break;
            }
        }
    }

    public T get(int index){
        if(index < arr.length){
            return arr[index];
        }
        else {
            return null;
        }
    }

    public void remove(int index){
        if(index < arr.length){
            arr[index] = null;
            for(int i = index; i< arr.length ; i++){
                if(i== arr.length-1){
                    arr[i] = null;
                }
                else{
                    arr [i] = arr[i+1];
                }
            }
        }
        else {
            System.out.println("null");
        }
    }

    public void set(int index, T data){
        if(index < arr.length) {
            arr[index] = data;
        }
        else {
            System.out.println("null");
        }
    }

    public String toString(){
        int a = size();
        arr = Arrays.copyOf(arr,a);
        return Arrays.toString((T []) arr) ;
    }

    public int indexOf(T data){
        for(int i = 0; i<arr.length; i++){
            if (arr[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int lastIndex =-1;
        for(int i = 0; i<arr.length; i++) {
            if (arr[i] == data) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public boolean isEmpty(){
        for ( T i : arr){
            if(i != null){
                return false;
            }
        }
        return true;
    }

    public T[] toArray(){
        return Arrays.copyOfRange(arr,0,size());

    }

    public void clear() {
        this.arr = (T[]) new Object[10];
    }

    public  MyList<T>  subList(int start,int finish){
        MyList<T> newList = new MyList<>(finish - start + 1);
        for(int i = start; i <= finish; i++){
            newList.add(arr[i]);
        }
        return newList;
    }

    public boolean contains(T data){
        for( T i : arr){
            if(i == data){
                return true;
            }
        }
        return false;
    }

}
