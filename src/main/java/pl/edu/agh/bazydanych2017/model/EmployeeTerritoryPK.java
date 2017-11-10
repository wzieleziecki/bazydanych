package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class EmployeeTerritoryPK implements Serializable {
    @Id
    private long employeeId;

    @Id
    private String territoryId;

}
