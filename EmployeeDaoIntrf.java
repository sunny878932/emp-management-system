package empapp;

public interface EmployeeDaoIntrf {

    //create employee
    public default int createEmployee(Employee emp) {
        return 0;
    }

    //show all employee
    public default void showAllEmployee() {

    }

    //show employee based on id
    public void showEmployeeBasedOnID(int id);
    //update employee
    public void updateEmployee(int id,String name);
    //delete employee
    public void deleteEmployee(int id);


}
