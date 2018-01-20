package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.transaction.annotation.Transactional;

public interface JdbcTransaction {

    @Transactional
    void changeExistingCategory(String newCategory, String oldCategory, String description);
}
