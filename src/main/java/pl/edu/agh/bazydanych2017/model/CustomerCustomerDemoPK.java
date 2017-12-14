package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class CustomerCustomerDemoPK implements Serializable {
    @Id
    private String customerId;

    @Id
    private String customerTypeId;

}
