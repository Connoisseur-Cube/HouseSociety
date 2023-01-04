
package housesociety;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Code to Output tables in another window

public class TableOutput implements ActionListener {

    public static JFrame frame;
    
     TableOutput(String[] columnNames, String[][] data){
         
        // Setting Window
        frame = new JFrame("Output Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600,250,400,200);
        frame.setLayout(new BorderLayout());
        
        // Setting Table
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Setting Ok button
        JButton ok = new JButton("OK");
        ok.addActionListener(this);
        
        frame.add(scrollPane, BorderLayout.CENTER);        
        frame.add(ok,BorderLayout.SOUTH);        
        frame.setVisible(true);
            
    }
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
    }
}
