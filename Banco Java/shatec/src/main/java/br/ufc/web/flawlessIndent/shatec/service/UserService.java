package br.ufc.web.flawlessIndent.shatec.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.flawlessIndent.shatec.model.User;
import br.ufc.web.flawlessIndent.shatec.repository.UserRepository;
 
@Service
public class UserService {
 
    @Autowired
    UserRepository userRepo;
    
    public User addUser(String login, String password, String nome, String sobrenome) {
        User user = new User(login, password, nome, sobrenome);
        
        if(getUserByLogin(user) != null) {
        	return null;
        }
        
        return userRepo.save(user);
    }
    
    public boolean removeUser(Integer id) {
        if(userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    
    public User getUser(Integer id) {
        return userRepo.findById(id).get();
    }
    
    public User getUserByLogin(User user) {
    	User user1 = userRepo.findFirstByLogin(user.getLogin());
    	if(user1 != null) {
	    	if(user.getPassword().equals(user1.getPassword())) {
	    		return user1;
	    	}
    	}
    	return null;
    }
    
    /*public List<User> getUserByQtd(Integer qtd) {
    	List<User> users = userRepo.findByQtd(qtd);
    	return users;
    }*/
    
    public User updateUser(Integer id, String login, String password, String nome, String sobrenome) {
        User userAux = userRepo.findById(id).get();
        
        if(userAux != null) {
        	userAux.setNome(nome);
        	userAux.setLogin(login);
        	userAux.setPassword(password);
        	userAux.setSobrenome(sobrenome);
        	
        	userRepo.save(userAux);         
        }
        
        return userAux;
    }
}