package pl.edu.agh.bazydanych2017;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.JpaProductsDao;
import pl.edu.agh.bazydanych2017.model.Products;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class RunAtStart {

    private final JdbcProductsDao jdbcProductsDao;
    private final JpaProductsDao jpaProductsDao;

    @Autowired
    public RunAtStart(JdbcProductsDao jdbcProductsDao, JpaProductsDao jpaProductsDao) {
        this.jdbcProductsDao = jdbcProductsDao;
        this.jpaProductsDao = jpaProductsDao;
    }
    @PostConstruct
    public void RunAtStart() {
       //select
        Products chai = jdbcProductsDao.findByProductname("Chai");
        System.out.println("JDBC " + chai);

        for (Products products : jdbcProductsDao.sortByProductname()) {
            System.out.println("JDBC Sort " + products);
        }

        Products findByProductname = jpaProductsDao.findByProductname("Chai");
        System.out.println("JPA " + findByProductname);

        List<Products> sortByProductname = jpaProductsDao.findAll(new Sort(Sort.Direction.ASC, "productname"));
        for (Products products : sortByProductname) {
            System.out.println("JPA Sort " + products);
        }
        //update
        jpaProductsDao.setUnitPrice("Beverages",10.0);
    }

}
