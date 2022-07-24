package com.lgtdlr.staem.user;

import com.lgtdlr.staem.game.model.Game;

import javax.persistence.*;

@Entity
@Table(name = "user_cart")
public class UserCart {

    @EmbeddedId
    private UserCartKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
