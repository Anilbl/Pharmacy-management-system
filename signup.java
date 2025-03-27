package pharmacy_stock_management_system;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class signup extends javax.swing.JFrame {
     int sno;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
   // public String mobilenopattern = "^[0-9]*$";
    public String passwordpattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$";
    public signup() {
        initComponents();
    }
    
    int getSNO(){
        return sno;
    }
    
    void setSNO(int x){
        sno = x;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelVerticalDBeanInfo1 = new rojerusan.RSLabelVerticalDBeanInfo();
        swingTimerTimingSource1 = new org.jdesktop.swing.animation.timing.sources.SwingTimerTimingSource();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        password_txtfield = new javax.swing.JPasswordField();
        username_txtfield2 = new javax.swing.JTextField();
        show_hide_btn = new javax.swing.JCheckBox();
        next = new rojerusan.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        username_txtfield3 = new app.bolivia.swing.JCTextField();
        new_pass = new javax.swing.JPasswordField();
        confirm_pass = new javax.swing.JPasswordField();
        signup = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        showbtn = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        email_txtfield = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        s_q = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        q_s = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(680, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(40, 96, 148));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("default password");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 131, 31));

        jLabel4.setBackground(new java.awt.Color(40, 96, 148));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("username");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 51, 131, 31));
        jPanel1.add(password_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 98, 235, 30));
        jPanel1.add(username_txtfield2, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 51, 235, 31));

        show_hide_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_hide_btnActionPerformed(evt);
            }
        });
        jPanel1.add(show_hide_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 100, -1, 32));

        next.setBackground(new java.awt.Color(40, 96, 148));
        next.setText("next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel1.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 410, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("already have an account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 20));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(40, 96, 148));
        rSMaterialButtonCircle2.setText("login");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 410, 40));

        jTabbedPane1.addTab("tab1", jPanel1);

        signup.setBackground(new java.awt.Color(40, 96, 148));
        signup.setText("signup");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(40, 96, 148));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("user name");
        jLabel2.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(40, 96, 148));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("new password");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(40, 96, 148));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("confirm password");
        jLabel6.setOpaque(true);

        showbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showbtnActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(40, 96, 148));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("email");
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(40, 96, 148));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("security question");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(40, 96, 148));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("answer");
        jLabel9.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(username_txtfield3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showbtn))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(confirm_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(q_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(s_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_txtfield3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -42, 680, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void show_hide_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_hide_btnActionPerformed
        // TODO add your handling code here:
        if (show_hide_btn.isSelected()) {
            password_txtfield.setEchoChar((char) 0);
        } else {
            password_txtfield.setEchoChar('*');
        }
    }//GEN-LAST:event_show_hide_btnActionPerformed
    
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        String username = username_txtfield2.getText();
        String password = new String(password_txtfield.getPassword());
        setSNO(Integer.parseInt(username));
        try {
            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill username and password");
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill username ");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill Password box please");
            }
            
            else {
                Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "root", "Mych0ice@12345");
                String sql = "SELECT * FROM login WHERE username=? AND password=?";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, username);
                    stm.setString(2, password);

                    ResultSet rs = stm.executeQuery();

                    if (rs.next()) {
                        jTabbedPane1.setSelectedIndex(1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Check username and password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred. Check console for details.");
        }
    }//GEN-LAST:event_nextActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        login form = new login();
        form.setVisible(true);

    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        // TODO add your handling code here:
        int x = getSNO();
        String name = username_txtfield3.getText();
        String newpass = new_pass.getText();
        String confirm = confirm_pass.getText();
        String email = email_txtfield.getText();
        String securityq =s_q.getText();
        String securityans = q_s.getText();
        if(name.isEmpty()){
         JOptionPane.showMessageDialog(null, "Username field can not be empty");
        }
        else if (newpass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "new password box is empty");
            return;
        } else if (confirm.isEmpty()) {
            JOptionPane.showMessageDialog(null, "confirm password box is empty");
            return;
        } else if (newpass.isEmpty() && confirm.isEmpty()) {
            JOptionPane.showMessageDialog(null, "fill all box");
            return;
        } else if (!newpass.equals(confirm)) {
            JOptionPane.showMessageDialog(null, "new password and confirm password are different");
            return;
        }
        else if (!newpass.matches(passwordpattern) ){
            JOptionPane.showMessageDialog(null, " use strong password");
        }
        else if (!email.matches(emailPattern) ){
            JOptionPane.showMessageDialog(null, "invalid email");
        }
        else if(securityq.isEmpty() || securityans.isEmpty()){
            JOptionPane.showMessageDialog(null, "fill security question and ans");
        }
        else
        {
            Connection Con = (Connection) Change_password_from_setting.DatabaseManager.getConnection();      
            String sql = "SELECT * FROM login WHERE username=? ";
            try (PreparedStatement stm = Con.prepareStatement(sql)) {
                stm.setString(1, name);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username is already taken. Please choose another one.");
                    return;
                }
                //System.out.print("OK4");
                if ( !rs.next()) {
                    //System.out.print("OK3");
                    // Get the new password from the new_pass_txtfield

                    // Update the password in the med_category table
                    try  {
//                        Connection Cn = (Connection) Change_password_from_setting.DatabaseManager.getConnection();
                        String query = "UPDATE login SET username=?, password=?, email=? WHERE sno=?";
                        PreparedStatement pst = Con.prepareStatement(query);
                        pst.setString(1, name);
                        pst.setString(2, newpass);
                        pst.setString(3, email);
                        pst.setInt(4, x);
                        
                        int rowsAffected = pst.executeUpdate();
                        if (rowsAffected > 0) {
                          //  System.out.print("OK2");
                            JOptionPane.showMessageDialog(null, "user name and password updated successfully");
                            setVisible(false);
                            login form = new login();
                            form.setVisible(true);
                        } else {
                          //  System.out.print("OK1");
                            JOptionPane.showMessageDialog(null, "Failed to update password");
                        }
                        pst.close();
                        
                    } catch (SQLException | HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
                rs.close();
                stm.close();
                Con.close();
            } catch (SQLException | HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e);
            
        }
        }


    }//GEN-LAST:event_signupActionPerformed

    private void showbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showbtnActionPerformed
        // TODO add your handling code here:
        if (showbtn.isSelected()) {
            new_pass.setEchoChar((char) 0);
            confirm_pass.setEchoChar((char) 0);
        } else {
            new_pass.setEchoChar('*');
            confirm_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_showbtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirm_pass;
    private app.bolivia.swing.JCTextField email_txtfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField new_pass;
    private rojerusan.RSMaterialButtonCircle next;
    private javax.swing.JPasswordField password_txtfield;
    private app.bolivia.swing.JCTextField q_s;
    private rojerusan.RSLabelVerticalDBeanInfo rSLabelVerticalDBeanInfo1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField s_q;
    private javax.swing.JCheckBox show_hide_btn;
    private javax.swing.JCheckBox showbtn;
    private rojerusan.RSMaterialButtonCircle signup;
    private org.jdesktop.swing.animation.timing.sources.SwingTimerTimingSource swingTimerTimingSource1;
    private javax.swing.JTextField username_txtfield2;
    private app.bolivia.swing.JCTextField username_txtfield3;
    // End of variables declaration//GEN-END:variables
}
