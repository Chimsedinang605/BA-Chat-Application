package Entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class User {
    private String id;
    private String userName;
    private String passWord;
    private String fullName;
    private String email;
    private String avatar;
    private String gender;

    public User(String id, String userName, String passWord, String fullName, String email, String avatar, String gender) {
        this.id = id;
        this.userName = userName;
        this.passWord = (passWord);
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.gender = gender;
    }

    public User(String userName, String hashedPassword) {
        this.userName = userName;
        this.passWord = encryptPassword(hashedPassword);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = encryptPassword(passWord);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
