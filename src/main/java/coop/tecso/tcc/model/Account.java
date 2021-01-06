package coop.tecso.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account
{
	@Id
	@Column
	@GeneratedValue( strategy = GenerationType.AUTO )
	private  int id;
	
	@Column
	private int accountNumber;
	
	@Column
	private String currency;
	
	@Column
	private float balance;
	
}
