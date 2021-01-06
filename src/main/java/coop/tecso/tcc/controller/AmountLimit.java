package coop.tecso.tcc.controller;

public enum AmountLimit
{
	USD (300),
	ARG (1000),
	EUR (150);

	int AMOUNT_LIMIT ;
	
	AmountLimit( int  limit)
	{
		this.AMOUNT_LIMIT = limit;
		 
	}
 
}
