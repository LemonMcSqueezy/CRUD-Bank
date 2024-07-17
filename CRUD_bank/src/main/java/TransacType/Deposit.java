// not in use, discuss in presentation
package TransacType;

import java.util.List;

public class Deposit {
    private double currBalance;
    private double postTransac;
    //private List<Account> accounts;
    public double Deposit(double currBalance, double dAmt){
        if(dAmt <= 0){
            System.out.print("Invalid deposit amount");
            System.exit(1);
        }
        else{
            postTransac += currBalance + dAmt;
        }
        if(this.postTransac == 0.00){
            //this.acct.remove();
            //drop row from database
            System.out.println("todo");
        }
        return postTransac;
    }
}
