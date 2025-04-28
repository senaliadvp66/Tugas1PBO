package controller;

import model.*;
import view.*;
import java.util.List;
import java.util.Scanner;
import static model.Validasi.inputInt;


public class CustomerController {

    public static void menu(Customer customer, List<Saham> daftarSaham, List<SuratBerhargaNegara> daftarSBN) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n====================================================================================================");
            System.out.println("||                                        MENU CUSTOMER                                           ||");
            System.out.println("====================================================================================================");
            System.out.println("|| [1] Saham                                                                                      ||");
            System.out.println("|| [2] SBN                                                                                        ||");
            System.out.println("|| [3] Lihat Portofolio                                                                           ||");
            System.out.println("|| [4] Logout                                                                                     ||");
            System.out.println("====================================================================================================");
            int pilih = inputInt(input, "Pilih: ");

            switch (pilih) {
                case 1:
                    // Memanggil menuSaham dari MenuCustomer
                    MenuCustomer.menuSaham(customer, input, daftarSaham);
                    break;
                case 2:
                    // Memanggil menuSBN dari MenuCustomer
                    MenuCustomer.menuSBN(customer, input, daftarSBN);
                    break;
                case 3:
                    // Lihat Portofolio
                    customer.getPortofolio().tampilkanPortofolio();
                    break;
                case 4:
                    System.out.println("\n====================================================================================================");
                    System.out.println("||                                      Logout berhasil                                           ||");
                    System.out.println("====================================================================================================");
                    return;  // Logout dan keluar
                default:
                    System.out.println("\n====================================================================================================");
                    System.out.println("||                                 Pilihan tidak valid                                            ||");
                    System.out.println("====================================================================================================");
            }
        }
    }
}
