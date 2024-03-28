import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner pilih = new Scanner(System.in);
        boolean menu = false;
        String userAdmin = "ctreix";
        String passAdmin = "admin123";

        while (!menu) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Student");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih angka (1-3): ");
            int kasus = pilih.nextInt();

            switch (kasus) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String panjangNIM = pilih.next();
                    if (panjangNIM.length() == 15) {
                        System.out.println("Login Sukses sebagai Student");
                    } else {
                        System.out.println("User Tidak Ditemukan");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan username (admin): ");
                    String username = pilih.next();
                    System.out.print("Masukkan password (admin): ");
                    String password = pilih.next();
                    if (username.equals(userAdmin) && password.equals(passAdmin)) {
                        System.out.println("Login Sukses sebagai Admin");
                    } else {
                        System.out.println("Admin User Tidak Ditemukan");
                    }
                    break;
                case 3:
                    menu = true;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia");
            }
        }

    }
}