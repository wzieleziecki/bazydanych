package pl.edu.agh.bazydanych2017.dao.jpa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransactionDao;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;
import pl.edu.agh.bazydanych2017.model.Suppliers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaTransctionDaoImpl implements JpaTransactionDao {

    private final JpaCategoriesDao jpaCategoriesDao;
    private final JpaProductsDao jpaProductsDao;
    private final JpaProductRepository jpaProductRepository;
    private final JpaCategoriesRepository jpaCategoriesRepository;
    private final JpaSuppliersRepository jpaSuppliersRepository;

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
        jpaProductsDao.removeForeignKeyCategoryidFromProducts(oldCategory);
        jpaCategoriesDao.deleteCategoryByCategoryname(oldCategory);
        jpaCategoriesDao.createNewCategory(newCategory, description);
        jpaProductRepository.setCategoryidWhereCategoryidIsNull(newCategory);

    }

    @Override
    @Transactional
    public Long createNewProduct(String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        Categories categorie = jpaCategoriesRepository.findByCategoryname(categoryname);
        Suppliers supplier = jpaSuppliersRepository.findByCompanyname(companyname);
        Products products = new Products(productname, supplier,categorie,quantityperunit, unitprice,unitsinstock, unitsonorder, reorderlevel, discontinued);
        em.persist(products);
        em.flush();
        return products.getProductid();
    }
}
