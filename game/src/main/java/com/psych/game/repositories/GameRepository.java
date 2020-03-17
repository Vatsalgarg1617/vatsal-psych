package com.psych.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
