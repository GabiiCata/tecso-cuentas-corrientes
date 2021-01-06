package coop.tecso.tcc.service;

import java.util.List;

import coop.tecso.tcc.model.Movement;

public interface MovementService {
	
	List<Movement> list();
	Movement listId( int id );
	List<Movement> listByAccountNumber( int originAccountNumber );
	Movement add( Movement person );
	Movement edit( Movement person );
	Movement delete( int id);
	
}
