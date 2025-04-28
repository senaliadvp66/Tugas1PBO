package controller;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import static model.Validasi.inputInt;
import static model.Validasi.inputString;

public class LoginController {

    public static User loginProcess(Scanner input, ArrayList<User> users) {
        System.out.println("\n====================================================================================================");
        System.out.println("||                                           MENU AWAL                                             ||");
        System.out.println("====================================================================================================");
        System.out.println("|| [1] Login sebagai Admin                                                                         ||");
        System.out.println("|| [2] Login sebagai Customer                                                                      ||");
        System.out.println("|| [3] Keluar                                                                                      ||");
        System.out.println("====================================================================================================");
        int pilih = inputInt(input, "Pilih: ");

        if (pilih == 1 || pilih == 2) {
            String roleYangDipilih = (pilih == 1) ? "admin" : "customer";
            String username = inputString(input, "Username: ");
            String password = inputString(input, "Password: ");

            User userLogin = login(username, password, roleYangDipilih, users);
            if (userLogin != null) {
                System.out.println("\n====================================================================================================");
                System.out.println("||                                       Login berhasil!                                          ||");
                System.out.println("====================================================================================================");
                System.out.printf("                     Selamat datang, %-60s||\n", userLogin.getUsername());
                System.out.println("====================================================================================================");
                if (userLogin.getRole().equals("admin")) {
                    return userLogin;
                } else {
                    return userLogin;
                }
            } else {
                System.out.println("\n====================================================================================================");
                System.out.println("||                                         Login gagal                                            ||");
                System.out.println("====================================================================================================");
                System.out.printf("          Username/password salah atau bukan %-50s||\n", roleYangDipilih);
                System.out.println("====================================================================================================");
                return null;
            }
        } else if (pilih == 3) {
            System.out.println("\n====================================================================================================");
            System.out.println("||                                        Terima kasih                                            ||");
            System.out.println("====================================================================================================");
            return null;
        } else {
            System.out.println("\n====================================================================================================");
            System.out.println("||                                   Pilihan tidak valid                                          ||");
            System.out.println("====================================================================================================");
            return null;
        }
    }

    private static User login(String username, String password, String role, ArrayList<User> users) {
        for (User user : users) {
            if (user.login(username, password) && user.getRole().equals(role)) {
                return user;
            }
        }
        return null;
    }
}
