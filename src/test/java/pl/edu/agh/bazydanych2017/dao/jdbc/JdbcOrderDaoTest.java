package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.bazydanych2017.model.Order;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class JdbcOrderDaoTest extends AbstractCrudDaoTest<JdbcOrderDao, Order, Long> {

    @Autowired
    @Override
    public void setCrudDao(JdbcOrderDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    Long getPK(Order entity) {
        return entity.getOrderId();
    }

    @Override
    Order getSampleExistingEntity() {
        Order order = new Order();
        order.setOrderId(10248L);
        order.setCustomerId("VINET");
        order.setEmployeeId(5L);
        order.setOrderDate(Timestamp.valueOf("1996-07-04 00:00:00"));
        order.setRequiredDate(Timestamp.valueOf("1996-08-01 00:00:00"));
        order.setShippedDate(Timestamp.valueOf("1996-07-16 00:00:00"));
        order.setShipVia(3L);
        order.setFreight(new BigDecimal("32.3800"));
        order.setShipName("Vins et alcools Chevalier");
        order.setShipAddress("59 rue de l-Abbaye");
        order.setShipCity("Reims");
        order.setShipPostalCode("51100");
        order.setShipCountry("France");
        return order;
    }

    @Override
    Order getSampleNewEntity() {
        Order order = new Order();
        order.setOrderId(11078L);
        order.setCustomerId("ALFKI");
        order.setEmployeeId(1L);
        order.setOrderDate(Timestamp.valueOf("1997-01-01 00:00:00"));
        order.setShippedDate(Timestamp.valueOf("1997-01-01 00:00:00"));
        order.setShipVia(1L);
        return order;
    }

    @Override
    Order getModifiedExistingEntity() {
        Order order = getSampleExistingEntity();
        order.setCustomerId("ALFKI");
        order.setEmployeeId(1L);
        order.setShipVia(1L);
        return order;
    }
}