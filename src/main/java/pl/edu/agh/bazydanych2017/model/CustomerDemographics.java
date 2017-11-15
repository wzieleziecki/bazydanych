package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customerdemographics", schema = "northwind")
public class CustomerDemographics {
    @Id
    private String customerTypeID;

    private String customerDesc;

}
