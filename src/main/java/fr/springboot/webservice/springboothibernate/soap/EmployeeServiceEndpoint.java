package fr.springboot.webservice.springboothibernate.soap;

import javax.xml.bind.JAXBElement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import fr.springboot.webservice.springboothibernate.aop.LoggableService;
import fr.springboot.webservice.springboothibernate.service.EmployeeService;
import payroll.bestpay.employee.EmployeeIdWrapper;
import payroll.bestpay.employee.EmployeeInfo;
import payroll.bestpay.employee.EmployeeInfoWrapper;
import payroll.bestpay.employee.ObjectFactory;

@Endpoint
public class EmployeeServiceEndpoint {
	
	private static final String NAMESPACE_URI="http://bestpay.payroll/employee";
	
	@Autowired
	private EmployeeService empService;
	
	@PayloadRoot(namespace= NAMESPACE_URI,localPart="employeeLookupRequest")
	@ResponsePayload
	@LoggableService
	public JAXBElement<EmployeeInfoWrapper> employeeLookup(@RequestPayload JAXBElement<EmployeeIdWrapper> request)
	{
		
		ObjectFactory factory = new  ObjectFactory();
		EmployeeInfoWrapper response= factory.createEmployeeInfoWrapper();
		
		for (String  empId : request.getValue().getEid()) {
			EmployeeInfo found= empService.employeeLookupRequest(empId);
			if(found !=null) {
				
				response.getEmployeeInfo().add(found);
			}
		}
		
		return  factory.createEmployeeServiceResponse(response);
		
		
	}
	

}
