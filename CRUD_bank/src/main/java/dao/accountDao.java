package dao;
import java.sql.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import UML.Account;
import utils.connectionUtil;

public class accountDao  {


    public accountDao(){

    }

    public void create(Account acct){
        try{
            Connection connection = connectionUtil.getConnection();
            String sql = "INSERT INTO accounts(acctHolder, balance) VALUES (? , ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, acct.getAcctHolder());
            pstmt.setDouble(2, acct.getBalance());
            pstmt.executeUpdate();
            ResultSet dbKey = pstmt.getGeneratedKeys();
            if(dbKey.next()){
                acct.setaID(dbKey.getInt(1));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //read accounts by acct holder name
    public List<Account> readByName(Integer uID){
        List<Account> acct = new ArrayList<>();
        try{
            Connection connection = connectionUtil.getConnection();
            String sql = "SELECT * FROM accounts WHERE uID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, uID);
            ResultSet results = pstmt.executeQuery();
            if(results.next()){
                String aName = (results.getString("acctHolder"));
                double aBalance = (results.getDouble("balance"));
                Account temp = new Account(aName, aBalance);
                acct.add(temp);
            }
            pstmt.execute();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return acct;
    }

    public Account read(Integer aID){
        try{
            Connection connection = connectionUtil.getConnection();
            String sql = "SELECT * FROM accounts WHERE aID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, aID);
            ResultSet results = pstmt.executeQuery();
            if(results.next()){
                String aName = (results.getString("acctHolder"));
                double aBalance = (results.getDouble("balance"));
                return new Account(aName, aBalance);
            }
            pstmt.execute();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(Account acct){
        String sql = "UPDATE accounts SET acctHolder = ? , balance = ?";
        try{
            Connection connection = connectionUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, acct.getAcctHolder());
            pstmt.setDouble(2, acct.getBalance());
            pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(Account acct) {
        String sql = "DELETE FROM users where aID = ?";
        try {
            Connection connection = connectionUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, acct.getaID());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
