package com.sigei.cookshare.request;

import com.sigei.cookshare.model.Recipe;
import com.sigei.cookshare.model.User;
import lombok.Data;

@Data
public class CreateRecipeRequest {
    private Recipe recipe;
    private User user;
}
