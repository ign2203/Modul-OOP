package org.example;

public class Magazine extends Publication implements Printable {
    private int issueNumber;

    private static int magazineCount = 0;

    public static int getMagazineCount() {
        return magazineCount;
    }

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
        magazineCount++;
    }

    public static void decreaseMagazineCount() {
        if (magazineCount > 0) {
            magazineCount--;
        }
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getType() {
        return "Журнал";
    }

    @Override
    public void printDetails() {
        System.out.println(this); // вызывает toString()
    }

    @Override
    public String toString() {
        return super.toString() + " Номер выпуска: " + issueNumber;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Magazine)) return false;
        if (!super.equals(obj)) return false;

        Magazine magazine = (Magazine) obj;
        return this.issueNumber == magazine.issueNumber;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + (getIssueNumber());
    }
}