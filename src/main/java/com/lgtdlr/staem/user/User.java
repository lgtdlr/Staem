package com.lgtdlr.staem.user;

import com.lgtdlr.staem.order.Order;
import com.lgtdlr.staem.order.OrderGames;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "public")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "user")
    private List<UserCart> cart;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    List<UserGames> games;

    public User() {}

    public User(String email, String password, String displayName, String avatar, List<UserCart> cart, List<Order> orders, List<UserGames> games) {
        this.email = email;
        this.password = password;
        this.displayName = displayName;
        this.avatar = avatar;
        this.cart = cart;
        this.orders = orders;
        this.games = games;
    }
}
