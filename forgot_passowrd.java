package pharmacy_stock_management_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class forgot_passowrd extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    //PreparedStatement pst = null;
   
    
    int sno;
   
    public forgot_passowrd() {
        initComponents();
    }
    int getSNO(){
        return sno;
    }
    void setSNO(int y){
        sno = y;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        s_q = new javax.swing.JTextField();
        next_btn = new rojerusan.RSMaterialButtonCircle();
        jLabel7 = new javax.swing.JLabel();
        a_q = new javax.swing.JTextField();
        next_btn1 = new rojerusan.RSMaterialButtonCircle();
        jLabel8 = new javax.swing.JLabel();
        newpass = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        confirmpass = new javax.swing.JTextField();
        next_btn2 = new rojerusan.RSMaterialButtonCircle();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(40, 96, 148));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("user name");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(40, 96, 148));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("security question");
        jLabel3.setOpaque(true);

        next_btn.setBackground(new java.awt.Color(40, 96, 148));
        next_btn.setText("Confirm");
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(40, 96, 148));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ans");
        jLabel7.setOpaque(true);

        next_btn1.setBackground(new java.awt.Color(40, 96, 148));
        next_btn1.setText("search");
        next_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btn1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(40, 96, 148));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("new Password");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(40, 96, 148));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Confirm Password");
        jLabel9.setOpaque(true);

        next_btn2.setBackground(new java.awt.Color(40, 96, 148));
        next_btn2.setText("back");
        next_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(next_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(s_q, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(a_q, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(next_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(next_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(next_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(s_q, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(a_q, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(next_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(next_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 640, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed
        // TODO add your handling code here:
        //int x = getSNO();
        String user= username_txt.getText();
        String security =s_q.getText();
        String ans = a_q.getText();
        String nwpass = newpass.getText();
        String conpass = confirmpass.getText();
        if(user.isEmpty()){
            JOptionPane.showMessageDialog(null, "enter username");
        }
        else if(security.isEmpty()){
            JOptionPane.showMessageDialog(null, "click search button before confirm");
        }
        else if(ans.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter your answer");
        }
        else if (nwpass.isEmpty() || conpass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter new passwoerd ");
        }
        else if (!nwpass.equals(conpass)){
            JOptionPane.showMessageDialog(null, "new password and confirm password is different ");
        }
        else{
            try{
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "root", "Mych0ice@12345");
                String sql = "SELECT * FROM login WHERE ans=?";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    
                    stm.setString(1, ans);

                    ResultSet rs = stm.executeQuery();

                    if (rs.next()) {
                        String sql1 = "UPDATE login SET password=? WHERE username=?";
                        PreparedStatement pst1 = con.prepareStatement(sql1);
                         pst1.setString(1, nwpass);
                         pst1.setString(2, user);
                         pst1.executeUpdate();
                        JOptionPane.showMessageDialog(this, "password update successfully");
                         username_txt.setText("");
                         s_q.setText("");
                         a_q.setText("");
                         newpass.setText("");
                         confirmpass.setText("");
                         this.setVisible(false);
                         new login().setVisible(true);
                         
                    } else {
                        JOptionPane.showMessageDialog(this, "Check your answer");
                    }
                }
        }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        
    }//GEN-LAST:event_next_btnActionPerformed

    private void next_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btn1ActionPerformed
        // TODO add your handling code here:
        try {
            Connection Con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            String sql = "SELECT * FROM login WHERE username= ?";
    
            // Create a PreparedStatement
            try (PreparedStatement statement = Con.prepareStatement(sql)) {
        
                // Set the parameter for the med_id
                String username = username_txt.getText();
                statement.setString(1, username);
        
                // Execute the query
                ResultSet resultSet = statement.executeQuery();
        
                // Check if any results were returned
                if (resultSet.next()) {
                    // Set the values in your text fields based on the retrieved data
                    //id_txt.setText(resultSet.getString("sup_id"));
                    s_q.setText(resultSet.getString("securityq"));
                    //contact_txt.setText(resultSet.getString("sup_contact"));
                    //address_txt.setText(resultSet.getString("sup_address"));
            
                    
                      
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "No data found for the specified med_id.");
                }
            }
    
            // Close the connection
            Con.close();
            
        }
        catch (SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        finally
        {
            menu.DatabaseManager.closeConnection();
        }
    }//GEN-LAST:event_next_btn1ActionPerformed

    private void next_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btn2ActionPerformed
        // TODO add your handling code here:
       this.setVisible(false);
       new login().setVisible(true);
    }//GEN-LAST:event_next_btn2ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(forgot_passowrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgot_passowrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgot_passowrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgot_passowrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgot_passowrd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a_q;
    private javax.swing.JTextField confirmpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField newpass;
    private rojerusan.RSMaterialButtonCircle next_btn;
    private rojerusan.RSMaterialButtonCircle next_btn1;
    private rojerusan.RSMaterialButtonCircle next_btn2;
    private javax.swing.JTextField s_q;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
