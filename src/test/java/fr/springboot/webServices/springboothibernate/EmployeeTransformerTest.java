package fr.springboot.webServices.springboothibernate;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.springboot.webservice.springboothibernate.entity.Employee;
import fr.springboot.webservice.springboothibernate.service.EmployeeTransformer;
import payroll.bestpay.employee.EmployeeInfo;

public class EmployeeTransformerTest {
	
	private EmployeeTransformer testClass;
	
	@Before
	public void setup() {
		testClass = new EmployeeTransformer();
	}

	@Test
	public void convert_happyPath() {
		Employee emp = new Employee();
		emp.setFirstName("Mary");
		emp.setLastName("Zheng");
		emp.setHourlyRate(45);		
		
		EmployeeInfo empInfo = testClass.convert(emp );
		assertEquals("Mary", empInfo.getFirstName());
		assertEquals("Zheng", empInfo.getLastName());
		assertEquals(0, empInfo.getHourlyRate().compareTo(new BigDecimal(45)));
	}

}