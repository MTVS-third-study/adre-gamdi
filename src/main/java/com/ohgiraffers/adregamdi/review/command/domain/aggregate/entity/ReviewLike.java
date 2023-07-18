package com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
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
    private User likeUserNo;


    public static ReviewLike toReviewLike(User user, Review review) {
        ReviewLike reviewLike = new ReviewLike();
        reviewLike.setLikedReviewNo(review);
        reviewLike.setLikeUserNo(user);

        return reviewLike;
    }
}
