package coop.tecso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping ( { "${app.version}" + "/persona-juridica" } )
public class LegalPersonController 
{
	@Autowired  	
	LegalPersonService service;
	
	@Autowired  
	PhysicalPersonService ppservice;
	
	
	@GetMapping
	public List< LegalPerson > list()
	{
		return service.list();
	}
	
	@PostMapping
	public Object add (@RequestBody LegalPerson person)
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
	
	private boolean validPerson(LegalPerson person) 
	{
		List < LegalPerson > persons = list();
		for ( LegalPerson p : persons)
			if ( p.getRut() == person.getRut() )
				return false;
		
 		List < PhysicalPerson > ppersons = ppservice.list();
		
		for ( PhysicalPerson p : ppersons)
			if ( p.getRut() == person.getRut() )
				return false;
		
		return true;
	}
	
	
	@GetMapping(path="/{id}")
	public LegalPerson listId( @PathVariable("id") int id)
	{
		return service.listId(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public LegalPerson edit( @RequestBody LegalPerson person, @PathVariable("id") int id  )
	{
		person.setId(id);
		return service.edit(person);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public LegalPerson edit( @PathVariable("id") int id  )
	{
		return service.delete(id);
	}
}
