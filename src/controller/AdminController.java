package controller;

import model.*;
import java.util.*;

import static model.Validasi.*;

public class AdminController {
    public static void menu(Admin admin, Scanner input, List<Saham> daftarSaham, List<SuratBerhargaNegara> daftarSBN) {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Tambah SBN");
            System.out.println("4. Lihat Produk Investasi");
            System.out.println("5. Logout");
            int pilih = inputInt(input, "Masukan Pilihan: ");

            switch (pilih) {
                case 1 :{
                    String kode = inputString(input, "Kode Saham: ");
                    String nama = inputString(input, "Nama Perusahaan: ");
                    double harga = inputDouble(input, "Harga Saham: ");
                    daftarSaham.add(new Saham(kode, nama, harga));
                    System.out.println("✅ Saham berhasil ditambahkan!");
                } break;
                case 2 :{
                    if (daftarSaham.isEmpty()) {
                        System.out.println("Belum ada saham.");
                        break;
                    }
                    for (int i = 0; i < daftarSaham.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        daftarSaham.get(i).tampilkanInfo();
                    }
                    int idx = inputInt(input, "Pilih nomor saham yang ingin diubah: ") - 1;
                    if (idx >= 0 && idx < daftarSaham.size()) {
                        double hargaBaru = inputDouble(input, "Masukkan harga baru: ");
                        daftarSaham.get(idx).setHarga(hargaBaru);
                        System.out.println("Harga saham berhasil diperbarui!");
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                } break;
                case 3:{
                    String namaSbn = inputString(input, "Nama SBN: ");
                    double bunga = inputDouble(input, "Bunga (%): ");
                    int waktu = inputInt(input, "Jangka Waktu (bulan): ");
                    String tempo = inputString(input, "Tanggal Jatuh Tempo: ");
                    double kuota = inputDouble(input, "Kuota Nasional: ");
                    daftarSBN.add(new SuratBerhargaNegara(namaSbn, bunga, waktu, tempo, kuota));
                    System.out.println("SBN berhasil ditambahkan!");
                } break;
                case 4: {
                    System.out.println("=== Daftar Saham ===");
                    if (daftarSaham.isEmpty()) System.out.println("Belum ada saham.");
                    else daftarSaham.forEach(Saham::tampilkanInfo);

                    System.out.println("\n=== Daftar SBN ===");
                    if (daftarSBN.isEmpty()) System.out.println("Belum ada SBN.");
                    else daftarSBN.forEach(SuratBerhargaNegara::tampilkanInfo);
                } break;
                case 5:{
                    System.out.println("Logout...");
                    return;
                }
                default: System.out.println("Pilihan yang Anda masukkan tidak valid."); break;
            }
        }
    }
}
