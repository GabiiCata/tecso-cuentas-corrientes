package coop.tecso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.tcc.model.Account;
import coop.tecso.tcc.service.AccountService;
import coop.tecso.tcc.service.PhysicalPersonService;

@CrossOrigin ( origins = "http//localhost:4200", maxAge = 3600)
@RestController
@RequestMapping ( { "/account" } )
public class AccountController 
{
	@Autowired  
	AccountService service;
	
	@Autowired  
	PhysicalPersonService ppservice;
	
	
	@GetMapping
	public List< Account > list()
	{
		return service.list();
	}
	
	@PostMapping
	public Object add (@RequestBody Account account)
	{
	 return service.add( account ); 
	 }
 
	
	
	@GetMapping(path="/{id}")
	public Account listId( @PathVariable("id") int id)
	{
		return service.listId(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public Account edit( @RequestBody Account account, @PathVariable("id") int id  )
	{
		account.setId(id);
		return service.edit(account);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public Account edit( @PathVariable("id") int id  )
	{
		return service.delete(id);
	}
}
