package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "employeeterritories", schema = "northwind")
@IdClass(EmployeeTerritoryPK.class)
public class EmployeeTerritory implements Serializable {
    @Id
    private long employeeId;

    @Id
    private String territoryId;

}
