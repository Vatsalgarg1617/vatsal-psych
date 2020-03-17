package com.psych.game;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.psych.game.model.Employee;

@Entity
@Table(name="admins")
public class Admin extends Employee {
	
}
