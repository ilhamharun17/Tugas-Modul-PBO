package org.main;

import java.util.Random;
import java.util.Scanner;

public class Admin extends User {
    static String adminUsername = "ctreix";
    static String adminPassword = "pass";
    static String[] studentList;
    static Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.println("==== Add Student ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter NIM: ");
        String nim;
        do {
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM should have 15 characters.");
                System.out.print("Enter NIM: ");
            }
        } while (nim.length() != 15);

        System.out.print("Enter Faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter Program Studi: ");
        String studyProgram = scanner.nextLine();

        Student.arr_userStudent.add(new Student.userStudent(name, nim, faculty, studyProgram));

        System.out.println("Student successfully added.");
    }

    @Override
    public void inputBook() {
        super.inputBook();
    }
    @Override
    public void displayBooks() {
        super.displayBooks();
    }

    public void displayStudents() {
        System.out.println("==== Registered Students ====");
        for (Student.userStudent i : Student.arr_userStudent) {
            System.out.println("Nama : " + i.name);
            System.out.println("NIM : " + i.nim);
            System.out.println("Fakultas : " + i.faculty);
            System.out.println("Prodi : " + i.programStudi);
            System.out.println();
        }
        System.out.println("==============================");
    }

    public static boolean isAdmin() {
        System.out.println("==== Login Admin ====");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Logged In");
                return true;
            } else {
                System.out.println("User not found");
                return false;
            }
    }

    public String generateId() {
        Random random = new Random();

        StringBuilder idStart = new StringBuilder();
        StringBuilder idEnd = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idStart.append(random.nextInt(4));
            idEnd.append(random.nextInt(4));

        }
        return ("UMM-" + idStart + "-" + idEnd);
    }


}
