package pl.edu.agh.bazydanych2017.implementation;

import pl.edu.agh.bazydanych2017.model.Employees;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesRowMapper implements org.springframework.jdbc.core.RowMapper<Employees> {

    @Override
    public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employees employees = new Employees();
        employees.setEmployeeId(rs.getInt("EmployeeID"));
        employees.setFirstName(rs.getString("FirstName"));
        employees.setLastName(rs.getString("LastName"));
        return employees;
    }
}
