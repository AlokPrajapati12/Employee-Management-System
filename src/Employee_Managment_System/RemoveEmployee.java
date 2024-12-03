package Employee_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee {
    JFrame frame;
    Choice ch;
    JButton delete,back;
    RemoveEmployee(){
        frame=new JFrame();
        frame.setSize(1000,400);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocation(300,150);

        JLabel label=new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        frame.add(label);
        ch=new Choice();
        ch.setBounds(200,50,150,30);
        frame.add(ch);

        try {
            config c=new config();
            ResultSet resultSet=c.statement.executeQuery("select * from addEmp ");
            while (resultSet.next()){
                ch.add(resultSet.getString("empID"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name =new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        name.setBounds(50,100,100,30);
        frame.add(name);
        JLabel nameTet=new JLabel();
        nameTet.setBounds(200,100,150,30);
        frame.add(nameTet);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(50,150,100,30);
        phone.setFont(new Font("Tahoma",Font.BOLD,15));
        frame.add(phone);
        JLabel phoneText=new JLabel();
        phoneText.setBounds(200,150,150,30);
        frame.add(phoneText);

        JLabel email=new JLabel("Email");
        email.setBounds(50,200,100,30);
        email.setFont(new Font("Tahoma",Font.BOLD,15));
        frame.add(email);
        JLabel emailText=new JLabel();
        emailText.setBounds(200,200,150,30);
        frame.add(emailText);
        try {
            config c=new config();
            ResultSet resultSet=c.statement.executeQuery("select * from addEmp where empID='"+ch.getSelectedItem()+"'");
            while (resultSet.next()){
              nameTet.setText(resultSet.getString("name"));
              phoneText.setText(resultSet.getString("phone"));
              emailText.setText(resultSet.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    config c = new config();
                    ResultSet resultSet = c.statement.executeQuery("select * from addEmp where empID='" + ch.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        nameTet.setText(resultSet.getString("name"));
                        phoneText.setText(resultSet.getString("phone"));
                        emailText.setText(resultSet.getString("email"));


                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   config c=new config();
                   String q="delete from addEmp where empID='"+ch.getSelectedItem()+"'";
                   c.statement.executeUpdate(q);
                   JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
                   frame.setVisible(false);
                   new MainClass();

               } catch (Exception ex) {
                   ex.printStackTrace();
               }
            }
        });
        frame.add(delete);

        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainClass();
            }
        });
        frame.add(back);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image image=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(image);
        JLabel label1=new JLabel(img2);
        label1.setBounds(700,80,200,200);
        frame.add(label1);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image image1=imageIcon.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(image1);
        JLabel label2=new JLabel(imageIcon2);
        label2.setBounds(0,0,1120,630);
        frame.add(label2);



        frame.setVisible(true);
    }
    public static void main(String[] args){
        new RemoveEmployee();
    }
}
