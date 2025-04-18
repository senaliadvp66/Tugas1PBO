import model.*;

import java.util.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat beberapa data contoh
        List<User> users = new ArrayList<>();
        users.add(new Admin("admin", "admin123"));
        users.add(new Customer("customer1", "cust123"));

        // Membuat beberapa saham dan SBN contoh
        List<Saham> sahamList = new ArrayList<>();
        sahamList.add(new Saham("AAPL", "Apple", 150000));
        sahamList.add(new Saham("GOOG", "Google", 200000));

        List<SuratBerhargaNegara> sbnList = new ArrayList<>();
        sbnList.add(new SuratBerhargaNegara("SBN 10 Tahun", 5, 10, LocalDate.of(2035, 4, 17), 10000));

        // Input login
        System.out.println("===== Program Investasi =====");
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();

        System.out.print("Password: ");
        String inputPass = scanner.nextLine();

        User loggedInUser = null;

        // Cek login pengguna
        for (User user : users) {
            if (user.login(inputUser, inputPass)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println("Login berhasil sebagai: " + loggedInUser.getRole());
            showMenu(loggedInUser, sahamList, sbnList);
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    // Menu berdasarkan role pengguna
    public static void showMenu(User user, List<Saham> sahamList, List<SuratBerhargaNegara> sbnList) {
        Scanner scanner = new Scanner(System.in);
        Portofolio portofolio = new Portofolio();

        if (user.getRole().equals("admin")) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            // Admin bisa menambah atau mengubah harga saham
        } else if (user.getRole().equals("customer")) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Lihat Portofolio");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Daftar Saham Tersedia:");
                    for (int i = 0; i < sahamList.size(); i++) {
                        System.out.println((i + 1) + ". " + sahamList.get(i));
                    }
                    System.out.print("Pilih saham yang ingin dibeli: ");
                    int sahamChoice = scanner.nextInt();
                    portofolio.beliSaham(sahamList.get(sahamChoice - 1));
                    break;
                case 3:
                    System.out.println("Daftar SBN Tersedia:");
                    for (int i = 0; i < sbnList.size(); i++) {
                        System.out.println((i + 1) + ". " + sbnList.get(i));
                    }
                    System.out.print("Pilih SBN yang ingin dibeli: ");
                    int sbnChoice = scanner.nextInt();
                    portofolio.beliSBN(sbnList.get(sbnChoice - 1));
                    break;
                case 4:
                    portofolio.tampilkanSaham();
                    portofolio.tampilkanSBN();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
