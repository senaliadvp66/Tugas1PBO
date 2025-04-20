package model;

public class SuratBerhargaNegara {
    private String nama;
    private double bunga;
    private int jangkaWaktu;
    private String tanggalJatuhTempo;
    private double kuotaNasional;

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    public String getNama() {
        return nama;
    }

    public double getBunga() {
        return bunga;
    }

    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

    public String getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public double getKuotaNasional() {
        return kuotaNasional;
    }

    public void kurangiKuota(double nominal) {
        if (nominal <= 0 || nominal > kuotaNasional) {
            throw new IllegalArgumentException("Nominal tidak valid atau melebihi kuota.");
        }
        this.kuotaNasional -= nominal;
    }

    public void tampilkanInfo() {
        System.out.printf("Nama: %s | Bunga: %.2f%% | Waktu: %d bln | Jatuh Tempo: %s | Kuota: Rp%.2f\n",
                nama, bunga, jangkaWaktu, tanggalJatuhTempo, kuotaNasional);
    }
}
