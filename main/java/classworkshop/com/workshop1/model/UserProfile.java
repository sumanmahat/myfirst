package classworkshop.com.workshop1.model;

/**
 * Created by Admin on 9/9/2017.
 */

public class UserProfile {
    private String fname, lname, username,age;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String email) {
        this.age = age;
    }

    public UserProfile(String fname, String lname, String username, String age) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.age = age;

    }
}
