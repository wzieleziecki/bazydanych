package pl.edu.agh.bazydanych2017.dao.jdbc;

import pl.edu.agh.bazydanych2017.dao.GenericCrudDao;
import pl.edu.agh.bazydanych2017.model.Order;

import java.util.List;

//todo: nie używane przeze mnie
public interface JdbcOrderDao extends GenericCrudDao<Order, Long> {
    void deleteByCustomerId(String customerId);

    List<Order> findByCustomerId(String customerId);
}
