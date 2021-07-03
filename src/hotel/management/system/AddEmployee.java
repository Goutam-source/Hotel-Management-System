
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee(){
        JLabel j1 = new JLabel("NAME");
        j1.setBounds(40, 30, 120, 20);
        add(j1);
        
        t1 = new JTextField();
        t1.setBounds(170, 30, 130, 20);
        add(t1);
        
        JLabel j2 = new JLabel("AGE");
        j2.setBounds(40, 80, 120, 20);
        add(j2);
        
        t2 = new JTextField();
        t2.setBounds(170, 80, 130, 20);
        add(t2);
        
        JLabel j3 = new JLabel("GENDER");
        j3.setBounds(40, 130, 120, 20);
        add(j3);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(170, 130, 50, 20);
        r1.setBackground(Color.white);
        r1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(222, 130, 80, 20);
        r2.setBackground(Color.white);
        r2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(r2);
        
        JLabel j4 = new JLabel("JOB");
        j4.setBounds(40, 180, 120, 20);
        add(j4);
        
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox(str);
        c1.setBackground(Color.white);
        c1.setBounds(170, 180, 130, 20);
        add(c1);
        
        JLabel j5 = new JLabel("SALARY");
        j5.setBounds(40, 230, 120, 20);
        add(j5);
        
        t3 = new JTextField();
        t3.setBounds(170, 230, 130, 20);
        add(t3);
        
        JLabel j6 = new JLabel("PHONE");
        j6.setBounds(40, 280, 120, 20);
        add(j6);
        
        t4 = new JTextField();
        t4.setBounds(170, 280, 130, 20);
        add(t4);
        
        JLabel j7 = new JLabel("AADHAR");
        j7.setBounds(40, 330, 120, 20);
        add(j7);
        
        t5 = new JTextField();
        t5.setBounds(170, 330, 130, 20);
        add(t5);
        
        JLabel j8 = new JLabel("EMAIL");
        j8.setBounds(40, 380, 120, 20);
        add(j8);
        
        t6 = new JTextField();
        t6.setBounds(170, 380, 130, 20);
        add(t6);
        
        b1 = new JButton("SUBMIT");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(170, 430, 130, 20);
        b1.addActionListener(this);
        add(b1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j9 = new JLabel(i3);
        j9.setBounds(350, 80, 300, 350);
        add(j9);
        
        JLabel j10 = new JLabel("ADD EMPLOYEE DETAILS");
        j10.setFont(new Font("Tahoma", Font.PLAIN, 25));
        j10.setForeground(Color.blue);
        j10.setBounds(380, 40, 290, 70);
        add(j10);
        
        getContentPane().setBackground(Color.white);
        setBounds(430, 180, 700, 500);
        setLayout(null);
        setVisible(true);
      
    }
    
    @Override
    
     public void actionPerformed(ActionEvent ae){
         
         String name = t1.getText();
         String age = t2.getText();
         String salary = t3.getText();
         String phone = t4.getText();
         String aadhar = t5.getText();
         String email = t6.getText();
         
         String gender = null;
         if(r1.isSelected()){
             gender = "Male";
         }
         else if(r2.isSelected()){
             gender = "Female";
         }
         
         String job = (String) c1.getSelectedItem();
         
         Conn c = new Conn();
         String str = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+aadhar+"', '"+email+"')";
         
         try{
             
             c.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null, "Employee Added Succesfully");
             this.setVisible(false);
         }
         catch(Exception e){
             System.out.println(e);
         }
         
         

     }
    
    
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
