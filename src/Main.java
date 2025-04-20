import model.*;
import controller.*;
import java.util.*;

public class Main {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Saham> daftarSaham = new ArrayList<>();
    static ArrayList<SuratBerhargaNegara> daftarSBN = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initUsers();

        while (true) {
            System.out.println("\n=== MENU AWAL ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Customer");
            System.out.println("3. Keluar");
            int pilih = inputInt(input, "Pilih: ");

            if (pilih == 1 || pilih == 2) {
                String roleYangDipilih = (pilih == 1) ? "admin" : "customer";
                String username = inputString(input, "Username: ");
                String password = inputString(input, "Password: ");

                User userLogin = login(username, password, roleYangDipilih);
                if (userLogin != null) {
                    if (userLogin.getRole().equals("admin")) {
                        AdminController.menu((Admin) userLogin, input, daftarSaham, daftarSBN);
                    } else {
                        CustomerController.menu((Customer) userLogin, daftarSaham, daftarSBN);
                    }
                } else {
                    System.out.println("Login gagal. Username/password salah atau bukan " + roleYangDipilih);
                }
            } else if (pilih == 3) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void initUsers() {
        Admin admin = new Admin("admin", "admin123");
        Customer budi = new Customer("budi", "123");
        Customer sari = new Customer("sari", "456");

        // Tambah contoh saham & sbn
        Saham bbca = new Saham("BBCA", "Bank BCA", 10000);
        Saham tlkm = new Saham("TLKM", "Telkom Indonesia", 4000);
        daftarSaham.add(bbca);
        daftarSaham.add(tlkm);

        SuratBerhargaNegara sbr012 = new SuratBerhargaNegara("SBR012", 6.15, 24, "2027-05-01", 1_000_000_000);
        daftarSBN.add(sbr012);

        // Isi portofolio awal Budi
        budi.getPortofolio().beliSaham(bbca, 100); // 100 lembar BBCA
        budi.getPortofolio().beliSBN(sbr012, 500_000); // beli SBN Rp500.000

        // Isi portofolio awal Sari
        sari.getPortofolio().beliSaham(tlkm, 50);  // 50 lembar TLKM
        sari.getPortofolio().beliSBN(sbr012, 1_000_000); // beli SBN Rp1.000.000

        // Masukkan user ke daftar login
        users.add(admin);
        users.add(budi);
        users.add(sari);
    }


    static User login(String username, String password, String role) {
        for (User user : users) {
            if (user.login(username, password) && user.getRole().equals(role)) {
                return user;
            }
        }
        return null;
    }

    static int inputInt(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Masukkan angka yang valid.");
            }
        }
    }

    static double inputDouble(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Masukkan angka desimal yang valid.");
            }
        }
    }

    static String inputString(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("⚠️ Input tidak boleh kosong.");
        }
    }
}
