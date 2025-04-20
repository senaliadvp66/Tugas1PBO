package controller;

import model.*;
import java.util.*;

public class CustomerController {
    public static void menu(Customer customer, List<Saham> daftarSaham, List<SuratBerhargaNegara> daftarSBN) {
        Scanner input = new Scanner(System.in);
        Portofolio portofolio = customer.getPortofolio();

        while (true) {
            System.out.println("\n=== MENU CUSTOMER ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Lihat Portofolio");
            System.out.println("6. Logout");
            int pilih = inputInt(input, "Pilih: ");

            switch (pilih) {
                case 1: {
                    if (daftarSaham.isEmpty()) {
                        System.out.println("Belum ada saham.");
                        break;
                    }
                    for (int i = 0; i < daftarSaham.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        daftarSaham.get(i).tampilkanInfo();
                    }
                    int idx = inputInt(input, "Pilih nomor saham: ") - 1;
                    if (idx >= 0 && idx < daftarSaham.size()) {
                        int jumlah = inputInt(input, "Jumlah lembar: ");
                        portofolio.beliSaham(daftarSaham.get(idx), jumlah);
                        System.out.println("✅ Saham berhasil dibeli.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
                case 2: {
                    if (portofolio.getSaham().isEmpty()) {
                        System.out.println("Belum punya saham.");
                        break;
                    }
                    ArrayList<Saham> list = new ArrayList<>(portofolio.getSaham().keySet());
                    for (int i = 0; i < list.size(); i++) {
                        Saham s = list.get(i);
                        System.out.printf("%d. %s (%d lembar)\n", i + 1, s.getNamaPerusahaan(), portofolio.getSaham().get(s));
                    }
                    int idx = inputInt(input, "Pilih nomor saham yang ingin dijual: ") - 1;
                    int jumlah = inputInt(input, "Jumlah lembar: ");
                    if (!portofolio.jualSaham(list.get(idx), jumlah)) {
                        System.out.println("⚠️ Gagal jual saham. Jumlah tidak mencukupi.");
                    } else {
                        System.out.println("✅ Saham berhasil dijual.");
                    }
                }
                case 3: {
                    if (daftarSBN.isEmpty()) {
                        System.out.println("Belum ada SBN.");
                        break;
                    }
                    for (int i = 0; i < daftarSBN.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        daftarSBN.get(i).tampilkanInfo();
                    }
                    int idx = inputInt(input, "Pilih SBN: ") - 1;
                    double nominal = inputDouble(input, "Nominal pembelian: ");
                    SuratBerhargaNegara sbn = daftarSBN.get(idx);
                    sbn.kurangiKuota(nominal);
                    portofolio.beliSBN(sbn, nominal);
                    System.out.println("✅ SBN berhasil dibeli.");
                }
                case 4 :{
                    double bunga = inputDouble(input, "Bunga (%): ");
                    double nominal = inputDouble(input, "Nominal investasi: ");
                    double hasil = (bunga / 100) / 12 * 0.9 * nominal;
                    System.out.printf("💰 Simulasi bunga per bulan: Rp%.2f\n", hasil);
                }
                case 5 : portofolio.tampilkanPortofolio();
                case 6 : {
                    System.out.println("Logout...");
                    return;
                }
                default : System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static int inputInt(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Masukkan angka yang valid.");
            }
        }
    }

    private static double inputDouble(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Masukkan angka desimal yang valid.");
            }
        }
    }
}
