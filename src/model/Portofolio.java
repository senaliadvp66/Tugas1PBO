package model;

import java.util.*;

public class Portofolio {
    private Map<Saham, Integer> saham = new HashMap<>();
    private Map<SuratBerhargaNegara, Double> sbn = new HashMap<>();

    public void beliSaham(Saham s, int lembar) {
        if (lembar <= 0) throw new IllegalArgumentException("Lembar harus lebih dari 0.");
        saham.put(s, saham.getOrDefault(s, 0) + lembar);
    }

    public boolean jualSaham(Saham s, int lembar) {
        if (lembar <= 0) return false;
        if (!saham.containsKey(s) || saham.get(s) < lembar) {
            return false;
        }
        saham.put(s, saham.get(s) - lembar);
        if (saham.get(s) == 0) saham.remove(s);
        return true;
    }

    public void beliSBN(SuratBerhargaNegara sbnObj, double nominal) {
        if (nominal <= 0) throw new IllegalArgumentException("Nominal harus lebih dari 0.");
        sbn.put(sbnObj, sbn.getOrDefault(sbnObj, 0.0) + nominal);
    }

    public void tampilkanPortofolio() {
        System.out.println("\n=== PORTOFOLIO SAHAM ===");
        double totalPasar = 0;
        if (saham.isEmpty()) {
            System.out.println("Belum punya saham.");
        } else {
            for (Saham s : saham.keySet()) {
                int lembar = saham.get(s);
                double nilai = s.getHarga() * lembar;
                System.out.printf("Kode: %s | Nama: %s | Lembar: %d | Nilai Pasar: Rp%.2f\n",
                        s.getKode(), s.getNamaPerusahaan(), lembar, nilai);
                totalPasar += nilai;
            }
            System.out.printf("Total Nilai Pasar Saham: Rp%.2f\n", totalPasar);
        }

        System.out.println("\n=== PORTOFOLIO SBN ===");
        double totalBunga = 0;
        if (sbn.isEmpty()) {
            System.out.println("Belum punya SBN.");
        } else {
            for (SuratBerhargaNegara sb : sbn.keySet()) {
                double nominal = sbn.get(sb);
                double bunga = (sb.getBunga() / 100) / 12 * 0.9 * nominal;
                System.out.printf("Nama: %s | Nominal: Rp%.2f | Bunga / bulan: Rp%.2f\n",
                        sb.getNama(), nominal, bunga);
                totalBunga += bunga;
            }
            System.out.printf("Total Bunga SBN per Bulan: Rp%.2f\n", totalBunga);
        }
    }

    public Map<Saham, Integer> getSaham() {
        return saham;
    }

    public Map<SuratBerhargaNegara, Double> getSBN() {
        return sbn;
    }
}
