package pl.edu.agh.bazydanych2017;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bazydanych2017ApplicationTests {

	private JdbcProductsDao jdbcProductDao;
	private  JpaProductsDao jpaProductsDao;

	@Autowired
	public void setJdbcProductsDao(JdbcProductsDao jdbcProductDao) {
		this.jdbcProductDao = jdbcProductDao;
	}

	@Autowired
	public void setJpaProductsDao(JpaProductsDao jpaProductsDao) {
		this.jpaProductsDao = jpaProductsDao;
	}

	@Test
	public void contextLoads() {
	}

	//test select
	@Test
	public void checkIfQueryFindByProductnameIsEqualsInJpaJdbc(){
		//given
		Products jdbcChai = jdbcProductDao.findProductByProductName("Chai");
		Products jpaChai = jpaProductsDao.findByProductname("Chai");
		//then
		assertThat(jdbcChai).isEqualTo(jpaChai);
	}

	@Test
	public void checkIfQueryFindAllIsEqualsInJpaJdbc(){
		//given
		List<Products> jdbcProducts = jdbcProductDao.listProductsSortedByProductName();
		List<Products> jpaProducts = jpaProductsDao.findAll(new Sort(Sort.Direction.ASC, "productname"));
		//then
		assertThat(jdbcProducts).isEqualTo(jpaProducts);
	}

	//test update
	@Test
	public void checkIfNumberOfChangesEqualsInJpaJdbc(){
		//given
		int jdbcChangedBeverages = jdbcProductDao.changeProductsUnitPriceForCategoryname(10.0,"Beverages");
		int jpaChangedBeverages = jpaProductsDao.changeUnitPriceForCategoryname("Beverages", 10.0);
		//then
		assertThat(jdbcChangedBeverages).isEqualTo(jpaChangedBeverages);
	}
	//todo: test insert



	//todo: test delete

}
