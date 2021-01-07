package coop.tecso.tcc.controller;

 import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.tcc.model.Account;
import coop.tecso.tcc.model.Movement;
import coop.tecso.tcc.service.AccountService;
import coop.tecso.tcc.service.LegalPersonService;
import coop.tecso.tcc.service.MovementService;
import coop.tecso.tcc.service.PhysicalPersonService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping ( { "${app.version}" + "/movement" } )
public class MovementController 
{
	@Autowired 
	MovementService movementService;
	
	@Autowired 
	PhysicalPersonService physicalPersonService;
	
	@Autowired 
	LegalPersonService legalPersonService;
	
	@Autowired  
	AccountService  accountService;
	
	private String errMsg;
	
	static Map< String , Float > validAmmount; 
	

	@GetMapping(path="/{id}")
	public  Object  listbyAccountNumber( @PathVariable("id") int id)
	{
		Account account = accountService.listId(id);
		
		if ( account != null)
		{
			return movementService.listByAccountNumber( account.getAccountNumber() );

		}
		
		errMsg = "Account doesn´t exist.";
		return badRequestHandler( );

	}

	private Object badRequestHandler() 
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(  "{\n'message':'" + errMsg + "'\n}" );
	}
	
	@PostMapping
	public Object add (@RequestBody Movement movement)
	{
		long millis=System.currentTimeMillis();  
 		movement.setDate( new Date( millis  ) );
		if ( isValidAmount ( movement ) )
		{
			Account originAccount = accountService.listByAccountNumber( movement.getOriginAccountNumber() );
			Account destinationAccount = accountService.listByAccountNumber( movement.getDestinationAccountNumber() );
		
			if ( validMovement ( movement , originAccount ))
			{
				originAccount.setBalance( originAccount.getBalance() - movement.getAmount() );
				destinationAccount.setBalance( destinationAccount.getBalance() + movement.getAmount() );
				
				accountService.edit( originAccount );
				accountService.edit( destinationAccount );
				
				return movementService.add( movement ); 
			}
		}
		return badRequestHandler();
	}
 
	
	private boolean validMovement( Movement movement , Account account) 
	{
		if ( account.getBalance() >= movement.getAmount() )
		{
			return true;
		}
		
		errMsg = "Insufficient funds";
		
		return false;

	}

	private boolean isValidAmount(Movement movement) 
	{
		
		if (  AmountLimit.valueOf( movement.getMovementType() ).AMOUNT_LIMIT >= movement.getAmount() )
		{
			return true;
		}
		
		errMsg = "Amount limit exceded for " + movement.getMovementType() + " currency." ;
		
		return false;
		
	}

	
	

}
