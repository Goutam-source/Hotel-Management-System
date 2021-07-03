
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice c1;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    
    UpdateRoom(){
        JLabel j1 = new JLabel("Update Room Status");
        j1.setBounds(70, 30, 180, 30);
        j1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j1);
        
        JLabel j2 = new JLabel("Guest Id");
        j2.setBounds(30, 120, 120, 30);
        j2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(j2);
        
        c1 = new Choice();
        try{
            Conn c = new Conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number")); 
            }
            
        }catch(Exception e){
            
        }
        c1.setBounds(190, 120, 180, 30);
        add(c1);
        
        JLabel j3 = new JLabel("Room Number");
        j3.setBounds(30, 170, 120, 30);
        j3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(j3);
        
        t1 = new JTextField();
        t1.setBounds(190, 170, 180, 30);
        add(t1);
        
        JLabel j4 = new JLabel("Availability");
        j4.setBounds(30, 220, 120, 30);
        j4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(j4);
        
        t2 = new JTextField();
        t2.setBounds(190, 220, 180, 30);
        add(t2);
        
        JLabel j5 = new JLabel("Clean Status");
        j5.setBounds(30, 270, 120, 30);
        j5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(j5);
        
        t3= new JTextField();
        t3.setBounds(190, 270, 180, 30);
        add(t3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j6 = new JLabel(i3);
        j6.setBounds(430, 120, 500, 300);
        add(j6);
        
        b1 = new JButton("Check");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(80, 330, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(30, 380, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(170, 380, 120, 30);
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(350, 180, 960, 490);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String number = c1.getSelectedItem();
            String room = null;
            Conn c = new Conn();
            try{
                String str = "select * from customer where number = '"+number+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                }
                room = t1.getText();
                String str1 = "select * from room where room_number = '"+room+"'";
                    ResultSet rs1 = c.s.executeQuery(str1);
                    while(rs1.next()){
                        t2.setText(rs1.getString("available"));
                        t3.setText(rs1.getString("status"));
                    }
                
            }
            catch(Exception e){
                
            }
            
        }
        else if(ae.getSource() == b2){
            String room = t1.getText();
            String available = t2.getText();
            String status = t3.getText();
            Conn c = new Conn();
            try{
                String str = "update room set available = '"+available+"', status = '"+status+"' where room_number = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                this.setVisible(false);
                new Reception().setVisible(true);
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() ==  b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new UpdateRoom();
    }
}
