package pl.edu.agh.bazydanych2017;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.bazydanych2017.dao.JpaProductRepository;
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
	private JpaProductRepository jpaProductRepository;

	@Autowired
	public void setJdbcProductsDao(JdbcProductsDao jdbcProductDao) {
		this.jdbcProductDao = jdbcProductDao;
	}

	@Autowired
	public void setJpaProductsDao(JpaProductsDao jpaProductsDao) {
		this.jpaProductsDao = jpaProductsDao;
	}

	@Autowired
	public void setJpaProductRepository(JpaProductRepository jpaProductRepository) {
		this.jpaProductRepository = jpaProductRepository;
	}

	@Test
	public void contextLoads() {
	}

	//test select
	@Test
	public void checkIfQueryFindByProductnameIsEqualsInJpaJdbc(){
		//given
		Products jdbcChai = jdbcProductDao.findProductByProductName("Chai");
		Products jpaChai = jpaProductRepository.findByProductname("Chai");
		//then
		assertThat(jdbcChai).isEqualTo(jpaChai);
	}

	@Test
	public void checkIfQueryFindAllIsEqualsInJpaJdbc(){
		//given
		List<Products> jdbcProducts = jdbcProductDao.listProductsSortedByProductName();
		List<Products> jpaProducts = jpaProductsDao.listProductsSortedByProductName();
		//then
		assertThat(jdbcProducts).isEqualTo(jpaProducts);
	}

	//test update
	@Test
	public void checkIfNumberOfChangesEqualsInJpaJdbc(){
		//given
		int jdbcChangedBeverages = jdbcProductDao.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
		int jpaChangedBeverages = jpaProductsDao.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
		//then
		assertThat(jdbcChangedBeverages).isEqualTo(jpaChangedBeverages);
	}
	//todo: test insert



	//todo: test delete

}
