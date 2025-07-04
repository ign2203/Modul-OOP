package org.example;

public abstract class Publication {    // Абстрактный класс
    private String title;
    private String author;
    private int year;

/*
Мысли вслух, для чего мы пишем сеттеры, если не собираемся вносить корректировки в будущих объектах
сеттеры же нужны для внесения изменений
 */
    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private static int publicationCount = 0;

    public static int getPublicationCount() {
        return publicationCount;
    }

    protected static void decreaseCount() { // Инкапсуляция
        if (publicationCount > 0) {
            publicationCount--;
        }
    }

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        publicationCount++;
    }

    public abstract String getType();


    @Override
    public String toString() {
        return "Тип публикации: " + getType() + " Название: " + title + " Автор: " + author + " Год: " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Publication pub = (Publication) obj;
        return (title != null ? title.equals(pub.title) : pub.title == null) &&
                (author != null ? author.equals(pub.author) : pub.author == null) &&
                (this.year == pub.year);

    }

    @Override
    public int hashCode() {
        int result = (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        // equals
        return result;
    }
}
