package pl.edu.agh.bazydanych2017;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.agh.bazydanych2017.dao.EmployeeDao;
import pl.edu.agh.bazydanych2017.model.Employees;

@SpringBootApplication
public class Bazydanych2017Application implements CommandLineRunner {

	@Autowired
	private EmployeeDao employeeDao;

	public static void main(String[] args) {
		SpringApplication.run(Bazydanych2017Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createEmployee();
		getEmployeeById();
		employeeDao.updateEmployeeEmailById(10, "Kraków");
		employeeDao.deleteEmployeeById(12);
		System.out.println("Employ last name - " + employeeDao.getEmployeeLastName(2));
	}
	private void createEmployee(){
		Employees employees = new Employees();
		employees.setFirstName("Johen");
		employees.setLastName("Bochen");
		employees.setNotes("The best baker in this town");
		employees.setSalary(9000.00);

		employeeDao.createEmployee(employees);
	}

	private void getEmployeeById(){
		Employees employees = employeeDao.getEmployeeById(1);
		System.out.println(employees);
	}
}
