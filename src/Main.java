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
            User userLogin = LoginController.loginProcess(input, users);

            if (userLogin != null) {
                if (userLogin.getRole().equals("admin")) {
                    AdminController.menu((Admin) userLogin, input, daftarSaham, daftarSBN);
                } else {
                    CustomerController.menu((Customer) userLogin, daftarSaham, daftarSBN);
                }
            } else {
                break;
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
        Saham ri0t = new Saham("RI0T", "Riot Games", 15000000);
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
}
