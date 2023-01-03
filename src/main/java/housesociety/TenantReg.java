package housesociety;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;

public class TenantReg extends JPanel implements ActionListener{
    private JLabel heading;
    private JLabel heading2;
    private JLabel h1;
    private JLabel h2;
    private JLabel h3;
    private JTextField jcomp6;
    private JTextField jcomp7;
    private JTextField jcomp8;
    private JLabel jcomp9;
    private JComboBox<String> Combo;
    private JButton reg;
    private JLabel error;
    JFrame frame = new JFrame ("Tenant Register");
    
    public TenantReg() throws Exception {

        heading = new JLabel ("Tenant Registeration form");
        heading2 = new JLabel ("Fill in all the fields");
        h1 = new JLabel ("      Name  :");
        h2 = new JLabel ("Password : ");
        h3 = new JLabel ("        E-mail : ");
        jcomp6 = new JTextField (5);
        jcomp7 = new JTextField (5);
        jcomp8 = new JTextField (5);
        jcomp9 = new JLabel ("Choose Your Area : ");
        Combo = new JComboBox<String>();
        reg = new JButton ("Register");
        error = new JLabel ("  ");
        
        // COMBO BOX
        Statement s = new ConnectToMySQL().getState();
        ResultSet rs = s.executeQuery("SELECT address FROM housingsociety.house;");
        while(rs.next()){
            Combo.addItem(rs.getString("address"));
        }
        
        reg.addActionListener(this);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (341, 430));
        setLayout (null);

        //add components
        add (heading);
        add (heading2);
        add (h1);
        add (h2);
        add (h3);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (Combo);
        add (reg);
        add (error);

        //set component bounds (only needed by Absolute Positioning)
        heading.setBounds (15, 5, 380, 55);
        heading2.setBounds (20, 55, 120, 25);
        h1.setBounds (20, 85, 100, 25);
        h2.setBounds (20, 120, 100, 25);
        h3.setBounds (15, 160, 100, 25);
        jcomp6.setBounds (110, 120, 200, 25);
        jcomp7.setBounds (110, 155, 200, 25);
        jcomp8.setBounds (110, 85, 200, 25);
        jcomp9.setBounds (15, 210, 125, 25);
        Combo.setBounds (140, 205, 170, 30);
        reg.setBounds (100, 260, 135, 45);
        error.setBounds (115, 325, 100, 25);
        
    }
    
    public void start() throws Exception{
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TenantReg());
        frame.setBounds(600, 250, WIDTH, HEIGHT);
        frame.pack();
        frame.setVisible (true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String name = jcomp8.getText();
            String email = jcomp7.getText();
            String address = Combo.getItemAt(Combo.getSelectedIndex());
            String pass = jcomp6.getText();
            int h_id = 0;
            
            System.out.println("Got pass successfully");
            
            Statement s = new ConnectToMySQL().getState();
            ResultSet rs = s.executeQuery("SELECT House_ID FROM housingsociety.house where address = '" + address + "';");
            if(rs.next()){
                h_id = rs.getInt("House_ID");
            }
            System.out.println("found h_id");
            
            s.executeUpdate("INSERT INTO housingsociety.tenant (T_Name,T_Email,House_ID) VALUES ('" + name 
            + "' , '"+ email + "' , " + h_id + ");");
            
            System.out.println("Inserted into tenant");
            s.executeUpdate("Insert into housingsociety.login (Name, Password) values ('"+ name + "' , '"+ pass + "');");
            
            frame.dispose();
            new FirstPage().setVisible(true);       
            
        }
        catch(Exception ex){
            ex.printStackTrace();
            error.setText("Wrong Input!");
        }
    }


}
