package pl.edu.agh.bazydanych2017.dao.jdbc;

import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

public interface JdbcProductsDao {

    String getEmployeeLastName(int employeeId);

    Products findProductByProductName(String productname);

    List<Products> listProductsSortedByProductName();

    int changeProductsUnitPriceForCategoryname(String categroryname, Double addToUnitPrice );

    Long createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);

    int removeForeignKeyCategoryidFromProducts(String categroryname);

    int deleteProductByProductname(String productname);

    int setCategoryidWhereCategoryidIsNull(String categroryname);

    Products listDetailInformationForInvoicePurpose(String productname);
}

