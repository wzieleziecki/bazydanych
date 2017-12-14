package pl.edu.agh.bazydanych2017.dao;

import pl.edu.agh.bazydanych2017.model.Order;

import java.util.List;

public interface OrderDao extends GenericCrudDao<Order, Long> {
    void deleteByCustomerId(String customerId);

    List<Order> findByCustomerId(String customerId);
}
