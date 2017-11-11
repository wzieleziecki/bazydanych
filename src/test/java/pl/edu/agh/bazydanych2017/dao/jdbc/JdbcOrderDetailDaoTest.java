package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.OrderDetail;
import pl.edu.agh.bazydanych2017.model.OrderDetailPK;

import java.math.BigDecimal;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JdbcOrderDetailDaoTest extends AbstractDaoTest<JdbcOrderDetailDao, OrderDetail, OrderDetailPK>{

    @Autowired
    @Override
    public void setCrudDao(JdbcOrderDetailDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    OrderDetailPK getPK(OrderDetail entity) {
        OrderDetailPK pk = new OrderDetailPK();
        pk.setOrderId(entity.getOrderId());
        pk.setProductId(entity.getProductId());
        return pk;
    }

    @Override
    OrderDetail getSampleExistingEntity() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(10248L);
        orderDetail.setProductId(72L);
        orderDetail.setUnitPrice(new BigDecimal("34.8000"));
        orderDetail.setQuantity((short)5);
        orderDetail.setDiscount(0d);
        return orderDetail;
    }

    @Override
    OrderDetail getSampleNewEntity() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(10248L);
        orderDetail.setProductId(1L);
        orderDetail.setUnitPrice(new BigDecimal("10.0000"));
        orderDetail.setQuantity((short)1);
        orderDetail.setDiscount(0d);
        return orderDetail;
    }

    @Override
    OrderDetail getModifiedExistingEntity() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(10248L);
        orderDetail.setProductId(72L);
        orderDetail.setUnitPrice(new BigDecimal("10.0000"));
        orderDetail.setQuantity((short)1);
        orderDetail.setDiscount(0d);
        return orderDetail;
    }

}