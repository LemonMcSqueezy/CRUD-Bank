// not in use, discuss in presentation
package TransacType;

import java.util.List;
import dao.transactionDao;

public class Withdraw {
    private double currBalance;
    private double postTransac;
    //private List<Account> accounts;


    public double withdraw(double currBalance, double wAmt){
        if(wAmt > currBalance){
            System.out.print("Insufficient account balance");
            System.exit(1);
        }
        else{
            postTransac -= currBalance - wAmt;
        }



        if(this.postTransac == 0.00){
            //this.acct.remove();
            //drop row from database
            System.out.println("todo");
        }
        return postTransac;
    }
}
