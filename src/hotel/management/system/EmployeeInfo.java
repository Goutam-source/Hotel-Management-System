
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;


public class EmployeeInfo extends JFrame implements ActionListener{
    
    JButton b1, b2;
    JTable t1;
    
    EmployeeInfo(){
        
        t1 = new JTable();
        t1.setBounds(0, 40, 1320, 450);
        add(t1);
        
        b1 = new JButton("Load data");
        b1.setBounds(150, 500, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(450, 500, 120, 30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);
        
        JLabel j1 = new JLabel("Name");
        j1.setBounds(50, 5, 120, 20);
        j1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j1);
        
        JLabel j2 = new JLabel("Age");
        j2.setBounds(230, 5, 120, 20);
        j2.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j2);
        
        JLabel j3 = new JLabel("Gender");
        j3.setBounds(380, 5, 120, 20);
        j3.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j3);
        
        JLabel j4 = new JLabel("Job");
        j4.setBounds(550, 5, 120, 20);
        j4.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j4);
        
        JLabel j5 = new JLabel("Salary");
        j5.setBounds(710, 5, 120, 20);
        j5.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j5);
        
        JLabel j6 = new JLabel("Phone");
        j6.setBounds(870, 5, 120, 20);
        j6.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j6);
        
        JLabel j7 = new JLabel("Aadhar");
        j7.setBounds(1040, 5, 120, 20);
        j7.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j7);
        
        JLabel j8 = new JLabel("E-mail");
        j8.setBounds(1200, 5, 120, 20);
        j8.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j8);
        
        getContentPane().setBackground(Color.white);
        setBounds(90, 180, 1320, 600);
        setLayout(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Conn c = new Conn();
            try{
                String str = "select * from employee";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                              
                
                
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String args[]){
        new EmployeeInfo();
    }
}
