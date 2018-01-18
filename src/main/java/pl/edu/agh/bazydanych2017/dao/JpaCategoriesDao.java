package pl.edu.agh.bazydanych2017.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.Categories;

public interface JpaCategoriesDao extends JpaRepository<Categories, Long>{

    Categories findByCategoryname(String categoryname);

    @Transactional
    @Modifying
    @Query(value = "delete from Categories c where c.categoryname = :categryname")
    int deleteCategroryByCategoryname(@Param("categryname") String categryname);

}
