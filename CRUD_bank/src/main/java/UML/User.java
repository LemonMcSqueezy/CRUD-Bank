package UML;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer uID;
    private String fname;
    private String lname;
    private String email;
    private String phoneNo;
    private String username;
    private String password;
    private List<Account> accounts;

    public User(Integer uID, String fname, String lname, String email, String phoneNo, String username, String password){
        this.uID = uID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.username = username;
        this.password = password;
    }

    public User(Integer uID){
        this.uID = uID;
    }

    public User(String fname, String lname, String email, String phoneNo, String username, String password){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.username = username;
        this.password = password;
    }

    public User(){

    }

    public Integer getuID() {
        return uID;
    }

    public void setuID(Integer uID) {
        this.uID = uID;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setHistory(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
