package coop.tecso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 import coop.tecso.tcc.model.LegalPerson;
import coop.tecso.tcc.model.PhysicalPerson;
import coop.tecso.tcc.service.LegalPersonService;
import coop.tecso.tcc.service.PhysicalPersonService;
 
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping ( { "${app.version}" + "/persona-fisica" } )
public class PhysicalPersonController 
{
	@Autowired  
	PhysicalPersonService service;
	
	@Autowired 
	LegalPersonService lpservice;
	
	@GetMapping
	public List< PhysicalPerson > list()
	{
		return service.list();
	}
	

	@PostMapping ( produces = MediaType.APPLICATION_JSON_VALUE)
	public Object add (@RequestBody PhysicalPerson person)
	{
		if ( validPerson ( person ) )
		{
			return service.add( person ); 
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(  "{'message':'RUT-duplicated'}" );
		}

		
	}
	
	private boolean validPerson(PhysicalPerson person) 
	{
		List < PhysicalPerson > persons = list();
		for ( PhysicalPerson p : persons)
			if ( p.getRut() == person.getRut() )
				return false;
		
 		List < LegalPerson > lpersons = lpservice.list();
		
		for ( LegalPerson p : lpersons)
			if ( p.getRut() == person.getRut() )
				return false;
		
		return true;
	}


	@GetMapping(path="/{id}")
	public PhysicalPerson listId( @PathVariable("id") int id)
	{
		return service.listId(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public PhysicalPerson edit( @RequestBody PhysicalPerson person, @PathVariable("id") int id  )
	{
		person.setId(id);
		return service.edit(person);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public PhysicalPerson edit( @PathVariable("id") int id  )
	{
		return service.delete(id);
	}
}
