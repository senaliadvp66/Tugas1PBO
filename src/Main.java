import model.*;
import controller.*;
import java.util.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat beberapa data contoh
        List<User> users = new ArrayList<>();
        users.add(new Admin("admin", "admin123"));
        users.add(new Customer("customer1", "cust123"));

        // Membuat beberapa saham contoh
        List<Saham> sahamList = new ArrayList<>();
        sahamList.add(new Saham("AAPL", "Apple", 150000));
        sahamList.add(new Saham("GOOG", "Google", 200000));

        // Membuat beberapa SBN contoh
        List<SuratBerhargaNegara> sbnList = new ArrayList<>();
        sbnList.add(new SuratBerhargaNegara("SBN 10 Tahun", 5, 10, LocalDate.of(2035, 4, 17), 10000));

        // Input login
        System.out.println("===== Program Investasi =====");
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();

        System.out.print("Password: ");
        String inputPass = scanner.nextLine();

        User loggedInUser = null;

        // Cek login pengguna
        for (User user : users) {
            if (user.login(inputUser, inputPass)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println("Login berhasil sebagai: " + loggedInUser.getRole());
            AdminCustomerController.showMenu(loggedInUser, sahamList, sbnList); // Panggil controller
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
