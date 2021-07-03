
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;


public class AddDriver extends JFrame implements ActionListener{
    
    
    JTextField t1, t2,t3,t4,t5;
    JComboBox c1, c2;
    JButton b1, b2;
    
    AddDriver(){
        JLabel j1 = new JLabel("ADD Drivers");
        j1.setBounds(150, 30, 150, 55);
        j1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j1);
        
        JLabel j2 = new JLabel("Name");
        j2.setBounds(75, 90, 120, 20);
        j2.setFont(new Font("serif", Font.PLAIN, 16));
        add(j2);
        
        t1 = new JTextField();
        t1.setBounds(220, 90, 120, 20);
        add(t1);
        
        JLabel j3 = new JLabel("Age");
        j3.setBounds(75, 140, 120, 20);
        j3.setFont(new Font("serif", Font.PLAIN, 16));
        add(j3);
        
        t2 = new JTextField();
        t2.setBounds(220, 140, 120, 20);
        add(t2);
        
        
        JLabel j4 = new JLabel("Gender");
        j4.setBounds(75, 190, 120, 20);
        j4.setFont(new Font("serif", Font.PLAIN, 16));
        add(j4);
        
        c1 = new JComboBox(new String[] {"Male", "Female"});
        c1.setBounds(220, 190, 120, 20);
        c1.setBackground(Color.white);
        add(c1);
          
        JLabel j5 = new JLabel("Car Brand");
        j5.setBounds(75, 240, 120, 20);
        j5.setFont(new Font("serif", Font.PLAIN, 16));
        add(j5);
        
        t3 = new JTextField();
        t3.setBounds(220, 240, 120, 20);
        add(t3);
        
        JLabel j6 = new JLabel("Car Model");
        j6.setBounds(75, 290, 120, 20);
        j6.setFont(new Font("serif", Font.PLAIN, 16));
        add(j6);
        
        t4 = new JTextField();
        t4.setBounds(220, 290, 120, 20);
        add(t4);
        
        JLabel j7 = new JLabel("Available");
        j7.setBounds(75, 340, 120, 20);
        j7.setFont(new Font("serif", Font.PLAIN, 16));
        add(j7);
        
        c2 = new JComboBox(new String[] {"Available", "Not available"});
        c2.setBounds(220, 340, 120, 20);
        c2.setBackground(Color.white);
        add(c2);
        
        JLabel j8 = new JLabel("Location");
        j8.setBounds(75, 390, 120, 20);
        j8.setFont(new Font("serif", Font.PLAIN, 16));
        add(j8);
        
        t5 = new JTextField();
        t5.setBounds(220, 390, 120, 20);
        add(t5);
       
        
        b1 = new JButton("Add");
        b1.setBounds(75, 440, 100, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220, 440, 100, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j9 = new JLabel(i3);
        j9.setBounds(400, 40, 500, 450);
        add(j9);
        
        setBounds(350, 180, 950, 545);
        setLayout(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String car = t3.getText();
            String model = t4.getText();
            String available = (String) c2.getSelectedItem();
            String location = t5.getText();
            
            
            String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+car+"', '"+model+"', '"+available+"', '"+location+"')";
            
            Conn c = new Conn();
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver added succesfully");
                this.setVisible(false);
            }
            catch(HeadlessException | SQLException e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
   public static void main(String args[]){
       new AddDriver();
   } 
}

    

