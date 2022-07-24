package com.lgtdlr.staem.order;

import javax.persistence.*;
import java.time.LocalDateTime;
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
}
