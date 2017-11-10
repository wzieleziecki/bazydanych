package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders", schema = "northwind")
public class Order {
    @Id
    private long orderId;

    private String customerId;

    private long employeeId;

    private Timestamp orderDate;

    private Timestamp requiredDate;

    private Timestamp shippedDate;

    private long shippedVia;

    private BigDecimal freight;

    private String shipName;

    private String shipAddress;

    private String shipCity;

    private String shipRegion;

    private String shipPostalCode;

    private String shipCountry;

}
