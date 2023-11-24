package com.example.demo10.Member.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column
    @Setter
    private String name;

    @Column
    @Setter
    private String number1;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Order> orders = new ArrayList<>();
//
//
//    public void addMember(Order order){
//        orders.add(order);
//        order.setMember(this);
//    }



}
