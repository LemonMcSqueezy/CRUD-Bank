package Services;
import java.util.List;
import java.util.ArrayList;
import dao.*;
import UML.*;
import TransacType.*;

public class transactionService {
    transactionDao tdao;

    public transactionService(){

    }

    public transactionService(transactionDao tdao){
        this.tdao = tdao;
    }

    public List<Transaction> getHistory(Integer aID){
        return tdao.transactionById(aID);
    }

    public void addTransac(Transaction temp){
        tdao.create(temp);
    }

}
