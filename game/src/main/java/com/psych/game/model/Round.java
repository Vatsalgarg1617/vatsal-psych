package com.psych.game.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rounds")
public class Round extends Auditable {
    
	@ManyToOne
	@JsonBackReference
	@Getter
	@Setter
	@NotNull
	private Game game;
	
	@ManyToOne
	@JsonIdentityReference
	@NotNull
	@Getter
	@Setter
	private Question question;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@Getter
	@Setter
	private Map<Player, PlayerAnswer> submittedAnswers = new HashMap<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@Getter
	@Setter
	private Map<Player, PlayerAnswer> selectedAnswers =  new HashMap<>();
	
	@ManyToOne
	@JsonIdentityReference
	@Getter
	@Setter
	private EllenAnswer ellenAns;
	
	@NotNull
	@Getter
	@Setter
	private int roundNumber;
}
