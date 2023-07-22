package com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_TAG")
public class Tag {

    @Id
    @Column(name = "TAG_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagNo;
    @Column(name = "TAG_NAME", unique = true)
    private String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
