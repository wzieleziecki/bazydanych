package pl.edu.agh.bazydanych2017.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

public interface JpaProductsDao {

    List<Products> listProductsSortedByProductName();

    Products findProductByProductName(String productname);

    int changeProductsUnitPriceForCategoryname(String categoryname, Double addToUnitPrice);

    int removeForeignKeyCategoryidFromProducts(String categoryname);

    int setCategoryidWhereCategoryidIsNull(String categoryname);

}
