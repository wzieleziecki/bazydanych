package pl.edu.agh.bazydanych2017;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.JpaSuppliersRepository;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDaoImpl;

import javax.annotation.PostConstruct;

@Component
public class RunAtStart {

    private final JdbcProductsDao jdbcProductDao;
    private final JpaProductsDao jpaProductsDao;
    private final JpaCategoriesDao jpaCategoriesDao;
    private final JpaSuppliersRepository jpaSuppliersDao;
    private JpaProductsDaoImpl jpaProductsDaoImpl;
    private final Logger logger = Logger.getLogger(RunAtStart.class);

    @Autowired
    public RunAtStart(JdbcProductsDao jdbcProductDao, JpaProductsDao jpaProductsDao, JpaCategoriesDao jpaCategoriesDao, JpaSuppliersRepository jpaSuppliersDao, JpaProductsDaoImpl jpaProductsDaoImpl) {
        this.jdbcProductDao = jdbcProductDao;
        this.jpaProductsDao = jpaProductsDao;
        this.jpaCategoriesDao = jpaCategoriesDao;
        this.jpaSuppliersDao = jpaSuppliersDao;
        this.jpaProductsDaoImpl = jpaProductsDaoImpl;
    }

//    private List<Products> listProductsSortedByProductName(){
//        long StartTime = System.nanoTime();
//        List<Products> productname = jpaProductsDao.findAll(new Sort(Sort.Direction.ASC, "productname"));
//        long EndTime = System.nanoTime();
//        long output = EndTime - StartTime;
//        logger.info("JPA list Sorted Products - time "+ output);
//        return productname;
//    }

//    private Products getChai() {
//        long StartTime = System.nanoTime();
//        Products chai = jpaProductsDao.findProductByProductName("Chai");
//        long EndTime = System.nanoTime();
//        long output = EndTime - StartTime;
//        logger.info("JPA find by product name - time "+ output);
//        return chai;
//    }

//    private int changeProductsUnitPriceForCategoryname() {
//        long StartTime = System.nanoTime();
//        int beverages = jpaProductsDao.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
//        long EndTime = System.nanoTime();
//        long output = EndTime - StartTime;
//        logger.info("JPA change unit price by category name - time "+ output);
//        return beverages;
//    }

//    private void createNewCategory(String categoryname, String description){
//        Categories categories = new Categories( categoryname, description);
//        long StartTime = System.nanoTime();
//        jpaProductsDaoImpl.createCategory(categories);
//        long EndTime = System.nanoTime();
//        long output = EndTime - StartTime;
//        logger.info("JPA create new category - time "+ output);
//    }

//    todo: private void createNewProduct(){
//        long StartTime = System.nanoTime();
//        Categories spiceFoodId = jpaCategoriesDao.findByCategoryname("Produce");
//        Suppliers suppliers = jpaSuppliersDao.findByCompanyname("Tokyo Traders");
//        Products products = new Products("Dethrein JPA", suppliers,spiceFoodId,"10 boxes x 20 bags", 10D,50L, 10L, 10L, false);
//        jpaProductsDaoImpl.createProduct(products);
//        long EndTime = System.nanoTime();
//        long output = EndTime - StartTime;
//        logger.info("JPA create new product - time "+ output);
//    }

//    private void setNullProductsCategoryid(String categoryname){
//        long StartTime = System.nanoTime();
//        jpaProductsDao.setNullProdactsCategoryid(categoryname);
//        long EndTime = System.nanoTime();
//        long output = EndTime - StartTime;
//        logger.info("JPA set null in products categoryid - time "+ output);
//    }

//    private void deleteCategoryByCategoryname(String categoryname){
//        long StartTime = System.nanoTime();
//        jpaCategoriesDao.deleteCategroryByCategoryname(categoryname);
//        long EndTime = System.nanoTime();
//        long output = EndTime - StartTime;
//        logger.info("JPA delete category by categoryname - time "+ output);
//    }


    @PostConstruct
    public void RunAtStart() {

        //Sortowanie tabeli products
 //       jdbcProductDao.listProductsSortedByProductName();
 //       listProductsSortedByProductName();
        //################################

        //Znajdowanie produktu po nazwie
 //       jdbcProductDao.findProductByProductName("Chai");
 //       getChai();
        //################################

        //Zmiana ceny dla danej kategorii
      //  jdbcProductDao.changeProductsUnitPriceForCategoryname( 10.0, "Beverages");
     //   changeProductsUnitPriceForCategoryname();
        //################################

        //todo: utworzenie nowej kategorii jdbc
//        jdbcProductDao.removeForeignKeyCategoryidFromProducts("Spice food");
//        jdbcProductDao.deleteCategroryByCategoryname("Spice food");
//        jdbcProductDao.createNewCategrory("Spice food", "Really spicy food from around the world");


//        setNullProductsCategoryid("Spice food");
//        deleteCategoryByCategoryname("Spice food");
//        createNewCategory("Spice food","Really spicy food from around the world");
        //#################################

        //utworzenie nowego produktu
       //todo: jdbcProductDao.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);
//todo:         createNewProduct();
        //##################################

    }




}
