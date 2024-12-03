package Employee_Managment_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee {
    JFrame frame;
    Choice ch;
    JTable table;
    JButton serachB,print,update,back;
    ViewEmployee(){
        frame=new JFrame();
        frame.setSize(900,700);
        frame.setLayout(null);
        frame.setLocation(300,100);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(255,131,122));

        JLabel search=new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        frame.add(search);
        ch=new Choice();
        ch.setBounds(180,20,150,20);
        frame.add(ch);
        try {
            config c=new config();
            ResultSet resultSet=c.statement.executeQuery("select * from addEmp");
            while (resultSet.next()){
                ch.add(resultSet.getString("empID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table=new JTable();
        try {
            config c=new config();
            ResultSet resultSet=c.statement.executeQuery("select * from addEmp");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane pan=new JScrollPane(table);
        pan.setBounds(0,100,900,600);
        frame.add(pan);

        serachB=new JButton("Search");
        serachB.setBounds(20,70,80,20);
        serachB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from addEmp where empID = '"+ch.getSelectedItem()+"'";
                try {
                    config c=new config();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(serachB);

         print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try {
                 table.print();
              } catch (Exception ex) {
                  ex.printStackTrace();
              }
            }
        });
        frame.add(print);

        update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              frame.setVisible(false);
              new Update(ch.getSelectedItem());
            }
        });
        frame.add(update);

        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             frame.setVisible(false);
             new MainClass();
            }
        });
        frame.add(back);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new ViewEmployee();
    }
}
