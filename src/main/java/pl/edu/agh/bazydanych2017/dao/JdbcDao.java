package pl.edu.agh.bazydanych2017.dao;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

public interface JdbcDao {

    String getEmployeeLastName(int employeeId);
    Products findByProductname(String productname);
    List<Products> listSortedProducts();
    int changeUnitPriceForCategoryname(Double addToUnitPrice, String categroryname );
    int createNewCategrory(String categoryname, String description);
    int deleteCategroryByCategoryname(String categoryname);
    @Transactional
    void addUniqueCategory(String categoryname, String description);
    int createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);
    @Transactional
    void removeCategory(String categoryname);
    int setNullInProductCategoryid(String categroryname);
    int deleteProductByProductname(String productname);
}

