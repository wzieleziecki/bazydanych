package pl.edu.agh.bazydanych2017.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.Products;

public interface JpaProductsDao extends JpaRepository<Products, Long> {
    //select
    Products findByProductname(String productname);

    //update
    @Transactional
    @Modifying
    @Query(value = "update Products p set p.unitprice = p.unitprice+ :addToUnitPrice where p.categoryid in (select c.categoryid from Categories c where c.categoryname = :categryname)")
    int setUnitPrice(@Param("categryname") String categoryname, @Param("addToUnitPrice") Double addToUnitPrice );

    //todo: insert

    //todo: delete


}
