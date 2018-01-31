package pl.edu.agh.bazydanych2017.dao.jpa.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransactionDao;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;
import pl.edu.agh.bazydanych2017.model.Suppliers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JpaTransctionDaoImpl implements JpaTransactionDao {

    private final JpaCategoriesDao jpaCategoriesDao;
    private final JpaProductsDao jpaProductsDao;
    private final JpaProductRepository jpaProductRepository;
    private final JpaCategoriesRepository jpaCategoriesRepository;
    private final JpaSuppliersRepository jpaSuppliersRepository;

    private final Logger logger = Logger.getLogger(JpaProductsDaoImpl.class);

    public JpaTransctionDaoImpl(JpaCategoriesDao jpaCategoriesDao, JpaProductsDao jpaProductsDao, JpaProductRepository jpaProductRepository, JpaCategoriesRepository jpaCategoriesRepository, JpaSuppliersRepository jpaSuppliersRepository) {
        this.jpaCategoriesDao = jpaCategoriesDao;
        this.jpaProductsDao = jpaProductsDao;
        this.jpaProductRepository = jpaProductRepository;
        this.jpaCategoriesRepository = jpaCategoriesRepository;
        this.jpaSuppliersRepository = jpaSuppliersRepository;
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public void changeExistingCategory(String newCategory, String oldCategory, String description) {
        logger.info("JPA Start Transaction - changeExistingCategory ");
        long StartTime = System.nanoTime();
        jpaProductsDao.removeForeignKeyCategoryidFromProducts(oldCategory);
        jpaCategoriesDao.deleteCategoryByCategoryname(oldCategory);
        jpaCategoriesDao.createNewCategory(newCategory, description);
        jpaProductRepository.setCategoryidWhereCategoryidIsNull(newCategory);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA Transakcja - time " + output);

    }

    @Override
    @Transactional
    public void createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        long StartTime = System.nanoTime();
        Categories spiceFoodId = jpaCategoriesRepository.findByCategoryname(categoryname);
        Suppliers suppliers = jpaSuppliersRepository.findByCompanyname(companyname);
        Products products = new Products(productname, suppliers,spiceFoodId,quantityperunit, unitprice,unitsinstock, unitsonorder, reorderlevel, discontinued);
        em.persist(products);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA stworzenie nowego produktu Trnsakcja - time "+ output);
    }

    @Override
    @Transactional
    public void timeCreateNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        Categories spiceFoodId = jpaCategoriesRepository.findByCategoryname(categoryname);
        Suppliers suppliers = jpaSuppliersRepository.findByCompanyname(companyname);
        Products products = new Products(productname, suppliers,spiceFoodId,quantityperunit, unitprice,unitsinstock, unitsonorder, reorderlevel, discontinued);
        em.persist(products);
    }
}
