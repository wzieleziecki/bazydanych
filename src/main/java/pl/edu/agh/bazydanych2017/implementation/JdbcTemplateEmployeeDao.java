package pl.edu.agh.bazydanych2017.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.EmployeeDao;
import pl.edu.agh.bazydanych2017.model.Employees;

@Repository
public class JdbcTemplateEmployeeDao implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getEmployeeLastName(int employeeId) {
        String GET_EMPLOYEE_LAST_NAME = "SELECT LastName FROM employees WHERE EmployeeID=?";
        String employeeLastName = jdbcTemplate.queryForObject(GET_EMPLOYEE_LAST_NAME, String.class, employeeId);
        return employeeLastName;
    }

    @Override
    public void createEmployee(Employees employees) {
        String CREATE_EMPLOYEE_SQL = "INSERT INTO employees (FirstName, LastName, Notes, Salary) VALUES (?,?,?,?);";
        int update = jdbcTemplate.update(CREATE_EMPLOYEE_SQL,employees.getFirstName(),employees.getLastName(),employees.getNotes(),employees.getSalary());

        if (update == 1){
            System.out.println("Employee is created");
        }
    }

    @Override
    public Employees getEmployeeById(Integer employeeId) {
        String GET_EMPLOYEE_BY_ID = "SELECT EmployeeID, FirstName, LastName FROM employees WHERE EmployeeID=?";
        Employees employees = jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID, new EmployeesRowMapper(), employeeId);
        return employees;
    }

    @Override
    public void updateEmployeeEmailById(Integer employeeId, String city) {
        String UPDATE_EMPLOYEE_BY_ID = "UPDATE employees SET City=? WHERE EmployeeID=?";
        int update = jdbcTemplate.update(UPDATE_EMPLOYEE_BY_ID, city, employeeId);
        if (update == 1){
            System.out.println("Employee is updated");
        }
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employees WHERE EmployeeID=?";
        int update = jdbcTemplate.update(DELETE_EMPLOYEE_BY_ID, employeeId);
        if (update == 1){
            System.out.println("Employee is deleted");
        }
    }
}