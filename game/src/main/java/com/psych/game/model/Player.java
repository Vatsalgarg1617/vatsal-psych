package com.psych.game.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "players")
public class Player extends User {

	@NotBlank
	@Getter
	@Setter
	private String alias;

	@Getter
	@Setter
	private String psychFaceURL;

	@Getter
	@Setter
	private String picURL;

	@OneToOne(cascade = CascadeType.ALL)
	@Getter
	@Setter
	private Stat stats = new Stat();

	@ManyToMany(mappedBy = "players")
	@Getter
	@Setter
	private Set<Game> games = new HashSet<>();
	
	public Player() {}

	public static final class Builder {
		private @Email @NotBlank String email;
		private @NotBlank String saltedHashedPassword;
		private String alias;
		private String psychFaceURL;
		private String picURL;
		
		public Builder(){
			
		}
		
		public Builder email(@Email @NotBlank String val) {
			email = val;
			return this;
		}
		
		public Builder saltedHashedPassword(@NotBlank String val) {
			saltedHashedPassword = val;
			return this;
		}

		public Builder alias(String alias) {
			this.alias = alias;
			return this;
		}

		public Builder psychFaceURL(String psychFaceURL) {
			this.psychFaceURL = psychFaceURL;
			return this;
		}

		public Builder picURL(String picURL) {
			this.picURL = picURL;
			return this;
		}

		public Player build() {
			return new Player(this);
		}
	}

	private Player(Builder builder) {
	    setEmail(builder.email);
	    setSaltedHashedPassword(builder.saltedHashedPassword);
	    setAlias(builder.alias);
	    setPsychFaceURL(builder.psychFaceURL);
	    setPicURL(builder.picURL);
	}
}
