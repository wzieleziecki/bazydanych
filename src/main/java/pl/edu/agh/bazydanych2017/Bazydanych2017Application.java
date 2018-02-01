package pl.edu.agh.bazydanych2017;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportView;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcTransactionDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaReportView;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransactionDao;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaReportViewImpl;


@SpringBootApplication
public class Bazydanych2017Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Bazydanych2017Application.class, args);
	}

	private JpaProductsDao jpaProductsDao;
	private JdbcProductsDao jdbcProductDao;
	private JpaTransactionDao jpaTransactionDao;
	private JpaCategoriesDao jpaCategoriesDao;
	private JdbcTransactionDao jdbcTransactionDao;
	private TimeCounter timeCounter;
	private JpaReportView jpaReportView;
	private JdbcReportView jdbcReportView;
	private final Logger logger = Logger.getLogger(Bazydanych2017Application.class);

	public Bazydanych2017Application(JpaProductsDao jpaProductsDao, JdbcProductsDao jdbcProductDao, JpaTransactionDao jpaTransactionDao, JpaCategoriesDao jpaCategoriesDao, JdbcTransactionDao jdbcTransactionDao, TimeCounterImpl timeCounter, JpaReportViewImpl jpaReportDao, JdbcReportView jdbcReportView) {
		this.jpaProductsDao = jpaProductsDao;
		this.jdbcProductDao = jdbcProductDao;
		this.jpaTransactionDao = jpaTransactionDao;
		this.jpaCategoriesDao = jpaCategoriesDao;
		this.jdbcTransactionDao = jdbcTransactionDao;
		this.timeCounter = timeCounter;
		this.jpaReportView = jpaReportDao;
		this.jdbcReportView = jdbcReportView;
	}

	@Override
	public void run(String... args) throws Exception {
		int numberOfTest = 1;

		logger.info("JPA   "+ numberOfTest +"X test listProductsSortedByProductName        "+ timeCounter.avarageTimeJPAListProductsSortedByProductName(numberOfTest) /1000000000.0d);
		logger.info("JDBC  "+ numberOfTest +"X test listProductsSortedByProductName        "+ timeCounter.avarageTimeJDBCListProductsSortedByProductName(numberOfTest) /1000000000.0d);

		logger.info("JPA   "+ numberOfTest +"X test findProductByProductName               "+ timeCounter.avarageTimeJPAFindProductByProductName(numberOfTest,"Chai") /1000000000.0d);
		logger.info("JDBC  "+ numberOfTest +"X test findProductByProductName               "+ timeCounter.avarageTimeJDBCFindProductByProductName(numberOfTest,"Chai") /1000000000.0d);

		logger.info("JPA   "+ numberOfTest +"X test Report                                 "+ timeCounter.avarageTimeJPAReport(numberOfTest) / 1000000000.0d);
		logger.info("JDBC  "+ numberOfTest +"X test Report                                 "+ timeCounter.avarageTimeJDBCReport(numberOfTest) / 1000000000.0d);

		logger.info("JPA   "+ numberOfTest +"X test changeProductsUnitPriceForCategoryname "+ timeCounter.avarageTimeJPAChangeProductsUnitPriceForCategoryname(numberOfTest,"Beverages", 10.0) / 1000000000.0d);
		logger.info("JDBC  "+ numberOfTest +"X test changeProductsUnitPriceForCategoryname "+ timeCounter.avarageTimeJDBCChangeProductsUnitPriceForCategoryname(numberOfTest,"Beverages", 10.0) / 1000000000.0d);

		//jpaTransactionDao.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");
		//jdbcTransactionDao.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");

		logger.info("JPA   "+ numberOfTest +"X test createNewProduct                       "+ timeCounter.avarageTimeJPACreateNewProduct(numberOfTest,"Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false) / 1000000000.0d);
		logger.info("JDBC  "+ numberOfTest +"X test createNewProduct                       "+ timeCounter.avarageTimeJDBCCreateNewProduct(numberOfTest,"Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false) / 1000000000.0d);

	}
}
