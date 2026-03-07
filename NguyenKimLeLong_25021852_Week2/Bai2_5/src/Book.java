public class Book {

    private String tille;
    private String author;
    private double price;
    public Book(String tille, String author, double price) {
        this.tille = tille;
        this.author = author;
        this.price = price;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass())
            return false;

        Book other = (Book) obj;
        return this.tille.equals(other.tille) && this.author.equals(other.author) && this.price == other.price;
    }

    public static void main(String[] args) {
        Book book1 = new Book("A", "Long", 10);
        Book book2 = new Book("A", "Long", 10);

        System.out.println("==: " + (book1 == book2));
        System.out.println("equals: " + (book1.equals(book2)));

    }
}
