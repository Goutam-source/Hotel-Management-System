
package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem(){
        setBounds(150,150,1366,565);
//        setSize(400,400);
//        setLocation(300,300);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1366, 565);
        add(l1);
        
        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20, 430, 1000, 70);
        l2.setForeground(Color.red);
        l2.setFont(new Font("serif", Font.PLAIN, 55)); 
        l1.add(l2);
        
        JButton b1 = new JButton("Next");
        b1.setBounds(1150, 465, 150, 50);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);
        
        setLayout(null);
        setVisible(true);
        
        while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){}
            l2.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){}
            
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
          new HotelManagementSystem();
         
    }
    
}
