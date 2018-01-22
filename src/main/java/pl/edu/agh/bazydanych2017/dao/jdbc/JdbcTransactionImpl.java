package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDaoImpl;

@Component
public class JdbcTransactionImpl implements JdbcTransaction {

    private final JdbcProductsDao jdbcProductDao;
    private final JdbcCategoriesDao jdbcCategoriesDao;
    private final Logger logger = Logger.getLogger(JpaProductsDaoImpl.class);

    public JdbcTransactionImpl(JdbcProductsDao jdbcProductDao, JdbcCategoriesDao jdbcCategoriesDao) {
        this.jdbcProductDao = jdbcProductDao;
        this.jdbcCategoriesDao = jdbcCategoriesDao;
    }

    @Override
    public void changeExistingCategory(String newCategory, String oldCategory, String description) {
        logger.info("JDBC Start Transaction - changeExistingCategory ");
        long StartTime = System.nanoTime();
        jdbcProductDao.removeForeignKeyCategoryidFromProducts(oldCategory);
        jdbcCategoriesDao.deleteCategroryByCategoryname(oldCategory);
        jdbcCategoriesDao.createNewCategrory(newCategory, description);
        jdbcProductDao.setCategoryidWhereCategoryidIsNull(newCategory);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JDBC Transakcja - time " + output);

    }
}
