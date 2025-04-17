import model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<User> users = new ArrayList<>();
        users.add(new Admin("admin", "admin123"));
        users.add(new Customer("user1", "pass1"));

        System.out.println("===== PROGRAM INVESTASI =====");
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();

        System.out.print("Password: ");
        String inputPass = scanner.nextLine();

        User loggedInUser = null;

        for (User user : users) {
            if (user.login(inputUser, inputPass)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println("Login berhasil sebagai: " + loggedInUser.getRole());

        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
