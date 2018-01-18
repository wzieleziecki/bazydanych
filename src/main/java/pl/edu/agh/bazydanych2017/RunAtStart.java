package pl.edu.agh.bazydanych2017;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDaoImpl;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RunAtStart {

    private final JdbcProductsDao jdbcProductsDao;
    private final JpaProductsDao jpaProductsDao;
    private final JpaCategoriesDao jpaCategoriesDao;
    private JpaProductsDaoImpl jpaProductsDaoImpl;

    public RunAtStart(JdbcProductsDao jdbcProductsDao, JpaProductsDao jpaProductsDao, JpaCategoriesDao jpaCategoriesDao, JpaProductsDaoImpl jpaProductsDaoImpl) {
        this.jdbcProductsDao = jdbcProductsDao;
        this.jpaProductsDao = jpaProductsDao;
        this.jpaCategoriesDao = jpaCategoriesDao;
        this.jpaProductsDaoImpl = jpaProductsDaoImpl;
    }

    @PostConstruct
    public void RunAtStart() {
       //select
        Products chai = jdbcProductsDao.findByProductname("Chai");
        System.out.println("JDBC " + chai);

        for (Products products : jdbcProductsDao.listSortedProducts()) {
            System.out.println("JDBC Sort " + products);
        }

        Products findByProductname = jpaProductsDao.findByProductname("Chai");
        System.out.println("JPA " + findByProductname);

        List<Products> sortByProductname = jpaProductsDao.findAll(new Sort(Sort.Direction.ASC, "productname"));
        for (Products products : sortByProductname) {
            System.out.println("JPA Sort " + products);
        }
        //update
        jpaProductsDao.changeUnitPriceForCategoryname("Beverages",10.0);

        //delete
        //jdbcProductsDao.deleteSimilarCategrory("Spice food");

        //insert
        //jdbcProductsDao.createNewCategrory("Spice food", "Really spicy food from around the world");
        Categories categories = new Categories("Spice food2", "Really spicy food from around the world");
        jpaProductsDaoImpl.createCategory(categories);

        //transaction
        //jdbcProductsDao.addUniqueCategory("Spice food", "Nowa kategoria Spice Food");

        //jdbcProductsDao.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);
        Categories spiceFoodId = jpaCategoriesDao.findByCategoryname("Produce");
        System.out.println("Spice food "+ spiceFoodId);
        Products products = new Products("Dethrein JPA", 1L,spiceFoodId,"10 boxes x 20 bags", 10D,50L, 10L, 10L, false);
        jpaProductsDaoImpl.createProduct(products);

        //todo: delete category update product transaction
        //jdbcProductsDao.removeCategory("Spice food");

        //To zastapiłem transakcją removeCategory
        //jdbcProductsDao.setNullInProductCategoryid("Spice food");
        //jdbcProductsDao.deleteCategroryByCategoryname("Spice food");
        jpaCategoriesDao.deleteCategroryByCategoryname("Spice food");

        //jdbcProductsDao.deleteProductByProductname("Dethrein");
    }

}
