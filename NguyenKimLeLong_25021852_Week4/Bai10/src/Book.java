public class Book extends MediaItem{
    String author;
    int pages;
    Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }
    
    public void display() {
        System.out.println(name + " - " + author + " - " + pages);
    }
}
