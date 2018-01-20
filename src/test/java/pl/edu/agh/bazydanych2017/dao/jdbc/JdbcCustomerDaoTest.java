package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JdbcCustomerDaoTest extends AbstractCrudDaoTest<JdbcCustomerDaoImpl, Customer, String> {

    @Autowired
    @Override
    public void setCrudDao(JdbcCustomerDaoImpl crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    String getPK(Customer entity) {
        return entity.getCustomerId();
    }

    @Override
    Customer getSampleExistingEntity() {
        Customer customer = new Customer();
        customer.setCustomerId("ALFKI");
        customer.setCompanyName("Alfreds Futterkiste");
        customer.setContactName("Maria Anders");
        customer.setContactTitle("Sales Representative");
        customer.setAddress("Obere Str. 57");
        customer.setCity("Berlin");
        customer.setPostalCode("12209");
        customer.setCountry("Germany");
        customer.setPhone("030-0074321");
        customer.setFax("030-0076545");
        return customer;
    }

    @Override
    Customer getSampleNewEntity() {
        Customer customer = new Customer();
        customer.setCustomerId("AAAAA");
        customer.setCompanyName("Sample Company Name");
        return customer;
    }

    @Override
    Customer getModifiedExistingEntity() {
        Customer customer = getSampleExistingEntity();
        customer.setCompanyName("New Company Name");
        customer.setContactName("New Contact Name");
        return customer;
    }

}