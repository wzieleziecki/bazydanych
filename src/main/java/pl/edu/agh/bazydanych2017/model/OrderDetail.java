package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order details", schema = "northwind")
@IdClass(OrderDetailPK.class)
public class OrderDetail {
    @Id
    private long orderId;

    @Id
    private long productId;

    private BigDecimal unitPrice;

    private short quantity;

    private double discount;

}
