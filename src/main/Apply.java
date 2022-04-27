package main;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Apply extends javax.swing.JFrame {

    private static void d(String passowrd_Check, String string) {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    /**
     * Creates new form Login
     */
    public Apply() {
        initComponents();
    }

    public void apply() {
        txtNames.grabFocus();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNames = new javax.swing.JTextField();
        txtMarks = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Full Names");

        jLabel2.setText("Marks");


        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit Application");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jButton2.setForeground(new java.awt.Color(70, 70, 255));
        jButton2.setText("Show Admission status");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setText("Application Form");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtNames, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                        .addComponent(txtMarks)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(38, 38, 38))
        );

        pack();
    }
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
    	
    // if someone clik submit application button 
    	
    	
    	String year = "2022";
      	if (evt.getSource() == jButton1) {
      		
      			// connect to database
  				String dbURL = "jdbc:mysql://localhost:3306/javasummative";
  				String username = "root";
  				String password = "";
  				String tu = txtNames.getText();
  				String tem = txtMarks.getText();
  				Connection conn = DriverManager.getConnection(dbURL, username, password);
  				
  				// course determination according to grades
  				
  				// get grade
  				String course = String.valueOf(txtMarks.getText());
 
  		        // convert marks to int
  		        int gradeInt = Integer.parseInt(course);
  		        
  		        // if mark is between 18 and 20 out of 20
  		        if (gradeInt >= 18) {
  		            // set course to "CS: Computer Science"
  		            course = "CS";
  		        }
  		        // *  If the student’s mark is between 15 and 17 out of 20,
  		        else if (gradeInt >= 15 && gradeInt <= 17) {
  		            // set set course to GC: Global Challenges"
  		        	course = "GC";
  		        }
  		        // If the student’s mark is between 12 and 14 out of 20,
  		        else if (gradeInt >= 12 && gradeInt <= 14) {
  		            // set course to IBT: business studies
  		        	course = "IBT";
  		        }
  		        // if grade is less than 12
  		        else {
  		            // the student will not be considered for admission at ALU.
  		        	course = "Not allowed to ALU";
  		        }
  		        
  		        //Registration number declaration
  		        Random random = new Random();
				int randNbr = random.nextInt(1000);
				String RNumber =year+'/'+randNbr;
  				
  				try {
  					
  					Statement stmt = conn.createStatement();
  					String query = "insert into applications(RegistratioNbr,Fullnames,Marks, Course) values (?, ?, ?, ?)";
  					PreparedStatement preparedStatement = conn.prepareStatement(query);
  					preparedStatement.setString (1, RNumber.toString());
  					preparedStatement.setString(2, tu.toString());
  					preparedStatement.setString (3, tem.toString());
  					preparedStatement.setString   (4, course.toString());
  					int rows = preparedStatement.executeUpdate();
  					
  					jButton1.addActionListener(new ActionListener() {
  				      public void actionPerformed(ActionEvent e) {
  				          JLabel lable23 = new JLabel("Application submitted");
  				          lable23.setLocation(80, 80);
  				          lable23.setSize(250, 30);
  				          lable23.setOpaque(true);
  				          lable23.setBackground(Color.yellow);
  				          add(lable23);
  				          validate();
  				          repaint();
  				          System.out.println("Submited successfull");
  		
  						}
  					});
  	
    } finally {
		conn.close();
    	
    }
    }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	

    	if(evt.getSource()== jButton2) {
    		CourseAdmission frame;
			try {
				frame = new CourseAdmission().admissions("");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

    	}

    }

   
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Apply().setVisible(true);

            }

        }
        );

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNames;
    private javax.swing.JTextField txtMarks;
    // End of variables declaration                   

    private Object getIntent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

