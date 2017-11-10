package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "shippers", schema = "northwind")
public class Shipper {
    @Id
    private long shipperId;

    private String companyName;

    private String phone;

}
