package com.psych.game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="games")
public class Game extends Auditable {
	
	@ManyToMany
	@Getter
	@Setter
	private Set<Player> players = new HashSet<Player>();
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@NotNull
	private GameMode gameMode;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@Getter
	@Setter
	private List<Round> rounds = new ArrayList<>();
	
	@Getter
	@Setter
	private int numRounds = 10;
	
	@Getter
	@Setter
	private Boolean hasEllen = false;
	
	@NotNull
	@Getter
	@Setter
	@ManyToOne
	private Player learder;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Map<Player , Stat> playerStats = new HashMap<>();
	
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private GameStatus gameStatus;
	
	@ManyToMany
	@Getter
	@Setter
	private Set<Player> readyPlayers = new HashSet<>();
}