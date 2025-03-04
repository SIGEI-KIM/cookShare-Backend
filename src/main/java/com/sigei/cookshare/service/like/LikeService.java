package com.sigei.cookshare.service.like;

import com.sigei.cookshare.model.Like;
import com.sigei.cookshare.model.Recipe;
import com.sigei.cookshare.repo.LikeRepository;
import com.sigei.cookshare.repo.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService implements ILikeService {
    private final LikeRepository likeRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public Long likeRecipe(Long recipeId) {
        return Long.valueOf(recipeRepository.findById(recipeId).map(recipe -> {
            if(!likeRepository.existsByRecipeId(recipe.getId())){
                Like like = new Like(recipe);
                likeRepository.save(like);
            }
            recipe.setLikeCount(recipe.getLikeCount() + 1);
            return recipeRepository.save(recipe).getLikeCount();
        }).orElseThrow(() -> new EntityNotFoundException("Recipe not found!")));
    }

    @Override
    public Long unLikeRecipe(Long recipeId) {
        return Long.valueOf(likeRepository.findFirstByRecipeId(recipeId).map(like -> {
            Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
//            likeRepository.delete(like);
            if(recipe.getLikeCount() > 0){
                recipe.setLikeCount(recipe.getLikeCount() - 1);
                recipeRepository.save(recipe);
            }else {
                throw new IllegalArgumentException("Like is already zero");
            }
            return recipe.getLikeCount();
        }).orElseThrow(() -> new EntityNotFoundException("No likes for this recipe")));
    }

    @Override
    public Long getLikesCount(Long recipeId) {
        return recipeRepository.findById(recipeId)
                .map(recipe -> likeRepository.countByRecipeId(recipe.getId())).orElse(0L);
    }
}
