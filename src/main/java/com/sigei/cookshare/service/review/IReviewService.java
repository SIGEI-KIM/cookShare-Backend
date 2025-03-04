package com.sigei.cookshare.service.review;

import com.sigei.cookshare.model.Review;
import com.sigei.cookshare.request.ReviewRequest;

public interface IReviewService {
    void addReview(Long recipeId, ReviewRequest request);
    void deleteReview(Long recipeId, Long reviewId);
    int getTotalReviews(Long recipeId );
}
