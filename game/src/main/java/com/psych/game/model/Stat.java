package com.psych.game.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stats")
public class Stat extends Auditable {
	@Getter
	@Setter
	private long getPsychedCount = 0;

	@Getter
	@Setter
	private long psychedOthersCount = 0;

	@Getter
	@Setter
	private long correctAnsCount = 0;
}
