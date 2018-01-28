package pl.edu.agh.bazydanych2017.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employees {
  @Id
  @GeneratedValue
  private Long employeeid;
  private String lastname;
  private String firstname;
  private String title;
  private String titleofcourtesy;
  private java.sql.Timestamp birthdate;
  private java.sql.Timestamp hiredate;
  private String address;
  private String city;
  private String region;
  private String postalcode;
  private String country;
  private String homephone;
  private String extension;
  private String photo;
  private String notes;
  private Long reportsto;
  private String photopath;
  private Double salary;

  @OneToMany(mappedBy="employeeid")
  private List<Orders> orders;

  public List<Orders> getOrders() {
    return orders;
  }

  public void setOrders(List<Orders> orders) {
    this.orders = orders;
  }

  public Long getEmployeeid() {
    return employeeid;
  }

  public void setEmployeeid(Long employeeid) {
    this.employeeid = employeeid;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitleofcourtesy() {
    return titleofcourtesy;
  }

  public void setTitleofcourtesy(String titleofcourtesy) {
    this.titleofcourtesy = titleofcourtesy;
  }

  public java.sql.Timestamp getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(java.sql.Timestamp birthdate) {
    this.birthdate = birthdate;
  }

  public java.sql.Timestamp getHiredate() {
    return hiredate;
  }

  public void setHiredate(java.sql.Timestamp hiredate) {
    this.hiredate = hiredate;
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

  public String getHomephone() {
    return homephone;
  }

  public void setHomephone(String homephone) {
    this.homephone = homephone;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Long getReportsto() {
    return reportsto;
  }

  public void setReportsto(Long reportsto) {
    this.reportsto = reportsto;
  }

  public String getPhotopath() {
    return photopath;
  }

  public void setPhotopath(String photopath) {
    this.photopath = photopath;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }
}
