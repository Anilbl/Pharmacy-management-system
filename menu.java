package pharmacy_stock_management_system;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class menu extends javax.swing.JFrame {

    public String mobilenopattern = "^[0-9]*$";
    public String pattern = "^[a-zA-Z]+$";

    public void add_fill_table() {
        try {
            Connection Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            DefaultTableModel model = (DefaultTableModel) med_table.getModel();

            model.setRowCount(0);

            Statement st = Con2.createStatement();

            ResultSet rs5 = st.executeQuery("SELECT * FROM med_category");
            ResultSetMetaData rsmd = (ResultSetMetaData) rs5.getMetaData();
            DefaultTableModel model5 = (DefaultTableModel) med_table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                model5.setColumnIdentifiers(colName);
                String id, name, amount, price, expire_date, manufacture_date, category;
                while (rs5.next()) {
                    id = rs5.getString(1);
                    name = rs5.getString(2);
                    amount = rs5.getString(3);
                    price = rs5.getString(4);
                    expire_date = rs5.getString(5);
                    manufacture_date = rs5.getString(6);
                    category = rs5.getString(7);
                    String[] row = {id, name, amount, price, expire_date, manufacture_date, category};
                    model.addRow(row);
                }

            }

            st.close();
            Con2.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
        }
    }

    public menu() {
        initComponents();

        add_fill_table();
        low_stocks_table();
        supplier_tbl();
        expiry_detail();
        expire_in_six();
        sales_detail();
        // private float total =0;
    }

    public void clearinputs() {
        med_id_txtfield1.setText("");
        med_name_txtfield.setText("");
        med_amount_txtfield.setText("");
        med_price_txtfield.setText("");
        med_expired_date2.setDate(null);
        med_manufact_date.setDate(null);
    }

    public void clear_txtfield() {
        billing_id.setText("");
        billing_amount.setText("");
    }

    public void clear_table_billing() {
        DefaultTableModel model7 = (DefaultTableModel) billing_tbl.getModel();

        model7.setRowCount(0);
    }

    public void sales_detail() {

        try {
            try (Connection Con6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345")) {
                String query = "SELECT med_id, med_name, amount, med_price, total_price, med_expire_date, med_sale_date FROM med_sale";
                Statement st6 = Con6.createStatement();
                ResultSet rs6 = st6.executeQuery(query);

                DefaultTableModel model6 = (DefaultTableModel) sales_tbl.getModel();
                model6.setRowCount(0);

                ResultSetMetaData rsmd6 = (ResultSetMetaData) rs6.getMetaData();
                int cols6 = rsmd6.getColumnCount();
                String[] colName6 = new String[cols6];
                for (int j = 0; j < cols6; j++) {
                    colName6[j] = rsmd6.getColumnName(j + 1);
                }
                model6.setColumnIdentifiers(colName6);
                while (rs6.next()) {
                    String id = rs6.getString(1);
                    String name = rs6.getString(2);
                    String amount = rs6.getString(3);
                    String price = rs6.getString(4);
                    String total = rs6.getString(5);
                    String expire_date = rs6.getString(6);
                    String sale_date = rs6.getString(7);
                    String[] row6 = {id, name, amount, price, total, expire_date, sale_date};
                    model6.addRow(row6);
                }
                Con6.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void supplier_tbl() {
        try {
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");

            DefaultTableModel model3 = (DefaultTableModel) supplier_tbl.getModel();

            model3.setRowCount(0);
            Statement st2 = Con.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT * FROM med_supplier ");

            ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
            DefaultTableModel model2 = (DefaultTableModel) supplier_tbl.getModel();

            int cols2 = rsmd2.getColumnCount();
            String[] colName3 = new String[cols2];
            for (int k = 0; k < cols2; k++) {
                colName3[k] = rsmd2.getColumnName(k + 1);
                model2.setColumnIdentifiers(colName3);
                String sup_id, sup_name, sup_contact, address;
                while (rs2.next()) {
                    sup_id = rs2.getString(1);
                    sup_name = rs2.getString(2);
                    sup_contact = rs2.getString(3);
                    address = rs2.getString(4);

                    String[] row2 = {sup_id, sup_name, sup_contact, address};
                    model2.addRow(row2);
                }
            }
        } catch (SQLException ex2) {
            ex2.printStackTrace();
        }
    }

    public void low_stocks_table() {

        try {
            Connection Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            DefaultTableModel model2 = (DefaultTableModel) low_stock_tbl.getModel();

            model2.setRowCount(0);
            Statement st1 = Con2.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM med_category where med_amount<100");
            ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
            DefaultTableModel model1 = (DefaultTableModel) low_stock_tbl.getModel();

            int cols1 = rsmd1.getColumnCount();
            String[] colName2 = new String[cols1];
            for (int j = 0; j < cols1; j++) {
                colName2[j] = rsmd1.getColumnName(j + 1);
                model1.setColumnIdentifiers(colName2);
                String med_id, med_name, med_amount, med_price, med_expire_date, med_manufactured_date, category;
                while (rs1.next()) {
                    med_id = rs1.getString(1);
                    med_name = rs1.getString(2);
                    med_amount = rs1.getString(3);
                    med_price = rs1.getString(4);
                    med_expire_date = rs1.getString(5);
                    med_manufactured_date = rs1.getString(6);
                    category = rs1.getString(7);
                    String[] row1 = {med_id, med_name, med_amount, med_price, med_expire_date, med_manufactured_date, category};
                    model1.addRow(row1);
                }
            }
            Con2.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void expiry_detail() {

        try {
            try (Connection Con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345")) {
                java.util.Date currentDate = new java.util.Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                calendar.add(Calendar.MONTH, 6);
                String query = "SELECT * FROM med_category WHERE med_expired_date < CURDATE()";
                Statement st5 = Con4.createStatement();
                ResultSet rs5 = st5.executeQuery(query);
                // Assuming that 'expired_or_in_6month' is a JTable
                DefaultTableModel model5 = (DefaultTableModel) expired_or_in_6month.getModel();
                model5.setRowCount(0);

                ResultSetMetaData rsmd5 = (ResultSetMetaData) rs5.getMetaData();
                int cols4 = rsmd5.getColumnCount();
                String[] colName5 = new String[cols4];
                // Set column names
                for (int j = 0; j < cols4; j++) {
                    colName5[j] = rsmd5.getColumnName(j + 1);
                }
                model5.setColumnIdentifiers(colName5);
                // Fetch and display rows
                while (rs5.next()) {
                    String med_id = rs5.getString(1);
                    String med_name = rs5.getString(2);
                    String med_amount = rs5.getString(3);
                    String med_price = rs5.getString(4);
                    String med_expire_date = rs5.getString(5);
                    String med_manufactured_date = rs5.getString(6);
                    String category = rs5.getString(7);
                    String[] row4 = {med_id, med_name, med_amount, med_price, med_expire_date, med_manufactured_date, category};
                    model5.addRow(row4);
                }
                Con4.close();
                // Close the connection when done
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void expire_in_six() {
        try {
            try (Connection Con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345")) {
                java.util.Date currentDate = new java.util.Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                calendar.add(Calendar.MONTH, 6);
                String query = "SELECT * FROM med_category WHERE med_expired_date > CURDATE() AND med_expired_date <= DATE_ADD(CURDATE(), INTERVAL 6 MONTH);";
                Statement st4 = Con1.createStatement();
                ResultSet rs4 = st4.executeQuery(query);
                // Assuming that 'six_month_expired' is a JTable
                DefaultTableModel model4 = (DefaultTableModel) six_month_expired.getModel();
                model4.setRowCount(0);

                ResultSetMetaData rsmd4 = (ResultSetMetaData) rs4.getMetaData();
                int cols4 = rsmd4.getColumnCount();
                String[] colName4 = new String[cols4];
                // Set column names
                for (int j = 0; j < cols4; j++) {
                    colName4[j] = rsmd4.getColumnName(j + 1);
                }
                model4.setColumnIdentifiers(colName4);
                // Fetch and display rows
                while (rs4.next()) {
                    String med_id = rs4.getString("med_id");
                    String med_name = rs4.getString("med_name");
                    String med_amount = rs4.getString("med_amount");
                    String med_price = rs4.getString("med_price");
                    String med_expire_date = rs4.getString("med_expired_date");
                    String med_manufactured_date = rs4.getString("med_manufact_date");
                    String category = rs4.getString("category");
                    String[] row4 = {med_id, med_name, med_amount, med_price, med_expire_date, med_manufactured_date, category};
                    model4.addRow(row4);
                }
                // Close the connection when done
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void fill_med_table() {
        try {
            Connection Con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            Statement st7 = Con5.createStatement();

            DefaultTableModel model = (DefaultTableModel) med_table.getModel();

            model.setRowCount(0);

            ResultSet rs = st7.executeQuery("SELECT * FROM med_category");
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colName);
                String med_id, med_name, med_amount, med_price, med_expire_date, med_manufactured_date, category;
                while (rs.next()) {
                    med_id = rs.getString(1);
                    med_name = rs.getString(2);
                    med_amount = rs.getString(3);
                    med_price = rs.getString(4);
                    med_expire_date = rs.getString(5);
                    med_manufactured_date = rs.getString(6);
                    category = rs.getString(7);
                    String[] row = {med_id, med_name, med_amount, med_price, med_expire_date, med_manufactured_date, category};
                    model.addRow(row);
                }

            }

            st7.close();
            Con5.close();

        } catch (Exception ex1) {

        }
    }

    public void clearinputs1() {
        id_txt.setText("");
        supname_txt.setText("");
        contact_txt.setText("");
        address_txt.setText("");
    }

    class DatabaseManager {

        private static Connection connection;

        public static Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
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

        jPanel5 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Homepage_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sales_tbl = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        expired_or_in_6month = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        six_month_expired = new javax.swing.JTable();
        billing_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        billing_tbl = new javax.swing.JTable();
        billing_amount = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        add_to_cart = new rojerusan.RSMaterialButtonCircle();
        billing_id = new app.bolivia.swing.JCTextField();
        clear_table = new rojerusan.RSMaterialButtonCircle();
        totalamt = new javax.swing.JLabel();
        add_to_cart1 = new rojerusan.RSMaterialButtonCircle();
        lowstocks_panel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        low_stock_tbl = new javax.swing.JTable();
        med_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        med_table = new javax.swing.JTable();
        update_btn = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        med_amount_txtfield = new app.bolivia.swing.JCTextField();
        med_price_txtfield = new app.bolivia.swing.JCTextField();
        med_name_txtfield = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        med_id_txtfield1 = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        med_manufact_date = new com.toedter.calendar.JDateChooser();
        med_delete_btn = new rojerusan.RSMaterialButtonRectangle();
        jLabel6 = new javax.swing.JLabel();
        med_expired_date2 = new com.toedter.calendar.JDateChooser();
        search_btn = new rojerusan.RSMaterialButtonCircle();
        med_add_btn1 = new rojerusan.RSMaterialButtonRectangle();
        txtcategory = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        suuplier_panel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        supplier_tbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        delete_btn = new rojerusan.RSMaterialButtonCircle();
        id_txt = new app.bolivia.swing.JCTextField();
        supname_txt = new app.bolivia.swing.JCTextField();
        contact_txt = new app.bolivia.swing.JCTextField();
        address_txt = new app.bolivia.swing.JCTextField();
        supplier_add_btn = new rojerusan.RSMaterialButtonCircle();
        supplier_search_btn = new rojerusan.RSMaterialButtonCircle();
        btns_panel = new javax.swing.JPanel();
        homepage_btn = new rojerusan.RSMaterialButtonRectangle();
        Low_Stocks_btn = new rojerusan.RSMaterialButtonRectangle();
        medicine_btn = new rojerusan.RSMaterialButtonRectangle();
        Supplier_btn = new rojerusan.RSMaterialButtonRectangle();
        Billing_btn = new rojerusan.RSMaterialButtonRectangle();
        logout_btn = new javax.swing.JButton();
        change_pass_btn = new javax.swing.JButton();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jCTextField1 = new app.bolivia.swing.JCTextField();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1600, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1616, 1050));

        Homepage_panel.setAlignmentX(0.0F);
        Homepage_panel.setAlignmentY(0.0F);
        Homepage_panel.setPreferredSize(new java.awt.Dimension(1110, 720));
        Homepage_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sales_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sales_tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(sales_tbl);
        if (sales_tbl.getColumnModel().getColumnCount() > 0) {
            sales_tbl.getColumnModel().getColumn(0).setResizable(false);
        }

        Homepage_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 1230, 320));

        expired_or_in_6month.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expiry details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(expired_or_in_6month);
        if (expired_or_in_6month.getColumnModel().getColumnCount() > 0) {
            expired_or_in_6month.getColumnModel().getColumn(0).setResizable(false);
        }

        Homepage_panel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 560, 290));

        jLabel13.setBackground(new java.awt.Color(0, 153, 153));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Expired in 6 months Medicines");
        jLabel13.setOpaque(true);
        Homepage_panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 540, 50));

        jLabel14.setBackground(new java.awt.Color(0, 153, 153));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Expired Medicines");
        jLabel14.setOpaque(true);
        Homepage_panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 540, 50));

        six_month_expired.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "expired in 6 months"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(six_month_expired);
        if (six_month_expired.getColumnModel().getColumnCount() > 0) {
            six_month_expired.getColumnModel().getColumn(0).setResizable(false);
        }

        Homepage_panel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 610, 290));

        jTabbedPane1.addTab("HomePage", Homepage_panel);

        billing_panel.setBackground(new java.awt.Color(255, 255, 255));
        billing_panel.setPreferredSize(new java.awt.Dimension(1600, 1080));

        billing_tbl.setBackground(new java.awt.Color(0, 153, 153));
        billing_tbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        billing_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SN", "medcine name", "Quantity", "Price", "total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billing_tbl.getTableHeader().setReorderingAllowed(false);
        billing_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billing_tblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(billing_tbl);
        if (billing_tbl.getColumnModel().getColumnCount() > 0) {
            billing_tbl.getColumnModel().getColumn(1).setResizable(false);
            billing_tbl.getColumnModel().getColumn(2).setResizable(false);
            billing_tbl.getColumnModel().getColumn(3).setResizable(false);
            billing_tbl.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Amount");
        jLabel1.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(0, 153, 153));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ID");
        jLabel11.setOpaque(true);

        add_to_cart.setBackground(new java.awt.Color(0, 153, 153));
        add_to_cart.setText("add");
        add_to_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_to_cartActionPerformed(evt);
            }
        });

        clear_table.setBackground(new java.awt.Color(0, 153, 153));
        clear_table.setText("clear table");
        clear_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_tableActionPerformed(evt);
            }
        });

        totalamt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalamt.setText("00.00");

        add_to_cart1.setBackground(new java.awt.Color(0, 153, 153));
        add_to_cart1.setText("print");
        add_to_cart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_to_cart1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout billing_panelLayout = new javax.swing.GroupLayout(billing_panel);
        billing_panel.setLayout(billing_panelLayout);
        billing_panelLayout.setHorizontalGroup(
            billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billing_panelLayout.createSequentialGroup()
                .addGroup(billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billing_panelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billing_panelLayout.createSequentialGroup()
                                .addComponent(clear_table, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(add_to_cart1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(255, 255, 255)
                                .addComponent(totalamt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(billing_panelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billing_panelLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(billing_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billing_panelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(billing_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(add_to_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(128, 128, 128))
        );
        billing_panelLayout.setVerticalGroup(
            billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billing_panelLayout.createSequentialGroup()
                .addGroup(billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billing_panelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(billing_panelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(billing_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(billing_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billing_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(add_to_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalamt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(add_to_cart1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clear_table, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180))
        );

        jTabbedPane1.addTab("billing", billing_panel);

        low_stock_tbl.setBackground(new java.awt.Color(0, 153, 153));
        low_stock_tbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        low_stock_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "low stocks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        low_stock_tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(low_stock_tbl);
        if (low_stock_tbl.getColumnModel().getColumnCount() > 0) {
            low_stock_tbl.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout lowstocks_panelLayout = new javax.swing.GroupLayout(lowstocks_panel);
        lowstocks_panel.setLayout(lowstocks_panelLayout);
        lowstocks_panelLayout.setHorizontalGroup(
            lowstocks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lowstocks_panelLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        lowstocks_panelLayout.setVerticalGroup(
            lowstocks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lowstocks_panelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Low Stocks", lowstocks_panel);

        med_table.setBackground(new java.awt.Color(0, 153, 153));
        med_table.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        med_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "medicine table"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        med_table.setOpaque(false);
        med_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(med_table);

        update_btn.setBackground(new java.awt.Color(0, 102, 102));
        update_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update_btn.setText("update");
        update_btn.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Amount");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Med Name");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Price");
        jLabel4.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(0, 153, 153));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ID");
        jLabel12.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manufact date");
        jLabel5.setOpaque(true);

        med_manufact_date.setDateFormatString("yyyy-MM-dd");

        med_delete_btn.setBackground(new java.awt.Color(0, 102, 102));
        med_delete_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        med_delete_btn.setText("DElete");
        med_delete_btn.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        med_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                med_delete_btnActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Expired date");
        jLabel6.setOpaque(true);

        med_expired_date2.setDateFormatString("yyyy-MM-dd");

        search_btn.setBackground(new java.awt.Color(0, 102, 102));
        search_btn.setText("Search");
        search_btn.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        search_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_btnMouseClicked(evt);
            }
        });
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        med_add_btn1.setBackground(new java.awt.Color(0, 102, 102));
        med_add_btn1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        med_add_btn1.setText("ADD");
        med_add_btn1.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        med_add_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                med_add_btn1MouseClicked(evt);
            }
        });
        med_add_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                med_add_btn1ActionPerformed(evt);
            }
        });

        txtcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "antibiotics", "analgesics", "antipyretics", "anitidepressants", "pyratics", "antivirals", "antidiabetics", "anti allergics", "emergency tablets", "heart medicines", "anti inflamentory drugs", "anti coagulants", "anti histamines", "anti hypertensives" }));

        jLabel15.setBackground(new java.awt.Color(0, 153, 153));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("category");
        jLabel15.setOpaque(true);

        javax.swing.GroupLayout med_panelLayout = new javax.swing.GroupLayout(med_panel);
        med_panel.setLayout(med_panelLayout);
        med_panelLayout.setHorizontalGroup(
            med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(med_panelLayout.createSequentialGroup()
                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, med_panelLayout.createSequentialGroup()
                        .addContainerGap(95, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(med_panelLayout.createSequentialGroup()
                        .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(med_panelLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(med_id_txtfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(med_expired_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(med_panelLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(med_price_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(med_panelLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(med_add_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(364, 364, 364)
                                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(340, 340, 340)
                                .addComponent(med_delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(med_panelLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(med_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(med_name_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(218, 218, 218)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))
                                    .addGroup(med_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(med_amount_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(med_manufact_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        med_panelLayout.setVerticalGroup(
            med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(med_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(med_expired_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(med_panelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(med_id_txtfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(med_panelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(med_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(med_name_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(med_manufact_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(med_panelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(med_amount_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(med_panelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(med_price_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(med_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(med_add_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(med_delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Medicine", med_panel);

        suuplier_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplier_tbl.setBackground(new java.awt.Color(0, 153, 153));
        supplier_tbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        supplier_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplier_tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(supplier_tbl);
        if (supplier_tbl.getColumnModel().getColumnCount() > 0) {
            supplier_tbl.getColumnModel().getColumn(0).setResizable(false);
        }

        suuplier_panel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 458, 1210, 320));

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SNo");
        jLabel7.setOpaque(true);
        suuplier_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 189, 45));

        jLabel8.setBackground(new java.awt.Color(0, 153, 153));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Supplier Name");
        jLabel8.setOpaque(true);
        suuplier_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 189, 45));

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Address");
        jLabel9.setOpaque(true);
        suuplier_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 189, 45));

        jLabel10.setBackground(new java.awt.Color(0, 153, 153));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Contact");
        jLabel10.setOpaque(true);
        suuplier_panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 189, 45));

        delete_btn.setBackground(new java.awt.Color(0, 153, 153));
        delete_btn.setText("Delete");
        delete_btn.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        suuplier_panel.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 222, 50));
        suuplier_panel.add(id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 315, 45));
        suuplier_panel.add(supname_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 315, 45));

        contact_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_txtActionPerformed(evt);
            }
        });
        suuplier_panel.add(contact_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 315, 51));

        address_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_txtActionPerformed(evt);
            }
        });
        suuplier_panel.add(address_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 315, 51));

        supplier_add_btn.setBackground(new java.awt.Color(0, 153, 153));
        supplier_add_btn.setText("ADD");
        supplier_add_btn.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        supplier_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_add_btnActionPerformed(evt);
            }
        });
        suuplier_panel.add(supplier_add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 222, 50));

        supplier_search_btn.setBackground(new java.awt.Color(0, 153, 153));
        supplier_search_btn.setText("Search");
        supplier_search_btn.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        supplier_search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_search_btnActionPerformed(evt);
            }
        });
        suuplier_panel.add(supplier_search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 130, 50));

        jTabbedPane1.addTab("Supplier", suuplier_panel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, -35, 1490, 840));

        btns_panel.setBackground(new java.awt.Color(0, 153, 153));
        btns_panel.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 14)); // NOI18N
        btns_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homepage_btn.setBackground(new java.awt.Color(0, 102, 102));
        homepage_btn.setText("Homepage");
        homepage_btn.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        homepage_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homepage_btnActionPerformed(evt);
            }
        });
        btns_panel.add(homepage_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, 90, 46));

        Low_Stocks_btn.setBackground(new java.awt.Color(0, 102, 102));
        Low_Stocks_btn.setText("Low Stocks");
        Low_Stocks_btn.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Low_Stocks_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Low_Stocks_btnActionPerformed(evt);
            }
        });
        btns_panel.add(Low_Stocks_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, 90, 46));

        medicine_btn.setBackground(new java.awt.Color(0, 102, 102));
        medicine_btn.setText("Med category");
        medicine_btn.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        medicine_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicine_btnActionPerformed(evt);
            }
        });
        btns_panel.add(medicine_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 118, 90, 46));

        Supplier_btn.setBackground(new java.awt.Color(0, 102, 102));
        Supplier_btn.setText("Supplier");
        Supplier_btn.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Supplier_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supplier_btnActionPerformed(evt);
            }
        });
        btns_panel.add(Supplier_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 222, 90, 46));

        Billing_btn.setBackground(new java.awt.Color(0, 102, 102));
        Billing_btn.setText("Billing");
        Billing_btn.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Billing_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Billing_btnActionPerformed(evt);
            }
        });
        btns_panel.add(Billing_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 274, 90, 46));

        logout_btn.setText("logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        btns_panel.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 750, 81, -1));

        change_pass_btn.setText("change pass");
        change_pass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_pass_btnActionPerformed(evt);
            }
        });
        btns_panel.add(change_pass_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 110, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonRectangle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle1.setText("admin");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        btns_panel.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 100, 30));

        jCTextField1.setEditable(false);
        jCTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jCTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jCTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jCTextField1.setText("default");
        jCTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField1ActionPerformed(evt);
            }
        });
        btns_panel.add(jCTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, -1));

        getContentPane().add(btns_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 110, 860));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homepage_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homepage_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        expiry_detail();
        expire_in_six();
        //sales_detail();
    }//GEN-LAST:event_homepage_btnActionPerformed

    private void medicine_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        add_fill_table();
    }//GEN-LAST:event_medicine_btnActionPerformed

    private void Low_Stocks_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Low_Stocks_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);

        low_stocks_table();


    }//GEN-LAST:event_Low_Stocks_btnActionPerformed

    private void Supplier_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supplier_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_Supplier_btnActionPerformed

    private void Billing_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Billing_btnActionPerformed
        // TODO add your handling code here:
        //jTabbedPane1.setSelectedIndex(1);
        this.setVisible(false);
        SellMedicine obj = new SellMedicine();
        obj.setVisible(true);

    }//GEN-LAST:event_Billing_btnActionPerformed


    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
      int option = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
if(option == JOptionPane.YES_OPTION) {
    setVisible(false);
    login form = new login();
    form.setVisible(true);
}

    }//GEN-LAST:event_logout_btnActionPerformed

    private void change_pass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_pass_btnActionPerformed
        // TODO add your handling code here:

        Change_password_from_setting form = new Change_password_from_setting();
        form.setVisible(true);
    }//GEN-LAST:event_change_pass_btnActionPerformed

    private void med_add_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_med_add_btn1MouseClicked
        // Check if any required fields are empty
       
    if (med_id_txtfield1.getText().isEmpty() || med_name_txtfield.getText().isEmpty()
            || med_amount_txtfield.getText().isEmpty() || med_price_txtfield.getText().isEmpty()
            || med_expired_date2.getDate() == null || med_manufact_date.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Please fill in all textboxes and select both manufacturing and expiration dates.");
    } else {
        LocalDate today = LocalDate.now();
        Date manu = med_manufact_date.getDate();
        Date ex = med_expired_date2.getDate();
        java.sql.Date todayDate = java.sql.Date.valueOf(today);
        
        
        
        int comparisonResult = ex.compareTo(manu);
        int comparisonResult2 = ex.compareTo(todayDate);
        if (comparisonResult >= 0 && comparisonResult2 <=0) {
            JOptionPane.showMessageDialog(null, "Invalid Expiry date");
        } else {
            try {
                // Establish database connection
                Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
                
                // Prepare the SQL statement
                PreparedStatement add = Con.prepareStatement("INSERT INTO med_category VALUES (?, ?, ?, ?, ?,?,?)");
                add.setInt(1, Integer.parseInt(med_id_txtfield1.getText()));
                add.setString(2, med_name_txtfield.getText());
                add.setInt(3, Integer.parseInt(med_amount_txtfield.getText()));
                add.setFloat(4, Float.parseFloat(med_price_txtfield.getText()));
                
                // Format dates as strings
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                add.setString(5, dateFormat.format(ex));
                add.setString(6, dateFormat.format(manu));
                
                // Get selected category
                String category = (String) txtcategory.getSelectedItem();
                add.setString(7, category);

                // Execute the SQL statement
                add.executeUpdate();
                
                // Display success message
                JOptionPane.showMessageDialog(this, "Data added successfully");
                
                // Clear input fields
                clearinputs();
                
                // Fill table with updated data
                add_fill_table();

            } catch (HeadlessException | NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
            }
        }
    }

    }//GEN-LAST:event_med_add_btn1MouseClicked
    private void total(float a) {

    }
    private void med_add_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_med_add_btn1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_med_add_btn1ActionPerformed

    private void search_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_btnMouseClicked
        // TODO add your handling code here:
        try {
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            String sql = "SELECT * FROM med_category WHERE med_id = ?";

            // Create a PreparedStatement
            try (PreparedStatement statement = Con.prepareStatement(sql)) {

                // Set the parameter for the med_id
                int medId = Integer.parseInt(med_id_txtfield1.getText());
                statement.setInt(1, medId);

                // Execute the query
                ResultSet resultSet = statement.executeQuery();

                // Check if any results were returned
                if (resultSet.next()) {
                    // Set the values in your text fields based on the retrieved data
                    med_name_txtfield.setText(resultSet.getString("med_name"));
                    med_amount_txtfield.setText(String.valueOf(resultSet.getInt("med_amount")));
                    med_price_txtfield.setText(String.valueOf(resultSet.getFloat("med_price")));

                    // Assuming med_manufactured_date and med_expire_date are date fields
                    java.sql.Date manufactureDate = resultSet.getDate("med_manufact_date");
                    java.sql.Date expireDate = resultSet.getDate("med_expired_date");

                    med_manufact_date.setDate(manufactureDate);
                    med_expired_date2.setDate(expireDate);
                } else {
                    JOptionPane.showMessageDialog(this, "No data found for the specified med_id.");
                }
            }

            // Close the connection
            Con.close();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            DatabaseManager.closeConnection();
        }

    }//GEN-LAST:event_search_btnMouseClicked

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:

        try {
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");

            String query = "UPDATE med_category SET med_name=?, med_amount=?, med_price=?, med_expired_date=?, med_manufact_date=? WHERE med_id=?";

            PreparedStatement pst = Con.prepareStatement(query);

            pst.setString(1, med_name_txtfield.getText());
            pst.setInt(2, Integer.parseInt(med_amount_txtfield.getText()));
            pst.setDouble(3, Double.parseDouble(med_price_txtfield.getText()));
            pst.setString(4, ((JTextField) med_expired_date2.getDateEditor().getUiComponent()).getText());
            pst.setString(5, ((JTextField) med_manufact_date.getDateEditor().getUiComponent()).getText());
            pst.setInt(6, Integer.parseInt(med_id_txtfield1.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data updated successfully");

            // Clear input fields
            clearinputs();
            add_fill_table();

        } catch (SQLException | HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_update_btnActionPerformed

    private void address_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_txtActionPerformed

    private void supplier_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_add_btnActionPerformed
        // TODO add your handling code here:
        if (id_txt.getText().equals("") || supname_txt.getText().equals("") || contact_txt.getText().equals("") || address_txt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in all textboxes.");
        } else if (contact_txt.getText().length() != 10 || !contact_txt.getText().matches(mobilenopattern)) {
            JOptionPane.showMessageDialog(null, "invalid phone no ");
        } else {
            try {
                Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
                PreparedStatement add = Con.prepareStatement("INSERT INTO med_supplier VALUES (?, ?, ?, ?)");

                add.setInt(1, Integer.parseInt(id_txt.getText()));
                add.setString(2, supname_txt.getText());

                add.setString(3, contact_txt.getText());
                add.setString(4, address_txt.getText());

                add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data added successfully");

                clearinputs1();
                supplier_tbl();

            } catch (HeadlessException | NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_supplier_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:

        try {
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            PreparedStatement del = Con.prepareStatement("DELETE FROM med_supplier WHERE sup_id=?");
            del.setInt(1, Integer.parseInt(id_txt.getText()));
            JOptionPane.showMessageDialog(this, "Data deleted successfully");

            del.executeUpdate();

            Con.close();
            clearinputs();
            supplier_tbl();

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
        }

    }//GEN-LAST:event_delete_btnActionPerformed

    private void med_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_med_delete_btnActionPerformed
        // TODO add your handling code here:
try {
    Connection Con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
    
    // Delete corresponding records from med_sale table
    PreparedStatement delMedSale = Con1.prepareStatement("DELETE FROM med_sale WHERE med_id=?");
    delMedSale.setInt(1, Integer.parseInt(med_id_txtfield1.getText()));
    delMedSale.executeUpdate();

    // Now, delete the record from med_category table
    PreparedStatement delMedCategory = Con1.prepareStatement("DELETE FROM med_category WHERE med_id=?");
    delMedCategory.setInt(1, Integer.parseInt(med_id_txtfield1.getText()));
    delMedCategory.executeUpdate();
    
    JOptionPane.showMessageDialog(this, "Data deleted successfully");
    
    Con1.close();
    clearinputs();
    add_fill_table();

} catch (HeadlessException | NumberFormatException | SQLException e) {
    JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
}


    }//GEN-LAST:event_med_delete_btnActionPerformed

    private void supplier_search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_search_btnActionPerformed
        // TODO add your handling code here:
        try {
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            String sql = "SELECT * FROM med_supplier WHERE sup_id= ?";

            // Create a PreparedStatement
            try (PreparedStatement statement = Con.prepareStatement(sql)) {

                // Set the parameter for the med_id
                int supId = Integer.parseInt(id_txt.getText());
                statement.setInt(1, supId);

                // Execute the query
                ResultSet resultSet = statement.executeQuery();

                // Check if any results were returned
                if (resultSet.next()) {
                    // Set the values in your text fields based on the retrieved data
                    //id_txt.setText(resultSet.getString("sup_id"));
                    supname_txt.setText(resultSet.getString("sup_name"));
                    contact_txt.setText(resultSet.getString("sup_contact"));
                    address_txt.setText(resultSet.getString("sup_address"));

                } else {
                    JOptionPane.showMessageDialog(this, "No data found for the specified med_id.");
                }
            }

            // Close the connection
            Con.close();

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            DatabaseManager.closeConnection();
        }

    }//GEN-LAST:event_supplier_search_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_btnActionPerformed

    private void contact_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_txtActionPerformed

    private void add_to_cartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_to_cartActionPerformed
        // TODO add your handling code here:
        String Id = billing_id.getText();
        String amount1 = billing_amount.getText();

        if (Id.isEmpty() && amount1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid ID and amount");
        } else if (amount1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid amount");
        } else if (Id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid ID");
        } else {
            try {
                int medId = Integer.parseInt(Id);
                int amount = Integer.parseInt(amount1);

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
                String selectQuery = "SELECT med_amount, med_name, med_price, med_expired_date FROM med_category WHERE med_id=?";
                String updateQuery = "UPDATE med_category SET med_amount = med_amount - ? WHERE med_id=?";
                String insertOrUpdateSaleQuery = "INSERT INTO med_sale (med_id, med_name, amount, med_price, med_expire_date, med_sale_date) "
                        + "VALUES (?, ?, ?, ?, ?, NOW()) ";
                // Step 1: Retrieve current data
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setInt(1, medId);
                ResultSet resultSet = selectStatement.executeQuery();

                DefaultTableModel model5 = (DefaultTableModel) billing_tbl.getModel();

                if (resultSet.next()) {
                    int medAmount = resultSet.getInt("med_amount");
                    if (medAmount >= amount) {
                        String medName = resultSet.getString("med_name");
                        float medPrice = resultSet.getFloat("med_price");
                        Date medExpireDate = resultSet.getDate("med_expired_date");

                        // Add row to billing table
                        Object[] row = {medId, medName, amount, medPrice, medExpireDate, amount * medPrice};
                        model5.addRow(row);

                        // Update med_category table
                        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                        updateStatement.setInt(1, amount);
                        updateStatement.setInt(2, medId);
                        updateStatement.executeUpdate();

                        // Insert or update med_sale table
                        PreparedStatement insertOrUpdateStatement = connection.prepareStatement(insertOrUpdateSaleQuery);
                        insertOrUpdateStatement.setInt(1, medId);
                        insertOrUpdateStatement.setString(2, medName);
                        insertOrUpdateStatement.setInt(3, amount);
                        insertOrUpdateStatement.setFloat(4, medPrice);
                        insertOrUpdateStatement.setDate(5, (java.sql.Date) medExpireDate);
                        insertOrUpdateStatement.setInt(6, amount);
                        insertOrUpdateStatement.executeUpdate();

                        // Calculate total amount
                        CalculateTotalAmt(amount * medPrice);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient amount");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Medicine not found");
                }
                connection.close();
                clear_txtfield();

            } catch (NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
                clear_txtfield();
            }
        }

        /*
        String Id = billing_id.getText();
    String amount1 = billing_amount.getText();
    
    if (Id.isEmpty() && amount1.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Invalid ID and amount");
    } else if (amount1.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Invalid amount");
    } else if (Id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Invalid ID");
    }
    
 
    
    else {
        try {
            int medId = Integer.parseInt(Id);
            int amount = Integer.parseInt(amount1);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Mych0ice@12345");
            String selectQuery = "SELECT med_amount, med_name, med_price,med_expired_date FROM med_category WHERE med_id=?";
            String updateQuery = "UPDATE med_category SET med_amount = med_amount - ? WHERE med_id=?";
            // Step 2: Add row to billing_tbl
            // Step 1: Retrieve current data
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, medId);
            ResultSet resultSet = selectStatement.executeQuery();
            
            

            DefaultTableModel model5 = (DefaultTableModel) billing_tbl.getModel();

            if (resultSet.next()) {
    int medAmount = resultSet.getInt("med_amount");
    if (medAmount >= amount) {
        String medName = resultSet.getString("med_name");
        float medPrice = resultSet.getFloat("med_price");
        Date medExpireDate = resultSet.getDate("med_expired_date"); // Correct variable name
        
        
        // Add row to billing table
        Object[] row = {medId, medName, amount, medPrice,medExpireDate, amount * medPrice};
        model5.addRow(row);

        // Update med_category table
        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.setInt(1, amount);
        updateStatement.setInt(2, medId);
        updateStatement.executeUpdate();

        // Insert into med_sale table
        String insertSaleQuery = "INSERT INTO med_sale (med_id, med_name,amount, med_price, med_expire_date, med_sale_date) VALUES (?,?, ?, ?, ?, NOW())"+ "ON DUPLICATE KEY UPDATE amount = amount + ?";
        PreparedStatement insertStatement = connection.prepareStatement(insertSaleQuery);
        insertStatement.setInt(1, medId);
        insertStatement.setString(2, medName);
        
        insertStatement.setInt(3,amount);
        insertStatement.setFloat(4, medPrice);
        insertStatement.setDate(5, (java.sql.Date) medExpireDate);
        insertStatement.setInt(6, amount); 
        insertStatement.executeUpdate();

        // Calculate total amount
        CalculateTotalAmt(amount * medPrice);
    } else {
        JOptionPane.showMessageDialog(null, "Insufficient amount ");
    }
    connection.close();
    clear_txtfield();
}

} catch (NumberFormatException | SQLException ex) {
    JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
}  clear_txtfield();
    
            
    }
         */

    }//GEN-LAST:event_add_to_cartActionPerformed

    private void clear_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_tableActionPerformed
        // TODO add your handling code here:
        clear_table_billing();
        DefaultTableModel model6 = (DefaultTableModel) billing_tbl.getModel();
        model6.setRowCount(0);
        amt = 0;
        CalculateTotalAmt(0);
    }//GEN-LAST:event_clear_tableActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
        String user = new User().getusername();
        try {
            if (new Permission().permission(user)) {
                //setVisible(false);
                admin dboard = new admin();
                dboard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "access denied");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void jCTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCTextField1ActionPerformed

    private void add_to_cart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_to_cart1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_to_cart1ActionPerformed

    private void billing_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billing_tblMouseClicked
        // TODO add your handling code here:
        /*
          int index = billing_tbl.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do You Want to Remove this Medicine", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = billing_tbl.getModel();
            String total = model.getValueAt(index, 5).toString();
            totalamt= totalamt - Integer.parseInt(total);
            lblfinaltotalprice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) cartTable.getModel()).removeRow(index);
        }
         */

    }//GEN-LAST:event_billing_tblMouseClicked

    static float amt = 00;

    void CalculateTotalAmt(float x) {
        if (x == 0) {
            totalamt.setText("00.00");
        } else {
            amt = x + amt;
            totalamt.setText(Float.toString(amt));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle Billing_btn;
    private javax.swing.JPanel Homepage_panel;
    private rojerusan.RSMaterialButtonRectangle Low_Stocks_btn;
    private rojerusan.RSMaterialButtonRectangle Supplier_btn;
    private rojerusan.RSMaterialButtonCircle add_to_cart;
    private rojerusan.RSMaterialButtonCircle add_to_cart1;
    private app.bolivia.swing.JCTextField address_txt;
    private app.bolivia.swing.JCTextField billing_amount;
    private app.bolivia.swing.JCTextField billing_id;
    private javax.swing.JPanel billing_panel;
    private javax.swing.JTable billing_tbl;
    private javax.swing.JPanel btns_panel;
    private javax.swing.JButton change_pass_btn;
    private rojerusan.RSMaterialButtonCircle clear_table;
    private app.bolivia.swing.JCTextField contact_txt;
    private rojerusan.RSMaterialButtonCircle delete_btn;
    private javax.swing.JTable expired_or_in_6month;
    private rojerusan.RSMaterialButtonRectangle homepage_btn;
    private app.bolivia.swing.JCTextField id_txt;
    private app.bolivia.swing.JCTextField jCTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTable low_stock_tbl;
    private javax.swing.JPanel lowstocks_panel;
    private rojerusan.RSMaterialButtonRectangle med_add_btn1;
    private app.bolivia.swing.JCTextField med_amount_txtfield;
    private rojerusan.RSMaterialButtonRectangle med_delete_btn;
    private com.toedter.calendar.JDateChooser med_expired_date2;
    private app.bolivia.swing.JCTextField med_id_txtfield1;
    private com.toedter.calendar.JDateChooser med_manufact_date;
    private app.bolivia.swing.JCTextField med_name_txtfield;
    private javax.swing.JPanel med_panel;
    private app.bolivia.swing.JCTextField med_price_txtfield;
    private javax.swing.JTable med_table;
    private rojerusan.RSMaterialButtonRectangle medicine_btn;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private javax.swing.JTable sales_tbl;
    private rojerusan.RSMaterialButtonCircle search_btn;
    private javax.swing.JTable six_month_expired;
    private app.bolivia.swing.JCTextField supname_txt;
    private rojerusan.RSMaterialButtonCircle supplier_add_btn;
    private rojerusan.RSMaterialButtonCircle supplier_search_btn;
    private javax.swing.JTable supplier_tbl;
    private javax.swing.JPanel suuplier_panel;
    private javax.swing.JLabel totalamt;
    private javax.swing.JComboBox<String> txtcategory;
    private rojerusan.RSMaterialButtonRectangle update_btn;
    // End of variables declaration//GEN-END:variables

    private void clearInputFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
