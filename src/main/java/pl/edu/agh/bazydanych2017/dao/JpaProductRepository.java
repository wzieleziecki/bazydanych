package pl.edu.agh.bazydanych2017.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.Products;

public interface JpaProductRepository extends JpaRepository<Products,Long> {

    Products findByProductname(String productname);

    @Transactional
    @Modifying
    @Query(value = "update Products p set p.unitprice = p.unitprice+ :addToUnitPrice where p.categoryid in (select c.categoryid from Categories c where c.categoryname = :categryname)")
    int changeProductsUnitPriceForCategoryname(@Param("categryname") String categoryname, @Param("addToUnitPrice") Double addToUnitPrice );

    @Transactional
    @Modifying
    @Query(value = "update Products p set p.categoryid = null where p.categoryid in (select c.categoryid from Categories c where c.categoryname = :categryname)")
    int removeForeignKeyCategoryidFromProducts(@Param("categryname") String categoryname);

    @Transactional
    @Modifying
    @Query(value = "update Products p set p.categoryid = (select c.categoryid from Categories c where c.categoryname = :categryname) where p.categoryid = null")
    int setCategoryidWhereCategoryidIsNull(@Param("categryname") String categoryname);



}
