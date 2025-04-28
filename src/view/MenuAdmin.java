package view;

import model.Saham;
import model.SuratBerhargaNegara;
import java.util.Scanner;
import java.util.List;

import static model.Validasi.*;

public class MenuAdmin {

    // Method untuk menampilkan menu Saham
    public static void menuSaham(Scanner input, List<Saham> daftarSaham) {
        while (true) {
            System.out.println("\n=========================================================================");
            System.out.println("||                               MENU SAHAM                            ||");
            System.out.println("=========================================================================");
            System.out.println("|| 1. Tambah Saham                                                     ||");
            System.out.println("|| 2. Ubah Harga Saham                                                 ||");
            System.out.println("|| 3. Kembali                                                          ||");
            System.out.println("=========================================================================");
            int pilihan = inputInt(input, "Pilih: ");

            switch (pilihan) {
                case 1:
                    tambahSaham(input, daftarSaham);  // Tambah saham
                    break;
                case 2:
                    ubahHargaSaham(input, daftarSaham);  // Ubah harga saham
                    break;
                case 3:
                    return;  // Kembali ke menu utama admin
                default:
                    System.out.println("=========================================================================");
                    System.out.println("||                        Pilihan tidak valid.                         ||");
                    System.out.println("=========================================================================");
            }
        }

    }

    // Method untuk menambah saham
    private static void tambahSaham(Scanner input, List<Saham> daftarSaham) {
        String kode = inputString(input, "Kode Saham: ");
        String nama = inputString(input, "Nama Perusahaan: ");
        double harga = inputDouble(input, "Harga Saham: ");
        daftarSaham.add(new Saham(kode, nama, harga));
        System.out.println("=========================================================================");
        System.out.println("||                   ✅ Saham berhasil ditambahkan!                    ||");
        System.out.println("=========================================================================");

    }

    // Method untuk mengubah harga saham
    private static void ubahHargaSaham(Scanner input, List<Saham> daftarSaham) {
        if (daftarSaham.isEmpty()) {
            System.out.println("=========================================================================");
            System.out.println("||                          Belum ada saham.                           ||");
            System.out.println("=========================================================================");
            return;
        }

        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarSaham.get(i).tampilkanInfo();
        }

        int idx = inputInt(input, "Pilih nomor saham yang ingin diubah: ") - 1;
        if (idx >= 0 && idx < daftarSaham.size()) {
            double hargaBaru = inputDouble(input, "Masukkan harga baru: ");
            daftarSaham.get(idx).setHarga(hargaBaru);
            System.out.println("=========================================================================");
            System.out.println("||                   Harga saham berhasil diperbarui!                  ||");
            System.out.println("=========================================================================");
        } else {
            System.out.println("=========================================================================");
            System.out.println("||                          Nomor tidak valid.                         ||");
            System.out.println("=========================================================================");
        }
    }

    // Method untuk menampilkan menu SBN
    public static void menuSBN(Scanner input, List<SuratBerhargaNegara> daftarSBN) {
        while (true) {
            System.out.println("\n=========================================================================");
            System.out.println("||                                MENU SBN                             ||");
            System.out.println("=========================================================================");
            System.out.println("|| 1. Tambah SBN                                                       ||");
            System.out.println("|| 2. Kembali                                                          ||");
            System.out.println("=========================================================================");
            int pilihan = inputInt(input, "Pilih: ");

            switch (pilihan) {
                case 1:
                    tambahSBN(input, daftarSBN);  // Tambah SBN
                    break;
                case 2:
                    return;  // Kembali ke menu utama admin
                default:
                    System.out.println("=========================================================================");
                    System.out.println("||                        Pilihan tidak valid.                         ||");
                    System.out.println("=========================================================================");
            }
        }
    }

    // Method untuk menambah SBN
    private static void tambahSBN(Scanner input, List<SuratBerhargaNegara> daftarSBN) {
        String namaSbn = inputString(input, "Nama SBN: ");
        double bunga = inputDouble(input, "Bunga (%): ");
        int waktu = inputInt(input, "Jangka Waktu (bulan): ");
        String tempo = inputString(input, "Tanggal Jatuh Tempo: ");
        double kuota = inputDouble(input, "Kuota Nasional: ");
        daftarSBN.add(new SuratBerhargaNegara(namaSbn, bunga, waktu, tempo, kuota));
        System.out.println("=========================================================================");
        System.out.println("||                       SBN berhasil ditambahkan!                     ||");
        System.out.println("=========================================================================");
    }

    // Method untuk melihat produk investasi (Saham dan SBN)
    public static void lihatProdukInvestasi(List<Saham> daftarSaham, List<SuratBerhargaNegara> daftarSBN) {
        System.out.println("\n=========================================================================");
        System.out.println("||                           DAFTAR SAHAM                              ||");
        System.out.println("=========================================================================");

        if (daftarSaham.isEmpty()) {
            System.out.println("=========================================================================");
            System.out.println("||                          Belum ada saham.                           ||");
            System.out.println("=========================================================================");
        } else {
            for (Saham saham : daftarSaham) {
                saham.tampilkanInfo();  // Menampilkan info saham
            }
        }

        System.out.println("\n=========================================================================");
        System.out.println("||                            DAFTAR SBN                               ||");
        System.out.println("=========================================================================");
        if (daftarSBN.isEmpty()) {
            System.out.println("=========================================================================");
            System.out.println("||                           Belum ada SBN.                            ||");
            System.out.println("=========================================================================");
        } else {
            for (SuratBerhargaNegara sbn : daftarSBN) {
                sbn.tampilkanInfo();  // Menampilkan info SBN
            }
        }
    }

}
