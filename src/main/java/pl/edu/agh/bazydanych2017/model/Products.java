package pl.edu.agh.bazydanych2017.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Products {
  @Id
  @GeneratedValue
  private Long productid;
  private String productname;
  @JoinColumn(name = "supplierid", referencedColumnName = "SupplierID")
  @ManyToOne
  private Suppliers supplierid;
  @JoinColumn(name = "categoryid", referencedColumnName = "CategoryID")
  @ManyToOne
  private Categories categoryid;
  private String quantityperunit;
  private Double unitprice;
  private Long unitsinstock;
  private Long unitsonorder;
  private Long reorderlevel;
  private Boolean discontinued;

  @OneToMany(mappedBy="productid")
  private List<Products> products;


  public Products() {
  }

  public Products(String productname, Suppliers supplierid, Categories categoryid, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, Boolean discontinued) {
    this.productname = productname;
    this.supplierid = supplierid;
    this.categoryid = categoryid;
    this.quantityperunit = quantityperunit;
    this.unitprice = unitprice;
    this.unitsinstock = unitsinstock;
    this.unitsonorder = unitsonorder;
    this.reorderlevel = reorderlevel;
    this.discontinued = discontinued;
  }

  public Long getProductid() {
    return productid;
  }

  public void setProductid(Long productid) {
    this.productid = productid;
  }

  public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }

  public Suppliers getSupplierid() {
    return supplierid;
  }

  public void setSupplierid(Suppliers supplierid) {
    this.supplierid = supplierid;
  }

  public Categories getCategoryid() {
    return categoryid;
  }

  public void setCategoryid(Categories categoryid) {
    this.categoryid = categoryid;
  }

  public String getQuantityperunit() {
    return quantityperunit;
  }

  public void setQuantityperunit(String quantityperunit) {
    this.quantityperunit = quantityperunit;
  }

  public Double getUnitprice() {
    return unitprice;
  }

  public void setUnitprice(Double unitprice) {
    this.unitprice = unitprice;
  }

  public Long getUnitsinstock() {
    return unitsinstock;
  }

  public void setUnitsinstock(Long unitsinstock) {
    this.unitsinstock = unitsinstock;
  }

  public Long getUnitsonorder() {
    return unitsonorder;
  }

  public void setUnitsonorder(Long unitsonorder) {
    this.unitsonorder = unitsonorder;
  }

  public Long getReorderlevel() {
    return reorderlevel;
  }

  public void setReorderlevel(Long reorderlevel) {
    this.reorderlevel = reorderlevel;
  }

  public Boolean getDiscontinued() {
    return discontinued;
  }

  public void setDiscontinued(Boolean discontinued) {
    this.discontinued = discontinued;
  }

  @Override
  public String toString() {
    return "Products{" +
            "productid=" + productid +
            ", productname='" + productname + '\'' +
            ", supplierid=" + supplierid +
            ", categoryid=" + categoryid +
            ", quantityperunit='" + quantityperunit + '\'' +
            ", unitprice=" + unitprice +
            ", unitsinstock=" + unitsinstock +
            ", unitsonorder=" + unitsonorder +
            ", reorderlevel=" + reorderlevel +
            ", discontinued='" + discontinued + '\'' +
            '}';
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        return productid.equals(products.productid);
    }

    @Override
    public int hashCode() {
        return productid.hashCode();
    }
}
