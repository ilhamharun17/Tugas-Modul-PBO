package org.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    static  String idBorrow;
    static int inputDuration;
    public static Object[] borrowedBooks;
    static ArrayList<borrowedBook> arr_borrowedBook = new ArrayList<>();
    static ArrayList<userStudent> arr_userStudent = new ArrayList<>();
    public static Scanner scanner;

    static class userStudent{
        String name;
        String nim;
        String faculty;
        String programStudi;

        public userStudent(String name, String nim, String faculty, String programStudi) {
            this.name = name;
            this.nim = nim;
            this.faculty = faculty;
            this.programStudi = programStudi;
        }
    }

    public static void displayInfo() {
        for (userStudent i : arr_userStudent) {
            if (Main.NIM.equals(i.nim)) {
                System.out.println("> Nama: " + i.name);
                System.out.println("> NIM : " + i.nim);
                break;
            }
        }
    }

    static class borrowedBook {
        String id;
        int duration;

        public borrowedBook(String id, int duration) {
            this.id = id;
            this.duration = duration;
        }
    }

    public static void showBorrowedBooks(){

        System.out.println("=======================================  Books Borrowed  ==================================================");
        System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Durasi");
        System.out.println("\n=============================================================================================================");

        for (borrowedBook a : arr_borrowedBook) {
            for (Main.bookList i : Main.arr_bookList) {
                if (i.idbuku.equals(a.id)) {
                    System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-5s  ||\n", i.idbuku, i.judulbuku, i.penulisbuku, i.kategoriBuku, a.duration);
                }
            }
        }
    }

    @Override
    public void displayBooks(){
        super.displayBooks();
    }

    public static void logout(){
        Main.menu();
    }

    public static void returnBooks(){
        boolean bookReturned = false;
        System.out.println("\nPlease Input the book ID ");
        System.out.print("> ID : ");
        idBorrow = scanner.nextLine();
        for (int i = 0; i < arr_borrowedBook.size(); i++ ) {
            if (arr_borrowedBook.get(i).id.equals(idBorrow)) {
                for (Main.bookList a : Main.arr_bookList) {
                    if (a.idbuku.equals(idBorrow)) {
                        a.stokbuku++;
                        arr_borrowedBook.remove(i);
                        bookReturned = true;
                    }
                }
            }
        }
        if(bookReturned){
            System.out.print("Book Returned");
        }else{
            System.out.print("Book not found.");
        }
    }

    public static void borrowBooks(){
        Scanner scanner = new Scanner(System.in);
        int loop;
        Book book = new Book(null,null,null,0);
        System.out.println(">> Input ID of the book");
        System.out.print(">  ID: ");
        idBorrow = scanner.nextLine();
        for (Main.bookList i : Main.arr_bookList) {
            if (i.idbuku.equals(idBorrow)) {
                if (i.stokbuku > 0) {
                    i.stokbuku--;
                    do{
                        System.out.println(">> Input borrow duration (14 Days max)");
                        System.out.print(">  How long? : ");
                        inputDuration = scanner.nextInt();
                        scanner.nextLine();

                        if(inputDuration > 14){
                            System.out.print("14 Days max!");
                            loop = 0;
                        }else{
                            loop = 1;
                        }
                    }while(loop == 0);
                    book.setDuration(inputDuration);
                    arr_borrowedBook.add(new borrowedBook(idBorrow, book.getDuration()));
                    System.out.println("Book successfully borrowed");
                    break;
                }else if (i.stokbuku == 0){
                    System.out.println("Out of stock");
                    break;
                }
            }
        }
    }


}

