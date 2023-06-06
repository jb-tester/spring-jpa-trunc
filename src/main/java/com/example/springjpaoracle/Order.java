package com.example.springjpaoracle;

import jakarta.persistence.*;
//import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    private float sum;
    private String title;
    private Date creationDate;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public Order(Long id, float sum, String title, Date creationDate, String status) {
        this.id = id;
        this.sum = sum;
        this.title = title;
        this.creationDate = creationDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sum=" + sum +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                '}';
    }

    public Order() {
    }
}
