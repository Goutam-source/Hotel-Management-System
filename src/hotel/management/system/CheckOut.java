
package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckOut extends JFrame implements ActionListener{
    Choice c1;
    JTextField t1;
    JButton b1, b2, b3;
    CheckOut(){
        JLabel j1 = new JLabel("Check Out");
        j1.setBounds(80, 30, 180, 30);
        j1.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(j1);
        
        JLabel j2 = new JLabel("Customer Id");
        j2.setBounds(30, 90, 120, 30);
        j2.setFont(new Font("serif", Font.PLAIN, 16));
        add(j2);
        
        c1 = new Choice();
        Conn c = new Conn();
        try{
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }
        catch(Exception e){}
        c1.setBounds(200, 90, 180, 30);
        add(c1);
        
        JLabel j3 = new JLabel("Room Number");
        j3.setBounds(30, 140, 120, 30);
        j3.setFont(new Font("serif", Font.PLAIN, 16));
        add(j3);
        
        t1 = new JTextField();
        t1.setBounds(200, 140, 180, 30);
        add(t1);
        
        b1 = new JButton("CheckOut");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(20, 220, 100, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(150, 220, 100, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(390, 90, 20, 20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel j4 = new JLabel(i6);
        j4.setBounds(430, 90, 350, 150);
        add(j4);
        
        
        
        setLayout(null);
        setBounds(390, 200, 800, 300);
        setVisible(true);
    }
    
    
    
    @Override 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String number = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number = '"+number+"'";
            String str1 = "update room set available = 'Available' where room_number = '"+room+"'";
            Conn c = new Conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Done CheckOut!");
                this.setVisible(false);
                new Reception().setVisible(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(ae.getSource() == b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
        
        else if(ae.getSource() == b3){
            String number = c1.getSelectedItem();
            Conn c = new Conn();
            try{
               String str = "select * from customer where number = '"+number+"'";
               ResultSet rs = c.s.executeQuery(str);
               while(rs.next()){
                   t1.setText(rs.getString("room"));
               }
            }
            catch(Exception e){}
        }
    }
    public static void main(String args[]){
        new CheckOut();
    }
    
}
