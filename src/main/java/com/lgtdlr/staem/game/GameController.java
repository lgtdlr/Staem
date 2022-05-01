package com.lgtdlr.staem.game;

import com.lgtdlr.staem.user.User;
import com.lgtdlr.staem.user.UserRepository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute
    public Optional<Game> findGame(@PathVariable(name = "id", required = false) Long id) {
        return id == null ? Optional.of(new Game()) : this.gameRepository.findById(id);
    }

    @GetMapping("/games")
    public List<Game> getGames() {
        return (List<Game>)gameRepository.findAll();
    }

    @PostMapping("/games")
    void addUser(@RequestBody Game game) {
        gameRepository.save(game);
    }

}
