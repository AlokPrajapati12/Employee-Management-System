package Employee_Managment_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class config {
    Connection connection;
    Statement statement;
    public config(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management","root","root123");
            statement=connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
