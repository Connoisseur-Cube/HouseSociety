
package housesociety;

import java.awt.GridLayout;
import java.sql.*;
import javax.swing.*;

public class TenantDashboard {

    TenantDashboard(String user) throws Exception{
        
            String Email ="";
            int house_id = -1;
            String address = "";
            int area = 0;
            int rent = 0;
            
            Statement s = new ConnectToMySQL().getState();
            ResultSet rs = s.executeQuery("Select * from housingsociety.tenant where T_Name = '"+ user +"';");
            while(rs.next()){
                Email = rs.getString("T_Email");
                house_id = rs.getInt("House_ID");
            }
            rs = s.executeQuery("Select * from housingsociety.house where House_ID = "+ house_id + ";");
            while(rs.next()){
                address = rs.getString("address");
                area = rs.getInt("area");
                rent = rs.getInt("rent");
            }
            s.close();
            
            //UI 
            JFrame frame = new JFrame("Tenant: "+user);
            JLabel n = new JLabel(" Name:  "+ user);
            JLabel e = new JLabel("E-mail: "+ Email);
            JLabel a = new JLabel("Address: "+address);
            JLabel ar = new JLabel("Total area = : "+area + " sq. foot");
            JLabel re = new JLabel("Address: "+rent+" USD");
            frame.add(n);
            frame.add(e);
            frame.add(a);
            frame.add(ar);
            frame.add(re);
            frame.setLayout(new GridLayout(3,2));
            frame.setBounds(600,250,300,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            
        
    }
    
}
