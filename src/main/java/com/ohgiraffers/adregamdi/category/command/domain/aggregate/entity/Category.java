package com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
