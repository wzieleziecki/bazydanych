package pl.edu.agh.bazydanych2017.dao.jpa;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.dao.JpaProductRepository;
import pl.edu.agh.bazydanych2017.model.Products;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaProductsDaoImpl implements JpaProductsDao{

    private final JpaProductRepository jpaProductRepository;
    private final Logger logger = Logger.getLogger(JpaProductsDaoImpl.class);

    public JpaProductsDaoImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    //todo: zmienić nazwę zwracanej zmiennej
    @Override
    public List<Products> listProductsSortedByProductName() {
        long StartTime = System.nanoTime();
        List<Products> productList = jpaProductRepository.findAll(new Sort(Sort.Direction.ASC, "productname"));
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA list Sorted Products - time " + output);
        return productList;
    }

    public List<Products> TimelistProductsSortedByProductName() {
        List<Products> productList = jpaProductRepository.findAll(new Sort(Sort.Direction.ASC, "productname"));
        return productList;
    }

    //todo: zmienić nazwę zwracanej zmiennej
    @Override
    public Products findProductByProductName(String productName) {
        long StartTime = System.nanoTime();
        Products chai = jpaProductRepository.findByProductname(productName);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA find by product name - time "+ output);
        return chai;
    }

    @Override
    public int changeProductsUnitPriceForCategoryname(String categoryname, Double addToUnitPrice) {
        long StartTime = System.nanoTime();
        int beverages = jpaProductRepository.changeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA change unit price for category name - time "+ output);
        return beverages;
    }

    //transakcja step 1
    @Override
    public int removeForeignKeyCategoryidFromProducts(String categoryname){
        long StartTime = System.nanoTime();
        int i = jpaProductRepository.removeForeignKeyCategoryidFromProducts(categoryname);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA set null in products categoryid - time "+ output);
        return i;
    }
    //transakcja step2

    @Override
    public int setCategoryidWhereCategoryidIsNull(String categoryname) {
        long StartTime = System.nanoTime();
        int beverages = jpaProductRepository.setCategoryidWhereCategoryidIsNull(categoryname);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA set categoryid where categoryid is null - time "+ output);
        return beverages;
    }
}
