package fr.springboot.webservice.springboothibernate;



import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import fr.springboot.webservice.springboothibernate.entity.Employee;
import fr.springboot.webservice.springboothibernate.repository.EmployeeRepository;
import payroll.bestpay.employee.EmployeeType;

@SpringBootApplication
@EnableAsync
public class SpringBootHibernateApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=	SpringApplication.run(SpringBootHibernateApplication.class, args);
	
	EmployeeRepository empRepos= ctx.getBean(EmployeeRepository.class);
	empRepos.save(buildDummyEmployee("John", "Lenon"));
	empRepos.save(buildDummyEmployee("Jack", "Lang"));
	empRepos.save(buildDummyEmployee("Georges", "Bush"));
	empRepos.save(buildDummyEmployee("Tom", "Zheng"));

	}

	private static Employee buildDummyEmployee(String firtName, String lastName) {
	Employee emp= new Employee();
	emp.setType(EmployeeType.HOURLY);
	Random rand = new Random();
	
	emp.setFirstName(firtName);
	emp.setFirstName(lastName);
	emp.setDepartement("SMT");
	emp.setManagerId("ETTYRYYR45656");
	emp.setHourlyRate(rand.nextInt(100));	
		return emp;
	}
}
