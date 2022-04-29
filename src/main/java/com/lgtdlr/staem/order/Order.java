package com.lgtdlr.staem.order;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
