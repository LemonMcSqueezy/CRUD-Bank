package UML;

public class Account {
    private String acctHolder;
    private Integer aID;
    private double balance;
    private Integer uID;

    public Account(){

    }

    public Account(Integer aID, String acctHolder, double balance){
        this.aID = aID;
        this.acctHolder = acctHolder;
        this.balance = balance;
    }

    public Account(String acctHolder, double balance){
        this.acctHolder = acctHolder;
        this.balance = balance;
    }

    public Integer getaID() {
        return aID;
    }

    public void setaID(Integer aID) {
        this.aID = aID;
    }

    public String getAcctHolder() {
        return acctHolder;
    }

    public void setAcctHolder(String acctHolder) {
        this.acctHolder = acctHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
