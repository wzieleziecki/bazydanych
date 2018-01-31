package pl.edu.agh.bazydanych2017.dao.jdbc.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcTransactionDao;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaProductsDaoImpl;

@Repository
public class JdbcTransactionDaoImpl implements JdbcTransactionDao {

    private final JdbcProductsDao jdbcProductDao;
    private final JdbcCategoriesDao jdbcCategoriesDao;
    private final Logger logger = Logger.getLogger(JpaProductsDaoImpl.class);

    public JdbcTransactionDaoImpl(JdbcProductsDao jdbcProductDao, JdbcCategoriesDao jdbcCategoriesDao) {
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
