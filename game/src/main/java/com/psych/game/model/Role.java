package com.psych.game.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
public class Role extends Auditable{
	
	@NotBlank
	@Getter
	@Setter
	private String name;
	
	@NotBlank
	@Getter
	@Setter
	private String description;
}
