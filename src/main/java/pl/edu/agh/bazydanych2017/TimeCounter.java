package pl.edu.agh.bazydanych2017;

public interface TimeCounter {
    Double avarageTimeJPAListProductsSortedByProductName(int numberOfTest);

    Double avarageTimeJDBCListProductsSortedByProductName(int numberOfTest);

    Double avarageTimeJPAFindProductByProductName(int numberOfTest, String productname);

    Double avarageTimeJDBCFindProductByProductName(int numberOfTest, String productname);

    Double avarageTimeJDBCReport(int numberOfTest);

    Double avarageTimeJPAReport(int numberOfTest);

    Double avarageTimeJDBCChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice);

    Double avarageTimeJPAChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice);

    Double avarageTimeJPACreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);

    Double avarageTimeJDBCCreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);
}
