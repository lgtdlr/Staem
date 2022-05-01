package com.lgtdlr.staem.order;

import com.lgtdlr.staem.game.Game;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @OneToMany(mappedBy = "order")
    List<OrderGames> games;

    public Order() {}

    public Order(Integer userId, List<OrderGames> games, LocalDateTime purchaseDate) {
        this.userId = userId;
        this.games = games;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<OrderGames> getGames() {
        return games;
    }

    public void setOrderGames(List<OrderGames> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", games=" + games +
                '}';
    }
}
