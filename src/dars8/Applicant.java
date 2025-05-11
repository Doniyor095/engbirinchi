package dars8;

import aplicant.BadRequest;

class Applicant {
    private String email;
    private String username;
    private String password;
    private String gitHubUrl;
    private String imageUrl;
    private String phoneNumber;

    Applicant(){
    }
     Applicant(String email, String username, String password, String gitHubUrl, String imageUrl, String phoneNumber) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.gitHubUrl = gitHubUrl;
        this.imageUrl = imageUrl;
        this.phoneNumber = phoneNumber;

    }
   static void validateApplicant(Applicant applicant){

   }

    public static void main(String[] args) {
        Applicant app = new Applicant();
        try {
            app.setPassword("salom2");

        }catch (BadRequest e){
            System.out.println(e.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
         String regex = "^\\+?998?(5[05]|88|33|20|9[12345789])\\d{7}$";
         if (!phoneNumber.matches(regex)) {
             System.out.println("Kuchli telefon raqam kiriting!!!");
         }
         else {
             this.phoneNumber = phoneNumber;
             System.out.println("Qo'shldi!!");
         }
    }

    public void setEmail(String email) {
         String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
         if (!email.matches(regex)) {
             System.out.println("Kuchli email kiriting!!!");
         } else {
             this.email = email;
             System.out.println("Qoshildi");
         }
    }

    public void setUsername(String username) {

             this.username = username;

    }

    public void setPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";
        if (!password.matches(regex)) {
            throw new BadRequest("Kuchli pasword kiriting!!!");
        } else {
            this.password = password;
            System.out.println("Pasword kiritildi");
        }
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
