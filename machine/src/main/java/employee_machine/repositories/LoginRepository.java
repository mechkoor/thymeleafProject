package employee_machine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import employee_machine.entities.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {
	
	@Query("SELECT l FROM Login l WHERE l.username = :username AND l.password = :password")
	public Login verifie(@Param("username") String username, @Param("password") String password);

	

}
