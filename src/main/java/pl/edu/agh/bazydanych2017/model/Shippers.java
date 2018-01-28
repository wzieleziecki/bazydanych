package pl.edu.agh.bazydanych2017.model;


import javax.persistence.*;
import java.util.List;
@Entity
@SqlResultSetMapping(name = "JpaReportMaping",
classes = {
        @ConstructorResult(targetClass = Report.class,
        columns = {@ColumnResult(name="shipName", type = String.class),
                  @ColumnResult(name="shipAddress", type = String.class),
                  @ColumnResult(name="shipCity", type = String.class),
                  @ColumnResult(name="shipRegion", type = String.class),
                  @ColumnResult(name="shipPostalCode", type = String.class),
                  @ColumnResult(name="shipCountry", type = String.class),
                  @ColumnResult(name="customerID", type = String.class),
                  @ColumnResult(name="customersCompasnyName", type = String.class),
                  @ColumnResult(name="address", type = String.class),
                  @ColumnResult(name="city", type = String.class),
                  @ColumnResult(name="region", type = String.class),
                  @ColumnResult(name="postalCode", type = String.class),
                  @ColumnResult(name="country", type = String.class),
                  @ColumnResult(name="salesperson", type = String.class),
                  @ColumnResult(name="orderID", type = String.class),
                  @ColumnResult(name="orderDate", type = String.class),
                  @ColumnResult(name="requiredDate", type = String.class),
                  @ColumnResult(name="shippedDate", type = String.class),
                  @ColumnResult(name="shipersCompanyName", type = String.class),
                  @ColumnResult(name="productID", type = String.class),
                  @ColumnResult(name="productName", type = String.class),
                  @ColumnResult(name="unitPrice", type = String.class),
                  @ColumnResult(name="quantity", type = String.class),
                  @ColumnResult(name="discount", type = String.class),
                  @ColumnResult(name="extendedPrice", type = String.class),
                  @ColumnResult(name="freight", type = String.class)}
        )}
)
public class Shippers {
  @Id
  @GeneratedValue
  private Long shipperid;
  private String companyname;
  private String phone;

  @OneToMany(mappedBy="orderid")
  private List<Orders> orders;

  public List<Orders> getOrders() {
    return orders;
  }

  public void setOrders(List<Orders> orders) {
    this.orders = orders;
  }

  public Long getShipperid() {
    return shipperid;
  }

  public void setShipperid(Long shipperid) {
    this.shipperid = shipperid;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}

