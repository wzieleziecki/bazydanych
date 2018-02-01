package pl.edu.agh.bazydanych2017;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcTransactionDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaReportView;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransactionDao;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaProductRepository;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportView;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaReportViewImpl;
import pl.edu.agh.bazydanych2017.model.Products;
import pl.edu.agh.bazydanych2017.model.Report;
import pl.edu.agh.bazydanych2017.model.Suppliers;

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
	private JpaTransactionDao jpaTransactionDao;

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

	@Autowired
	public void setJpaTransactionDao(JpaTransactionDao jpaTransactionDao) {
		this.jpaTransactionDao = jpaTransactionDao;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	public void checkIfQueryFindByProductnameIsEqualsInJpaJdbc(){

		Products jdbcChai = jdbcProductDao.findProductByProductName("Chai");
		Products jpaChai = jpaProductRepository.findByProductname("Chai");

		assertThat(jdbcChai).isEqualTo(jpaChai);
	}

	@Test
	@Transactional
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

	@Test
	public void checkIfNumberOfChangesEqualsInJpaJdbc(){
		//given
		int jdbcChangedBeverages = jdbcProductDao.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
		int jpaChangedBeverages = jpaProductsDao.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
		//then
		assertThat(jdbcChangedBeverages).isEqualTo(jpaChangedBeverages);
	}

	@Test
	@Transactional
	public void checkIfCreatedProductsEqualsExistingProductInJpaJdbc(){
		//given
		Products existingProduct = jpaProductRepository.findByProductid(500L);
		//when
		Long jdbcIdCreatedProduct = jdbcProductDao.createNewProduct("Dethrein", "Exotic Liquids", "Spice food", "10 boxes x 20 bags", 10D, 50L, 10L, 10L, false);
		Long jpaIdCreatedProduct = jpaTransactionDao.createNewProduct("Dethrein", "Exotic Liquids", "Spice food", "10 boxes x 20 bags", 10D, 50L, 10L, 10L, false);
		Products jpaCreatedProduct = jpaProductRepository.findByProductid(jpaIdCreatedProduct);
		Products jdbcCreatedProduct = jpaProductRepository.findByProductid(jdbcIdCreatedProduct);
		//then
		assertThat(jpaCreatedProduct).isEqualTo(existingProduct);
		assertThat(jdbcCreatedProduct).isEqualTo(existingProduct);
		assertThat(jpaCreatedProduct).isEqualTo(jdbcCreatedProduct);
	}

}
