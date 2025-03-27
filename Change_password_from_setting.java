package pharmacy_stock_management_system;
import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Change_password_from_setting extends javax.swing.JFrame {
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String passwordpattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$";


    public Change_password_from_setting() {
        initComponents();
    }
    class DatabaseManager {
    private static java.sql.Connection connection;

    public static java.sql.Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }
   
   }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        show_pass_btn = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        change_btn = new rojerusan.RSMaterialButtonRectangle();
        jLabel3 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        old_pass_txtfield = new javax.swing.JPasswordField();
        new_pass_txtfield = new javax.swing.JPasswordField();
        confirm_pass_txtfield = new javax.swing.JPasswordField();
        username_txtfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Password");
        jLabel1.setOpaque(true);

        show_pass_btn.setText("show");
        show_pass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_pass_btnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Confirm Password");
        jLabel2.setOpaque(true);

        change_btn.setBackground(new java.awt.Color(0, 102, 102));
        change_btn.setText("Confirm");
        change_btn.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        change_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_btnActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Old password");
        jLabel3.setOpaque(true);

        back_btn.setText("BACK");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("User name");
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confirm_pass_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(new_pass_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(change_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(username_txtfield, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(old_pass_txtfield))
                                .addGap(18, 18, 18)
                                .addComponent(show_pass_btn)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_btn)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show_pass_btn)
                    .addComponent(old_pass_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirm_pass_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(change_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(new_pass_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void show_pass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_pass_btnActionPerformed
        // TODO add your handling code here:
        
        if(show_pass_btn.isSelected()){
            old_pass_txtfield.setEchoChar((char)0);
            new_pass_txtfield.setEchoChar((char)0);
            confirm_pass_txtfield.setEchoChar((char)0);
        }
        else{
           old_pass_txtfield.setEchoChar('*');
           new_pass_txtfield.setEchoChar('*');
           confirm_pass_txtfield.setEchoChar('*');
                  
        } 
    }//GEN-LAST:event_show_pass_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_back_btnActionPerformed

    private void change_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_btnActionPerformed
        // TODO add your handling code here:
    String name = username_txtfield.getText();
    String oldpass = old_pass_txtfield.getText();
    String newpass = new_pass_txtfield.getText();
    String confirm = confirm_pass_txtfield.getText();
    if(name.isEmpty() && oldpass.isEmpty() && newpass.isEmpty() && confirm.isEmpty())
    {
        JOptionPane.showMessageDialog(null, "fill all the box please");
    }
    
    else if(name.isEmpty())
    {
        JOptionPane.showMessageDialog(null, "fill name textbox please");
    }
    else if (oldpass.isEmpty()){
        JOptionPane.showMessageDialog(null,"fill old pass box to");
    }
    else if(newpass.isEmpty()){
        JOptionPane.showMessageDialog(null, "fill new password box button");
    }
    else if(confirm.isEmpty()){
        JOptionPane.showMessageDialog(null, "fill confirm box");
    }
    else if (!newpass.matches(passwordpattern) ){
            JOptionPane.showMessageDialog(null, "use strong password");
        }
    else if(!newpass.equals(confirm)){
        JOptionPane.showMessageDialog(null, "new password and confirm password are different");
    }
    
    
    else{  
        try {
    Connection Con = (Connection) DatabaseManager.getConnection();

    String sql = "SELECT * FROM login WHERE username=? AND password=?";
    try (PreparedStatement stm = Con.prepareStatement(sql)) {
        stm.setString(1, name);
        stm.setString(2, oldpass);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // Get the new password from the new_pass_txtfield
            String newPassword = new_pass_txtfield.getText();

            // Update the password in the med_category table
            String query = "UPDATE login SET password=? WHERE username=?";
            try (PreparedStatement pst = Con.prepareStatement(query)) {
                pst.setString(1, newPassword);
                pst.setString(2, name);
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Password updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update password");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Check username and old password");
        }
    }
    username_txtfield.setText("");
    old_pass_txtfield.setText("");
    new_pass_txtfield.setText("");
    confirm_pass_txtfield.setText("");
    Con.close();

    }
    catch (SQLException | HeadlessException | NumberFormatException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
       
    }//GEN-LAST:event_change_btnActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_password_from_setting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private rojerusan.RSMaterialButtonRectangle change_btn;
    private javax.swing.JPasswordField confirm_pass_txtfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField new_pass_txtfield;
    private javax.swing.JPasswordField old_pass_txtfield;
    private javax.swing.JCheckBox show_pass_btn;
    private javax.swing.JTextField username_txtfield;
    // End of variables declaration//GEN-END:variables
}
