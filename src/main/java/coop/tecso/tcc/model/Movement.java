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
@Table(name = "movement")
@Getter
@Setter
public class Movement {
	
	@Id
	@Column
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private  int id;
	
	@Column
	private String date;
	
	@Column
	private String movementType;
	
	@Column
	private float amount;
	
	@Column
	private int originAccountNumber;
	
	@Column
	private int destinationAccountNumber;
	
	@Column
	private String description;
}
