package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "territories", schema = "northwind")
public class Territory {
    @Id
    private String territoryId;

    private String territoryDescription;

    private long regionId;

}
