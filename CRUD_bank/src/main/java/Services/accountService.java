package Services;
import UML.*;
import dao.*;
import java.util.List;
import java.sql.SQLException;
import TransacType.*;

public class accountService {
    accountDao adao;
    transactionDao tdao;
    transactionService tserv;

    public accountService(){

    }

    public accountService(accountDao adao){
        this.adao = adao;
    }

    public Account makeAccount(Account acct) throws SQLException{
        adao.create(acct);
        return acct;
    }

    public Account accountsById(Integer aID){
        return adao.read(aID);
    }

    public List<Account> accountsByUserID(Integer uID){
        return adao.readByName(uID);
    }

    public void deposit(Account aID, double amount){
        double currBal = aID.getBalance();
        if(amount > 0){
            currBal += amount;
            aID.setBalance(currBal);
            //tserv.addTransac(tdao.create(new Transaction("deposit", amount)));
            adao.update(aID);
            // currBal;
        }
        else{
            System.out.println("Deposit amount must be a positive number");
        }
        //return currBal;
    }

    public void withdraw(Account aID, double amount){
        double currBal = aID.getBalance();
        if(amount > 0 && !(amount > currBal)){
            currBal -= amount;
            aID.setBalance(currBal);

            adao.update(aID);
            //return currBal;
        }
        else{
            System.out.println("Insufficient account balance");
        }
        // currBal;
    }

    public void transfer(Account sender, Account rcvr, double amount){
        if(sender.getBalance() >= amount) {
            withdraw(sender, amount);
            deposit(rcvr, amount);
            //tdao.create(new Transaction("transfer", amount));
        }
        else{
            System.out.println("Sender has insufficient money to transfer");
        }
        adao.update(sender);
        adao.update(rcvr);
        //return sender.getBalance();
    }

    public boolean zeroAcct(Account acct){
        if(acct.getBalance() == 0.00){
            adao.delete(acct);
            return true;
        }
        else{
            System.out.println("To delete an account, it must have a balance of $0.00.");
            return false;
        }
    }
}
