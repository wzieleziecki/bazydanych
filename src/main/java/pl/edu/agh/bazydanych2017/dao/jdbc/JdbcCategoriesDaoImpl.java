package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;
@Component
public class JdbcCategoriesDaoImpl implements JdbcCategoriesDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private TransactionTemplate transactionTemplate;
    private final Logger logger = Logger.getLogger(JdbcProductsDaoImpl.class);

    public JdbcCategoriesDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, TransactionTemplate transactionTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public int deleteCategroryByCategoryname(String categoryname) {
        String sql = "delete from northwind.categories where categoryid = :categoryname";
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("categoryname",categoryname);
        long StartTime = System.nanoTime();
        int update = namedParameterJdbcTemplate.update(sql, parameter);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JDBC delete category by category name - time "+ output);
        return update;
    }
    //todo: transaction
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
        //todo: zmienić sposób podawania argumentów
        SqlParameterSource parameter = new MapSqlParameterSource("categoryname",categoryname).addValue("description",description);
        long StartTime = System.nanoTime();
        int update = namedParameterJdbcTemplate.update(sql, parameter);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JDBC create new category - time "+ output);
        return update;
    }
}
