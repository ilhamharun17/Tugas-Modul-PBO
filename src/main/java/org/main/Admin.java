package org.main;

import java.util.Scanner;

public class Admin {
    static String adminUsername = "ctreix";
    static String adminPassword = "pass";
    static Scanner scanner = new Scanner(System.in);

    public void addStudent() {
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

        Main.userStudent.add(new Student(name, nim, faculty, studyProgram));

        System.out.println("Student successfully added.");
    }

    public void displayStudents() {
        System.out.println("Registered Students:");
        for (Student student : Main.userStudent) {
            System.out.println(student.getName() + " (" + student.getNim() + "), " + "fakultas " + student.getFaculty() + ", prodi " + student.getProgramStudi() );
        }
    }
}
