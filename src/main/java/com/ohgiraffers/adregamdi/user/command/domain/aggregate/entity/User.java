package com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nickname;
    @Column
    private String email;
    @Column
    private String gender;

    public User update(int id, String nickname, String email, String gender) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
        return this;
    }

}
