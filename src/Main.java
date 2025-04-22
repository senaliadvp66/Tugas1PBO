import model.*;
import controller.*;
import java.util.*;

import static model.Validasi.inputInt;
import static model.Validasi.inputString;

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
        Admin lia = new Admin("Adminlia", "adminlia123");
        Admin tasya = new Admin("Admintasya", "admintasya123");
        Customer budi = new Customer("budiman", "budibudi");
        Customer sari = new Customer("sarini", "sarih");

        // Tambah contoh saham & sbn
        Saham bbca = new Saham("BBCA", "Bank BCA", 10000000);
        Saham tlkm = new Saham("TLKM", "Telkom Indonesia", 40000000);
        Saham ri0t = new Saham ("RI0T", "Riot Games", 15000000 );
        daftarSaham.add(bbca);
        daftarSaham.add(tlkm);
        daftarSaham.add(ri0t);

        SuratBerhargaNegara sbn25 = new SuratBerhargaNegara("SBN 2025", 6.15, 24, "2027-05-01", 1_000_000_000);
        SuratBerhargaNegara sbn30 = new SuratBerhargaNegara("SBN 2030", 6.20, 25, "2030-12-31", 1_000_000_000);
        daftarSBN.add(sbn25);
        daftarSBN.add(sbn30);

        // Isi portofolio awal Lia
        budi.getPortofolio().beliSaham(bbca, 100); // 100 lembar BBCA
        budi.getPortofolio().beliSBN(sbn25, 500_000); // beli SBN Rp500.000

        // Isi portofolio awal Tasya
        sari.getPortofolio().beliSaham(tlkm, 50);  // 50 lembar TLKM
        sari.getPortofolio().beliSBN(sbn30, 1_000_000); // beli SBN Rp1.000.000

        // Masukkan user ke daftar login
        users.add(lia);
        users.add(tasya);
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
}


