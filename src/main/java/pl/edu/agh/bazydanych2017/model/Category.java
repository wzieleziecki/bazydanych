package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "categories", schema = "northwind")
public class Category {
    @Id
    private long categoryId;

    private String categoryName;

    private String description;

    private byte[] picture;

}
