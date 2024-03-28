package org.main;

import java.util.Scanner;

public class User {
    public void displayBooks() {
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Stok");
        System.out.println("\n=========================================================================================================================");

        for (Main.bookList i : Main.arr_bookList) {
            System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s  ||\n", i.idbuku, i.judulbuku, i.penulisbuku, i.kategoriBuku, i.stokbuku);
        }
        System.out.print("=========================================================================================================================");

    }

    public void inputBook() {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Add Book ====");
        System.out.println("Pilih kategori buku : ");
        System.out.println("1. History Book");
        System.out.println("2. Story Book");
        System.out.println("3. Text Book");
        System.out.print("Pilih (1-3): ");
        String pilihan = scanner.nextLine();

        String idBuku = admin.generateId();

        System.out.print("Masukkan judul Buku: ");
        String judulBuku = scanner.nextLine();

        System.out.print("Masukkan Nama Penulis: ");
        String penulisBuku = scanner.nextLine();

        System.out.print("Masukkan Jumlah Stok Buku: ");
        int stokBuku = scanner.nextInt();

        HistoryBook historyBookObj = new HistoryBook(idBuku, judulBuku, penulisBuku, stokBuku);
        StoryBook storyBookObj     = new StoryBook(idBuku, judulBuku, penulisBuku, stokBuku);
        TextBook textBookObj       = new TextBook(idBuku, judulBuku, penulisBuku, stokBuku);
        Book bookObj               = new Book(idBuku, judulBuku, penulisBuku, stokBuku);
        bookObj.setId(idBuku);
        bookObj.setTitle(judulBuku);
        bookObj.setAuthor(penulisBuku);
        bookObj.setStock(stokBuku);

        switch (pilihan){
            case "1":
                historyBookObj.setCategory("History Book");
                Main.arr_bookList.add(new Main.bookList(bookObj.getId(), bookObj.getTitle(), bookObj.getAuthor(), historyBookObj.getCategory(), bookObj.getStock()));
                break;
            case "2":
                storyBookObj.setCategory("Story Book");
                Main.arr_bookList.add(new Main.bookList(bookObj.getId(), bookObj.getTitle(), bookObj.getAuthor(), storyBookObj.getCategory(), bookObj.getStock()));
                break;
            case "3":
                textBookObj.setCategory("Text Book");
                Main.arr_bookList.add(new Main.bookList(bookObj.getId(), bookObj.getTitle(), bookObj.getAuthor(), textBookObj.getCategory(), bookObj.getStock()));
                break;
        }
        System.out.println("Book successfully added");
    }
}
