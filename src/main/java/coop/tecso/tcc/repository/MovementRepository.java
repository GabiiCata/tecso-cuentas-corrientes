package coop.tecso.tcc.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

 import coop.tecso.tcc.model.Movement;

public interface MovementRepository extends Repository < Movement , Integer >
{
	List < Movement > findAll();
	Movement	findById( int id );
	List < Movement >  findByOriginAccountNumberOrderByDateDesc(int originAccountNumber);
	Movement save ( Movement person );
	void delete ( Movement  person );
}

