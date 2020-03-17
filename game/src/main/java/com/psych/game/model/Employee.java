package com.psych.game.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee extends User {
     
	@NotBlank
	@Getter
	@Setter
	private String address;
   
	@NotBlank
	@Getter
	@Setter
	private String phoneNumber;
	
	@NotBlank
	@Getter
	@Setter
	private String Name;
}
