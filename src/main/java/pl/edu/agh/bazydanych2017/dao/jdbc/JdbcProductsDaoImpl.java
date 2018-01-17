package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

@Repository
public class JdbcProductsDaoImpl implements JdbcProductsDao{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcProductsDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
        products.setDiscontinued(rs.getString("Discontinued"));
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
    public List<Products> sortByProductname(){
        String sql = "SELECT * FROM products order by ProductName asc";
        return jdbcTemplate.query(sql, productsRowMapper);
        }

    @Override
    public int setUnitPrice(Double addToUnitPrice, String categroryname) {
        String sql = "UPDATE Products SET UnitPrice = (UnitPrice + :addToUnitPrice) WHERE CategoryID = (SELECT categories.CategoryID FROM categories WHERE categories.CategoryName = :categroryname)";
        SqlParameterSource parameter = new MapSqlParameterSource("addToUnitPrice",addToUnitPrice).addValue("categroryname",categroryname);
        return namedParameterJdbcTemplate.update(sql,parameter);
    }

    //todo: insert

    //todo: delete
}
