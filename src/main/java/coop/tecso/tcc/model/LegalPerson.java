package coop.tecso.tcc.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "legal_person")
@Getter
@Setter
public class LegalPerson 
{
	@Id
	@Column
	@GeneratedValue( strategy = GenerationType.AUTO )
	private  int id;
	
	@Column
	private String businessName;
	
	@Column
	private int fundationYear;
	
	@Column int rut;
	
}
