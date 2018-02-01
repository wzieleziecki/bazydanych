package pl.edu.agh.bazydanych2017.dao.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface JpaTransactionDao {

    @Transactional
    void changeExistingCategory(String newCategory, String oldCategory, String description);

    @Transactional
    @Modifying
    Long createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued);
}
