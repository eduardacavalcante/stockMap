package com.example.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table

public class Stock{
    @javax.persistence.Id
    @Column(name = "idW", nullable = false)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idW;

    @Column(name = "nameW")
    private String nameW;

    @Column(name = "price")
    private BigDecimal price;
    private BigDecimal change;

    @ManyToOne
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "id"
    )
    private User user;

    public Stock(Long idW, String nameW, BigDecimal price, BigDecimal change) {
        this.idW = idW;
        this.nameW = nameW;
        this.price = price;
        this.change = change;
    }

    public Stock() {
        super();
    }

    public long getIdW() {
        return idW;
    }

    public void setIdW(long idW) {
        this.idW = idW;
    }

    public String getNameW() {
        return nameW;
    }

    public void setNameW(String nameW) {
        this.nameW = nameW;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Stock [id=" + idW + ", Name=" + nameW + ", price=" + price + ", change=" + change + "]";
    }
}
