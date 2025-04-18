package model;

import java.time.LocalDate;

public class SuratBerhargaNegara {
    private String nama;
    private double bunga;
    private int jangkaWaktu; // dalam tahun
    private LocalDate tanggalJatuhTempo;
    private int kuotaNasional;

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, LocalDate tanggalJatuhTempo, int kuotaNasional) {
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

    public LocalDate getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public int getKuotaNasional() {
        return kuotaNasional;
    }

    @Override
    public String toString() {
        return nama + " - Bunga: " + bunga + "% - Jangka Waktu: " + jangkaWaktu + " tahun";
    }
}
