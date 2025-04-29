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
Program akan menampilkan menu awal saat pertama kali dijalankan. Terdapat tiga opsi yang dapat dipilih user seperti login sebagai admin, login sebagai customer, atau keluar dari program.
![Menu Awal](images/menuawal.jpg)<br><br>
- Login sebagai Admin <br>
Jika user memilih login sebagai admin, maka akan muncul tampilan di bawah ini, dimana user akan diminta menginput username dan password admin.
  ![Login Admin](images/loginadmin.jpg)<br><br>
Berikut merupakan tampilan setelah user berhasil login sebagai admin.
  ![Login Admin](images/loginadmin1.jpg) <br><br>
- Login sebagai Customer<br>
JIka user memilih untuk login sebagai customer, maka tampilan untuk menginput username dan password sebagai customer akan muncul.
  ![Login Custom](images/logincustomer.jpg)<br><br>
Setelah user berhasil login sebagai customer, tampilan validasi akan muncul.
  ![Login Custom](images/logincustomer1.jpg) <br><br><br>

### 2. Menu Admin
Pengguna yang memiliki role admin akan mendapatkan tampilan menu admin dengan opsi-opsi seperti pengaturan saham, SBN, view list investasi dan logout.
![menuadmin.jpg](images/menuadmin.jpg)<br><br>

#### Menu Saham untuk Admin
Apabila user admin memilih opsi pertama, maka akan muncul menu pengaturan saham untuk admin sebagai berikut.
![menuadminsaham.jpg](images/menuadminsaham.jpg)<br><br>
- Tambah Saham Baru<br>
Jika user admin memilih opsi pertama dari menu saham, maka program akan meminta user admin untuk menginput kode saham, nama perusahaan, dan harga saham.
![admintambahsaham.jpg](images/admintambahsaham.jpg)<br><br>
Setelah user admin selesai menginput dan merupakan nilai yang valid, maka akan muncul tampilan sebagai berikut.
![admintambahsaham1.jpg](images/admintambahsaham1.jpg) <br><br>
- Ubah Harga Saham<br>
Apabila user admin memili opsi kedua dari menu saham, maka program akan memunculkan list saham seperti kode, nama, dan harga saham. User admin juga diminta untuk menginput nomor saham.
![adminubahsaham.jpg](images/adminubahsaham.jpg)<br><br>
Kemudian program akan meminta user admin untuk menginput harga baru. Jika nilai valid, maka tampilan update saham akan muncul.
![adminubahsaham1.jpg](images/adminubahsaham1.jpg)<br><br>
- Kembali ke Menu Admin<br>
Jika user admin memilih opsi terakhir pada menu saham untuk admin, maka user admin akan kembali ke menu admin seperti tampilan di bawah ini.
![adminsahamkembali.jpg](images/adminsahamkembali.jpg)<br><br><br>

#### Menu SBN untuk Admin
Jika user admin memilih SBN pada menu admin, maka tampilan pengaturan SBN untuk admin akan muncul. terdapat dua opsi pada menu SBN untuk admin yaitu menambah sbn dan kembali.
![adminsbn.jpg](images/adminsbn.jpg)<br><br>
- Tambah Produk SBN Baru<br>
Apabila user admin memilih opsi pertama, maka program akan meminta user admin menginput data seperti nama SBN, Bunga, Jangka waktu, tanggal jatuh tempo, dan kuota nasional.
![adminsbntambah.jpg](images/adminsbntambah.jpg)<br><br>
Kemudian user admin akan mendapat tampilan sebagai berikut apabila telah selesai memasukan data yang diperlukan dan data tervalidasi.
![adminsbntambah1.jpg](images/adminsbntambah1.jpg)<br><br>
- Kembali ke Menu Admin<br>
Jika user memilih opsi kedua, maka user akan dikembalikan ke tampilan menu admin.
![adminsbnkembali.jpg](images/adminsbnkembali.jpg)<br><br>

#### List Produk Investasi
Pada menu admin, jika user admin memilih opsi ketiga yaitu Lihat Produk Investasi maka user admin akan mendapat tampilan berupa list daftar saham dan daftar sbn pada program.
![adminlist.jpg](images/adminlist.jpg) <br><br>

#### Logout
User admin akan ter-logout apabila memilih opsi Logout pada pilihan keempat dan kembali pada menu awal.
![adminlogout.jpg](images/adminlogout.jpg)<br><br>

### 3. Menu Customer
Jika user login sebagai customer, maka user akan mendapat tampilan menu customer sebagai berikut. terdapat opsi-opsi seperti pengaturan saham, SBN, portofolio, dan logout.
![custommenu.jpg](images/custommenu.jpg)<br><br>

#### Menu Saham untuk Customer
Jika customer memilih opsi pertama yaitu saham, maka program akan memunculkan tampilan menu saham sebagai berikut.
![customsaham.jpg](images/customsaham.jpg)<br><br>

- Beli Saham<br>
Apabila pada menu saham customer memilih opsi beli saham, maka program akan memunculkan list saham beserta rinciannya. Kemudian customer akan diminta untuk menginput nomor saham dan jumlah lembar.
![customsahambeli.jpg](images/customsahambeli.jpg)<br><br>
Setelah customer menginput kedua data tadi, maka akan muncul tampilan seperti di bawah ini.
![customsahambeli1.jpg](images/customsahambeli1.jpg)<br><br>
- Jual Saham<br>
Program akan memunculkan tampilan sebagai berikut apabila customer memilih opsi keda pada menu saham. Lalu customer akan diminta untuk menginput nomor saham yang akan dijual beserta jumlah lembarnya.
![customsahamjual.jpg](images/customsahamjual.jpg)<br><br>
Berikut merupakan tampilan setelah customer berhasil menjual saham.
![customsahamjual1.jpg](images/customsahamjual1.jpg)<br><br>

#### Menu SBN untuk Customer
Jika pada menu customer user memilih opsi kedua yaitu SBN, maka program akan menampilkan menu SBN untuk customer yang berisi pilihan untuk membeli SBN, simulasi SBN, serta opsi kembali.
![customsbn.jpg](images/customsbn.jpg)<br><br>
- Beli Surat Berharga Negara (SBN)<br>
Program akan menampilkan list SBN yang teregister pada program dan customer akan diminta untuk memasukan nomor SBN sesuai dengan daftar.
![customsbnbeli.jpg](images/customsbnbeli.jpg)<br><br>
Setelah itu, user juga diminta untuk menginput nominal pembelian. Apabila transaksi berhasil, maka akan muncul tampilan sebagai berikut.
![customsbnbeli1.jpg](images/customsbnbeli1.jpg)<br><br>
- Simulasi Investasi SBN<br>
Jika pada menu SBN user memilih untuk melakukan simulasi SBN, maka program akan meminta user untuk menginput bunga persentase bunga dan nominal investasi.
![customsbnsimulasi.jpg](images/customsbnsimulasi.jpg)<br><br>
Program akan memunculkan tampilan berikut apabila kedua input customer valid.
![customsbnsimulasi1.jpg](images/customsbnsimulasi1.jpg)<br><br>
- Lihat Portofolio<br>
Apabila customer memilih opsi ketiga yaitu untuk melihat portofolio mereka, maka program akan memunculkan portofolio saham dan SBN customer.
![customporto.jpg](images/customporto.jpg)<br><br>
- Logout<br>
Program akan mengembalikan customer ke menu awal jika opsi keempat, Logout, dipilih.
![customlogout.jpg](images/customlogout.jpg)<br><br>

### 4. Exit
Jika pada menu awal user memilih opsi terakhir yaitu keluar, maka program akan mengakhiri proses dan memunculkan tampilan sebagai berikut.
![menulogout.jpg](images/menulogout.jpg)