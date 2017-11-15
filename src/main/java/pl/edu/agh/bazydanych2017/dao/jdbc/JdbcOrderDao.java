package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.OrderDao;
import pl.edu.agh.bazydanych2017.model.Order;

@Repository
public class JdbcOrderDao implements OrderDao {

    private final JdbcTemplate jdbcTemplate;

    private final JdbcOrderDetailDao jdbcOrderDetailDao;

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
    public JdbcOrderDao(JdbcTemplate jdbcTemplate, JdbcOrderDetailDao jdbcOrderDetailDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcOrderDetailDao = jdbcOrderDetailDao;
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
        jdbcOrderDetailDao.deleteByOrderId(order.getOrderId());
        String sql = "DELETE FROM orders WHERE OrderID = ?";
        jdbcTemplate.update(sql, order.getOrderId());
    }
}
