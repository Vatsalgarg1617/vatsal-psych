package com.psych.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psych.game.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
