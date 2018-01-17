package pl.edu.agh.bazydanych2017.model;

public class ProductsCategoriesVO {

    private String categoryname;
    private String productname;
    private String quantityperunit;
    private Long unitsinstock;
    private String discontinued;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    public Long getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Long unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public String toString() {
        return "ProductsCategoriesVO{" +
                "categoryname='" + categoryname + '\'' +
                ", productname='" + productname + '\'' +
                ", quantityperunit='" + quantityperunit + '\'' +
                ", unitsinstock=" + unitsinstock +
                ", discontinued='" + discontinued + '\'' +
                '}';
    }
}
