package empapp;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class DBConnection {
     static Connection con;
    public static Connection createDBConnection(){
        try{
            //load driver
             Class forName = forName("com.mysql.jdbc.Driver");
            //get connection
            String url="jdbc:mysql://localhost:3306//employeedb?useSSL=false";
            String username="root";
            String password="Vikash@932";
          con= DriverManager.getConnection(url,username,password);

        }catch(Exception ex){
            ex.printStackTrace();

        }

        return con;

    }


}
