package coop.tecso.tcc.repository;

import java.util.List;

import org.springframework.data.repository.*;

import coop.tecso.tcc.model.LegalPerson;

public interface LegalPersonRepository extends Repository < LegalPerson , Integer >
{
	List< LegalPerson > findAll();
	LegalPerson	findById( int id );
	LegalPerson save ( LegalPerson person );
	void delete ( LegalPerson  person );
}
