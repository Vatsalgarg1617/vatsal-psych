package com.psych.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psych.game.model.GameMode;
import com.psych.game.model.Player;
import com.psych.game.model.Question;
import com.psych.game.repositories.PlayerRepository;
import com.psych.game.repositories.QuestionRepositories;

@RestController
@RequestMapping("/dev-test")
public class HelloWorldController {
	
	@Autowired
	private QuestionRepositories questionRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	
	@GetMapping("/")
	public String hello() {
		return "Hello, World";
	}
	
	@GetMapping("/populate")
	public String populateDB() {
		Player luffy = new Player.Builder().alias("Monkey D. luffy")
				.saltedHashedPassword("strawhat")
				.email("luffy@vatsal.com")
				.build();
		playerRepository.save(luffy);
		Player robin = new Player.Builder().alias("Nico Robin")
				.saltedHashedPassword("punaglyph")
				.email("robin@vatsal.com")
				.build();
		playerRepository.save(robin);
		questionRepository.save(new Question("What is the most important Poneglyph" ,
				"Rio Poneglyph" ,
				GameMode.IS_THIS_A_FACT));
		return "populated";
	}
	
	@GetMapping("/questions")
	public List<Question> getAllQuestions(){
		return questionRepository.findAll();
	}
	
	@GetMapping("/questions/{id}")
	public Question getQuestionById(@PathVariable(name="id") Long id){
		return questionRepository.findById(id).orElseThrow();
	}
	
	@GetMapping("/players")
	public List<Player> getAllPlayers(){
		return playerRepository.findAll();
	}
	
	@GetMapping("/players/{id}")
	public Player getPlayerById(@PathVariable(name="id") Long id){
		return playerRepository.findById(id).orElseThrow();
	}
	
	// Games
	// Players
	// Admin
	// Questions
	// Rounds
	// ContentWriters
}
