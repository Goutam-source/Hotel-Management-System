
package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.color.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    
    Dashboard(){
        
        mb = new JMenuBar();
        mb.setBackground(Color.gray);
        add(mb);
        
        m1 = new JMenu("HOTEL MANAGEMENT");
        mb.add(m1);
        
        m2 = new JMenu("ADMIN");
        mb.add(m2);
        
        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(0, 0, 1950, 30);
        
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image l2 = l1.getImage().getScaledInstance(1920, 1090, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);        
        JLabel j = new JLabel(l3);
        j.setBounds(0, 0, 1550, 820);
        add(j);
        
        JLabel j1 = new JLabel("THE TAJ GROUP WELCOMES YOU!");
        j1.setBounds(400, 50, 850, 100);
        j1.setFont(new Font("Tahoma", Font.PLAIN, 50));
        j1.setForeground(Color.white);
        j.add(j1);
        
        setBounds(0, 0, 1950, 1020);
        setLayout(null);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Dashboard();
    }
}
