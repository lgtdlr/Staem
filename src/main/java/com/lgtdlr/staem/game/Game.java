package com.lgtdlr.staem.game;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "cover")
    private String cover;
}
