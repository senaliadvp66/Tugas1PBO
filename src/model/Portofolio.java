package model;

import java.util.*;

public class Portofolio {
    private List<Saham> sahamList = new ArrayList<>();
    private List<SuratBerhargaNegara> sbnList = new ArrayList<>();

    public void beliSaham(Saham saham) {
        sahamList.add(saham);
    }

    public void beliSBN(SuratBerhargaNegara sbn) {
        sbnList.add(sbn);
    }

    public void tampilkanSaham() {
        System.out.println("Daftar Saham yang dimiliki:");
        for (Saham saham : sahamList) {
            System.out.println(saham);
        }
    }

    public void tampilkanSBN() {
        System.out.println("Daftar SBN yang dimiliki:");
        for (SuratBerhargaNegara sbn : sbnList) {
            System.out.println(sbn);
        }
    }
}
