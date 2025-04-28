# Pemrograman Berorientasi Obyek
# Program Investasi Sederhana Berbasis Command Line

oleh:  
2405551101-Ni Putu Balina Senalia Devi  
2405551058-Made Amrtasya Saraswati<br><br>

Program ini merupakan aplikasi investasi sederhana berbasis command line menggunakan bahasa pemrograman Java.
Pengguna terbagi menjadi dua jenis yaitu Admin dan Customer. Admin dapat mengelola daftar saham dan surat berharga negara (SBN), sedangkan Customer dapat membeli, menjual, dan melihat portofolio investasinya.

## Diagram Kelas (UML)

![UML Diagram](images/uml.png)
- Admin: Kelas yang mewakili admin, yang dapat menambah saham, mengubah harga saham, dan menambah produk SBN.  
- Customer: Kelas yang mewakili customer, memungkinkan mereka untuk membeli saham, menjual saham, membeli SBN, dan melihat portofolio mereka.
- Portofolio: Kelas yang menyimpan daftar saham dan SBN yang dimiliki oleh customer, serta menyediakan metode untuk membeli, menjual, dan menampilkan portofolio.
- Saham: Kelas yang menyimpan informasi terkait saham, seperti kode, nama perusahaan, dan harga saham.
- SuratBerhargaNegara: Kelas yang menyimpan informasi terkait produk SBN, termasuk nama, bunga, jangka waktu, tanggal jatuh tempo, dan kuota nasional.
- User: Kelas abstrak yang menangani informasi dasar pengguna, seperti username dan password, serta metode untuk login dan mendapatkan role.
- Validasi: Kelas yang menyediakan metode untuk validasi input, seperti input integer, double, dan string.
- MenuAdmin: Kelas yang menampilkan menu untuk admin, termasuk pilihan untuk mengelola saham dan SBN.
- MenuCustomer: Kelas yang menampilkan menu untuk customer, termasuk pilihan untuk membeli dan menjual saham, membeli SBN, dan melihat portofolio.

## Prosedur Menjalankan Program

##### 1. Clone repository ini melalui link https://github.com/senaliadvp66/Tugas1PBO.git
##### 2. Buka project dengan IDE seperti IntelliJ IDEA.
##### 3. Pastikan sudah menggunakan Java 8 atau lebih baru.
##### 4. Jalankan file Main.java. 

## Tampilan Program
### 1. Awal

![Menu Awal](images/menuawal.jpg)<br>
- Login sebagai Admin

  ![Login Admin](images/loginadmin.jpg)

  ![Login Admin](images/loginadmin1.jpg) <br>
- Login sebagai Customer

  ![Login Custom](images/logincustomer.jpg)

  ![Login Custom](images/logincustomer1.jpg) <br><br>

### 2. Menu Admin

![menuadmin.jpg](images/menuadmin.jpg)<br><br>

#### Menu Saham untuk Admin

![menuadminsaham.jpg](images/menuadminsaham.jpg)<br>
- Tambah Saham Baru

![admintambahsaham.jpg](images/admintambahsaham.jpg)

![admintambahsaham1.jpg](images/admintambahsaham1.jpg) <br>
- Ubah Harga Saham

![adminubahsaham.jpg](images/adminubahsaham.jpg)

![adminubahsaham1.jpg](images/adminubahsaham1.jpg)<br>
- Kembali ke Menu Admin

![adminsahamkembali.jpg](images/adminsahamkembali.jpg)<br><br>

#### Menu SBN untuk Admin

![adminsbn.jpg](images/adminsbn.jpg)<br>
- Tambah Produk SBN Baru

![adminsbntambah.jpg](images/adminsbntambah.jpg)

![adminsbntambah1.jpg](images/adminsbntambah1.jpg)<br>
- Kembali ke Menu Admin

![adminsbnkembali.jpg](images/adminsbnkembali.jpg)<br><br>

#### List Produk Investasi

![adminlist.jpg](images/adminlist.jpg) <br><br>

#### Logout

![adminlogout.jpg](images/adminlogout.jpg)<br><br>

### 3. Menu Customer

![custommenu.jpg](images/custommenu.jpg)<br>

#### Menu Saham untuk Customer

![customsaham.jpg](images/customsaham.jpg)<br>

- Beli Saham

![customsahambeli.jpg](images/customsahambeli.jpg)

![customsahambeli1.jpg](images/customsahambeli1.jpg)<br>
- Jual Saham

![customsahamjual.jpg](images/customsahamjual.jpg)

![customsahamjual1.jpg](images/customsahamjual1.jpg)<br><br>

#### Menu SBN untuk Customer

![customsbn.jpg](images/customsbn.jpg)<br>
- Beli Surat Berharga Negara (SBN)

![customsbnbeli.jpg](images/customsbnbeli.jpg)


![customsbnbeli1.jpg](images/customsbnbeli1.jpg)<br>
- Simulasi Investasi SBN

![customsbnsimulasi.jpg](images/customsbnsimulasi.jpg)

![customsbnsimulasi1.jpg](images/customsbnsimulasi1.jpg)<br>
- Lihat Portofolio

![customporto.jpg](images/customporto.jpg)<br>
- Logout

![customlogout.jpg](images/customlogout.jpg)<br><br>

### 4. Exit

![menulogout.jpg](images/menulogout.jpg)