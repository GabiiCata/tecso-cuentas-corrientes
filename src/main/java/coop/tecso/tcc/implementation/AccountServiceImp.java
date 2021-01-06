package coop.tecso.tcc.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.tcc.model.Account;
import coop.tecso.tcc.model.LegalPerson;
import coop.tecso.tcc.repository.AccountRepository;
import coop.tecso.tcc.repository.LegalPersonRepository;
import coop.tecso.tcc.service.AccountService;
import coop.tecso.tcc.service.LegalPersonService;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired  
	private AccountRepository repository;
	
	@Override
	public List<Account> list() 
	{
		return repository.findAll();
	}

	@Override
	public Account listId(int id) {
		return repository.findById(id);
	}
	
	@Override
	public Account listByAccountNumber(int accountNumber) {
		return repository.findByAccountNumber(accountNumber);
	}

	@Override
	public Account add(Account account) {
		return repository.save(account);
	}

	@Override
	public Account edit(Account account) {
		return repository.save(account);
	}

	@Override
	public Account delete( int id ) {
		Account account = repository.findById(id);
		
		if ( account != null)
		{
			repository.delete(account);
		}
		
		return account;
	}

}
