package com.lgtdlr.staem.order;

import com.lgtdlr.staem.game.Game;

import javax.persistence.*;
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

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "order_games",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "game_id"))
//    private List<Game> games = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    List<OrderGames> games;

    public Order() {}

    public Order(Integer userId, List<OrderGames> games) {
        this.userId = userId;
        this.games = games;
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

//    public List<Game> getGames() {
//        return games;
//    }
//
//    public void setGames(List<Game> games) {
//        this.games = games;
//    }

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
