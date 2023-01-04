package housesociety;

import java.sql.*;
import java.util.ArrayList;

public class ConnectToMySQL {

    
/*----------------------------------------------------------------------------------------
    Ismail here. I turned connection and statement into static because I do not want more instances of these.
    So even if we create a new instance of the clase, The connection and statement simply get overrided, or "Re-connected"
    Piling up multiple instances of these is something we should avoid.
    We can create an instance of this class anywhere without the worry of duplication.
    I also do not see a reason to have multiple instances of strings that do not change
-----------------------------------------------------------------------------------------    */    
    
    private final static String user = "root";
    private final static String password = "1234";
    private final static String url = "jdbc:mysql://localhost:3306/HousingSociety?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static Connection conn;
    private static Statement s;
     
    // Connect to the database and return statement
    Statement getState() throws SQLException{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");  
        conn = DriverManager.getConnection(url,user,password);
        }
        catch(ClassNotFoundException | SQLException e){
         e.printStackTrace();
        }
        s = conn.createStatement();
        return s;
    }
    
    // This function will close the connection made by the getState() function
    void close() throws SQLException{
        s.close();
        conn.close();
    }
    
    public static String[][] ResultSetToData(ResultSet rs) throws SQLException{
	int colCount = rs.getMetaData().getColumnCount();
	ArrayList<String[]> list = new ArrayList<String[]>();
	while (rs.next()) {
		String[] row = new String[colCount];
		for (int i = 1; i <= colCount; i++) {
			row[i - 1] = rs.getString(i);
		}
		list.add(row);
	}
	String[][] array = new String[list.size()][colCount];
	list.toArray(array);
	return array;
}
    
    
}
