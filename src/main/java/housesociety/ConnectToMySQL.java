package housesociety;

import java.sql.*;

public class ConnectToMySQL {

    private final String user = "root";
    private final String password = "1234";
    private final String url = "jdbc:mysql://localhost:3306/HousingSociety?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static Connection conn;
    private static Statement s;
    
    ConnectToMySQL()throws Exception{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");  
        conn = DriverManager.getConnection(url,user,password);
        }
        catch(ClassNotFoundException | SQLException e){
         e.printStackTrace();
        }
    }
    
    Statement getState() throws SQLException{
        s = conn.createStatement();
        return s;
    }
    
    
    void close() throws SQLException{
        s.close();
        conn.close();
    }
    
    
    
}
