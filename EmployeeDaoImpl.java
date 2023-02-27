package empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

 public class EmployeeDaoImpl implements EmployeeDaoIntrf {

    Connection con;

     @Override
    public int createEmployee(Employee emp) {
        Connection con=DBConnection.createDBConnection();
        String query="insert into employee values(?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            pstm.executeUpdate();
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("employee Insert succesfully!!!");

        }catch (Exception ex){
            ex.printStackTrace();
        }


       return 0;
     }

    @Override
    public void showAllEmployee() {
         con=DBConnection.createDBConnection();
         String query="select*from employee";
        System.out.println("Employee Details:");
        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","age");
        System.out.println("-------------------------");
         try{
             Statement stmt=con.createStatement();
             ResultSet result=stmt.executeQuery(query);
             while (result.next()){
                 System.out.format("%d\t%s\t%f\t%d",
                         result.getInt(1),
                         result.getString(2),
                         result.getDouble(3),
                         result.getInt(4));
                 System.out.println("-------------------------");


             }

         }catch(Exception ex){
             ex.printStackTrace();
         }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
         con=DBConnection.createDBConnection();
         String query="select*from employee where id="+id;
         try {
             Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
             while (result.next()){
                 System.out.format("%d\t%s\t%f\t%d",
                         result.getInt(1),
                         result.getString(2),
                         result.getDouble(3),
                         result.getInt(4));
                 System.out.println("-------------------------");


             }

         }catch (Exception ex){
             ex.printStackTrace();
         }

    }

    @Override
    public void updateEmployee(int id, String name) {
         con=DBConnection.createDBConnection();
         String query="update employee set name=?where id=?";
         try {
             PreparedStatement pstm=con.prepareStatement(query);
             pstm.setString(1,name);
             pstm.setInt(2,id);
              int cnt= pstm.executeUpdate();
              if(cnt!=0)
                  System.out.println("employee Details updated sucessfully!!");


         }catch(Exception ex){
             ex.printStackTrace();
         }

    }

    @Override
    public void deleteEmployee(int id) {
         con=DBConnection.createDBConnection();
         String query="delete from where id=?";
         try{
             PreparedStatement pstm=con.prepareStatement(query);
             pstm.setInt(1,id);
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Deleted Succesfully!!!!"+id);
         }catch(Exception ex ){
             ex.printStackTrace();
         }

    }
}
