package pl.edu.agh.bazydanych2017;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.bazydanych2017.dao.JdbcDao;
import pl.edu.agh.bazydanych2017.dao.JpaProductsDao;
import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bazydanych2017ApplicationTests {

	private  JdbcDao jdbcDao;
	private  JpaProductsDao jpaProductsDao;

	@Autowired
	public void setJdbcProductsDao(JdbcDao jdbcDao) {
		this.jdbcDao = jdbcDao;
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
		Products jdbcChai = jdbcDao.findByProductname("Chai");
		Products jpaChai = jpaProductsDao.findByProductname("Chai");
		//then
		assertThat(jdbcChai).isEqualTo(jpaChai);
	}

	@Test
	public void checkIfQueryFindAllIsEqualsInJpaJdbc(){
		//given
		List<Products> jdbcProducts = jdbcDao.listSortedProducts();
		List<Products> jpaProducts = jpaProductsDao.findAll(new Sort(Sort.Direction.ASC, "productname"));
		//then
		assertThat(jdbcProducts).isEqualTo(jpaProducts);
	}

	//test update
	@Test
	public void checkIfNumberOfChangesEqualsInJpaJdbc(){
		//given
		int jdbcChangedBeverages = jdbcDao.changeUnitPriceForCategoryname(10.0,"Beverages");
		int jpaChangedBeverages = jpaProductsDao.changeUnitPriceForCategoryname("Beverages", 10.0);
		//then
		assertThat(jdbcChangedBeverages).isEqualTo(jpaChangedBeverages);
	}
	//todo: test insert



	//todo: test delete

}
