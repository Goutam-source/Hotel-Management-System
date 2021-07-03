
package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    
    Reception(){
        
        b1 = new JButton("New Customer Form");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(20, 30, 300, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Room");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(20, 70, 300, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Department");
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setBounds(20, 110, 300, 30);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("All Employee Info");
        b4.setForeground(Color.white);
        b4.setBackground(Color.black);
        b4.setBounds(20, 150, 300, 30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Customer Info");
        b5.setForeground(Color.white);
        b5.setBackground(Color.black);
        b5.setBounds(20, 190, 300, 30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Management Info");
        b6.setForeground(Color.white);
        b6.setBackground(Color.black);
        b6.setBounds(20, 230, 300, 30);
        b6.addActionListener(this);
        add(b6);
        
        b7 = new JButton("Checkout");
        b7.setForeground(Color.white);
        b7.setBackground(Color.black);
        b7.setBounds(20, 270, 300, 30);
        b7.addActionListener(this);
        add(b7);
        
        b8 = new JButton("Update Check Status");
        b8.setForeground(Color.white);
        b8.setBackground(Color.black);
        b8.setBounds(20, 310, 300, 30);
        b8.addActionListener(this);
        add(b8);
        
        b9 = new JButton("Update Room Status");
        b9.setForeground(Color.white);
        b9.setBackground(Color.black);
        b9.setBounds(20, 350, 300, 30);
        b9.addActionListener(this);
        add(b9);
        
        b10 = new JButton("Pickup Service");
        b10.setForeground(Color.white);
        b10.setBackground(Color.black);
        b10.setBounds(20, 390, 300, 30);
        b10.addActionListener(this);
        add(b10);
        
        b11 = new JButton("Search Room");
        b11.setForeground(Color.white);
        b11.setBackground(Color.black);
        b11.setBounds(20, 430, 300, 30);
        b11.addActionListener(this);
        add(b11);
        
        b12 = new JButton("Logout");
        b12.setForeground(Color.white);
        b12.setBackground(Color.black);
        b12.setBounds(20, 470, 300, 30);
        b12.addActionListener(this);
        add(b12);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        JLabel j1 = new JLabel(i1);
        j1.setBounds(350, 30, 500, 470);
        add(j1);
        
        
        setLayout(null);
        setBounds(350, 180, 890, 550);
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            new AddCustomer().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b2){
            new Room().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b3){
            this.setVisible(false);
            new Department().setVisible(true);
        }
        else if(ae.getSource() == b4){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b5){
            new CustomerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b6){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b7){
            this.setVisible(false);
            new CheckOut().setVisible(true);
        }
        else if(ae.getSource() == b8){
            this.setVisible(false);
            new UpdateCheck().setVisible(true);
        }
        else if(ae.getSource() == b9){
            new UpdateRoom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b10){
            this.setVisible(false);
            new PickUp().setVisible(true);
        }
        else if(ae.getSource() == b11){
            this.setVisible(false);
            new SearchRoom().setVisible(true);
        }
        else if(ae.getSource() == b12){
            this.setVisible(false);
        }
        
    }
    
    public static void main(String args[]){
        new Reception();
    }
    
}
