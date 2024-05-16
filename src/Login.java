//import java.awt.event.ActionEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class Login extends JFrame {
    private Connection con;
    private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-EJIGPN3\\SQLEXPRESS;databaseName=OnlineExaminationSystem";
    private static final String JDBC_USER = "as";
    private static final String JDBC_PASSWORD = "123456";

    private static final String userID_2 = "ITCSIU21241";
    private static final String password_2 = "1234";
    private static final String userID_3 = "ITL21241";
    private static final String password_3 = "1234";



    /** Creates new form Login */
    public Login() {
        connect();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


    public void inputID(java.awt.event.ActionEvent evt){
        String userID = jTextField1.getText();
        System.out.println("User ID entered: " + userID);
    }
    public void inputPassword(java.awt.event.ActionEvent evt){
//        char[] password = jTextField2.getPassword();
//        System.out.println("Password entered: " + new String(password));
//
    }
    public void loginActionPerformed(java.awt.event.ActionEvent evt){
        setVisible(false);
        String userID = jTextField1.getText();
        String password = jTextField2.getText();

        if(userID.equalsIgnoreCase(userID_2) && password.equals(password_2)) {

            Student object = new Student();
            object.initComponents();
            object.setVisible(true);
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else if(userID.equals(userID_3) && password.equals(password_3)) {
            Lecturer object = new Lecturer();
//            object.initComponents();
            object.initComponents();
            JOptionPane.showMessageDialog(this, "Login successful!");
        }
//
//         Thực hiện xác thực tài khoản ở đây
//        if (authenticate(userID, password)) {
//            JOptionPane.showMessageDialog(this, "Login successful!");
//        } else {
//            JOptionPane.showMessageDialog(this, "Invalid user ID or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
//        }

//        Student object = new Student();
//        object.initComponents();
//        object.setVisible(true);
    }
    private boolean authenticate(String userID, String password) {

        // Kiểm tra trong bảng LECTURER
        if (checkUserInLecturer(userID, password)) {
            return true;
        }
        // Kiểm tra trong bảng STUDENT
        if (checkUserInStudent(userID, password)) {
            return true;
        }
        return false;

//        // Giả sử xác thực đơn giản
//        String validUserID = "admin";
//        String validPassword = "password123";
//
//        return userID.equals(validUserID) && new String(password).equals(validPassword);
    }

    private boolean checkUserInLecturer(String lecturerID, String password) {
        String query = "SELECT COUNT(*) FROM LECTURER WHERE Lecturer_ID = ?";
//        String query = "SELECT COUNT(*) FROM LECTURER WHERE Lecturer_ID = ? AND LecturerPassword = ?";
//        return checkUser(query, lecturerID, password);
        if (password == "123456"){
            return checkUser(query, lecturerID);
        }
        return false;
    }

    private boolean checkUserInStudent(String studentID, String password) {
        String query = "SELECT COUNT(*) FROM STUDENT WHERE Student_ID = ?";
//        String query = "SELECT COUNT(*) FROM STUDENT WHERE Student_ID = ? AND StudentPassword = ?";
//        return checkUser(query, studentID, password);
        if (password == "123456"){
            return checkUser(query, studentID);
        }
        return false;
    }

//    private boolean checkUser(String query, String userID, String password) {
        private boolean checkUser(String query, String userID) {

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userID);
//            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void connect() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("123456");
        ds.setServerName("DESKTOP-EJIGPN3\\SQLEXPRESS");
        ds.setPortNumber(1433);
        ds.setDatabaseName("OnlineExaminationSystem");
        ds.setEncrypt(false);

        try {
            con = ds.getConnection();
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {



        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new  RoundedTextField(20);
        jTextField2 = new RoundedTextField(20);
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jPanel1 = new RoundedPanel(40);

        ImageIcon imageLogo = new ImageIcon(getClass().getResource("123.png"));
        Image image = imageLogo.getImage(); // transform it
        Image newimg = image.getScaledInstance(90, 90,  Image.SCALE_SMOOTH); // scale it the smooth way
        imageLogo = new ImageIcon(newimg);  // transform it back

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        setSize(new Dimension(1920, 1080));


        getContentPane().setBackground(Color.WHITE);


        jLabel1.setFont(new Font("SF Pro", 1, 15));
        jLabel1.setText("User's ID");

        jLabel2.setFont(new Font("SF Pro", 1, 15));
        jLabel2.setText("Password");

        jTextField1.setText("Type your ID");
        jTextField1.setForeground(new Color(121, 121, 121));
        jTextField1.setName(""); // NOI18N
        jTextField1.setPreferredSize(new Dimension(806, 78));
        jTextField1.setBackground(new Color(239, 233, 233));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputID(evt);
            }
        });


        jTextField2.setText("Type your password");
        jTextField2.setForeground(new Color(121, 121, 121));
        jTextField2.setToolTipText("");
        jTextField2.setPreferredSize(new Dimension(100,100));
        jTextField2.setBackground(new Color(239, 233, 233));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPassword(evt);
            }
        });

        jButton1.setBackground(new Color(0, 0, 204));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setFont(new Font("SF Pro", 1, 12));
        jButton1.setActionCommand("LOG IN");
        jButton1.setLabel("LOG IN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new Font("SF Pro", 1, 24)); // NOI18N
        jLabel3.setText("USER LOGIN ");
        jLabel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jLabel3.setPreferredSize(new Dimension(1128, 44));

        jLabel4.setFont(new Font("SF Pro", 1, 24)); // NOI18N
        jLabel4.setText("WELCOME TO HCMIU ONLINE EXAMINATION SYSTEM");
        jLabel4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jLabel4.setPreferredSize(new Dimension(1128, 44));

        jLabel5.setIcon(imageLogo);


        jPanel1.setBackground(new Color(217, 217, 217));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1000, Short.MAX_VALUE)  // width of jPanel1
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 360, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(590, 590, 590) //login - horizontal
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75))
//
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(436, 436, 436)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(275, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(307, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(307, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(268, Short.MAX_VALUE)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
                                        .addGap(300, 300, 300))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(600, 600, 600)))

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel5)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(97, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(121, Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(43, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(409, Short.MAX_VALUE)))
        );

        pack();
    }

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;

     
    // End of variables declaration                   

}
