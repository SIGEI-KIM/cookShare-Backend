package com.sigei.cookshare.repo;

import com.sigei.cookshare.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Long countByRecipeId(long recipeId);
    boolean existsByRecipeId(long id);

    Optional<Like> findFirstByRecipeId(Long recipeId);
}
