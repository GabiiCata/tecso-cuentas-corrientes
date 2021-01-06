package coop.tecso.tcc.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import coop.tecso.tcc.model.Account;
import coop.tecso.tcc.model.Movement;

public interface AccountRepository extends Repository < Account , Integer >
{
	List< Account > findAll();
	Account	findById( int id );
	Account	findByAccountNumber( int accountNumber );
	Account save ( Account person );
	void delete ( Account  person );
}
