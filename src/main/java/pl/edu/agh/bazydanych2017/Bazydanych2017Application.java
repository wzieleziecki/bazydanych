package pl.edu.agh.bazydanych2017;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcTransaction;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaReportDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransaction;
import org.apache.log4j.Logger;
import pl.edu.agh.bazydanych2017.model.Report;

import java.util.List;

@SpringBootApplication
public class Bazydanych2017Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Bazydanych2017Application.class, args);
	}

	private JpaProductsDao jpaProductsDaoImpl;
	private JdbcProductsDao jdbcProductDaoImpl;
	private JpaTransaction jpaTransaction;
	private JpaCategoriesDao jpaCategoriesDaoImpl;
	private JdbcTransaction jdbcTransaction;
	private TimeCounter	timeCounter;
	private JpaReportDaoImpl jpaReportDaoImpl;
	private JdbcReportDao jdbcReportDao;
	private final Logger logger = Logger.getLogger(Bazydanych2017Application.class);

	public Bazydanych2017Application(JpaProductsDao jpaProductsDaoImpl, JdbcProductsDao jdbcProductDaoImpl, JpaTransaction jpaTransaction, JpaCategoriesDao jpaCategoriesDaoImpl, JdbcTransaction jdbcTransaction, TimeCounter timeCounter, JpaReportDaoImpl jpaReportDaoImpl, JdbcReportDao jdbcReportDao) {
		this.jpaProductsDaoImpl = jpaProductsDaoImpl;
		this.jdbcProductDaoImpl = jdbcProductDaoImpl;
		this.jpaTransaction = jpaTransaction;
		this.jpaCategoriesDaoImpl = jpaCategoriesDaoImpl;
		this.jdbcTransaction = jdbcTransaction;
		this.timeCounter = timeCounter;
		this.jpaReportDaoImpl = jpaReportDaoImpl;
		this.jdbcReportDao = jdbcReportDao;
	}

	@Override
	public void run(String... args) throws Exception {
		int numberOfTest = 1;
		//todo: refaktoryzacja interfejsów i klas jpadao i jdbcdao
		//jpaProductsDaoImpl.listProductsSortedByProductName();
		logger.info("JPA "+ numberOfTest +" test listProductsSortedByProductName "+ (double)timeCounter.AvarageTimeJPAlistProductsSortedByProductName(numberOfTest)/ 1000000000.0);
		//jdbcProductDaoImpl.listProductsSortedByProductName();
		logger.info("JDBC "+ numberOfTest +" test listProductsSortedByProductName "+ (double)timeCounter.AvarageTimeJDBClistProductsSortedByProductName(numberOfTest)/ 1000000000.0);

		//jpaProductsDaoImpl.findProductByProductName("Chai");
		logger.info("JPA "+ numberOfTest +" test FindProductByProductName "+ (double)timeCounter.AvarageTimeJPAFindProductByProductName(numberOfTest,"Chai")/ 1000000000.0);
		//jdbcProductDaoImpl.findProductByProductName("Chai");
		logger.info("JDBC "+ numberOfTest +" test FindProductByProductName "+ (double)timeCounter.AvarageTimeJDBCFindProductByProductName(numberOfTest,"Chai")/ 1000000000.0);

		//todo: dorobić skomplikowane zapytanie JPA JDBC
		List<Report> reports = (List<Report>)jpaReportDaoImpl.detailInformationForInvoicePurpose();
//		System.out.println(reports.get(1));
//		for (Object jpaReport : reports) {
//			System.out.println("JPA Report " + jpaReport.toString());
//		}
		List<Report> reports1 = jdbcReportDao.detailInformationForInvoicePurpose();
		for (Report jdbcReport : reports) {
			System.out.println("JDBC Report " + jdbcReport);
		}


		jpaProductsDaoImpl.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
		jdbcProductDaoImpl.changeProductsUnitPriceForCategoryname("Beverages",10.0);

	//	jpaTransaction.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");
	//	jdbcTransaction.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");

		jpaTransaction.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);
		jdbcProductDaoImpl.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);

		//todo: dokumentacja
		//todo: raport skomplikowany
		//todo: transakcja która nie będzie generować błędu zamówienie
	}
}
