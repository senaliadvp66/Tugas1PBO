import model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<User> users = new ArrayList<>();
        users.add(new Admin("admin", "admin123"));
        users.add(new Customer("customer1", "cust123"));


        System.out.println("===== Program Investasi =====");
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();

        System.out.print("Password: ");
        String inputPass = scanner.nextLine();

        User loggedInUser = null;


        for (User user : users) {
            if (user.login(inputUser, inputPass)) {
                loggedInUser = user;
                break;
            }
        }


        if (loggedInUser != null) {
            System.out.println("Login berhasil sebagai: " + loggedInUser.getRole());
            // Tampilkan menu berdasarkan peran
            showMenu(loggedInUser);
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }


    public static void showMenu(User user) {
        Scanner scanner = new Scanner(System.in);

        if (user.getRole().equals("admin")) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            // Tambahkan fungsionalitas admin di sini
        } else if (user.getRole().equals("customer")) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Lihat Portofolio");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

        }
    }
}
