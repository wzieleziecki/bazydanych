package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "employees", schema = "northwind")
public class Employee {
    @Id
    private long employeeId;

    private String lastName;

    private String firstName;

    private String title;

    private String titleOfCourtesy;

    private Timestamp birthDate;

    private Timestamp hireDate;

    private String address;

    private String city;

    private String region;

    private String postalCode;

    private String country;

    private String homePhone;

    private String extension;

    private byte[] photo;

    private String notes;

    private long reportsTo;

    private String photoPath;

    private Double salary;

}
