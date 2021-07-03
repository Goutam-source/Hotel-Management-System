
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField t1, t2;
    JComboBox c1, c2, c3;
    JButton b1, b2;
    
    AddRooms(){
        JLabel j1 = new JLabel("ADD ROOMS");
        j1.setBounds(150, 30, 150, 55);
        j1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(j1);
        
        JLabel j2 = new JLabel("Room Number");
        j2.setBounds(75, 90, 120, 20);
        j2.setFont(new Font("serif", Font.PLAIN, 16));
        add(j2);
        
        t1 = new JTextField();
        t1.setBounds(220, 90, 120, 20);
        add(t1);
        
        JLabel j3 = new JLabel("Available");
        j3.setBounds(75, 140, 120, 20);
        j3.setFont(new Font("serif", Font.PLAIN, 16));
        add(j3);
        
        c1 = new JComboBox(new String[] {"Available", "Occupied"});
        c1.setBounds(220, 140, 120, 20);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel j4 = new JLabel("Cleaning Status");
        j4.setBounds(75, 190, 120, 20);
        j4.setFont(new Font("serif", Font.PLAIN, 16));
        add(j4);
        
        c2 = new JComboBox(new String[] {"Cleaned", "Dirty"});
        c2.setBounds(220, 190, 120, 20);
        c2.setBackground(Color.white);
        add(c2);
          
        JLabel j5 = new JLabel("Price");
        j5.setBounds(75, 240, 120, 20);
        j5.setFont(new Font("serif", Font.PLAIN, 16));
        add(j5);
        
        t2 = new JTextField();
        t2.setBounds(220, 240, 120, 20);
        add(t2);
        
        JLabel j6 = new JLabel("Bed Type");
        j6.setBounds(75, 290, 120, 20);
        j6.setFont(new Font("serif", Font.PLAIN, 16));
        add(j6);
        
        c3 = new JComboBox(new String[] {"Double Bed", "Single Bed"});
        c3.setBounds(220, 290, 120, 20);
        c3.setBackground(Color.white);
        add(c3);
       
        
        b1 = new JButton("Add");
        b1.setBounds(75, 340, 100, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220, 340, 100, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j7 = new JLabel(i3);
        j7.setBounds(400, 40, 350, 350);
        add(j7);
        
        setBounds(430, 180, 800, 445);
        setLayout(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            String room = t1.getText();
            String available = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();
            
            String str = "insert into room values('"+room+"', '"+available+"', '"+status+"', '"+price+"', '"+type+"')";
            
            Conn c = new Conn();
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room added succesfully");
                this.setVisible(false);
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
   public static void main(String args[]){
       new AddRooms();
   } 
}
