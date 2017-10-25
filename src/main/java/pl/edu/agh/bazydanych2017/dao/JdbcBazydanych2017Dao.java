package pl.edu.agh.bazydanych2017.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcBazydanych2017Dao implements JdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getEmployeeLastName(int employeeId) {
        return jdbcTemplate.queryForObject("SELECT LastName FROM employees where EmployeeID=?", new Object[]{employeeId},String.class);
    }
}
