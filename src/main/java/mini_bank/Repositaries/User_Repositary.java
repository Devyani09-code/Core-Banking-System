package mini_bank.Repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mini_bank.Components.User;
public interface User_Repositary extends JpaRepository<User,Long>{
	@Query("from User u where u.customer_id=:customer_id and u.name=:name and u.password=:password")
	User findByCustomer_idAndNameAndPassword(
			 @Param("customer_id") long customer_id,
		        @Param("name") String name,
		        @Param("password") String password
	);
}


