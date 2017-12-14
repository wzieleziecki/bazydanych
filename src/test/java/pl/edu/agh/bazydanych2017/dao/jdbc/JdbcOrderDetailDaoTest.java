package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.bazydanych2017.model.OrderDetail;
import pl.edu.agh.bazydanych2017.model.OrderDetailPK;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class JdbcOrderDetailDaoTest extends AbstractCrudDaoTest<JdbcOrderDetailDao, OrderDetail, OrderDetailPK> {

    private static final long EXISTING_ORDER_ID = 10248L;

    private static final Long[] PRODUCT_IDS_OF_EXISTING_ORDER = {11L, 42L, 72L};

    @Test
    public void findByOrderId() throws Exception {
        //given
        long orderId = EXISTING_ORDER_ID;
        List<OrderDetail> expectedOrderDetails = Stream.of(PRODUCT_IDS_OF_EXISTING_ORDER)
                .map(productId -> OrderDetailPK.of(orderId, productId))
                .map(orderDetailPK -> crudDao.read(orderDetailPK))
                .collect(Collectors.toList());
        //when
        List<OrderDetail> orderDetails = crudDao.findByOrderId(orderId);
        //then
        assertThat(orderDetails).isEqualTo(expectedOrderDetails);
    }

    @Test
    public void deleteByOrderId() throws Exception {
        //given
        long orderId = EXISTING_ORDER_ID;
        //when
        crudDao.deleteByOrderId(orderId);
        //then
        List<OrderDetail> orderDetails = crudDao.findByOrderId(orderId);
        assertThat(orderDetails).isEmpty();
    }

    @Autowired
    @Override
    public void setCrudDao(JdbcOrderDetailDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    OrderDetailPK getPK(OrderDetail entity) {
        return OrderDetailPK.of(entity.getOrderId(), entity.getProductId());
    }

    @Override
    OrderDetail getSampleExistingEntity() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(EXISTING_ORDER_ID);
        orderDetail.setProductId(72L);
        orderDetail.setUnitPrice(new BigDecimal("34.8000"));
        orderDetail.setQuantity((short) 5);
        orderDetail.setDiscount(0d);
        return orderDetail;
    }

    @Override
    OrderDetail getSampleNewEntity() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(EXISTING_ORDER_ID);
        orderDetail.setProductId(1L);
        orderDetail.setUnitPrice(new BigDecimal("10.0000"));
        orderDetail.setQuantity((short) 1);
        orderDetail.setDiscount(0d);
        return orderDetail;
    }

    @Override
    OrderDetail getModifiedExistingEntity() {
        OrderDetail orderDetail = getSampleExistingEntity();
        orderDetail.setUnitPrice(new BigDecimal("10.0000"));
        orderDetail.setQuantity((short) 1);
        return orderDetail;
    }

}