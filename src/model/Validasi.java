package model;

import java.io.IOException;
import java.util.Scanner;

public class Validasi {
    public static int inputInt(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Masukkan angka yang valid.");
            }
        }
    }

    public static double inputDouble(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Masukkan angka desimal yang valid.");
            }
        }
    }

    public static String inputString(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("⚠️ Input tidak boleh kosong.");
        }
    }
}

