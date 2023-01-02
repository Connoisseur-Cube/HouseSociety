package housesociety;

import java.sql.*;

public class HouseSociety {

//------------------------------------------------------------------------------    
    
    public static void main(String[] args) {
        
        try {
            ConnectToMySQL instance = new ConnectToMySQL();
            
        }           
        catch (Exception ex) {
            ex.getStackTrace();
        }  
        FirstPage obj = new FirstPage();
        obj.setVisible(true);
    }
//------------------------------------------------------------------------------
    
    
       
}
