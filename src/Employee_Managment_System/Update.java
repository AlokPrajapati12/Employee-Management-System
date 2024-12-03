package Employee_Managment_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class Update {
    JFrame frame;
    Random random=new Random();
    int number=random.nextInt(999999);
    JLabel name,fname,address,phone,aadhaar,email,salary,designation,nameText,date,aadhaarText;
    JTextField fnameText,addressText,phoneText,emailText,salaryText,designationText,eduText;
    JButton add,back;
    String id;
    Update(String id){
        frame=new JFrame();
        this.id=id;
        frame.setLocation(300,50);
        frame.setSize(900,700);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(163,255,188));

        JLabel heading =new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("sarif",Font.BOLD,25));
        frame.add(heading);

        name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(name);
        nameText=new JLabel();
        nameText.setBounds(200,150,150,30);
        nameText.setBackground(new Color(177,252,197));
        frame.add(nameText);

        fname=new JLabel("Father Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(fname);
        fnameText=new JTextField();
        fnameText.setBounds(600,150,150,30);
        fnameText.setBackground(new Color(177,252,197));
        frame.add(fnameText);

        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(dob);
        date=new JLabel();
        date.setBounds(200,200,150,30);
        date.setFont(new Font("Tahoma",Font.BOLD,20));
        date.setBackground(new Color(177,252,197));
        frame.add(date);

        salary=new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(salary);
        salaryText=new JTextField();
        salaryText.setBounds(600,200,150,30);
        salaryText.setBackground(new Color(177,252,197));
        frame.add(salaryText);

        address=new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(address);
        addressText=new JTextField();
        addressText.setBounds(200,250,150,30);
        addressText.setBackground(new Color(177,252,197));
        frame.add(addressText);

        phone=new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(phone);
        phoneText=new JTextField();
        phoneText.setBounds(600,250,150,30);
        phoneText.setBackground(new Color(177,252,197));
        frame.add(phoneText);

        email=new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(email);
        emailText=new JTextField();
        emailText.setBounds(200,300,150,30);
        emailText.setBackground(new Color(177,252,197));
        frame.add(emailText);

        JLabel high=new JLabel("Highest Education");
        high.setBounds(400,300,200,30);
        high.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(high);
        eduText=new JTextField();
        eduText.setBounds(600,300,150,30);
        eduText.setBackground(new Color(177,252,197));
        frame.add(eduText);


        aadhaar=new JLabel("Aadhaar");
        aadhaar.setBounds(50,350,150,30);
        aadhaar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(aadhaar);
        aadhaarText=new JLabel();
        aadhaarText.setBounds(200,350,150,30);
        aadhaarText.setBackground(new Color(177,252,197));
        frame.add(aadhaarText);

        JLabel empid=new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(empid);
        JLabel empidText=new JLabel(""+number);
        empidText.setBounds(200,400,150,30);
        empidText.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        empidText.setForeground(Color.RED);
        frame.add(empidText);

        designation=new JLabel("Designation");
        designation.setBounds(400,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(designation);
        designationText=new JTextField();
        designationText.setBounds(600,350,150,30);
        designationText.setBackground(new Color(177,252,197));
        frame.add(designationText);

        try {
            config c=new config();
            String q="select * from addEmp where empID = '"+id+"' ";
            ResultSet resultSet=c.statement.executeQuery(q);
            while (resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                fnameText.setText(resultSet.getString("fname"));
                date.setText(resultSet.getString("dob"));
                addressText.setText(resultSet.getString("address"));
                salaryText.setText(resultSet.getString("salary"));
                phoneText.setText(resultSet.getString("phone"));
                emailText.setText(resultSet.getString("email"));
                eduText.setText(resultSet.getString("education"));
                designationText.setText(resultSet.getString("designation"));
                aadhaarText.setText(resultSet.getString("aadhaar"));
                empidText.setText(resultSet.getString("empID"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        add=new JButton("Update");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname=fnameText.getText();
                String salary=salaryText.getText();
                String address = addressText.getText();
                String phone=phoneText.getText();
                String email=emailText.getText();
                String edu=eduText.getText();
                String designation=designationText.getText();

                try {
                    config c=new config();
                    String q="update addEmp set fname = '"+fname+"',salary = '"+salary+"',address ='"+address+"',phone = '"+phone+"',email = '"+email+"',education ='"+edu+"',designation ='"+designation+"' where empID = '"+id+"'";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                    frame.setVisible(false);
                    new MainClass();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        frame.add(add);

        back=new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ViewEmployee();
            }
        });
        frame.add(back);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Update("");
    }
}
