package pl.edu.agh.bazydanych2017.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface JpaCategoriesDao {

    @Transactional
    @Modifying
    int deleteCategoryByCategoryname(String categoryname);
    @Transactional
    @Modifying
    void createNewCategory(String categoryname, String description);

}
