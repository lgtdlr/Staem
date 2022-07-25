package com.lgtdlr.staem.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {


    private final GameRepository gameRepository;

    private final GameService gameService;


    @Autowired
    public GameController(GameRepository gameRepository, GameService gameService) {
        this.gameRepository = gameRepository;
        this.gameService = gameService;
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
    public List<Game> getAll() {
        return (List<Game>)gameRepository.findAll();
    }

    @PostMapping(value = "/games", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Game add(@RequestPart("game") Game game, @RequestPart("cover") MultipartFile cover) throws IOException {
        return this.gameService.add(game, cover);
    }

}
