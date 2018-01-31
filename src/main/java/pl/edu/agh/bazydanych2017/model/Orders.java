package pl.edu.agh.bazydanych2017.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Orders {
  @Id
  @GeneratedValue
  private Long orderid;
  @JoinColumn(name = "customerid", referencedColumnName = "CustomerID")
  @ManyToOne
  private Customers customerid;
  @JoinColumn(name = "employeeid", referencedColumnName = "EmployeeID")
  @ManyToOne
  private Employees employeeid;
  private java.sql.Timestamp orderdate;
  private java.sql.Timestamp requireddate;
  private java.sql.Timestamp shippeddate;
  @JoinColumn(name = "shipperid", referencedColumnName = "ShipperID")
  @ManyToOne
  private Shippers shipvia;
  private Double freight;
  private String shipname;
  private String shipaddress;
  private String shipcity;
  private String shipregion;
  private String shippostalcode;
  private String shipcountry;

  @OneToMany(mappedBy="orderid")
  private List<OrderDetails> orderDetails;

  public Orders(Customers customerid, Employees employeeid, Timestamp orderdate, Timestamp requireddate, Timestamp shippeddate, Shippers shipvia, Double freight, String shipname, String shipaddress, String shipcity, String shipregion, String shippostalcode, String shipcountry, List<OrderDetails> orderDetails) {
    this.customerid = customerid;
    this.employeeid = employeeid;
    this.orderdate = orderdate;
    this.requireddate = requireddate;
    this.shippeddate = shippeddate;
    this.shipvia = shipvia;
    this.freight = freight;
    this.shipname = shipname;
    this.shipaddress = shipaddress;
    this.shipcity = shipcity;
    this.shipregion = shipregion;
    this.shippostalcode = shippostalcode;
    this.shipcountry = shipcountry;
    this.orderDetails = orderDetails;
  }

  public Orders() {
  }

  public Orders(Customers customerid) {
    this.customerid = customerid;
  }

  public Long getOrderid() {
    return orderid;
  }

  public void setOrderid(Long orderid) {
    this.orderid = orderid;
  }

  public Customers getCustomerid() {
    return customerid;
  }

  public void setCustomerid(Customers customerid) {
    this.customerid = customerid;
  }

  public Employees getEmployeeid() {
    return employeeid;
  }

  public void setEmployeeid(Employees employeeid) {
    this.employeeid = employeeid;
  }

  public Timestamp getOrderdate() {
    return orderdate;
  }

  public void setOrderdate(Timestamp orderdate) {
    this.orderdate = orderdate;
  }

  public Timestamp getRequireddate() {
    return requireddate;
  }

  public void setRequireddate(Timestamp requireddate) {
    this.requireddate = requireddate;
  }

  public Timestamp getShippeddate() {
    return shippeddate;
  }

  public void setShippeddate(Timestamp shippeddate) {
    this.shippeddate = shippeddate;
  }

  public Shippers getShipvia() {
    return shipvia;
  }

  public void setShipvia(Shippers shipvia) {
    this.shipvia = shipvia;
  }

  public Double getFreight() {
    return freight;
  }

  public void setFreight(Double freight) {
    this.freight = freight;
  }

  public String getShipname() {
    return shipname;
  }

  public void setShipname(String shipname) {
    this.shipname = shipname;
  }

  public String getShipaddress() {
    return shipaddress;
  }

  public void setShipaddress(String shipaddress) {
    this.shipaddress = shipaddress;
  }

  public String getShipcity() {
    return shipcity;
  }

  public void setShipcity(String shipcity) {
    this.shipcity = shipcity;
  }

  public String getShipregion() {
    return shipregion;
  }

  public void setShipregion(String shipregion) {
    this.shipregion = shipregion;
  }

  public String getShippostalcode() {
    return shippostalcode;
  }

  public void setShippostalcode(String shippostalcode) {
    this.shippostalcode = shippostalcode;
  }

  public String getShipcountry() {
    return shipcountry;
  }

  public void setShipcountry(String shipcountry) {
    this.shipcountry = shipcountry;
  }

  public List<OrderDetails> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetails> orderDetails) {
    this.orderDetails = orderDetails;
  }

  @Override
  public String toString() {
    return "Orders{" +
            "orderid=" + orderid +
            ", customerid='" + customerid + '\'' +
            ", employeeid=" + employeeid +
            ", orderdate=" + orderdate +
            ", requireddate=" + requireddate +
            ", shippeddate=" + shippeddate +
            ", shipvia=" + shipvia +
            ", freight=" + freight +
            ", shipname='" + shipname + '\'' +
            ", shipaddress='" + shipaddress + '\'' +
            ", shipcity='" + shipcity + '\'' +
            ", shipregion='" + shipregion + '\'' +
            ", shippostalcode='" + shippostalcode + '\'' +
            ", shipcountry='" + shipcountry + '\'' +
            ", orderDetails=" + orderDetails +
            '}';
  }
}
