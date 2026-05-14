package mini_bank.Repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mini_bank.Components.Fixed_Deposit_Account;
public interface Fixed_Deposit_Repositary extends JpaRepository<Fixed_Deposit_Account,Long>{
	@Query(" from Fixed_Deposit_Account fd where fd.name=:name")
	Fixed_Deposit_Account findByNameFD(@Param ("name") String name);
	
}
