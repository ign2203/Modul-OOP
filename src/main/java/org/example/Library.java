package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private List<Publication> publications = new ArrayList<>();

    public void addPublication(Publication pub) {
        publications.add(pub);
    }

    public void listPublications() {
        for (Publication pub : publications) {
            System.out.println(pub);
        }
    }

    public void searchByAuthor(String author) { // метод поиск публикации по автору
        if (publications.isEmpty()) {
            System.out.println("Список публикаций  отсутствует");
            return;
        }
        boolean found = false;
        for (Publication pub : publications) {
            if (pub.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(pub);
                found = true;
            }
        }
        if (!found) {
            System.out.println(author + " - Автор не найден");
        }
    }

    public void searchByTitle(String title) {  // метод поиск публикации по названию
        if (publications.isEmpty()) {
            System.out.println("Список публикаций  отсутствует");
            return;
        }
        boolean found = false;
        for (Publication pub : publications) {
            if (pub.getTitle().equalsIgnoreCase(title)) {

                System.out.println(pub);
                found = true;
            }
        }
        if (!found) {
            System.out.println(title + " - Публикация с таким наименованием не найдена.");
        }
    }

    public void showStatistics() {
        System.out.println("Количество публикаций Книг: " + Book.getBookCount());
        System.out.println("Количество публикаций Журналов: " + Magazine.getMagazineCount());
        System.out.println("Количество публикаций Газет: " + Newspaper.getNewspaperCount());
        System.out.println("Всего количество публикаций: " + Publication.getPublicationCount());
    }

    public void delPublication(String title, String type_del) {
        if (publications.isEmpty()) {
            System.out.println("Список публикаций отсутствуют");
            return;
        }
        Iterator<Publication> iterator = publications.iterator();
        boolean isDeleted = false;
        while (iterator.hasNext()) {
            Publication pub = iterator.next();
            if (pub.getTitle().equalsIgnoreCase(title) && pub.getType().equalsIgnoreCase(type_del)) {
                System.out.println("Удалена публикация: " + pub);
                iterator.remove();
                switch (type_del.toLowerCase()) {
                    case "книга" -> Book.decreaseBookCount();
                    case "журнал" -> Magazine.decreaseMagazineCount();
                    case "газета" -> Newspaper.decreaseNewspaperCount();
                }
                isDeleted = true;
                break;
            }

        }
        if (!isDeleted) {
            System.out.println("Публикация с таким названием и типом не найдена.");
        }
    }
    
}

