package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.springframework.transaction.annotation.Transactional;

public interface JdbcCategoriesDao {

    int createNewCategrory(String categoryname, String description);
    int deleteCategroryByCategoryname(String categoryname);
    @Transactional
    void addUniqueCategory(String categoryname, String description);
}
