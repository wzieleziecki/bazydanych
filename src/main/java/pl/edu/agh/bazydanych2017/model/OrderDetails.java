package pl.edu.agh.bazydanych2017.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderDetails implements Serializable{
  @Id
  @GeneratedValue
  @JoinColumn(name = "orderid", referencedColumnName = "OrderID")
  @ManyToOne
  private Order orderid;
  @JoinColumn(name = "productid", referencedColumnName = "ProductID")
  @ManyToOne
  //todo: umieścić w dokumnecacji jak mapować
  private Products productid;
  private Double unitprice;
  private Long quantity;
  private Double discount;

  public OrderDetails(Products productid, Double unitprice, Long quantity, Double discount) {
    this.productid = productid;
    this.unitprice = unitprice;
    this.quantity = quantity;
    this.discount = discount;
  }

  public OrderDetails() {
  }

  public Order getOrderid() {
    return orderid;
  }

  public void setOrderid(Order orderid) {
    this.orderid = orderid;
  }

  public Products getProductid() {
    return productid;
  }

  public void setProductid(Products productid) {
    this.productid = productid;
  }

  public Double getUnitprice() {
    return unitprice;
  }

  public void setUnitprice(Double unitprice) {
    this.unitprice = unitprice;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  @Override
  public String toString() {
    return "OrderDetails{" +
            "orderid=" + orderid +
            ", productid=" + productid +
            ", unitprice=" + unitprice +
            ", quantity=" + quantity +
            ", discount=" + discount +
            '}';
  }
}
