package coop.tecso.tcc.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.tcc.model.LegalPerson;
import coop.tecso.tcc.model.PhysicalPerson;
import coop.tecso.tcc.repository.LegalPersonRepository;
import coop.tecso.tcc.repository.PhysicalPersonRepository;
import coop.tecso.tcc.service.PhysicalPersonService;

@Service
public class PhysicalPersonServiceImp implements PhysicalPersonService {

	@Autowired 
	private PhysicalPersonRepository repository;
	
	@Override
	public List<PhysicalPerson> list() 
	{
		return repository.findAll();
	}

	@Override
	public PhysicalPerson listId(int id) {
		return repository.findById(id);
	}

	@Override
	public PhysicalPerson add(PhysicalPerson person) {
		return repository.save(person);
	}


	@Override
	public PhysicalPerson edit(PhysicalPerson person) {
		return repository.save(person);
	}

	@Override
	public PhysicalPerson delete( int id ) {
		PhysicalPerson person = repository.findById(id);
		
		if ( person != null)
		{
			repository.delete(person);
		}
		
		return person;
	}

}
