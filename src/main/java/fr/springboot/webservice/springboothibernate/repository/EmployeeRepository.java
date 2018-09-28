package fr.springboot.webservice.springboothibernate.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.springboot.webservice.springboothibernate.entity.Employee;


@Repository
@Transactional
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
