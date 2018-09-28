package fr.springboot.webservice.springboothibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.springboot.webservice.springboothibernate.aop.LoggableService;
import fr.springboot.webservice.springboothibernate.entity.Employee;
import fr.springboot.webservice.springboothibernate.repository.EmployeeRepository;
import payroll.bestpay.employee.EmployeeInfo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private EmployeeTransformer empConvertor;
	
	@LoggableService
	public EmployeeInfo employeeLookupRequest (String employeId) {
		Employee employee =  empRepo.getOne(Long.parseLong(employeId));
		if(employee != null) {
			return empConvertor.convert(employee);
		}
		return null;
	}

}
