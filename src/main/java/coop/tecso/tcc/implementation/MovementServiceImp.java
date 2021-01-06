package coop.tecso.tcc.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.tcc.model.LegalPerson;
import coop.tecso.tcc.model.Movement;
import coop.tecso.tcc.model.PhysicalPerson;
import coop.tecso.tcc.repository.LegalPersonRepository;
import coop.tecso.tcc.repository.MovementRepository;
import coop.tecso.tcc.repository.PhysicalPersonRepository;
import coop.tecso.tcc.service.MovementService;
import coop.tecso.tcc.service.PhysicalPersonService;

@Service
public class MovementServiceImp implements MovementService {

	@Autowired  
	private MovementRepository repository;
	
	@Override
	public List<Movement> list() 
	{
		return repository.findAll();
	}

	@Override
	public Movement listId(int id) {
		return repository.findById(id);
	}

	@Override
	public Movement add(Movement movement) {
		return repository.save(movement);
	}


	@Override
	public Movement edit(Movement movement) {
		return repository.save(movement);
	}

	@Override
	public Movement delete( int id ) {
		Movement movement = repository.findById(id);
		
		if ( movement != null)
		{
			repository.delete(movement);
		}
		
		return movement;
	}

	@Override
	public List<Movement>   listByAccountNumber (int originAccountNumber) {
		return repository.findByOriginAccountNumberOrderByDateDesc(originAccountNumber);
	}

}
