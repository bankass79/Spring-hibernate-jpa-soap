package fr.springboot.webservice.springboothibernate.service;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

import fr.springboot.webservice.springboothibernate.aop.LoggableService;
import fr.springboot.webservice.springboothibernate.entity.Employee;
import payroll.bestpay.employee.EmployeeInfo;

@Component
public class EmployeeTransformer {
	@LoggableService
	public EmployeeInfo convert(Employee emp) {
		EmployeeInfo empInfo = new EmployeeInfo();
		BeanUtils.copyProperties(emp, empInfo);
		empInfo.setHourlyRate(new BigDecimal(emp.getHourlyRate()));
		empInfo.setEid(String.valueOf(emp.getId()));
		return  empInfo;
	}
}
