package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customercustomerdemo", schema = "northwind")
@IdClass(CustomerCustomerDemoPK.class)
public class CustomerCustomerDemo {
    @Id
    private String customerId;

    @Id
    private String customerTypeId;

}
