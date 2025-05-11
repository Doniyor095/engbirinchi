package concurency.lesson8.project;

public class Applicant {
    private String email;
    private String username;
    private String password;
    private String gitHubUrl;
    private String imageUrl;
    private String phoneNumber;


    public Applicant() {
    }

    public Applicant(String email, String username, String password, String gitHubUrl, String imageUrl, String phoneNumber) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.gitHubUrl = gitHubUrl;
        this.imageUrl = imageUrl;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
