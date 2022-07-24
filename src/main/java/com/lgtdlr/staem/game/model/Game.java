package com.lgtdlr.staem.game.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lgtdlr.staem.covers.Cover;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "games")
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@id")

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_generator")
    @SequenceGenerator(name = "game_generator", sequenceName = "game_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "release_date")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime releaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_id", referencedColumnName = "id")
    private Cover cover;
//    @OneToMany(mappedBy = "order")
//    private List<OrderGames> orderGames;

//    public List<OrderGames> getOrderGames() {
//        return orderGames;
//    }
//
//    public void setOrderGames(List<OrderGames> orderGames) {
//        this.orderGames = orderGames;
//    }
}
