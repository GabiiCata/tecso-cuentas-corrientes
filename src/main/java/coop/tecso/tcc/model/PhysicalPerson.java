package coop.tecso.tcc.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "physical_person")
@Getter
@Setter
public class PhysicalPerson 
{
	@Id
	@Column
	@GeneratedValue( strategy = GenerationType.AUTO )
	private  int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String cc;
	
	@Column int rut;
	
}
