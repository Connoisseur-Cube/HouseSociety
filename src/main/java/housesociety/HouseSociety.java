package housesociety;

import java.sql.*;



public class HouseSociety {

    public static void main(String[] args) {
        
        try {
            ConnectToMySQL instance = new ConnectToMySQL();
            
            Statement s = instance.getState();
            ResultSet rs = s.executeQuery("Select * from tenant;");
            
            while(rs.next()){
                System.out.println(rs.getInt("T_ID"));
                System.out.println(rs.getString("T_Name"));
                System.out.println(rs.getString("T_Email"));
                System.out.println(rs.getInt("House_ID"));
            }
            
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        

    }
}
