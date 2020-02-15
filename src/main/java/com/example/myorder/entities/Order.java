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

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Order setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public Order setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Order setItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }
}