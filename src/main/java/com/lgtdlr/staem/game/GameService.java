package com.lgtdlr.staem.game;

import com.lgtdlr.staem.covers.Cover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public Game add(Game game, MultipartFile file) throws IOException {
        Optional<Game> existingGame = this.gameRepository.findByTitle(game.getTitle());
        if (existingGame.isPresent()) {
            Cover cover = existingGame.get().getCover();
            cover.setBlob(file.getBytes());
            cover.setFilename(file.getOriginalFilename());
            cover.setContentType(file.getContentType());
            cover.setContentLength(file.getSize());
            existingGame.get().setCover(cover);
            return gameRepository.save(existingGame.get());
        }
        Cover cover = new Cover();
        cover.setBlob(file.getBytes());
        cover.setFilename(file.getOriginalFilename());
        cover.setContentType(file.getContentType());
        cover.setContentLength(file.getSize());

        game.setCover(cover);
        return gameRepository.save(game);
    }
}
