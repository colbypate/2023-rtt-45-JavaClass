package com.teksytems.capstone.database.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="sales")
public class Sales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="user_id", insertable=false, updatable=false)
    private Integer userId;

    @Column(name="sale_date")
    private Date saleDate;

    @Column(name="comments")
    private String comments;

    @ToString.Exclude
    @OneToMany(mappedBy = "sales", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SaleDetails> saleDetails = new ArrayList<SaleDetails>();

    @ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;
    
}
