package pl.edu.agh.bazydanych2017;

public interface TimeCounter {
    //ListProductsSortedByProductName#############################################
    //test potwierdzający że zapytanią są identyczne - checkIfQueryFindAllSortedIsEqualsInJpaJdbc
    Double avarageTimeJPAListProductsSortedByProductName(int numberOfTest);

    Double avarageTimeJDBCListProductsSortedByProductName(int numberOfTest);

    //FindProductByProductName####################################################
    //test potwierdzający że zapytanią są identyczne - checkIfQueryFindByProductnameIsEqualsInJpaJdbc
    Double avarageTimeJPAFindProductByProductName(int numberOfTest, String productname);

    Double avarageTimeJDBCFindProductByProductName(int numberOfTest, String productname);

    //DetailInformationForInvoicePurpose##########################################
    //test potwierdzający że zapytanią są identyczne - checkIfQueryReportIsEqualsInJpaJdbc przechodzi po normalnym uruchomieniu aplikacji
    Double avarageTimeJDBCReport(int numberOfTest);

    Double avarageTimeJPAReport(int numberOfTest);

    //ChangeProductsUnitPriceForCategoryname######################################
    //todo: brak testu potwierdzającego że to działa tak samo w JDBC i JPA
    Double avarageTimeJDBCChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice);

    Double avarageTimeJPAChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice);

    //CreateNewProduct############################################################
    Double avarageTimeJPACreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);

    Double avarageTimeJDBCCreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);
}
