package org.example;

public class Book extends Publication implements Printable {
    private String ISBN;
    private static int bookCount = 0;

    public static int getBookCount() {
        return bookCount;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
        bookCount++;
    }

    public static void decreaseBookCount() {
        if (bookCount > 0) {
            bookCount--;
        }
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public void printDetails() {
        System.out.println(this); // вызывает toString()
    }

    @Override
    public String toString() {
        return super.toString() + " ISBN: " + ISBN;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        if (!super.equals(obj)) return false;

        Book book = (Book) obj;
        return ISBN != null ? ISBN.equals(book.ISBN) : book.ISBN == null;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + (ISBN != null ? ISBN.hashCode() : 0);
    }
}

