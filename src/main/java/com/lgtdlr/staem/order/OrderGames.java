package com.lgtdlr.staem.order;

import com.lgtdlr.staem.game.Game;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_games")
public class OrderGames {

    @EmbeddedId
    private OrderGamesKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Column(name = "purchase_price")
    private Double purchasePrice;

//    public OrderGamesKey getId() {
//        return id;
//    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
