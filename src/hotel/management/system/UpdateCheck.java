
package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class UpdateCheck extends JFrame implements ActionListener{
    Choice c1;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;
    
    UpdateCheck(){
        JLabel j1 = new JLabel("Check-In Details");
        j1.setBounds(70, 30, 180, 30);
        j1.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(j1);
        
        JLabel j2 = new JLabel("Customer Id");
        j2.setBounds(30, 100, 120, 30);
        j2.setFont(new Font("serif", Font.PLAIN, 15));
        add(j2);
        
        c1 = new Choice();
        try{
            Conn c = new Conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }
        catch(Exception e){}
        c1.setBounds(220, 100, 180, 30);
        add(c1);
        
        JLabel j3 = new JLabel("Room Number");
        j3.setBounds(30, 150, 120, 30);
        j3.setFont(new Font("serif", Font.PLAIN, 15));
        add(j3);
        
        t1 = new JTextField();
        t1.setBounds(220, 150, 180, 30);
        add(t1);
        
        JLabel j4 = new JLabel("Name");
        j4.setBounds(30, 200, 120, 30);
        j4.setFont(new Font("serif", Font.PLAIN, 15));
        add(j4);
        
        t2 = new JTextField();
        t2.setBounds(220, 200, 180, 30);
        add(t2);
        
        JLabel j5 = new JLabel("Check-In");
        j5.setBounds(30, 250, 120, 30);
        j5.setFont(new Font("serif", Font.PLAIN, 15));
        add(j5);
        
        t3 = new JTextField();
        t3.setBounds(220, 250, 180, 30);
        add(t3);
        
        JLabel j6 = new JLabel("Amount Paid");
        j6.setBounds(30, 300, 120, 30);
        j6.setFont(new Font("serif", Font.PLAIN, 15));
        add(j6);
        
        t4 = new JTextField();
        t4.setBounds(220, 300, 180, 30);
        add(t4);
        
        JLabel j7 = new JLabel("Pending Amount");
        j7.setBounds(30, 350, 120, 30);
        j7.setFont(new Font("serif", Font.PLAIN, 15));
        add(j7);
        
        t5 = new JTextField();
        t5.setBounds(220, 350, 180, 30);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(30, 430, 100, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(160, 430, 100, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(300, 430, 100, 30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        JLabel j8 = new JLabel(i1);
        j8.setBounds(450, 50, 500, 400);
        add(j8);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(350, 180, 960, 550);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String number = c1.getSelectedItem();
            String room = null;
            int remainingAmt = 0;
            String deposit = null;
            String price = null;
            Conn c = new Conn();
            try{
                String str = "select * from customer where number = '"+number+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next())
                {
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    deposit = rs.getString("deposit");
                    room = rs.getString("room");
                                       
                }
                String str1 = "select * from room where room_number ='"+room+"'";
                ResultSet rs1 = c.s.executeQuery(str1);
                while(rs1.next()){
                    price = rs1.getString("price");
                }
                remainingAmt = Integer.parseInt(price) - Integer.parseInt(deposit);
                String s1 = ""+remainingAmt;
                t5.setText(s1);
            }
            catch(Exception e){}
        }
        else if(ae.getSource() == b2){
            Conn c = new Conn();
            String number = c1.getSelectedItem();
            String room = t1.getText();
            String name = t2.getText();
            String status = t3.getText();
            String deposit = t4.getText();
            
            
            try{
                String str = "update customer set room = '"+room+"', name = '"+name+"', status = '"+status+"', deposit = '"+deposit+"' where number = '"+number+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                this.setVisible(false);
                new Reception().setVisible(true);
            }
            catch(Exception e){e.printStackTrace();}
        }
        else if(ae.getSource() == b3){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new UpdateCheck();
    }
}
