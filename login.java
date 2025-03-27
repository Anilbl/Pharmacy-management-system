
package pharmacy_stock_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {

    
    public login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMetroTextPlaceHolderBeanInfo1 = new rojerusan.RSMetroTextPlaceHolderBeanInfo();
        rSPanelImageBeanInfo1 = new rojerusan.RSPanelImageBeanInfo();
        rSPanelImageBeanInfo2 = new rojerusan.RSPanelImageBeanInfo();
        roboto1 = new efectos.Roboto();
        rSLabelVerticalDBeanInfo1 = new rojerusan.RSLabelVerticalDBeanInfo();
        rSPopuMenu1 = new rojeru_san.complementos.RSPopuMenu();
        jPanel1 = new javax.swing.JPanel();
        password_container = new rojerusan.RSPasswordTextPlaceHolder();
        username_txtfield = new app.bolivia.swing.JCTextField();
        login_btn = new rojerusan.RSMaterialButtonCircle();
        forgot_pass_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        show_btn = new javax.swing.JCheckBox();
        signup_btn = new rojerusan.RSMaterialButtonRectangle();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password_container.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_containerActionPerformed(evt);
            }
        });
        jPanel1.add(password_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        username_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_txtfieldActionPerformed(evt);
            }
        });
        jPanel1.add(username_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        login_btn.setBackground(new java.awt.Color(0, 153, 153));
        login_btn.setText("login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        jPanel1.add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 350, 44));

        forgot_pass_btn.setText("forgot password");
        forgot_pass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgot_pass_btnActionPerformed(evt);
            }
        });
        jPanel1.add(forgot_pass_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Password");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 130, 32));

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("User Name");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, 32));

        show_btn.setBackground(new java.awt.Color(255, 255, 255));
        show_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_btnActionPerformed(evt);
            }
        });
        jPanel1.add(show_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, 20));

        signup_btn.setBackground(new java.awt.Color(0, 153, 153));
        signup_btn.setText("sign up");
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        jPanel1.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 130, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\buttons\\lol\\Free Vector _ Medical design poster with original medicinal capsule consisting of green and blue parts and leaves as a life symbol illustration.jpg")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void show_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_btnActionPerformed

        if(show_btn.isSelected()){
            password_container.setEchoChar((char)0);
        }
        else{
            password_container.setEchoChar('*');
        } 
    }//GEN-LAST:event_show_btnActionPerformed

    private void forgot_pass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgot_pass_btnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        forgot_passowrd form = new forgot_passowrd();
        form.setVisible(true);
    }//GEN-LAST:event_forgot_pass_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        // TODO add your handling code here:
        String username = username_txtfield.getText();
        String password = new String(password_container.getPassword());

        try {
            if(username.isEmpty() && password.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill username and password");
            }
            else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill username ");
            }
            else if(password.isEmpty()){
                JOptionPane.showMessageDialog(this, "Fill Password box please");
            }

            else {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "root", "Mych0ice@12345");
                String sql = "SELECT * FROM login WHERE username=? AND password=?";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, username);
                    stm.setString(2, password);

                    ResultSet rs = stm.executeQuery();

                    if (rs.next()) {
                        new User().setusername(username);
                        dispose();
                        menu dboard = new menu();
                        dboard.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "check username and password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred. Check console for details.");
        }
    }//GEN-LAST:event_login_btnActionPerformed

    private void username_txtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_txtfieldActionPerformed

    }//GEN-LAST:event_username_txtfieldActionPerformed

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        signup form = new signup();
        form.setVisible(true);
        
        
    }//GEN-LAST:event_signup_btnActionPerformed

    private void password_containerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_containerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_containerActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgot_pass_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSMaterialButtonCircle login_btn;
    private rojerusan.RSPasswordTextPlaceHolder password_container;
    private rojerusan.RSLabelVerticalDBeanInfo rSLabelVerticalDBeanInfo1;
    private rojerusan.RSMetroTextPlaceHolderBeanInfo rSMetroTextPlaceHolderBeanInfo1;
    private rojerusan.RSPanelImageBeanInfo rSPanelImageBeanInfo1;
    private rojerusan.RSPanelImageBeanInfo rSPanelImageBeanInfo2;
    private rojeru_san.complementos.RSPopuMenu rSPopuMenu1;
    private efectos.Roboto roboto1;
    private javax.swing.JCheckBox show_btn;
    private rojerusan.RSMaterialButtonRectangle signup_btn;
    private app.bolivia.swing.JCTextField username_txtfield;
    // End of variables declaration//GEN-END:variables
}
