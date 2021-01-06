package coop.tecso.tcc.service;

import java.util.List;

import coop.tecso.tcc.model.LegalPerson;

public interface LegalPersonService {
	
	List<LegalPerson> list();
	LegalPerson listId( int id );
	LegalPerson add( LegalPerson person );
	LegalPerson edit( LegalPerson person );
	LegalPerson delete( int id);
	
	
}
