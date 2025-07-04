package org.example;

public class Newspaper extends Publication implements Printable {
    private String publicationDay;

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    private static int newspaperCount = 0;

    public static int getNewspaperCount() {
        return newspaperCount;
    }

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
        newspaperCount++;
    }

    public static void decreaseNewspaperCount() {
        if (newspaperCount > 0) {
            newspaperCount--;
        }
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public String getType() {
        return "Газета";
    }

    @Override
    public void printDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + " День публикации: " + publicationDay;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Newspaper)) return false;
        if (!super.equals(obj)) return false;

        Newspaper newspaper = (Newspaper) obj;
        return publicationDay != null ? publicationDay.equals(newspaper.publicationDay) : newspaper.publicationDay == null;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + (publicationDay != null ? publicationDay.hashCode() : 0);
    }
}
