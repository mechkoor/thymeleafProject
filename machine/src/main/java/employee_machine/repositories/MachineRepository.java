package employee_machine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import employee_machine.entities.Machine;

@Repository
public interface MachineRepository extends CrudRepository<Machine, Integer> {
	List<Machine> findByEmployeeId(int employeeId);
	List<Machine> findByMarque(String marque);
	

}
