package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class CourseAdmission  {
	

JFrame admission = new JFrame("Admissions"); // initialize our frame
JLabel title, RegistratioNbr, FullNames,  ucourse, dbRegistratioNbr, dbFullNames,  dbucourse;
 
public CourseAdmission admissions(String applications) throws ClassNotFoundException {
// initialize the frame and give it some properties
admission.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
admission.setBounds(450, 190, 1000, 600);
admission.setResizable(false);
admission.setLayout(null);
 
// initialize all labels and give them some properties
title = new JLabel(applications + "Admission Status");
title.setBounds(400, 10, 300, 50);
//title.setFont(new Font("sans-serif",Font.PLAIN, 20));
 
RegistratioNbr = new JLabel("Registratio Number");
RegistratioNbr.setBounds(20, 50, 150, 50);
 
FullNames = new JLabel("FullNames");
FullNames.setBounds(200, 50, 100, 50);
ucourse = new JLabel("course");
ucourse.setBounds(450, 50, 100, 50);
 
 
try {
	// connect to database
		String dbURL = "jdbc:mysql://localhost:3306/javasummative";
		String username = "root";
		String password = "";

		Connection conn = null;
	try {
		conn = DriverManager.getConnection(dbURL, username, password);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
// create fetch query to get data from our database
//String queryLast = "SELECT * FROM applications WHERE course='" + course + "'";
String queryLast = "SELECT * FROM applications";
Statement stmt = conn.createStatement();
ResultSet result = stmt.executeQuery(queryLast);
//ResultSet result = statement.executeQuery(queryLast);

int y_coords = 80;
while(result.next()) {
String RegistratioNbr = result.getString("RegistratioNbr");
String FullNames = result.getString("FullNames");
String course1 = result.getString("course");

 
// inserting the data from our database into the labels
dbRegistratioNbr = new JLabel(RegistratioNbr);
dbRegistratioNbr.setBounds(50, y_coords, 100, 50);
 
dbFullNames = new JLabel(FullNames);
dbFullNames.setBounds(200, y_coords, 100, 50);
dbucourse = new JLabel(course1);
dbucourse.setBounds(450, y_coords, 100, 50);
 
// add the labels on the frame
admission.add(dbRegistratioNbr);
admission.add(dbFullNames);
admission.add(dbucourse);
 
System.out.println(RegistratioNbr + " " + FullNames + " "+ course1 ) ;
y_coords += 40;
}
 
}
catch (SQLException ex) {
ex.printStackTrace();
}
// add the labels on the frame
admission.add(title);
admission.add(RegistratioNbr);
admission.add(FullNames);
admission.add(ucourse);
// set the frame to be visible
admission.setVisible(true);
return null;
}


public static void main(String[] args) throws ClassNotFoundException{
    new CourseAdmission().admissions("");

}


public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}
 
 

	