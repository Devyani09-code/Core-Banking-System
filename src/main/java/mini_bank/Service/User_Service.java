package mini_bank.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mini_bank.Components.User;
import mini_bank.Repositaries.User_Repositary;

@Service
public class User_Service {
private final User_Repositary ur;

public User_Service(User_Repositary ur) {
	this.ur=ur;
}

//insert
public User create_user(User user) {
	user.setDate(LocalDate.now());
	System.out.println("Date being set: " + user.getDate());
	return ur.save(user);
	
}

//delete
public void delete_user(Long customer_id) {
	ur.deleteById(customer_id);
	
}

//update
public User update_user(User newuser,Long customer_id) {
	return ur.findById(customer_id).map(user->{
		user.setName(newuser.getName());
        user.setPassword(newuser.getPassword());
        return ur.save(user);}).orElse(null);

}

//check validity
public User login(User newuser) {

    User user = ur.findByCustomer_idAndNameAndPassword(
            newuser.getCustomer_id(),
            newuser.getName(),
            newuser.getPassword()
    );

    return user;
}

//searching user
public Optional<User> search(Long customer_id) {
    Optional<User> user= ur.findById(customer_id);
    return user;
}
}
