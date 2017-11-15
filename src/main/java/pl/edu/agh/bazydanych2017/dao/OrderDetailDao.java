package pl.edu.agh.bazydanych2017.dao;

import pl.edu.agh.bazydanych2017.model.OrderDetail;
import pl.edu.agh.bazydanych2017.model.OrderDetailPK;

import java.util.List;

public interface OrderDetailDao extends GenericCrudDao<OrderDetail, OrderDetailPK> {
    List<OrderDetail> findByOrderId(long orderId);

    void deleteByOrderId(long orderId);
}
