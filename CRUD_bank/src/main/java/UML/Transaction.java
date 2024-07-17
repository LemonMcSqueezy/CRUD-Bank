package UML;
import UML.Account;

public class Transaction {
    private Integer tID;
    private Integer aID;
    private String type;
    private double amount;

    public Transaction(Integer tID, String type, double amount){
        this.tID = tID;
        this.type = type;
        this.amount = amount;
    }

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
    }

    public Transaction(){

    }

    public Integer gettID() {
        return tID;
    }

    public void settID(Integer tID) {
        this.tID = tID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getAccountId() {
        return aID;
    }

    public void setAccount(Integer aID) {
            this.aID = aID;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
