package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Book[] bookList;
    public static List<Student> userStudent;
    public static Scanner scanner;
    Admin admin = new Admin();

    public Main() {
        scanner = new Scanner(System.in);
        bookList = new Book[]{
                new Book("388c-e681-9152", "Yessir", "NOONE", "Matematika", 4),
                new Book("d95e-8c4-9523", "Masc", "Luthor", "Sejarah", 1),
                new Book("huy1-78ad-9603", "ADALAH SAYA", "Ilham", "Fiksi", 3)
        };

        userStudent = new ArrayList<>();
        userStudent.add(new Student("Muhammad Ilham Harun", "202310370311354", "Teknik", "Informatika"));
        userStudent.add(new Student("Ndak Tau", "201310370311354", "Teknik", "Informatika"));
        userStudent.add(new Student("I dunno", "200310370311354", "Teknik", "Informatika"));
    }

    public static void main(String[] args) {
        Main library = new Main();
        library.menu();
    }

    public static int readInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid choice.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("Library System");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            choice = readInput();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan username : ");
                    String username = scanner.next();
                    System.out.print("Masukkan password : ");
                    String password = scanner.next();

                    if (username.equals(Admin.adminUsername) && password.equals(Admin.adminPassword)) {
                        System.out.println("Logged in successfully.");
                        menuAdmin();
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    inputNim();
                    break;
                case 3:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);
    }

    public void inputNim() {
        System.out.println("Enter NIM: ");
        scanner.nextLine();
        String nim = scanner.nextLine();
        checkNim(nim, 1);
    }

    public void checkNim(String nim, int i) {
        boolean found = false;
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                found = true;
                menuStudent();
                break;
            }
        }
        if (!found) {
            System.out.println("Student NIM" + nim + " not found.");
        }
    }

    public void menuAdmin() {
        int choice;
        do {
            System.out.println("Admin Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.print("Choose option: ");
            choice = readInput();

            switch (choice) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.displayStudents();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    public static void menuStudent() {
        int choice;
        do {
            System.out.println("Student Menu");
            System.out.println("1. Borrowed Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Logout");
            System.out.print("Choose option: ");
            choice = readInput();

            switch (choice) {
                case 1:
                    for (Student student : userStudent) {
                        student.displayBorrowedBooks();
                    }
                    break;
                case 2:
                    for (Student student : userStudent) {
                        student.borrowBook(bookList);
                    }
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);
    }
}