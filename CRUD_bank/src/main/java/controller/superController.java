package controller;
import UML.*;
import dao.*;
import Services.*;
import controller.dto.*;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Cookie;

import java.sql.SQLException;

public class superController {
    public void begin(){
        Javalin app = Javalin.create().start(7777);
        //post commands
        //user controller methods
        //works
        app.post("/register", ctx -> {userDao udao = new userDao();
                                            userService userv = new userService(udao);
                                            User temp = ctx.bodyAsClass(User.class);
                                            User success = userv.makeUser(temp);
                                            ctx.status(200);
                                            ctx.json(success);
                                            });
        //works
        app.post("/login", ctx -> {userDao udao = new userDao();
                                        AuthDto auth = ctx.bodyAsClass(AuthDto.class);
                                        userService userv = new userService(udao);
                                        User doesExist = null;
                                        try{
                                            doesExist = userv.login(auth.getUsername(), auth.getPassword());
                                            ctx.json(doesExist);
                                            Cookie cookie = new Cookie("Auth", doesExist.getUsername());
                                            ctx.cookie(cookie);
                                            ctx.status(200);
                                        } catch(Exception e){
                                            System.out.println(e.getMessage());
                                        }
                                        });

        //works
        app.post("/update", ctx -> {userDao udao = new userDao();
                                         userService userv = new userService(udao);
                                         User temp = ctx.bodyAsClass(User.class);
                                         User updUser = userv.makeUser(temp); //update not working for some reason
                                         ctx.status(200);
                                         ctx.json(updUser);
                                        });

        //account controller methods
        //works
        app.post("create/{uID}", ctx ->{accountDao adao = new accountDao();
                                             accountService aserv = new accountService(adao);
                                             //int parseID = Integer.parseInt(ctx.pathParam("uID"));
                                             //User temp = new User(parseID);
                                             Account acct = ctx.bodyAsClass(Account.class);
                                             Account success = aserv.makeAccount(acct);
                                             ctx.status(200);
                                             ctx.json(success);
                                             });

        //works
        app.post("/accounts/{aID}/withdraw/{amount}", ctx -> {
            accountDao adao = new accountDao();
            accountService aserv = new accountService(adao);
            int parseID = Integer.parseInt(ctx.pathParam("aID"));
            double parseAmt = Double.parseDouble(ctx.pathParam("amount"));
            Account temp = aserv.accountsById(parseID);
            aserv.withdraw(temp, parseAmt);
            ctx.status(200);
            ctx.result("Resultant balance is: " + temp.getBalance());
        });


        //works
        app.post("/accounts/{aID}/deposit/{amount}", ctx -> {
            accountDao adao = new accountDao();
            accountService aserv = new accountService(adao);
            int parseID = Integer.parseInt(ctx.pathParam("aID"));
            double parseAmt = Double.parseDouble(ctx.pathParam("amount"));
            Account temp = aserv.accountsById(parseID);
            aserv.deposit(temp, parseAmt);
            ctx.status(200);
            ctx.result("Resultant balance is: " + temp.getBalance());
        });

        //works
        app.post("/accounts/{aID}/transfer/{amount}/{rcvrID}", ctx ->{
            accountDao adao = new accountDao();
            accountService aserv = new accountService(adao);
            int parseID = Integer.parseInt(ctx.pathParam("aID"));
            double parseAmt = Double.parseDouble(ctx.pathParam("amount"));
            int parseRcvrId = Integer.parseInt(ctx.pathParam("rcvrID"));
            Account sender = aserv.accountsById(parseID);
            Account receiver = aserv.accountsById(parseRcvrId);
            aserv.transfer(sender, receiver, parseAmt);
            ctx.status(200);
            ctx.result("Resultant sender balance is: " + sender.getBalance() + "\n Receiver balance is now: " + receiver.getBalance());
        });
        //end of post commands

        //get commands
        //womp womp
        app.get("/accounts/{aID}/transacHistory", ctx -> {
            transactionDao tdao = new transactionDao();
            transactionService tserv = new transactionService();
            int parseID = Integer.parseInt(ctx.pathParam("aID"));
            List<Transaction> history = tserv.getHistory(parseID);
            ctx.status(200);
            ctx.result((InputStream) history);
        });

        //womp womp
        app.get("/users/{uID}/accounts", ctx -> {
            accountDao adao = new accountDao();
            accountService aserv = new accountService(adao);
            int parseID = Integer.parseInt(ctx.pathParam("uID"));
            List<Account> uidMatch = aserv.accountsByUserID(parseID);
            ctx.status(200);
            ctx.json(uidMatch);
        });

        app.get("/users/{uID}/accounts/{aID}", ctx -> {
            accountDao adao = new accountDao();
            accountService aserv = new accountService(adao);
            int parseID = Integer.parseInt(ctx.pathParam("aID"));
            Account aidMatch = aserv.accountsById(parseID);
            ctx.status(200);
            ctx.json(aidMatch);
        });

        //works
        app.get("/users/{username}", ctx -> {
            userDao udao = new userDao();
            userService userv = new userService(udao);
            String parsedUsername = ctx.pathParam("username");
            User user = userv.readUser(parsedUsername);
            ctx.status(200);
            ctx.json(user);
        });

        app.get("/users/{uID}", ctx -> {
            userDao udao = new userDao();
            userService userv = new userService(udao);
            Integer parseID = Integer.parseInt(ctx.pathParam("uID"));
            User user = userv.readUserByID(parseID);
            ctx.status(200);
            ctx.json(user);
        });
        //end of get commands

        //delete commands
        //works
        app.delete("/accounts/{aID}", ctx -> {
            accountDao adao = new accountDao();
            accountService aserv = new accountService(adao);
            int parseID = Integer.parseInt(ctx.pathParam("aID"));
            Account temp = aserv.accountsById(parseID);
            if(aserv.zeroAcct(temp)){
                //changed zeroAcct from void to boolean so that Postman can be made aware of the success/failure of method
                ctx.status(200);
            }
            else{
                ctx.status(450);
            }
        });
        //end of delete commands
    }
}
