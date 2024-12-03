package Employee_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {
     JFrame frame;
     JButton add,view,remove,back;
    MainClass(){
      frame=new JFrame();
      frame.setSize(1120,630);
      frame.setLayout(null);
      frame.setUndecorated(true);
      frame.setLocation(250,100);
      ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image image=img.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(image);
        JLabel label=new JLabel(img2);
        label.setBounds(0,0,1120,630);
        frame.add(label);

        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        label.add(heading);

        add=new JButton("Add Employee");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(335,270,150,40);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new AddEmployee();
            }
        });
        label.add(add);

        view=new JButton("View Employee");
        view.setForeground(Color.white);
        view.setBackground(Color.BLACK);
        view.setBounds(565,270,150,40);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              frame.setVisible(false);
              new ViewEmployee();
            }
        });
        label.add(view);

        remove=new JButton("Remove Employee");
        remove.setForeground(Color.white);
        remove.setBackground(Color.BLACK);
        remove.setBounds(440,370,150,40);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RemoveEmployee();
            }
        });
        label.add(remove);

        back=new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(970,10,100,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
        label.add(back);



        frame.setVisible(true);
    }

    public static void main(String[] args){
        new MainClass();
    }
}
