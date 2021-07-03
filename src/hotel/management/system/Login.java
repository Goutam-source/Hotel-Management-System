
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JButton b1,b2;
    JTextField t1;
    JPasswordField t2;
    ImageIcon i1;
    
    
    Login(){
        
        l1 = new JLabel("Username");
        l1.setBounds(50, 60, 100, 30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(50, 90, 100, 30);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150, 70, 130, 20);
        add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(150, 95, 130, 20);
        add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(50, 150, 100, 20);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        
        b2 = new JButton("Cancel");
        b2.setBounds(170, 150, 100, 20);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(350, 20, 200, 200);
        add(l3);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500, 300, 600, 400);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = t1.getText();
            String password = t2.getText();
            Conn c = new Conn();
            
            String str = "select * from login where username='"+username+"' and password='"+password+"'";
            
            try{
                ResultSet rs = c.s.executeQuery(str);
                
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    this.setVisible(false);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == b2){
            System.exit(0);
        }
    }
    
    public static void main(String args[]){
          new Login();
    }
    
}