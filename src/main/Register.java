
package main;
/**
*
* @author Lievin
*/

// imports of required libraries
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;


public class Register extends javax.swing.JPanel {

    /**
     * Creates new form Register(Sign up)
     */
    public Register() {
        initComponents();
    }

    public void register() {
        txtUser.grabFocus();
    }

    public void addEventBackLogin(ActionListener event) {
        cmdBackLogin.addActionListener(event);
    }

    
    @SuppressWarnings("unchecked")
    // initialising frame components
    private void initComponents() {

        txtUser = new swing.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new swing.MyPassword();
        jLabel3 = new javax.swing.JLabel();
        SignUp = new swing.MyButton();
        cmdBackLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPass1 = new swing.MyPassword();
        txtEmail = new swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("FullNames");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(69, 68, 68));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register");
        jLabel3.setText("Password");
        
        // signup button

        SignUp.setBackground(new java.awt.Color(125, 229, 251));
        SignUp.setForeground(new java.awt.Color(40, 40, 40));
        SignUp.setText("Sign Up");
        SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					SignUpActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        //back to login button

        cmdBackLogin.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        cmdBackLogin.setForeground(new java.awt.Color(30, 122, 236));
        cmdBackLogin.setText("Back to Login");
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setText("Confirm Password");

        jLabel5.setText("Email");
        
        // size and location setting of frame components

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(txtPass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(cmdBackLogin)
                .addGap(30, 30, 30))
        );
    }
    // event listern when you click sign up

    private void SignUpActionPerformed(java.awt.event.ActionEvent e) throws SQLException {
    	
    	
    	
    	if (e.getSource() == SignUp) {
    		
    		//connect to database
	
				String dbURL = "jdbc:mysql://localhost:3306/javasummative";
				String username = "root";
				String password = "";
				String tu = txtUser.getText();
				String tem = txtPass.getText();
				String email = txtEmail.getText();
				Connection conn = DriverManager.getConnection(dbURL, username, password);
				
				Random random = new Random();
				String year = "2022";
				int randNbr = random.nextInt(1000);
				String RNumber =year+'/'+randNbr;

				//insert data into database
				try {
					
					Statement stmt = conn.createStatement();
					String query = "insert into signup(RegistrationNbr, Fullnames, Email, Password) values (?,?, ?, ?)";
					PreparedStatement preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString (1, RNumber.toString());
					preparedStatement.setString(2, tu.toString());
					preparedStatement.setString   (3, email.toString());
					preparedStatement.setString (4, tem.toString());
					int rows = preparedStatement.executeUpdate();
					if (rows > 0) {
						JOptionPane.showMessageDialog(this,
				                "You have successfully signed up",
				                "",
				                JOptionPane.INFORMATION_MESSAGE);
						return;

					}	

				    				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					conn.close();
					
				}
			} else {
				JOptionPane.showMessageDialog(this,
		                "fail to signed up",
		                "",
		                JOptionPane.INFORMATION_MESSAGE);
				return;

			}
	}
			
	//GEN-LAST:event_SignUpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBackLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private swing.MyButton SignUp;
    private swing.MyPassword txtPass;
    private swing.MyPassword txtPass1;
    private swing.MyTextField txtUser;
    private swing.MyTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
