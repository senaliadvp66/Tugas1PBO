package controller;

import model.*;
import java.util.*;

public class AdminCustomerController {

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
            scanner.nextLine(); // untuk membersihkan buffer
            switch (choice) {
                case 1:
                    // Menambah saham baru
                    System.out.print("Masukkan kode saham: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan nama perusahaan: ");
                    String namaPerusahaan = scanner.nextLine();
                    System.out.print("Masukkan harga saham: ");
                    double harga = scanner.nextDouble();
                    Saham newSaham = new Saham(kode, namaPerusahaan, harga);
                    sahamList.add(newSaham);
                    System.out.println("Saham berhasil ditambahkan!");
                    break;
                case 2:
                    // Mengubah harga saham
                    System.out.println("Daftar Saham Tersedia:");
                    for (int i = 0; i < sahamList.size(); i++) {
                        System.out.println((i + 1) + ". " + sahamList.get(i));
                    }
                    System.out.print("Pilih saham yang harga nya ingin diubah: ");
                    int sahamChoice = scanner.nextInt();
                    System.out.print("Masukkan harga baru: ");
                    double newPrice = scanner.nextDouble();
                    // Mengubah harga saham yang dipilih
                    sahamList.get(sahamChoice - 1).setHarga(newPrice);
                    System.out.println("Harga saham berhasil diubah!");
                    break;
                case 3:
                    System.out.println("Keluar dari menu admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
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
                    int sahamChoiceBuy = scanner.nextInt();
                    portofolio.beliSaham(sahamList.get(sahamChoiceBuy - 1));
                    break;
                case 2:
                    System.out.println("Daftar Saham yang Dimiliki:");
                    // Menampilkan saham yang dimiliki customer
                    for (int i = 0; i < portofolio.getSahamList().size(); i++) {
                        System.out.println((i + 1) + ". " + portofolio.getSahamList().get(i));
                    }
                    System.out.print("Pilih saham yang ingin dijual: ");
                    int sahamChoiceSell = scanner.nextInt();
                    // Menjual saham
                    portofolio.getSahamList().remove(sahamChoiceSell - 1);
                    System.out.println("Saham berhasil dijual.");
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
                    // Menampilkan portofolio customer (saham dan SBN yang dimiliki)
                    System.out.println("\n=== Daftar Saham yang Dimiliki ===");
                    portofolio.tampilkanSaham();
                    System.out.println("\n=== Daftar SBN yang Dimiliki ===");
                    portofolio.tampilkanSBN();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
