
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    Choice cb1;
    
    PickUp(){
        JLabel j1 = new JLabel("Search For Room");
        j1.setFont(new Font("Tahoma", Font.BOLD, 18));
        j1.setBounds(80, 30, 180, 30);
        add(j1);
        
        cb1 = new Choice();
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                cb1.add(rs.getString("brand"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PickUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb1.setBounds(30, 90, 180, 20);
        add(cb1);
        
        t1 = new JTable();
        t1.setBounds(0, 180, 800, 390);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(150, 600, 100, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(450, 600, 100, 30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel j2 = new JLabel("Name");
        j2.setFont(new Font("Tahoma", Font.BOLD, 16));
        j2.setBounds(20, 150, 120, 30);
        add(j2);
        
        JLabel j3 = new JLabel("Age");
        j3.setFont(new Font("Tahoma", Font.BOLD, 16));
        j3.setBounds(150, 150, 120, 30);
        add(j3);
        
        JLabel j4 = new JLabel("Gender");
        j4.setFont(new Font("Tahoma", Font.BOLD, 16));
        j4.setBounds(240, 150, 180, 30);
        add(j4);
        
        JLabel j5 = new JLabel("Brand");
        j5.setFont(new Font("Tahoma", Font.BOLD, 16));
        j5.setBounds(370, 150, 120, 30);
        add(j5);
        
        JLabel j6 = new JLabel("Model");
        j6.setFont(new Font("Tahoma", Font.BOLD, 16));
        j6.setBounds(490, 150, 120, 30);
        add(j6);
        
        JLabel j7 = new JLabel("Status");
        j7.setFont(new Font("Tahoma", Font.BOLD, 16));
        j7.setBounds(600, 150, 120, 30);
        add(j7);
        
        JLabel j8 = new JLabel("Location");
        j8.setFont(new Font("Tahoma", Font.BOLD, 16));
        j8.setBounds(700, 150, 120, 30);
        add(j8);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(400, 100, 800, 700);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Conn c = new Conn();
            ResultSet rs;
            try{
                    rs = c.s.executeQuery("select * from driver where brand = '"+cb1.getSelectedItem()+"'");
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
        new PickUp();
    }
}
