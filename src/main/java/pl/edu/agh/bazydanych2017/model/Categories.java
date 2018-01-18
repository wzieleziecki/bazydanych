package pl.edu.agh.bazydanych2017.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categories {
  @Id
  @GeneratedValue
  //@Column(name = "CategoryID")
  private Long categoryid;
  private String categoryname;
  private String description;
  private String picture;

  @OneToMany(mappedBy="categoryid")
  private List<Products> products;

    public Categories(String categoryname) {
        this.categoryname = categoryname;
    }

    public Categories() {
    }

    public Categories(String categoryname, String description) {
        this.categoryname = categoryname;
        this.description = description;
    }



    public Long getCategoryid() {
    return categoryid;
  }

  public void setCategoryid(Long categoryid) {
    this.categoryid = categoryid;
  }

  public String getCategoryname() {
    return categoryname;
  }

  public void setCategoryname(String categoryname) {
    this.categoryname = categoryname;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoryid=" + categoryid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        return categoryid.equals(that.categoryid);
    }

    @Override
    public int hashCode() {
        return categoryid.hashCode();
    }
}
