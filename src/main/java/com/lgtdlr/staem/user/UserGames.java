package com.lgtdlr.staem.user;

import com.lgtdlr.staem.game.model.Game;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_games")
public class UserGames {

    @EmbeddedId
    private UserGamesKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Column(name = "expiration_date")
    private LocalDateTime purchaseDate;

//    public OrderGamesKey getId() {
//        return id;
//    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Game getGame() {
        return game;
    }

}
