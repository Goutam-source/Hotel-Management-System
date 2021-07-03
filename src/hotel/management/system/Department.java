
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;

    
    Department(){
        
        t1 = new JTable();
        t1.setBounds(0, 40, 700, 350);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(170, 410, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(400, 410, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel j2 = new JLabel("Department");
        j2.setFont(new Font("Tahoma", Font.BOLD, 16));
        j2.setBounds(145, 11, 105, 30);
        add(j2);
        
        JLabel j3 = new JLabel("Budget");
        j3.setFont(new Font("Tahoma", Font.BOLD, 16));
        j3.setBounds(431, 11, 75, 30);
        add(j3);
        
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450, 200, 700, 500);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Conn c = new Conn();
            ResultSet rs;
            try{
                    rs = c.s.executeQuery("select * from department");
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
               
            } catch (SQLException ex) {
                Logger.getLogger(SearchRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Department();
    }
}
