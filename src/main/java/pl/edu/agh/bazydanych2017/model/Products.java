package pl.edu.agh.bazydanych2017.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Products {
  @Id
  private Long productid;
 // @Column(name = "ProductName")
  private String productname;
  private Long supplierid;
  @JoinColumn(name = "categoryid", referencedColumnName = "CategoryID")
  @ManyToOne
  private Categories categoryid;
  private String quantityperunit;
  private Double unitprice;
  private Long unitsinstock;
  private Long unitsonorder;
  private Long reorderlevel;
  private String discontinued;

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

  public Long getSupplierid() {
    return supplierid;
  }

  public void setSupplierid(Long supplierid) {
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

  public String getDiscontinued() {
    return discontinued;
  }

  public void setDiscontinued(String discontinued) {
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
