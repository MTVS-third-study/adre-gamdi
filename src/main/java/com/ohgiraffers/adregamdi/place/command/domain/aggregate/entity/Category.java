package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "TBL_CATEGORY")
public class Category {

    @Id
    @Column(name = "CATEGORY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryNo;

    @Column(name = "CATEGORY_NAME", unique = true)
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

}
