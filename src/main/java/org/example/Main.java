package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствую Вас!");
        Scanner console = new Scanner(System.in);
        Library library = new Library();
        boolean exit = false;

        while (!exit) {
            System.out.println("Опция 1: Добавить новую публикацию.");
            System.out.println("Опция 2: Вывести список всех публикаций.");
            System.out.println("Опция 3: Поиск публикации по автору.");
            System.out.println("Опция 4: Вывести общее количество публикаций.");
            System.out.println("Опция 5: Удаление публикации");
            System.out.println("Опция 0: Выход.");
            if (!console.hasNextInt()) {
                console.next();
                System.out.println("Введите значение от 0 до 5");
                continue;
            }
            int choice = console.nextInt();
            console.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Введите тип публикации который хотите создать");
                    System.out.println("Книга, Журнал, Газета");
                    String type = console.nextLine();
                    if (!type.equalsIgnoreCase("книга") && !type.equalsIgnoreCase("журнал") && !type.equalsIgnoreCase("газета")) {
                        System.out.println("Вы ввели неверный тип публикации");
                        System.out.println("Нажмите 'ENTER' для выхода в меню");
                        console.nextLine();
                        break;
                    } else {
                        switch (type.toLowerCase()) {
                            case "книга": {
                                System.out.println("Введите название книги");
                                String title = console.nextLine();

                                System.out.println("Введите автора книги");
                                String author = console.nextLine();
                                System.out.println("Введите год выпуска");
                                int year = 0; // здесь еще важно чтобы число не было отравительным прочистить
                                boolean valid = false;
                                while (!valid) {
                                    try {
                                        year = console.nextInt();
                                        if (year < 0) {
                                            System.out.println("Год не может быть отрицательным");
                                        } else {
                                            valid = true;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ошибка! Введите целое число.");
                                        console.nextLine();
                                    }
                                }
                                console.nextLine();
                                System.out.println("Введите ISBN");
                                String ISBN = console.nextLine();
                                Book book1 = new Book(title, author, year, ISBN);
                                library.addPublication((book1));
                                book1.printDetails();
                            }
                            System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                            console.nextLine();
                            break;

                            case "журнал": {
                                System.out.println("Введите название журнала");
                                String title = console.nextLine();
                                System.out.println("Введите автора (издание) журнала");
                                String author = console.nextLine();
                                System.out.println("Введите год выпуска журнала");
                                int year = 0;
                                boolean valid3 = false;
                                while (!valid3) {
                                    try {
                                        year = console.nextInt();
                                        if (year < 0) {
                                            System.out.println("Год не может быть отрицательным");
                                        } else {
                                            valid3 = true;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ошибка! Введите целое число.");
                                        console.nextLine();
                                    }
                                }
                                console.nextLine();
                                System.out.println("Введите номер журнала");
                                int issueNumber = 0;
                                boolean valid2 = false;
                                while (!valid2) {
                                    try {
                                        issueNumber = console.nextInt();
                                        if (issueNumber < 0) {
                                            System.out.println("Номер не может быть отрицательным");
                                        } else {
                                            valid2 = true;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ошибка! Введите целое число.");
                                        console.nextLine();
                                    }
                                }
                                console.nextLine();
                                Magazine mgzn1 = new Magazine(title, author, year, issueNumber);
                                library.addPublication((mgzn1));
                                mgzn1.printDetails();
                            }
                            System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                            console.nextLine();
                            break;

                            case "газета": {
                                System.out.println("Введите название газеты");
                                String title = console.nextLine();
                                System.out.println("Введите автора газеты");
                                String author = console.nextLine();
                                System.out.println("Введите год выпуска");
                                int year = 0;
                                boolean valid5 = false;
                                while (!valid5) {
                                    try {
                                        year = console.nextInt();
                                        if (year < 0) {
                                            System.out.println("Год не может быть отрицательным");
                                        } else {
                                            valid5 = true;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Ошибка! Введите целое число.");
                                        console.nextLine();
                                    }
                                }
                                console.nextLine();
                                System.out.println("Введите месяц и число  публикации газеты");
                                String publicationDay = console.nextLine();
                                Newspaper nwsp1 = new Newspaper(title, author, year, publicationDay);
                                nwsp1.printDetails();
                                library.addPublication((nwsp1));
                            }
                            System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                            console.nextLine();
                            break;
                        }
                        break;
                    }
                case 2:

                    int publicationCount = Publication.getPublicationCount();

                    if (publicationCount == 0) {
                        System.out.println("Список публикаций отсутствует");
                    } else {
                        library.listPublications();
                    }
                    System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                    console.nextLine();
                    break;

                case 4:

                    publicationCount = Publication.getPublicationCount();
                    if (publicationCount == 0) {
                        System.out.println("Список публикаций отсутствует");
                    } else {
                        library.showStatistics();
                    }
                    System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                    console.nextLine();
                    break;

                case 0:
                    exit = true;
                    System.out.println("Выход из приложения");
                    break;

                case 3:
                    publicationCount = Publication.getPublicationCount();
                    if (publicationCount == 0) {
                        System.out.println("Список публикаций отсутствует");
                    } else {
                        System.out.println("Введите автора публикации для поиска");
                        String author = console.nextLine();
                        library.searchByAuthor(author);
                    }

                    System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                    console.nextLine();
                    break;
                case 5:
                    publicationCount = Publication.getPublicationCount();
                    if (publicationCount == 0) {
                        System.out.println("Список публикаций отсутствует");

                        System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                        console.nextLine();
                        break;
                    } else {
                        System.out.println("Введите наименование публикации для удаления");
                        String title = console.nextLine();
                        library.searchByTitle(title);

                        System.out.println("Введите тип публикации для удаления: книга, журнал, газета");
                        String type_del = console.nextLine();
                        if (!type_del.equalsIgnoreCase("книга") && !type_del.equalsIgnoreCase("журнал") && !type_del.equalsIgnoreCase("газета")) {
                            System.out.println("Вы ввели неверный тип публикации");
                            break;
                        } else {
                            library.delPublication(title, type_del);

                        }
                        System.out.println("Нажмите 'любую_клавишу' для выхода в меню");
                        console.nextLine();
                        break;
                    }
            }
        }
    }
}

