package com.example.myorder.entities;

import com.example.myorder.enums.OrderStatusEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UserOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "totalValue",  nullable = false)
    private Double totalValue;

    @Column(name = "status", nullable = false)
    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OrderBy("id ASC")
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;


}
