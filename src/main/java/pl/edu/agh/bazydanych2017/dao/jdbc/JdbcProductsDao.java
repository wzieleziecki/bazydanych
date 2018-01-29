package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

public interface JdbcProductsDao {

    String getEmployeeLastName(int employeeId);
    Products findProductByProductName(String productname);
    List<Products> listProductsSortedByProductName();
    int changeProductsUnitPriceForCategoryname(String categroryname, Double addToUnitPrice );
    int createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);

    int removeForeignKeyCategoryidFromProducts(String categroryname);
    int deleteProductByProductname(String productname);
    int setCategoryidWhereCategoryidIsNull(String categroryname);
    List<Products> timeListProductsSortedByProductName();
    int timeChangeProductsUnitPriceForCategoryname(String categroryname, Double addToUnitPrice);
    int timeCreateNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);
    Products listDetailInformationForInvoicePurpose(String productname);
    Products timeFindProductByProductName(String productname);

}

