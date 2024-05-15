import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
    private JPanel Main;
    private JTable table1;
    private JButton signOutButton;

    Connection con;
    PreparedStatement pst;

    public Student() {
        connect();
        table_load();
    }

    public JPanel getMainPanel() {
        return Main;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student");
        frame.setContentPane(new Student().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pdmproject", "root", "21082002");
            System.out.println("Connect Successfully");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void table_load() {
        try {
            pst = con.prepareStatement("select * from student");
            table1.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
