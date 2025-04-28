package controller;

import model.*;
import view.*;
import java.util.Scanner;
import java.util.List;

import static model.Validasi.inputInt;


public class AdminController {

    public static void menu(Admin admin, Scanner input, List<Saham> daftarSaham, List<SuratBerhargaNegara> daftarSBN) {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Lihat Produk Investasi");
            System.out.println("4. Logout");

            int pilih = inputInt(input, "Masukan Pilihan: ");

            switch (pilih) {
                case 1:
                    MenuAdmin.menuSaham(input, daftarSaham);  // Panggil method dari MenuAdmin untuk Saham
                    break;
                case 2:
                    MenuAdmin.menuSBN(input, daftarSBN);  // Panggil method dari MenuAdmin untuk SBN
                    break;
                case 3:
                    MenuAdmin.lihatProdukInvestasi(daftarSaham, daftarSBN);
                case 4:
                    System.out.println("Logout berhasil.");
                    return;  // Logout dan keluar
                default:
                    System.out.println("Pilihan yang Anda masukkan tidak valid.");
            }
        }
    }
}
