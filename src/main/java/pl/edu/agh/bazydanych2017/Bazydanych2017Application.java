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
	//todo: zmienić nazwę JdbcProductsDao na JdbcProductsDao
	//todo: Podzielić interfejs JdbcProductsDao na tabele
	private JdbcProductsDao jdbcProductDaoImpl;
	private JpaTransaction jpaTransaction;
	private JpaCategoriesDao jpaCategoriesDaoImpl;
	private JdbcTransaction jdbcTransaction;

	public Bazydanych2017Application(JpaProductsDao jpaProductsDaoImpl, JdbcProductsDao jdbcProductDaoImpl, JpaTransaction jpaTransaction, JpaCategoriesDao jpaCategoriesDaoImpl, JdbcTransaction jdbcTransaction) {
		this.jpaProductsDaoImpl = jpaProductsDaoImpl;
		this.jdbcProductDaoImpl = jdbcProductDaoImpl;
		this.jpaTransaction = jpaTransaction;
		this.jpaCategoriesDaoImpl = jpaCategoriesDaoImpl;
		this.jdbcTransaction = jdbcTransaction;
	}

	@Override
	public void run(String... args) throws Exception {
		jpaProductsDaoImpl.listProductsSortedByProductName();
		jdbcProductDaoImpl.listProductsSortedByProductName();

		jpaProductsDaoImpl.findProductByProductName("Chai");
		jdbcProductDaoImpl.findProductByProductName("Chai");

		jpaProductsDaoImpl.changeProductsUnitPriceForCategoryname("Beverages", 10.0);
		jdbcProductDaoImpl.changeProductsUnitPriceForCategoryname("Beverages",10.0);

		//todo: przerobic  metodę dodać parametry
		jpaTransaction.changeExistingCategory("WZ1", "Spice food JAP1", "Nowa kaegoria WZ");
		jdbcTransaction.changeExistingCategory("WZ2", "Spice food JAP2", "Nowa kaegoria WZ");
//		jpaProductsDaoImpl.removeForeignKeyCategoryidFromProducts("Spice food2");
//		jpaCategoriesDaoImpl.deleteCategoryByCategoryname("Spice food2");
//		jpaCategoriesDaoImpl.createNewCategory("Spice food", "Nowakategoria JPA Transakcja");
//		jpaProductsDaoImpl.setCategoryidWhereCategoryidIsNull("Spice food");
		//todo: sprawdzić opisy operacji
		//todo: konwersja milisekund do bardziej przyjaznej postaci
		//todo: opsiuać jak to zrobiłem

		jpaTransaction.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);
		jdbcProductDaoImpl.createNewProduct("Dethrein", "Exotic Liquids","Spice food","10 boxes x 20 bags", 10D,50L, 10L, 10L, false);

	}
}
