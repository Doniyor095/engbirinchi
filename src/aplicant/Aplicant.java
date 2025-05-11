package aplicant;

import java.io.*;

public class Aplicant {
    private String email;
    private String username;
    private String password;
    private String gitHubUrl;
    private String imageUrl;
    private String phoneNumber;

    public static boolean usernameExists(String username) {
        File file = new File("java-io/usernames.txt");
        if (!file.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(username.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Faylda xatolik boldi: " + e.getMessage());
        }
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-io/usernames.txt", true))) {
            writer.write(username);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("❌ Username yozishda xatolik: " + e.getMessage());
        }
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGitHubUrl() { return gitHubUrl; }
    public void setGitHubUrl(String gitHubUrl) { this.gitHubUrl = gitHubUrl; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
