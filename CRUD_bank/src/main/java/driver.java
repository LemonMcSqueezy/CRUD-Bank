import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import io.javalin.Javalin;
import controller.superController;
import utils.*;

public class driver {
    public static void main(String[] args) throws Exception {
        /*try{
            serverUtil.getUtil().exec(7777);
        } catch (Exception e){
            throw new Exception(e);
        }*/
        superController sCon = new superController();
        sCon.begin();
    }
}
