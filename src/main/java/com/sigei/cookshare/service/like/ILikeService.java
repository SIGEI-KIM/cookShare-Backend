package com.sigei.cookshare.service.like;

public interface ILikeService {
    Long likeRecipe (Long recipeId);
    Long unLikeRecipe (Long recipeId);
    Long getLikesCount (Long recipeId);
}
