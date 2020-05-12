package sample;

import javax.xml.bind.SchemaOutputResolver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.Class.forName;

public class DBConnect {

    public Connection con;
    public Statement st;
    public ResultSet rs;

    public DBConnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rc_racunari", "root", "");

            st = con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
    }

    public ResultSet Query(String query)
    {
        try{
            rs = st.executeQuery(query);
            System.out.println("Query executed!");
            return rs;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
    }

}
