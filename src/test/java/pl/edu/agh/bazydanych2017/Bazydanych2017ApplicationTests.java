package pl.edu.agh.bazydanych2017;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.bazydanych2017.dao.EmployeeDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bazydanych2017ApplicationTests {

	@Autowired
	private EmployeeDao jdbcBazydanych2017Dao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findEmployeeById(){
		Assert.assertNotNull(jdbcBazydanych2017Dao.getEmployeeLastName(1));
	}
}
