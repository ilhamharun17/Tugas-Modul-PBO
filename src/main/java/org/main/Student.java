package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    public String name;
    public String nim;
    public String faculty;
    public String programStudi;
    public static List<Book> borrowedBooks;
    public static Scanner scanner;

    public Student(String name, String nim, String faculty, String programStudi) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudi = programStudi;
        this.borrowedBooks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getFaculty() {
        return faculty;
    }public String getProgramStudi() {
        return programStudi;
    }

    public static void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You haven't borrowed any books.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.getId() + " - " + book.getTitle() + " (" + book.getAuthor() + ")");
                break;
            }
        }
    }

    public static void borrowBook(Book[] books) {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book.getId() + " - " + book.getTitle() + " (" + book.getAuthor() + ") " + "[" + book.getCategory() + "] " + book.getStock() + " copies available");
        }
        System.out.print("Enter the ID of the book you want to borrow: ");
        scanner.nextLine();
        String bookId = scanner.nextLine();
        Book bookToBorrow = null;
        for (Book book : Main.bookList) {
            if (book.getId().equals(bookId)) {
                bookToBorrow = book;
                break;
            }
        }
        for (Book book : Main.bookList) {
            if (book.getId().equals(bookId)) {
                if (book.getStock() > 0) {
                    borrowedBooks.add(book);
                    book.setStock(book.getStock() - 1);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is currently out of stock.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}