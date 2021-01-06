package coop.tecso.tcc.repository;

import java.util.List;

import org.springframework.data.repository.*;
import coop.tecso.tcc.model.PhysicalPerson;

public interface PhysicalPersonRepository extends Repository < PhysicalPerson , Integer >
{
	List< PhysicalPerson > findAll();
	PhysicalPerson	findById( int id );
	PhysicalPerson save ( PhysicalPerson person );
	void delete ( PhysicalPerson  person );
}
