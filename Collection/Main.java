package Collection;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        
        TreeSet<Book> bookSetName = new TreeSet<>();

       bookSetName.add(new Book("War and Peace\t", 100, "Tolstoy", 1866));
       bookSetName.add(new Book("Les Miserables\t", 200, "	Victor Hugo", 1862));
       bookSetName.add(new Book("The Count of Monte Cristo", 300, " Alexandre Dumas pere", 1844));
       bookSetName.add(new Book("Kürk Mantolu Madonna", 400, "Sabahattin Ali", 1943));
       bookSetName.add(new Book("Puslu Kıtalar Atlası", 500, "İhsan Oktay Anar", 1995));
        
       for (Book book:bookSetName) {
           System.out.println("Book Name : " + book.getName() + " \t\tPage : " + book.getPage());
        }

        System.out.println("################################################");

        TreeSet<Book> bookSetPageNum = new TreeSet<>(new Comparator<Book>() {

            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPage() - b2.getPage();
            }
        }.reversed());

        bookSetPageNum.addAll(bookSetName);

        for( Book b : bookSetPageNum){
            System.out.println("Page : " + b.getPage() + " Book Name : " + b.getName());
        }
        
    }
}
