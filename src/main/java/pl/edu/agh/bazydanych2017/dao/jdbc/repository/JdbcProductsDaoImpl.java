package pl.edu.agh.bazydanych2017.dao.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;
import pl.edu.agh.bazydanych2017.model.Suppliers;

import java.util.List;

@Repository
public class JdbcProductsDaoImpl implements JdbcProductsDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private TransactionTemplate transactionTemplate;

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
        return jdbcTemplate.queryForObject(sql, productsRowMapper, productname);
    }

    @Override
    public Products listDetailInformationForInvoicePurpose(String productname) {
        String sql = "SELECT ProductID, ProductName, SupplierID, categoryname AS CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued  FROM northwind.products \n" +
                "JOIN categories ON categories.CategoryID = products.CategoryID \n" +
                "WHERE ProductName = ?";
        return jdbcTemplate.queryForObject(sql, productsRowMapper, productname);
    }

    @Override
    public List<Products>listProductsSortedByProductName() {
        String sql = "SELECT * FROM products order by ProductName asc";
        return jdbcTemplate.query(sql, productsRowMapper);
    }

    @Override
    public int changeProductsUnitPriceForCategoryname(String categroryname, Double addToUnitPrice) {
        String sql = "UPDATE Products SET UnitPrice = (UnitPrice + :addToUnitPrice) WHERE CategoryID = (SELECT categories.CategoryID FROM categories WHERE categories.CategoryName = :categroryname)";
        SqlParameterSource parameter = new MapSqlParameterSource("addToUnitPrice",addToUnitPrice).addValue("categroryname",categroryname);
        return namedParameterJdbcTemplate.update(sql, parameter);
    }

    @Override
    public Long createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        KeyHolder holder = new GeneratedKeyHolder();
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
                "(SELECT supplierid FROM northwind.suppliers WHERE CompanyName = :companyname) , \n" +
                "(SELECT categoryid FROM NORTHWINd.categories WHERE CategoryName = :categoryname), \n" +
                ":quantityperunit, \n" +
                ":unitprice, \n" +
                ":unitsinstock, \n" +
                ":unitsonorder,\n" +
                ":reorderlevel, \n" +
                ":discontinued)");

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
        namedParameterJdbcTemplate.update(sql, parameter, holder);
        Number key = holder.getKey();
        return key.longValue();
    }

    @Override
    public int removeForeignKeyCategoryidFromProducts(String categroryname) {
        String sql = "update products set categoryid = null where CategoryID = (SELECT CategoryID FROM categories WHERE CategoryName = :categroryname)";
        SqlParameterSource parameter = new MapSqlParameterSource("categroryname",categroryname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

    @Override
    public int deleteProductByProductname(String productname) {
        String sql = "delete from northwind.products where ProductName = :productname";
        SqlParameterSource parameter = new MapSqlParameterSource("productname",productname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

    @Override
    public int setCategoryidWhereCategoryidIsNull(String categroryname) {
        String sql = "update products set categoryid = (SELECT CategoryID FROM categories WHERE CategoryName = :categroryname) WHERE CategoryID is NULL ";
        SqlParameterSource parameter = new MapSqlParameterSource("categroryname",categroryname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

}
