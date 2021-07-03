
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    JComboBox cb1;
    JCheckBox c1;
    
    SearchRoom(){
        JLabel j1 = new JLabel("Search For Room");
        j1.setFont(new Font("Tahoma", Font.BOLD, 18));
        j1.setBounds(80, 30, 180, 30);
        add(j1);
        
        cb1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        cb1.setBounds(30, 90, 180, 20);
        add(cb1);
        
        c1 = new JCheckBox("Only Display Available");
        c1.setBounds(300, 90, 180, 20);
        c1.setFont(new Font("serif", Font.PLAIN, 14));
        add(c1);
        
        t1 = new JTable();
        t1.setBounds(0, 180, 800, 390);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(150, 600, 100, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(450, 600, 100, 30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel j2 = new JLabel("Room Number");
        j2.setFont(new Font("Tahoma", Font.BOLD, 16));
        j2.setBounds(20, 150, 150, 30);
        add(j2);
        
        JLabel j3 = new JLabel("Status");
        j3.setFont(new Font("Tahoma", Font.BOLD, 16));
        j3.setBounds(210, 150, 150, 30);
        add(j3);
        
        JLabel j4 = new JLabel("Condition");
        j4.setFont(new Font("Tahoma", Font.BOLD, 16));
        j4.setBounds(340, 150, 180, 30);
        add(j4);
        
        JLabel j5 = new JLabel("Price");
        j5.setFont(new Font("Tahoma", Font.BOLD, 16));
        j5.setBounds(530, 150, 180, 30);
        add(j5);
        
        JLabel j6 = new JLabel("Bed Type");
        j6.setFont(new Font("Tahoma", Font.BOLD, 16));
        j6.setBounds(670, 150, 180, 30);
        add(j6);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(400, 100, 800, 700);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String str1 = "select * from room where bed_type = '"+cb1.getSelectedItem()+"'";
            String str2 = "select * from room where available = 'Available' AND bed_type = '"+cb1.getSelectedItem()+"'";
            Conn c = new Conn();
            ResultSet rs;
            try{
                if(c1.isSelected()){
                    rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else{
                    rs = c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SearchRoom();
    }
}
