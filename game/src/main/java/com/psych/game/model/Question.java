package com.psych.game.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="questions")
public class Question extends Auditable {
	

	@NotNull
	@Getter
	@Setter
	private String question;
	
	@NotNull
	@Getter
	@Setter
	private String correctAnswers;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "question")
	@Getter
	@Setter
	private Set<EllenAnswer> ellenAnswers = new HashSet<EllenAnswer>();
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Getter
	@Setter
	private GameMode gameMode;
	
	public Question() {}
	
	public Question(@NotNull String question, @NotNull String correctAnswers, @NotNull GameMode gameMode) {
		super();
		this.question = question;
		this.correctAnswers = correctAnswers;
		this.gameMode = gameMode;
	}
}
