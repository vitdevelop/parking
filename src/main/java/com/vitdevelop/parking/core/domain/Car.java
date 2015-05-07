package com.vitdevelop.parking.core.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "PLATE", nullable = false, length = 6)
    private String plate;

    @Basic
    @Column(name = "COLOR", nullable = false, length = 15)
    private String color;

    @Basic
    @Column(name = "ENTRACE", nullable = false)
    private Date entrace;

    @Basic
    @Column(name = "PRICE",nullable = false)
    private int price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getEntrace() {
        return entrace;
    }

    public void setEntrace(Date entrace) {
        this.entrace = entrace;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", color='" + color + '\'' +
                ", entrace=" + entrace +
                ", price=" + price +
                '}';
    }
}
