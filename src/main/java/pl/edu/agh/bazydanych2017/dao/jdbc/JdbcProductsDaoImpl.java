package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import pl.edu.agh.bazydanych2017.dao.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

@Repository
public class JdbcProductsDaoImpl implements JdbcProductsDao{

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
        products.setSupplierid(rs.getLong("SupplierID"));
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
    public Products findByProductname(String productname) {
        String sql = "SELECT ProductID, ProductName, SupplierID, categoryname AS CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued  FROM northwind.products \n" +
                "JOIN categories ON categories.CategoryID = products.CategoryID \n" +
                "WHERE ProductName = ?";
        return jdbcTemplate.queryForObject(sql, productsRowMapper, productname);
    }
    @Override
    public List<Products> listSortedProducts(){
        String sql = "SELECT * FROM products order by ProductName asc";
        return jdbcTemplate.query(sql, productsRowMapper);
        }

    @Override
    public int changeUnitPriceForCategoryname(Double addToUnitPrice, String categroryname) {
        String sql = "UPDATE Products SET UnitPrice = (UnitPrice + :addToUnitPrice) WHERE CategoryID = (SELECT categories.CategoryID FROM categories WHERE categories.CategoryName = :categroryname)";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("addToUnitPrice",addToUnitPrice).addValue("categroryname",categroryname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }


    //todo: insert
    @Override
    public int createNewCategrory(String categoryname, String description) {
        String sql = "INSERT INTO categories (categoryname,  description) VALUES (:categoryname, :description)";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("categoryname",categoryname).addValue("description",description);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

    //todo: delete
    @Override
    public int deleteCategroryByCategoryname(String categoryname) {
        String sql = "delete from northwind.categories where categoryid = :categoryname";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("categoryname",categoryname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }
    //todo: transaction
    @Override
    public void addUniqueCategory(String categoryname, String description){
        deleteCategroryByCategoryname(categoryname);
        createNewCategrory(categoryname, description);
    }


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
                "(SELECT supplierid FROM northwind.suppliers WHERE CompanyName = :companyname) , \n" +
                "(SELECT categoryid FROM NORTHWINd.categories WHERE CategoryName = :categoryname), \n" +
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
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

    @Override
    public void removeCategory(String categoryname) {
            setNullInProductCategoryid(categoryname);
            deleteCategroryByCategoryname(categoryname);
    }

    @Override
    public int setNullInProductCategoryid(String categroryname) {
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

}
