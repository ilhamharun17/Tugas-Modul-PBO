package org.main;

import java.util.ArrayList;
import java.util.Scanner;

import static org.main.Student.arr_userStudent;
import static org.main.Student.logout;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    static ArrayList<bookList> arr_bookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    static String NIM;

    static class bookList {
        String idbuku, judulbuku, penulisbuku, kategoriBuku;
        int stokbuku;

        public bookList(String idbuku, String judulbuku, String penulisbuku, String kategoriBuku, int stokbuku) {
            this.idbuku = idbuku;
            this.judulbuku = judulbuku;
            this.penulisbuku = penulisbuku;
            this.kategoriBuku = kategoriBuku;
            this.stokbuku = stokbuku;
        }
    }

    public static int readInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid choice.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void menu() {
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
                    if(Admin.isAdmin()){
                        menuAdmin();
                    }else{
                        Admin.isAdmin();
                    }
                    break;
                case 2:
                    checkNim();
                    menuStudent();
                    break;
                case 3:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);
    }

    public static void inputNim() {
        System.out.print("Enter NIM: ");
        NIM = scanner.nextLine();
    }

    public static void checkNim() {
        boolean valid = false;
        int loop = 0;
        do{
            inputNim();
            if(NIM.length() != 15) {
                System.out.println("NIM harus 15 digit");
                continue;
            }
            for(Student.userStudent i : arr_userStudent){
                if(i.nim.equals(Main.NIM)){
                    valid = true;
                    break;
                }
            }
            if(valid){
                System.out.println("==== Login Success ====");
                loop = 1;
            }else{
                System.out.println("==== NIM not found ===");
                Main.menu();
            }
        } while(loop == 0);
    }


    public static void menuStudent() {
        Student student = new Student();
        Student.displayInfo();
        int choice;
        do {
            System.out.println("==== Student Menu ====");
            System.out.println("1. Borrowed Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            choice = readInput();

            switch (choice) {
                case 1:
                    Student.showBorrowedBooks();
                    break;
                case 2:
                    student.displayBooks();
                    Student.borrowBooks();
                    break;
                case 3:
                    Student.showBorrowedBooks();
                    Student.returnBooks();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    logout();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }

    public static void menuAdmin() {
        Admin admin = new Admin();
        int choice;
        do {
            System.out.println("==== Admin Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Add Book");
            System.out.println("4. Logout");
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
                    admin.inputBook();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    logout();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    public void addTempStudent() {
        //a
    }

    public void addTempBooks() {
        //a
    }
}
