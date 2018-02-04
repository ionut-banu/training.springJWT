package training.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import training.demo.model.User;
import training.demo.repository.UserRepository;

@Service
@Transactional
public class UserJpaService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUserById(int id) {
		userRepository.deleteUserByUserId(id);
	}
	
	public User findUserById(int id) {
		return userRepository.findByUserId(id);
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
        	System.out.println("User from DB: " + user.getUserId() + "  " + user.getUsername() + " " + user.getPassword());
            return user;
        }
	}

}
