package model;

public class Saham {
    private String kode;
    private String namaPerusahaan;
    private double harga;


    public Saham(String kode, String namaPerusahaan, double harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        setHarga(harga);
    }

    public String getKode() {
        return kode;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga saham harus lebih dari 0.");
        }
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println("=========================================================================");
        System.out.printf("Kode: %s | Nama: %s | Harga: Rp%.2f\n", kode, namaPerusahaan, harga);
        System.out.println("=========================================================================");
    }
}

