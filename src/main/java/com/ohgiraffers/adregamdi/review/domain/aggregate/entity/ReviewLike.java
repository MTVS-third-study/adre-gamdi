package com.ohgiraffers.adregamdi.review.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TBL_REVIEW_LIKE")
public class ReviewLike {

    @Id
    @Column(name = "REVIEW_LIKE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewLikeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REVIEW_NO")
    private Review likedReviewNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NO")
    private User likeReviewUserNo;

}
