package pl.edu.agh.bazydanych2017;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcTransaction;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransaction;

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

	public Bazydanych2017Application(JpaProductsDao jpaProductsDaoImpl, JdbcProductsDao jdbcProductDaoImpl, JpaTransaction jpaTransaction, JpaCategoriesDao jpaCategoriesDaoImpl, JdbcTransaction jdbcTransaction, TimeCounter timeCounter) {
		this.jpaProductsDaoImpl = jpaProductsDaoImpl;
		this.jdbcProductDaoImpl = jdbcProductDaoImpl;
		this.jpaTransaction = jpaTransaction;
		this.jpaCategoriesDaoImpl = jpaCategoriesDaoImpl;
		this.jdbcTransaction = jdbcTransaction;
		this.timeCounter = timeCounter;
	}

	@Override
	public void run(String... args) throws Exception {
		jpaProductsDaoImpl.listProductsSortedByProductName();
		System.out.printf("JPA %f", (double)timeCounter.AvarageTimelistProductsSortedByProductName(10));
		jdbcProductDaoImpl.listProductsSortedByProductName();

		jpaProductsDaoImpl.findProductByProductName("Chai");
		jdbcProductDaoImpl.findProductByProductName("Chai");

		jpaProductsDaoImpl.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
		jdbcProductDaoImpl.changeProductsUnitPriceForCategoryname("Beverages",10.0);

	//	jpaTransaction.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");
	//	jdbcTransaction.changeExistingCategory("IZ3", "IZ2", "Nowa kaegoria WZ");

		jpaTransaction.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);
		jdbcProductDaoImpl.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);

		//todo: dokumentacja
		//todo: raport skomplikowany
	}
}
