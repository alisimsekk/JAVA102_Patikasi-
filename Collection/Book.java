package Collection;

public class Book implements Comparable<Book> {
    private String name;
    private int page;
    private String author;
    private int 	publishDate;

    public Book(String name, int page, String author, int publishDate) {
        this.name = name;
        this.page = page;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book b2) {
        return (this.getName()).compareTo(b2.getName());
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }
    
    
    
}
