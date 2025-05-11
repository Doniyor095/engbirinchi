package aplicant;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern VALID_PHONE = Pattern.compile("^(\\+998)?(9[0-9]|88|33|5[0-9]|20)\\d{7}$");
    private static final Pattern VALID_EMAIL = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern VALID_PASSWORD = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^&*_])[A-Za-z0-9#$^&*_]{8,16}$");
    private static final Pattern VALID_GITHUB_URL = Pattern.compile("^https://github\\.com/[a-zA-Z0-9-]{1,39}$");
//    private static final Pattern VALID_IMAGE_URL = Pattern.compile("^https?://[^\\s]+\\.(jpg|png)$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aplicant applicant = new Aplicant();

        long n1 = System.currentTimeMillis();
        while (true) {
            System.out.print("📧 Email kiriting: ");
            String input = scanner.nextLine();
            if (VALID_EMAIL.matcher(input).matches()) {
                applicant.setEmail(input);
                break;
            } else {
                System.out.println("\u001B[31m❌ Noto‘g‘ri email format. Qayta urinib ko‘ring.\u001B[0m");
            }
        }


        while (true) {
            System.out.print("👤 Username kiriting: ");
            String input = scanner.nextLine();
            if (!Aplicant.usernameExists(input)) {
                applicant.setUsername(input);
                break;
            } else {
                System.out.println("\u001B[31m❌ Bu username ilgari kiritilgan boshqa kiriting.\u001B[0m");
            }
        }
        while (true) {
            System.out.print("📱 Telefon raqam kiriting (+998...): ");
            String input3 = scanner.nextLine();
            if (VALID_PHONE.matcher(input3).matches()) {
                applicant.setPhoneNumber(input3);
                break;
            } else {
                System.out.println("\u001B[31m❌ Telefon raqami noto‘g‘ri. +998 bilan boshlanishi kerak.\u001B[0m");
            }
        }

        while (true) {
            System.out.print("🔒 Parol kiriting: ");
            String input4 = scanner.nextLine();
            if (VALID_PASSWORD.matcher(input4).matches()) {
                applicant.setPassword(input4);
                break;
            } else {
                System.out.println("\u001B[31m❌ Parol kuchsiz. 8+ belgidan iborat, katta, kichik harf, raqam, belgi kerak.\u001B[0m");
            }
        }

        while (true) {
            System.out.print("🌐 GitHub URL: (Masalan : https://github.com/username ");
            String input = scanner.nextLine();
            if (VALID_GITHUB_URL.matcher(input).matches()) {
                applicant.setGitHubUrl(input);
                break;
            } else {
                System.out.println("\u001B[31m❌ Noto‘g‘ri GitHub URL. Masalan: https://github.com/username\u001B[0m");
            }
        }


        System.out.print("📸 Rasm URL (.jpg/.png): (\u001B[33mIxtiyoriy\u001B[0m) ");
        String input1 = scanner.nextLine();

        applicant.setImageUrl(input1);
        long n2 = System.currentTimeMillis();
        System.out.println("\u001B[32m✅ Barcha ma’lumotlar muvaffaqiyatli saqlandi!\u001B[0m");
        System.out.println((n2 - n1)/1000 + " soniya ");
    }
}
