package pl.edu.agh.bazydanych2017.dao.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.OrderDetailDao;
import pl.edu.agh.bazydanych2017.model.Order;

import java.util.List;

@Repository
//todo: klasa nie jest używana przeze mnie
public class JdbcJdbcOrderDao implements pl.edu.agh.bazydanych2017.dao.jdbc.JdbcOrderDao {

    private final JdbcTemplate jdbcTemplate;

    private final OrderDetailDao orderDetailDao;

    private static final RowMapper<Order> orderRowMapper = (rs, rowNum) -> {
        Order order = new Order();
        order.setOrderId(rs.getLong("OrderId"));
        order.setCustomerId(rs.getString("CustomerId"));
        order.setEmployeeId(rs.getLong("EmployeeId"));
        order.setOrderDate(rs.getTimestamp("OrderDate"));
        order.setRequiredDate(rs.getTimestamp("RequiredDate"));
        order.setShippedDate(rs.getTimestamp("ShippedDate"));
        order.setShipVia(rs.getLong("ShipVia"));
        order.setFreight(rs.getBigDecimal("Freight"));
        order.setShipName(rs.getString("ShipName"));
        order.setShipAddress(rs.getString("ShipAddress"));
        order.setShipCity(rs.getString("ShipCity"));
        order.setShipRegion(rs.getString("ShipRegion"));
        order.setShipPostalCode(rs.getString("ShipPostalCode"));
        order.setShipCountry(rs.getString("ShipCountry"));
        return order;
    };

    @Autowired
    public JdbcJdbcOrderDao(JdbcTemplate jdbcTemplate, JdbcOrderDetailDao orderDetailDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.orderDetailDao = orderDetailDao;
    }

    @Override
    public Order create(Order order) {
        String sql = "INSERT INTO `orders` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                order.getOrderId(),
                order.getCustomerId(),
                order.getEmployeeId(),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getShipVia(),
                order.getFreight(),
                order.getShipName(),
                order.getShipAddress(),
                order.getShipCity(),
                order.getShipRegion(),
                order.getShipPostalCode(),
                order.getShipCountry());
        return order;
    }

    @Override
    public Order read(Long id) {
        String sql = "SELECT * FROM orders WHERE OrderID = ?";
        return jdbcTemplate.queryForObject(sql, orderRowMapper, id);
    }

    @Override
    public List<Order> findByCustomerId(String customerId) {
        String sql = "SELECT * FROM orders WHERE CustomerID = ?";
        return jdbcTemplate.query(sql, orderRowMapper, customerId);
    }

    @Override
    public Order update(Order order) {
        String sql = "UPDATE orders " +
                "SET CustomerID = ?," +
                "EmployeeID = ?," +
                "OrderDate = ?," +
                "RequiredDate = ?," +
                "ShippedDate = ?," +
                "ShipVia = ?," +
                "Freight = ?," +
                "ShipName = ?," +
                "ShipAddress = ?," +
                "ShipCity = ?," +
                "ShipRegion = ?," +
                "ShipPostalCode = ?," +
                "ShipCountry = ?" +
                "WHERE OrderID = ?";
        jdbcTemplate.update(sql,
                order.getCustomerId(),
                order.getEmployeeId(),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getShipVia(),
                order.getFreight(),
                order.getShipName(),
                order.getShipAddress(),
                order.getShipCity(),
                order.getShipRegion(),
                order.getShipPostalCode(),
                order.getShipCountry(),
                order.getOrderId());
        return order;
    }

    @Override
    public void delete(Order order) {
        orderDetailDao.deleteByOrderId(order.getOrderId());
        String sql = "DELETE FROM orders WHERE OrderID = ?";
        jdbcTemplate.update(sql, order.getOrderId());
    }

    @Override
    public void deleteByCustomerId(String customerId) {
        List<Order> ordersByCustomer = findByCustomerId(customerId);
        ordersByCustomer.forEach(order -> orderDetailDao.deleteByOrderId(order.getOrderId()));
        String sql = "DELETE FROM orders WHERE CustomerID = ?";
        jdbcTemplate.update(sql, customerId);
    }
}
