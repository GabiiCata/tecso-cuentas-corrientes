package coop.tecso.tcc.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class Controller {
	
	private static final  String RESPONSE = "<h1>Feliz 2021!</h1>.<hr> <h3>El servidor funciona correctamente :) </h3>" ; 
	
	@RequestMapping ({"/"})
	@GetMapping
	public String blankPage()
	{
		return RESPONSE;
	}
	
	@RequestMapping ({ "${app.version}" } )
	@GetMapping
	public String blankPageVersion()
	{
		return RESPONSE;
	}
}
