package ma.thymeleaf.dem.demothymeleaf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.thymeleaf.dem.demothymeleaf.entities.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {}

