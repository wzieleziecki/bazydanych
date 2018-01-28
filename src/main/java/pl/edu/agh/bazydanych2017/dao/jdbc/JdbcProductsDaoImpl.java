package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;
import pl.edu.agh.bazydanych2017.model.Suppliers;

import java.util.List;

@Repository
public class JdbcProductsDaoImpl implements JdbcProductsDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private TransactionTemplate transactionTemplate;
    private final Logger logger = Logger.getLogger(JdbcProductsDaoImpl.class);

    @Autowired
    public JdbcProductsDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, TransactionTemplate transactionTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.transactionTemplate = transactionTemplate;
    }

    private static final RowMapper<Products> productsRowMapper = (rs, rowNum) ->{
        Products products = new Products();
        products.setProductid(rs.getLong("ProductID"));
        products.setProductname(rs.getString("ProductName"));
        products.setSupplierid(new Suppliers(rs.getString("SupplierID")));
        products.setCategoryid(new Categories(rs.getString("CategoryID")));
        products.setQuantityperunit(rs.getString("QuantityPerUnit"));
        products.setUnitprice(rs.getDouble("UnitPrice"));
        products.setUnitsinstock(rs.getLong("UnitsInStock"));
        products.setUnitsonorder(rs.getLong("UnitsOnOrder"));
        products.setReorderlevel(rs.getLong("ReorderLevel"));
        products.setDiscontinued(rs.getBoolean("Discontinued"));
        return products;
    };

    @Override
    public String getEmployeeLastName(int employeeId) {
        return jdbcTemplate.queryForObject("SELECT LastName FROM employees where EmployeeID=?", new Object[]{employeeId},String.class);
    }

    @Override
    public Products findProductByProductName(String productname) {
        String sql = "SELECT ProductID, ProductName, SupplierID, categoryname AS CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued  FROM northwind.products \n" +
                "JOIN categories ON categories.CategoryID = products.CategoryID \n" +
                "WHERE ProductName = ?";
        long StartTime = System.nanoTime();
        Products products = jdbcTemplate.queryForObject(sql, productsRowMapper, productname);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JDBC find by product name - time "+ output);
        return products;
    }

    public Products timeFindProductByProductName(String productname) {
        String sql = "SELECT ProductID, ProductName, SupplierID, categoryname AS CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued  FROM northwind.products \n" +
                "JOIN categories ON categories.CategoryID = products.CategoryID \n" +
                "WHERE ProductName = ?";
        Products products = jdbcTemplate.queryForObject(sql, productsRowMapper, productname);
        return products;
    }

    public Products listDetailInformationForInvoicePurpose(String productname) {
        String sql = "SELECT ProductID, ProductName, SupplierID, categoryname AS CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued  FROM northwind.products \n" +
                "JOIN categories ON categories.CategoryID = products.CategoryID \n" +
                "WHERE ProductName = ?";
        Products products = jdbcTemplate.queryForObject(sql, productsRowMapper, productname);
        return products;
    }
    @Override
    public List<Products> listProductsSortedByProductName(){
        String sql = "SELECT * FROM products order by ProductName asc";
        long StartTime = System.nanoTime();
        List<Products> listSortedProducts = jdbcTemplate.query(sql, productsRowMapper);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JDBC list Sorted Products - time "+ output / 1000000000.0);
        return listSortedProducts;
        }

    @Override
    public List<Products> TimelistProductsSortedByProductName() {
        String sql = "SELECT * FROM products order by ProductName asc";
        List<Products> productList = jdbcTemplate.query(sql, productsRowMapper);
        return productList;
    }

    @Override
    public int changeProductsUnitPriceForCategoryname(String categroryname, Double addToUnitPrice) {
        String sql = "UPDATE Products SET UnitPrice = (UnitPrice + :addToUnitPrice) WHERE CategoryID = (SELECT categories.CategoryID FROM categories WHERE categories.CategoryName = :categroryname)";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("addToUnitPrice",addToUnitPrice).addValue("categroryname",categroryname);
        long StartTime = System.nanoTime();
        int update = namedParameterJdbcTemplate.update(sql, parameter);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JDBC change unit price for category name - time "+ output);
        return update;
    }


    //todo: insert

    //todo: insert
    @Override
    public int createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        String sql = ("INSERT INTO " +
                "products \n" +
                "(ProductName, \n" +
                "SupplierID, \n" +
                "CategoryID, \n" +
                "QuantityPerUnit, \n" +
                "UnitPrice, \n" +
                "UnitsInStock,\n" +
                "UnitsOnOrder, \n" +
                "ReorderLevel, \n" +
                "Discontinued ) \n" +
                "VALUES \n" +
                "(:productname, \n" +
                "(SELECT max(supplierid) FROM northwind.suppliers WHERE CompanyName = :companyname) , \n" +
                "(SELECT max(categoryid) FROM NORTHWINd.categories WHERE CategoryName = :categoryname), \n" +
                ":quantityperunit, \n" +
                ":unitprice, \n" +
                ":unitsinstock, \n" +
                ":unitsonorder,\n" +
                ":reorderlevel, \n" +
                ":discontinued)");
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource(
                          "productname",productname)
                .addValue("companyname",companyname)
                .addValue("categoryname", categoryname)
                .addValue("quantityperunit",quantityperunit)
                .addValue("unitprice", unitprice)
                .addValue("unitsinstock", unitsinstock)
                .addValue("unitsonorder", unitsonorder)
                .addValue("reorderlevel", reorderlevel)
                .addValue("discontinued", discontinued);
        long StartTime = System.nanoTime();
        int update = namedParameterJdbcTemplate.update(sql, parameter);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JDBC stworzenie nowego produktu Trnsakcja - time"+ output);
        return update;
    }

    @Override
    public int removeForeignKeyCategoryidFromProducts(String categroryname) {
        String sql = "update products set categoryid = null where CategoryID = (SELECT CategoryID FROM categories WHERE CategoryName = :categroryname)";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("categroryname",categroryname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

    @Override
    public int deleteProductByProductname(String productname) {
        String sql = "delete from northwind.products where ProductName = :productname";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("productname",productname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

    @Override
    public int setCategoryidWhereCategoryidIsNull(String categroryname) {
        String sql = "update products set categoryid = (SELECT CategoryID FROM categories WHERE CategoryName = :categroryname) WHERE CategoryID is NULL ";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("categroryname",categroryname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

}
