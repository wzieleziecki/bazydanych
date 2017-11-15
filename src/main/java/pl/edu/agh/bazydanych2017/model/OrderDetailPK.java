package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class OrderDetailPK implements Serializable {
    @Id
    private long orderId;

    @Id
    private long productId;

    public static OrderDetailPK of(long orderId, long productId) {
        OrderDetailPK orderDetailPK = new OrderDetailPK();
        orderDetailPK.setOrderId(orderId);
        orderDetailPK.setProductId(productId);
        return orderDetailPK;
    }
}
