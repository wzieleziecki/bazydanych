package pl.edu.agh.bazydanych2017;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaReportView;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaProductRepository;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportView;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaReportViewImpl;
import pl.edu.agh.bazydanych2017.model.Products;
import pl.edu.agh.bazydanych2017.model.Report;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bazydanych2017ApplicationTests {

	private JdbcProductsDao jdbcProductDao;
	private JpaProductsDao jpaProductsDao;
	private JpaProductRepository jpaProductRepository;
	private JpaReportView jpaReportView;
	private JdbcReportView jdbcReportView;

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

	@Autowired
	public void setJpaReportView(JpaReportViewImpl jpaReportView) {
		this.jpaReportView = jpaReportView;
	}

	@Autowired
	public void setJdbcReportView(JdbcReportView jdbcReportView) {
		this.jdbcReportView = jdbcReportView;
	}

	@Test
	public void contextLoads() {
	}

	//test select
	@Test
	public void checkIfQueryFindByProductnameIsEqualsInJpaJdbc(){

		Products jdbcChai = jdbcProductDao.findProductByProductName("Chai");
		Products jpaChai = jpaProductRepository.findByProductname("Chai");

		assertThat(jdbcChai).isEqualTo(jpaChai);
	}

	@Test
	public void checkIfQueryFindAllSortedIsEqualsInJpaJdbc(){

		List<Products> jdbcProducts = jdbcProductDao.listProductsSortedByProductName();
		List<Products> jpaProducts = jpaProductsDao.listProductsSortedByProductName();

		assertThat(jdbcProducts).isEqualTo(jpaProducts);
	}

	@Test
	public void checkIfQueryReportIsEqualsInJpaJdbc(){

		List<Report> jpaReports = jpaReportView.detailInformationForInvoice();
		List<Report> jdbcReports = jdbcReportView.detailInformationForInvoice();

		assertThat(jpaReports).isEqualTo(jdbcReports);
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
