package dao;
import UML.Transaction;
import utils.connectionUtil;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class transactionDao {

    public transactionDao(){

    }


    public List<Transaction>transactionById(Integer aID){
        List<Transaction> history = new ArrayList<>();
        try{
            Connection connection = connectionUtil.getConnection();
            String sql = "SELECT * FROM transactions WHERE aID=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,aID);
            ResultSet resSet = pstmt.executeQuery();
            while(resSet.next()) {
                String tType = resSet.getString("type");
                Integer acctId = resSet.getInt("aID");
                double tAmount = resSet.getDouble("amount");
                Transaction temp = new Transaction(tType, tAmount);
                history.add(temp);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return history;
    }

    public Transaction create(Transaction transac){
        try{
            Connection connection = connectionUtil.getConnection();
            String sql = "INSERT INTO transactions (type, amount) VALUES(? , ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,transac.getType());
            pstmt.setDouble(2,transac.getAmount());
            pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return transac;
    }
}
