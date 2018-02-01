package pl.edu.agh.bazydanych2017.dao.jdbc.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcCategoriesDao;

@Repository
public class JdbcCategoriesDaoImpl implements JdbcCategoriesDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private TransactionTemplate transactionTemplate;

    public JdbcCategoriesDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, TransactionTemplate transactionTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public int deleteCategroryByCategoryname(String categoryname) {
        String sql = "delete from northwind.categories where categoryid = :categoryname";
        SqlParameterSource parameter = new MapSqlParameterSource("categoryname",categoryname);
        return namedParameterJdbcTemplate.update(sql, parameter);
    }
    @Override
    public void addUniqueCategory(String categoryname, String description){
        deleteCategroryByCategoryname(categoryname);
        createNewCategrory(categoryname, description);
    }

//    @Override
//    public void removeCategory(String categoryname) {
//        removeForeignKeyCategoryidFromProducts(categoryname);
//        deleteCategroryByCategoryname(categoryname);
//    }

    @Override
    public int createNewCategrory(String categoryname, String description) {
        String sql = "INSERT INTO categories (categoryname,  description) VALUES (:categoryname, :description)";
        SqlParameterSource parameter = new MapSqlParameterSource("categoryname",categoryname).addValue("description",description);
        return namedParameterJdbcTemplate.update(sql, parameter);
    }
}
