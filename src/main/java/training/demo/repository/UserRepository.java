package training.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import training.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	void deleteUserByUserId(int id);
	
	User findByUserId(int id);
	
	User findByUsername(String username);
	
	List<User> findAll();
}
