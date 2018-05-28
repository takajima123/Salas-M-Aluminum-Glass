package DataBase;

import java.sql.*;
import javax.swing.*;

public class sqliteConnect 
{
    Connection conn = null;
    public static Connection connectorDB()
            {
                try
                {
                    Class.forName("org.sqlite.JDBC");
                  //Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\lalabs\\kerr and josh  was here\\MAAN.Sqlite");
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:MAAN.Sqlite");
                    //JOptionPane.showMessageDialog(null, "Database connection has been established");
                    return conn;
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                    return null;
                }
            }
    
}
