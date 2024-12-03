package Employee_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class Login {
    JFrame frame;
    JLabel user,pass;
    JTextField userText;
    JPasswordField passText;
    JButton login,back;
    Login(){
       frame=new JFrame();
       frame.setSize(600,300);
       frame.setLayout(null);
       frame.setUndecorated(true);
       frame.setLocation(450,200);

       user=new JLabel("Username");
       user.setBounds(40,20,100,30);
       frame.add(user);
       userText=new JTextField();
       userText.setBounds(150,20,150,30);
       frame.add(userText);

       pass=new JLabel("Password");
       pass.setBounds(40,70,100,30);
       frame.add(pass);
       passText=new JPasswordField();
       passText.setBounds(150,70,150,30);
       frame.add(passText);

       login=new JButton("LOGIN");
       login.setBounds(150,140,150,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.white);
       login.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {

                   config c = new config();
                   String pass = passText.getText();
                   String user = userText.getText();
                   String q = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                   ResultSet resultSet = c.statement.executeQuery(q);
                   if(resultSet.next()){
                       frame.setVisible(false);
                       new MainClass();
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"Invalid username or password");
                   }
               }catch (Exception ex){
                   ex.printStackTrace();
               }
           }
       });
       frame.add(login);

        back=new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(104);
            }
        });
        frame.add(back);

        ImageIcon img11=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image Img11=img11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon img22=new ImageIcon(Img11);
        JLabel label1=new JLabel(img22);
        label1.setBounds(350,10,600,300);
        frame.add(label1);


        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image Img=img.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(Img);
        JLabel label=new JLabel(img2);
        label.setBounds(0,0,600,400);
        frame.add(label);


        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    }

}
