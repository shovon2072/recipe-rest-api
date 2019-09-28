package shovon.nnlife.recipe.ui.model.response;

import shovon.nnlife.recipe.io.entity.RecipeEntity;

import java.util.List;

public class GetAllResponse {
    private List<RecipeEntity> recipes;

    public List<RecipeEntity> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeEntity> recipes) {
        this.recipes = recipes;
    }
}
