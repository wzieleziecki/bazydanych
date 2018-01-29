package pl.edu.agh.bazydanych2017;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcTransactionDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaReportDao;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaReportDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransactionDao;
import org.apache.log4j.Logger;

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
	private JpaReportDao jpaReportDao;
	private JdbcReportDao jdbcReportDao;
	private final Logger logger = Logger.getLogger(Bazydanych2017Application.class);

	public Bazydanych2017Application(JpaProductsDao jpaProductsDao, JdbcProductsDao jdbcProductDao, JpaTransactionDao jpaTransactionDao, JpaCategoriesDao jpaCategoriesDao, JdbcTransactionDao jdbcTransactionDao, TimeCounterImpl timeCounter, JpaReportDaoImpl jpaReportDao, JdbcReportDao jdbcReportDao) {
		this.jpaProductsDao = jpaProductsDao;
		this.jdbcProductDao = jdbcProductDao;
		this.jpaTransactionDao = jpaTransactionDao;
		this.jpaCategoriesDao = jpaCategoriesDao;
		this.jdbcTransactionDao = jdbcTransactionDao;
		this.timeCounter = timeCounter;
		this.jpaReportDao = jpaReportDao;
		this.jdbcReportDao = jdbcReportDao;
	}

	@Override
	public void run(String... args) throws Exception {
		int numberOfTest = 100;
		//todo: refaktoryzacja interfejsów i klas jpadao i jdbcdao
		logger.info("JPA   "+ numberOfTest +" test listProductsSortedByProductName        "+ (double) timeCounter.avarageTimeJPAListProductsSortedByProductName(numberOfTest)/ 1000000000.0);
		logger.info("JDBC  "+ numberOfTest +" test listProductsSortedByProductName        "+ (double) timeCounter.avarageTimeJDBCListProductsSortedByProductName(numberOfTest)/ 1000000000.0);

		logger.info("JPA   "+ numberOfTest +" test FindProductByProductName               "+ (double) timeCounter.avarageTimeJPAFindProductByProductName(numberOfTest,"Chai")/ 1000000000.0);
		logger.info("JDBC  "+ numberOfTest +" test FindProductByProductName               "+ (double) timeCounter.avarageTimeJDBCFindProductByProductName(numberOfTest,"Chai")/ 1000000000.0);

		logger.info("JPA   "+ numberOfTest +" test Report                                 "+ (double) timeCounter.avarageTimeJPAReport(numberOfTest)/ 1000000000.0);
		logger.info("JDBC  "+ numberOfTest +" test Report                                 "+ (double) timeCounter.avarageTimeJDBCReport(numberOfTest)/ 1000000000.0);

		logger.info("JPA   "+ numberOfTest +" test changeProductsUnitPriceForCategoryname "+ (double) timeCounter.avarageTimeJPAChangeProductsUnitPriceForCategoryname(numberOfTest,"Beverages", 10.0)/ 1000000000.0);
		logger.info("JDBC  "+ numberOfTest +" test changeProductsUnitPriceForCategoryname "+ (double) timeCounter.avarageTimeJDBCChangeProductsUnitPriceForCategoryname(numberOfTest,"Beverages", 10.0)/ 1000000000.0);

	//	jpaTransactionDao.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");
	//	jdbcTransactionDao.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");

		logger.info("JPA   "+ numberOfTest +" test createNewProduct                       "+ (double) timeCounter.avarageTimeJPACreateNewProduct(numberOfTest,"Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false)/ 1000000000.0);
		logger.info("JDBC  "+ numberOfTest +" test createNewProduct                       "+ (double) timeCounter.avarageTimeJDBCCreateNewProduct(numberOfTest,"Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false)/ 1000000000.0);

		//todo: dokumentacja
		//todo: transakcja która nie będzie generować błędu zamówienie - to sam sobie dodałem ale może być jak starczy czasu
//todo: uporządkuj interfejsy

	}
}
