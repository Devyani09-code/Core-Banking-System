package mini_bank.Repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import mini_bank.Components.Savings_Account;

public interface Savings_Account_Repositary extends JpaRepository<Savings_Account,Long>{

@Query(" from Savings_Account sa where sa.name=:name")
Savings_Account findByNameSA(@Param ("name") String name);
	

}
