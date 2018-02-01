package pl.edu.agh.bazydanych2017.dao.jpa.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

@Repository
public class JpaProductsDaoImpl implements JpaProductsDao {

    private final JpaProductRepository jpaProductRepository;

    public JpaProductsDaoImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public List<Products> listProductsSortedByProductName() {
        return jpaProductRepository.findAll(new Sort(Sort.Direction.ASC, "productname"));
    }

    @Override
    public Products findProductByProductName(String productName) {
        return jpaProductRepository.findByProductname(productName);
    }

//
//    @Override
//    public Products timeFindProductByProductName(String productName) {
//        Products chai = jpaProductRepository.findByProductname(productName);
//        return chai;
//    }
//

    @Override
    public int changeProductsUnitPriceForCategoryname(String categoryname, Double addToUnitPrice) {
        return jpaProductRepository.changeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
    }

    @Override
    public int removeForeignKeyCategoryidFromProducts(String categoryname){
        return jpaProductRepository.removeForeignKeyCategoryidFromProducts(categoryname);
    }

    @Override
    public int setCategoryidWhereCategoryidIsNull(String categoryname) {
        return jpaProductRepository.setCategoryidWhereCategoryidIsNull(categoryname);
    }
}
