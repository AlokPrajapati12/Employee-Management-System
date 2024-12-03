package Employee_Managment_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class AddEmployee {
    JFrame frame;
    Random random=new Random();
    int number=random.nextInt(999999);
    JLabel name,fname,address,phone,aadhaar,email,salary,designation;
    JTextField nameText,fnameText,addressText,phoneText,aadhaarText,emailText,salaryText,designationText;
    JDateChooser date;
    JComboBox education;
    JButton add,back;
    AddEmployee(){
        frame=new JFrame();
        frame.setLocation(300,50);
        frame.setSize(900,700);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(163,255,188));

        JLabel heading =new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("sarif",Font.BOLD,25));
        frame.add(heading);

        name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(name);
        nameText=new JTextField();
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
        date=new JDateChooser();
        date.setBounds(200,200,150,30);
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
         String edu[]={"BBA","B.Tech","BCA","BA","BSC","B.COM","MBA","MCA","M.Tech","MSC","PHD"};
        education=new JComboBox<>(edu);
        education.setBounds(600,300,150,30);
        education.setBackground(new Color(177,252,197));
        frame.add(education);

        aadhaar=new JLabel("Aadhaar");
        aadhaar.setBounds(50,350,150,30);
        aadhaar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        frame.add(aadhaar);
        aadhaarText=new JTextField();
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

        add=new JButton("ADD");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameText.getText();
                String fname=fnameText.getText();
                String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
                String salary=salaryText.getText();
                String address = addressText.getText();
                String phone=phoneText.getText();
                String email=emailText.getText();
                String edu=(String)education.getSelectedItem();
                String aadhar=aadhaarText.getText();
                String designation=designationText.getText();
                String empid=empidText.getText();

                try {
                    config c=new config();
                    String q="insert into addEmp values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+edu+"','"+designation+"','"+aadhar+"','"+empid+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Employee Added Successfully");
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
            }
        });
        frame.add(back);


        frame.setVisible(true);
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
