package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.bazydanych2017.model.Order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class JdbcOrderDaoTest extends AbstractCrudDaoTest<JdbcOrderDao, Order, Long> {

    private static final Long[] ORDER_IDS_OF_EXISTING_CUSTOMER = {10643L, 10692L, 10702L, 10835L, 10952L, 11011L};

    private static final String EXISTING_CUSTOMER_ID = "ALFKI";

    @Test
    public void findByCustomerId() throws Exception {
        //given
        List<Order> expectedOrders = Stream.of(ORDER_IDS_OF_EXISTING_CUSTOMER)
                .map(orderId -> crudDao.read(orderId))
                .collect(Collectors.toList());
        //when
        List<Order> orders = crudDao.findByCustomerId(EXISTING_CUSTOMER_ID);
        //then
        assertThat(orders).isEqualTo(expectedOrders);
    }

    @Test
    public void deleteByCustomerId() throws Exception {
        //given
        String customerId = EXISTING_CUSTOMER_ID;
        //when
        crudDao.deleteByCustomerId(customerId);
        //then
        List<Order> orderDetails = crudDao.findByCustomerId(customerId);
        assertThat(orderDetails).isEmpty();
    }

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
        order.setCustomerId(EXISTING_CUSTOMER_ID);
        order.setEmployeeId(1L);
        order.setOrderDate(Timestamp.valueOf("1997-01-01 00:00:00"));
        order.setShippedDate(Timestamp.valueOf("1997-01-01 00:00:00"));
        order.setShipVia(1L);
        return order;
    }

    @Override
    Order getModifiedExistingEntity() {
        Order order = getSampleExistingEntity();
        order.setCustomerId(EXISTING_CUSTOMER_ID);
        order.setEmployeeId(1L);
        order.setShipVia(1L);
        return order;
    }
}