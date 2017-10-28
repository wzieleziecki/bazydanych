package pl.edu.agh.bazydanych2017.dao;

import pl.edu.agh.bazydanych2017.model.Employees;

public interface EmployeeDao {
    String getEmployeeLastName(int employeeId);
    void createEmployee(Employees employees);
    Employees getEmployeeById(Integer employeeId);
    void updateEmployeeEmailById(Integer employeeId, String city);
    void deleteEmployeeById(Integer employeeId);

}

