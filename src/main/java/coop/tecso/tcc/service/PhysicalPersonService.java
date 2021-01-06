package coop.tecso.tcc.service;

import java.util.List;

import coop.tecso.tcc.model.PhysicalPerson;

public interface PhysicalPersonService {
	
	List<PhysicalPerson> list();
	PhysicalPerson listId( int id );
	PhysicalPerson add( PhysicalPerson persona );
	PhysicalPerson edit( PhysicalPerson persona );
	PhysicalPerson delete( int id );
	
	
}
