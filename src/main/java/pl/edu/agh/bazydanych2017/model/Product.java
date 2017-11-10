package pl.edu.agh.bazydanych2017.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products", schema = "northwind")
public class Product {
    @Id
    private long productId;

    private String productName;

    private long supplierId;

    private long categoryId;

    private String quantityPerUnit;

    private BigDecimal unitPrice;

    private Short unitsInStock;

    private Short unitsOnOrder;

    private Short reorderLevel;

    private boolean discontinued;

}
