package model;

import java.util.*;

public class Portofolio {
    private List<Saham> sahamList = new ArrayList<>();
    private List<SuratBerhargaNegara> sbnList = new ArrayList<>();

    // Menambah saham yang dibeli ke dalam portofolio
    public void beliSaham(Saham saham) {
        sahamList.add(saham);
    }

    // Menambah SBN yang dibeli ke dalam portofolio
    public void beliSBN(SuratBerhargaNegara sbn) {
        sbnList.add(sbn);
    }

    // Menampilkan daftar saham yang dimiliki
    public void tampilkanSaham() {
        if (sahamList.isEmpty()) {
            System.out.println("Portofolio Saham kosong.");
        } else {
            System.out.println("Daftar Saham yang dimiliki:");
            for (Saham saham : sahamList) {
                System.out.println(saham);
            }
        }
    }

    // Getter untuk daftar saham
    public List<Saham> getSahamList() {
        return sahamList;
    }

    // Menampilkan daftar SBN yang dimiliki
    public void tampilkanSBN() {
        if (sbnList.isEmpty()) {
            System.out.println("Portofolio SBN kosong.");
        } else {
            System.out.println("Daftar SBN yang dimiliki:");
            for (SuratBerhargaNegara sbn : sbnList) {
                System.out.println(sbn);
            }
        }
    }

    // Getter untuk daftar SBN
    public List<SuratBerhargaNegara> getSbnList() {
        return sbnList;
    }
}
