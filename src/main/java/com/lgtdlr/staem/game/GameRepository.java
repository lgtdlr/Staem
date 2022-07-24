package com.lgtdlr.staem.game;

import com.lgtdlr.staem.game.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findByTitle(String title);
}
