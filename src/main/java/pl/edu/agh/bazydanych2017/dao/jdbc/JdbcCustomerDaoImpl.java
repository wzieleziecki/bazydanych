package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.CustomerDao;
import pl.edu.agh.bazydanych2017.model.Customer;

@Repository
public class JdbcCustomerDaoImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    private final JdbcOrderDao jdbcOrderDao;

    private static final RowMapper<Customer> customerRowMapper = (rs, rowNum) -> {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getNString("CustomerId"));
        customer.setCompanyName(rs.getString("CompanyName"));
        customer.setContactName(rs.getString("ContactName"));
        customer.setContactTitle(rs.getString("ContactTitle"));
        customer.setAddress(rs.getString("Address"));
        customer.setCity(rs.getString("City"));
        customer.setRegion(rs.getString("Region"));
        customer.setPostalCode(rs.getString("PostalCode"));
        customer.setCountry(rs.getString("Country"));
        customer.setPhone(rs.getString("Phone"));
        customer.setFax(rs.getString("Fax"));
        return customer;
    };

    @Autowired
    public JdbcCustomerDaoImpl(JdbcTemplate jdbcTemplate, JdbcOrderDao jdbcOrderDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcOrderDao = jdbcOrderDao;
    }

    @Override
    public Customer create(Customer customer) {
        String sql = "INSERT INTO customers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                customer.getCustomerId(),
                customer.getCompanyName(),
                customer.getContactName(),
                customer.getContactTitle(),
                customer.getAddress(),
                customer.getCity(),
                customer.getRegion(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getPhone(),
                customer.getFax());
        return customer;
    }

    @Override
    public Customer read(String s) {
        String sql = "SELECT * FROM customers WHERE CustomerID = ?";
        return jdbcTemplate.queryForObject(sql, customerRowMapper, s);
    }

    @Override
    public Customer update(Customer customer) {
        String sql = "UPDATE customers " +
                "SET CompanyName = ?," +
                "ContactName = ?," +
                "ContactTitle = ?," +
                "Address = ?," +
                "City = ?," +
                "Region = ?," +
                "PostalCode = ?," +
                "Country = ?," +
                "Phone = ?," +
                "Fax = ?" +
                "WHERE CustomerId = ?";
        jdbcTemplate.update(sql,
                customer.getCompanyName(),
                customer.getContactName(),
                customer.getContactTitle(),
                customer.getAddress(),
                customer.getCity(),
                customer.getRegion(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getPhone(),
                customer.getFax(),
                customer.getCustomerId());
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        jdbcOrderDao.deleteByCustomerId(customer.getCustomerId());
        String sql = "DELETE FROM customers WHERE CustomerID = ?";
        jdbcTemplate.update(sql, customer.getCustomerId());
    }
}
