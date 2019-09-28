package shovon.nnlife.recipe.ui.model.response;

import shovon.nnlife.recipe.io.entity.RecipeEntity;

import java.util.List;

public class GetRecipeResponse {
    private String message;
    private List<RecipeEntity> recipe;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RecipeEntity> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<RecipeEntity> recipe) {
        this.recipe = recipe;
    }
}
