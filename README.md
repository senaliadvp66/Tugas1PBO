# Tugas1PBO
# Investasi Sederhana

Program sederhana berbasis Java untuk simulasi investasi Saham dan Surat Berharga Negara (SBN).

## Cara Menjalankan Program

1. Buka project ini di IntelliJ IDEA.
2. Pastikan sudah menggunakan JDK 11.
3. Jalankan file `Main.java`.
4. Ikuti instruksi login dan menu yang tersedia.

## Fitur Program

**Sebagai Admin:**
- Menambah produk Saham
- Mengubah harga Saham
- Menambah produk SBN
- Menghapus produk investasi

**Sebagai Customer:**
- Melihat daftar Saham dan SBN
- Membeli dan menjual Saham
- Membeli SBN
- Melihat portofolio
- Simulasi kupon SBN

## Struktur Kelas

- `Main`: Kelas utama untuk menjalankan program dan mengatur alur login serta menu.
- `Admin`: Kelas untuk fungsi-fungsi Admin.
- `Customer`: Kelas untuk fungsi-fungsi Customer.
- `Saham`: Menyimpan informasi kode saham, nama perusahaan, dan harga saham.
- `SuratBerhargaNegara`: Menyimpan informasi nama SBN, bunga, jangka waktu, tanggal jatuh tempo, dan kuota nasional.
- `Portofolio`: Menyimpan daftar investasi customer.

## Diagram UML

Berikut adalah diagram hubungan antar kelas:

* ss UML

- **Admin** mengelola **Saham** dan **SuratBerhargaNegara**.
- **Customer** memiliki **Portofolio** berisi **Saham** dan **SuratBerhargaNegara**.







---

## Catatan

- Semua data disimpan di memori (tidak menggunakan database/file).
- Akun login sudah di-hardcode di dalam program.

