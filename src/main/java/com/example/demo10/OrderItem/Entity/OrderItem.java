package com.example.demo10.OrderItem.Entity;



import com.example.demo10.Order.Entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @Setter
    @Column
    private int orderPrice;

    @Setter
    @Column
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "orderId")
    @Setter
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn
    @Setter
    private Item item;

}
