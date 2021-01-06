package coop.tecso.tcc.service;

import java.util.List;

import coop.tecso.tcc.model.Account;

public interface AccountService {
	
	List<Account> list();
	Account listId( int id );
	Account add( Account account );
	Account edit( Account account );
	Account delete( int id);
	Account listByAccountNumber(int accountNumber);
	
	
	
}
