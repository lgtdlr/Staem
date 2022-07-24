package com.lgtdlr.staem.covers;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lgtdlr.staem.game.model.Game;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "covers")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Data
public class Cover {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "blob")
    private byte[] blob;

    @Column(name = "content_length")
    private Long contentLength;

    @Column(name = "content_type")
    private String contentType;

    @OneToOne(mappedBy = "cover")
    private Game game;

}
