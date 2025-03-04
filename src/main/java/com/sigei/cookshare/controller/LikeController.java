package com.sigei.cookshare.controller;

import com.sigei.cookshare.service.like.ILikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/likes")
public class LikeController {
    private final ILikeService likeService;

    @PostMapping("/recipe/{recipeId}/like")
    public ResponseEntity<Long> likeRecipe(@PathVariable Long recipeId) {
        Long like = likeService.likeRecipe(recipeId);
        return ResponseEntity.ok(like);
    }

    @PutMapping("/recipe/{recipeId}/unLike")
    public ResponseEntity<Long> unLikeRecipe(@PathVariable Long recipeId) {
        Long like = likeService.unLikeRecipe(recipeId);
        return ResponseEntity.ok(like);
    }

    @GetMapping("/recipe/{recipeId}/like-count")
    public ResponseEntity<Long> getLikesCount(@PathVariable Long recipeId) {
        Long count = likeService.getLikesCount(recipeId);
        System.out.println("display likes count: " + count);
        return ResponseEntity.ok(count);
    }
}
