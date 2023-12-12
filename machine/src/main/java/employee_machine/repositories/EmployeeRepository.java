package employee_machine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import employee_machine.entities.Employee;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	List<Employee> findByNom(String nom);
	
	
}
