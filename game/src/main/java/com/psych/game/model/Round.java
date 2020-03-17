package com.psych.game.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rounds")
public class Round extends Auditable {
    
	@ManyToOne
	@Getter
	@Setter
	@NotNull
	private Game game;
	
	@ManyToOne
	@NotNull
	private Question question;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter
	@Setter
	private Map<Player, PlayerAnswer> playerAnswer = new HashMap<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter
	@Setter
	private Map<Player, PlayerAnswer> selectedAnswers =  new HashMap<>();
	
	@ManyToOne
	@Getter
	@Setter
	private EllenAnswer ellenAns;
	
	@NotNull
	@Getter
	@Setter
	private int roundNumber;
}
