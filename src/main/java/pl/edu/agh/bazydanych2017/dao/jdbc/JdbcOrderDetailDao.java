package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.OrderDetailDao;
import pl.edu.agh.bazydanych2017.model.OrderDetail;
import pl.edu.agh.bazydanych2017.model.OrderDetailPK;

import java.util.List;

@Repository
public class JdbcOrderDetailDao implements OrderDetailDao {

    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<OrderDetail> orderDetailRowMapper = (rs, rowNum) -> {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(rs.getLong("OrderId"));
        orderDetail.setProductId(rs.getLong("ProductId"));
        orderDetail.setUnitPrice(rs.getBigDecimal("UnitPrice"));
        orderDetail.setQuantity(rs.getShort("Quantity"));
        orderDetail.setDiscount(rs.getDouble("Discount"));
        return orderDetail;
    };

    @Autowired
    public JdbcOrderDetailDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        String sql = "INSERT INTO `order details` VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                orderDetail.getOrderId(),
                orderDetail.getProductId(),
                orderDetail.getUnitPrice(),
                orderDetail.getQuantity(),
                orderDetail.getDiscount());
        return orderDetail;
    }

    @Override
    public OrderDetail read(OrderDetailPK pk) {
        String sql = "SELECT * FROM `order details` WHERE OrderID = ? AND ProductID = ?";
        return jdbcTemplate.queryForObject(sql, orderDetailRowMapper, pk.getOrderId(), pk.getProductId());
    }

    public List<OrderDetail> findByOrderId(long orderId) {
        String sql = "SELECT * FROM `order details` WHERE OrderID = ?";
        return jdbcTemplate.query(sql, orderDetailRowMapper, orderId);
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        String sql = "UPDATE `order details` " +
                "SET UnitPrice = ?, Quantity = ?, Discount = ? " +
                "WHERE OrderID = ? AND ProductID = ?";
        jdbcTemplate.update(sql,
                orderDetail.getUnitPrice(), orderDetail.getQuantity(), orderDetail.getDiscount(),
                orderDetail.getOrderId(), orderDetail.getProductId());
        return orderDetail;
    }

    @Override
    public void delete(OrderDetail orderDetail) {
        String sql = "DELETE FROM `order details` WHERE OrderID = ? AND ProductID = ?";
        jdbcTemplate.update(sql, orderDetail.getOrderId(), orderDetail.getProductId());
    }

    public void deleteByOrderId(long orderId) {
        String sql = "DELETE FROM `order details` WHERE OrderID = ?";
        jdbcTemplate.update(sql, orderId);
    }
}
