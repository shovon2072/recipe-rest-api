package shovon.nnlife.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shovon.nnlife.recipe.RecipeRepository;
import shovon.nnlife.recipe.io.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public RecipeEntity saveRecipe(RecipeEntity recipe) {
        RecipeEntity storedRecipe = recipeRepository.save(recipe);

        return storedRecipe;
    }

    public List<RecipeEntity> getAllRecipes() {
        Iterable<RecipeEntity> recipes = recipeRepository.findAll();

        List<RecipeEntity> returnValue = new ArrayList<>();
        for (RecipeEntity recipe : recipes) {
            returnValue.add(recipe);
        }

        return returnValue;
    }

    public Optional<RecipeEntity> getRecipeById(Integer recipeId) {
        Optional<RecipeEntity> recipe = recipeRepository.findById(recipeId);

        return recipe;
    }

    public void deleteRecipeById(Integer recipeId) {
        recipeRepository.deleteById(recipeId);
    }

}
