package view;

import model.*;

import java.util.List;
import java.util.Scanner;
import static model.Validasi.*;
import java.util.ArrayList;

public class MenuCustomer {

    // Method untuk Menu Saham
    public static void menuSaham(Customer customer, Scanner input, List<Saham> daftarSaham) {
        while (true) {
            System.out.println("\n=== MENU SAHAM ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Kembali");

            int pilihan = inputInt(input, "Pilih: ");

            switch (pilihan) {
                case 1:
                    beliSaham(customer, input, daftarSaham);  // Beli Saham
                    break;
                case 2:
                    jualSaham(customer, input, daftarSaham);  // Jual Saham
                    break;
                case 3:
                    return;  // Kembali ke menu utama customer
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Method untuk Beli Saham
    private static void beliSaham(Customer customer, Scanner input, List<Saham> daftarSaham) {
        if (daftarSaham.isEmpty()) {
            System.out.println("Belum ada saham.");
            return;
        }

        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarSaham.get(i).tampilkanInfo();
        }

        int idx = inputInt(input, "Pilih nomor saham: ") - 1;
        if (idx >= 0 && idx < daftarSaham.size()) {
            int jumlah = inputInt(input, "Jumlah lembar: ");
            customer.getPortofolio().beliSaham(daftarSaham.get(idx), jumlah);
            System.out.println("✅ Saham berhasil dibeli.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    // Method untuk Jual Saham
    private static void jualSaham(Customer customer, Scanner input, List<Saham> daftarSaham) {
        if (customer.getPortofolio().getSaham().isEmpty()) {
            System.out.println("Belum punya saham.");
            return;
        }

        ArrayList<Saham> list = new ArrayList<>(customer.getPortofolio().getSaham().keySet());
        for (int i = 0; i < list.size(); i++) {
            Saham s = list.get(i);
            System.out.printf("%d. %s (%d lembar)\n", i + 1, s.getNamaPerusahaan(), customer.getPortofolio().getSaham().get(s));
        }

        int idx = inputInt(input, "Pilih nomor saham yang ingin dijual: ") - 1;
        int jumlah = inputInt(input, "Jumlah lembar: ");
        if (!customer.getPortofolio().jualSaham(list.get(idx), jumlah)) {
            System.out.println("⚠️ Gagal jual saham. Jumlah tidak mencukupi.");
        } else {
            System.out.println("✅ Saham berhasil dijual.");
        }
    }

    // Method untuk Menu SBN
    public static void menuSBN(Customer customer, Scanner input, List<SuratBerhargaNegara> daftarSBN) {
        while (true) {
            System.out.println("\n=== MENU SBN ===");
            System.out.println("1. Beli SBN");
            System.out.println("2. Simulasi SBN");
            System.out.println("3. Kembali");

            int pilihan = inputInt(input, "Pilih: ");

            switch (pilihan) {
                case 1:
                    beliSBN(customer, input, daftarSBN);  // Beli SBN
                    break;
                case 2:
                    simulasiSBN(input);  // Simulasi SBN
                    break;
                case 3:
                    return;  // Kembali ke menu utama customer
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Method untuk Beli SBN
    private static void beliSBN(Customer customer, Scanner input, List<SuratBerhargaNegara> daftarSBN) {
        if (daftarSBN.isEmpty()) {
            System.out.println("Belum ada SBN.");
            return;
        }

        for (int i = 0; i < daftarSBN.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarSBN.get(i).tampilkanInfo();
        }

        int idx;
        while (true) {
            idx = inputInt(input, "Pilih SBN: ") - 1;  // Mengurangi 1 untuk mendapatkan indeks yang benar
            if (idx < 0 || idx >= daftarSBN.size()) {
                System.out.println("⚠️ Pilihan tidak valid. Silakan pilih SBN yang valid.");
            } else {
                break;
            }
        }
        double nominal = inputDouble(input, "Nominal pembelian: ");
        SuratBerhargaNegara sbn = daftarSBN.get(idx);
        sbn.kurangiKuota(nominal);
        customer.getPortofolio().beliSBN(sbn, nominal);
        System.out.println("✅ SBN berhasil dibeli.");
    }

    // Method untuk Simulasi SBN
    private static void simulasiSBN(Scanner input) {
        double bunga = inputDouble(input, "Bunga (%): ");
        double nominal = inputDouble(input, "Nominal investasi: ");
        double hasil = (bunga / 100) / 12 * 0.9 * nominal;
        System.out.printf("💰 Simulasi bunga per bulan: Rp%.2f\n", hasil);
    }
}
