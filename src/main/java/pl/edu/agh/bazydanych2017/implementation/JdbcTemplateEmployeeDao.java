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
        return jdbcTemplate.queryForObject("SELECT LastName FROM employees where EmployeeID=?", new Object[]{employeeId},String.class);
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
        return null;
    }

    @Override
    public void updateEmployeeEmailById(Integer employeeId, String employeeEmail) {

    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {

    }
}