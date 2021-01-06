package coop.tecso.tcc.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.tcc.model.LegalPerson;
import coop.tecso.tcc.repository.LegalPersonRepository;
import coop.tecso.tcc.service.LegalPersonService;

@Service
public class LegalPersonServiceImp implements LegalPersonService {

	@Autowired   
	private LegalPersonRepository repository;
	
	@Override
	public List<LegalPerson> list() 
	{
		return repository.findAll();
	}

	@Override
	public LegalPerson listId(int id) {
		return repository.findById(id);
	}

	@Override
	public LegalPerson add(LegalPerson person) {
		return repository.save(person);
	}

	@Override
	public LegalPerson edit(LegalPerson person) {
		return repository.save(person);
	}

	@Override
	public LegalPerson delete( int id ) {
		LegalPerson person = repository.findById(id);
		
		if ( person != null)
		{
			repository.delete(person);
		}
		
		return person;
	}

}
