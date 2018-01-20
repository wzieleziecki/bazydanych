package pl.edu.agh.bazydanych2017.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Suppliers {
  @Id
  @GeneratedValue
  private Long supplierid;
  private String companyname;
  private String contactname;
  private String contacttitle;
  private String address;
  private String city;
  private String region;
  private String postalcode;
  private String country;
  private String phone;
  private String fax;
  private String homepage;

  @OneToMany(mappedBy="supplierid")
  private List<Products> products;

  public Suppliers(String companyname, String contactname, String contacttitle, String address, String city, String region, String postalcode, String country, String phone, String fax, String homepage) {
    this.companyname = companyname;
    this.contactname = contactname;
    this.contacttitle = contacttitle;
    this.address = address;
    this.city = city;
    this.region = region;
    this.postalcode = postalcode;
    this.country = country;
    this.phone = phone;
    this.fax = fax;
    this.homepage = homepage;
  }

  public Suppliers() {
  }

  public Suppliers(String companyname) {
    this.companyname = companyname;
  }

  public List<Products> getProducts() {
    return products;
  }

  public void setProducts(List<Products> products) {
    this.products = products;
  }

  public Long getSupplierid() {
    return supplierid;
  }

  public void setSupplierid(Long supplierid) {
    this.supplierid = supplierid;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public String getContactname() {
    return contactname;
  }

  public void setContactname(String contactname) {
    this.contactname = contactname;
  }

  public String getContacttitle() {
    return contacttitle;
  }

  public void setContacttitle(String contacttitle) {
    this.contacttitle = contacttitle;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getPostalcode() {
    return postalcode;
  }

  public void setPostalcode(String postalcode) {
    this.postalcode = postalcode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getHomepage() {
    return homepage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Suppliers suppliers = (Suppliers) o;

    return supplierid != null ? supplierid.equals(suppliers.supplierid) : suppliers.supplierid == null;
  }

  @Override
  public int hashCode() {
    return supplierid != null ? supplierid.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Suppliers{" +
            "supplierid=" + supplierid +
            '}';
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }
}
