
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField t1, t2, t3, t4, t5;
    JComboBox cb1;
    Choice c1;
    JRadioButton  r1, r2;
    JButton b1, b2;
    
    
    AddCustomer(){
        JLabel j1 = new JLabel("New Customer Form");
        j1.setBounds(120, 50, 250, 20);
        j1.setForeground(Color.blue);
        j1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(j1);
        
        JLabel j2 = new JLabel("ID");
        j2.setBounds(50, 120, 180, 30);
        j2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j2);
        
        cb1 = new JComboBox(new String[]{"Aadhar", "Voter Id", "Passport", "Driving License"});
        cb1.setBounds(320, 120, 170, 20);
        add(cb1);
        
        JLabel j3 = new JLabel("Number");
        j3.setBounds(50, 170, 180, 30);
        j3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j3);
        
        t1 = new JTextField();
        t1.setBounds(320, 170, 170, 20);
        add(t1);
        
        JLabel j4 = new JLabel("Name");
        j4.setBounds(50, 220, 180, 30);
        j4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j4);
        
        t2 = new JTextField();
        t2.setBounds(320, 220, 170, 20);
        add(t2);
        
        JLabel j5 = new JLabel("Gender");
        j5.setBounds(50, 270, 180, 30);
        j5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j5);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(320, 270, 85, 20);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(420, 270, 85, 20);
        add(r2);
        
        
        JLabel j6 = new JLabel("Country");
        j6.setBounds(50, 320, 180, 30);
        j6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j6);
        
        t3 = new JTextField();
        t3.setBounds(320, 320, 170, 20);
        add(t3);
        
        JLabel j7 = new JLabel("Allocated Room Number");
        j7.setBounds(50, 370, 180, 30);
        j7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j7);
        
        c1 = new Choice();
        try{
            String str = "select * from room where available = 'available'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("room_number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(320, 370, 170, 20);
        add(c1);
        
        JLabel j8 = new JLabel("Checked In");
        j8.setBounds(50, 420, 180, 30);
        j8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j8);
        
        t4 = new JTextField();
        t4.setBounds(320, 420, 170, 20);
        add(t4);
        
        JLabel j9 = new JLabel("Deposit");
        j9.setBounds(50, 470, 180, 30);
        j9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j9);
        
        t5 = new JTextField();
        t5.setBounds(320, 470, 170, 20);
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(50, 510, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(320, 510, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j10 = new JLabel(i3);
        j10.setBounds(550, 70, 400, 470);
        add(j10);
        
        setBounds(350, 180, 1000, 600);
        setLayout(null);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String id = (String) cb1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            String status = t4.getText();
            String deposit = t5.getText();
            if(r1.isSelected()){
                gender = "male";
            }
            else if (r2.isSelected()){
                gender = "Female";
            }
            String country = t3.getText();
            String room = c1.getSelectedItem();
            
            Conn c = new Conn();
            String str1 = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+status+"', '"+deposit+"')";
            String str2 = "update room set available = 'Occupied' where room_number = '"+room+"'";
            try {
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                this.setVisible(false);
                new Reception().setVisible(true);
             }
            catch (Exception e) {
               
            }
            
            
            
            
        }
        else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
        
    public static void main(String args[]){
        new AddCustomer();
    }
}
