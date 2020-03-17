package com.psych.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.model.Question;


@Repository
public interface QuestionRepositories extends JpaRepository<Question, Long>{

}
