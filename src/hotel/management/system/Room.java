
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    
    Room(){
        
        t1 = new JTable();
        t1.setBounds(0, 50, 550, 450);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(60, 500, 120, 30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(290, 500, 120, 30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(420, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel  j1 = new JLabel(i3);
        j1.setBounds(560, 30, 420, 500);
        add(j1);
        
        JLabel j2 = new JLabel("Room");
        j2.setBounds(35, 5, 120, 30);
        j2.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j2);
        
        JLabel j3 = new JLabel("Status");
        j3.setBounds(120, 5, 120, 30);
        j3.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j3);
        
        JLabel j4 = new JLabel("Condition");
        j4.setBounds(230, 5, 120, 30);
        j4.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j4);
        
        JLabel j5 = new JLabel("Price");
        j5.setBounds(360, 5, 120, 30);
        j5.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j5);
        
        JLabel j6 = new JLabel("Type");
        j6.setBounds(470, 5, 120, 30);
        j6.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j6);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350, 180, 1000, 600);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Conn c = new Conn();
            try{
                String str = "Select * from room";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                System.out.println(e);
            }
        } else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static void main(String arhs[]){
        new Room();
    }
    
}
