package utils;

import dao.*;
import Services.*;

import io.javalin.Javalin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import controller.*;

public class serverUtil {
    private static serverUtil sutil;
    private serverUtil(){

    }

    public static serverUtil getUtil(){
        if(sutil == null){
            sutil = new serverUtil();
        }
        return sutil;
    }

    public Javalin exec(int port) throws SQLException, IOException, ClassNotFoundException {
        Javalin api = Javalin.create().start(port);
        //Connection conn = connectionUtil.getConnection();

        userDao udao = new userDao();
        transactionDao tdao = new transactionDao();
        accountDao adao = new accountDao();

        userService userv = new userService(udao);
        transactionService tserv = new transactionService(tdao);
        accountService aserv = new accountService(adao);

        return api;
    }
}
