package shovon.nnlife.recipe.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import shovon.nnlife.recipe.exceptions.*;
import shovon.nnlife.recipe.io.entity.RecipeEntity;
import shovon.nnlife.recipe.service.RecipeService;
import shovon.nnlife.recipe.ui.model.request.*;
import shovon.nnlife.recipe.ui.model.response.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping(
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<GetAllResponse> getRecipes() {
        List<RecipeEntity> recipes = recipeService.getAllRecipes();

        GetAllResponse getAllResponse = new GetAllResponse();
        getAllResponse.setRecipes(recipes);

        return new ResponseEntity<>(getAllResponse, HttpStatus.OK);
    }

    @GetMapping(
        path="/{recipeId}",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<GetRecipeResponse> getRecipe(@PathVariable Integer recipeId) {
        Optional<RecipeEntity> recipe = recipeService.getRecipeById(recipeId);

        List recipeList = new ArrayList();
        recipe.ifPresent(r -> recipeList.add(r));

        GetRecipeResponse getRecipeResponse = new GetRecipeResponse();
        getRecipeResponse.setMessage("Recipe details by id");
        getRecipeResponse.setRecipe(recipeList);

        return new ResponseEntity<>(getRecipeResponse, HttpStatus.OK);
    }

    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<CreateRecipeResponse> createRecipe(
        @Valid @RequestBody RecipeCreate recipeDetails
    ) {
        RecipeEntity recipeToCreate = new RecipeEntity();
        BeanUtils.copyProperties(recipeDetails, recipeToCreate);

        RecipeEntity recipeCreated = recipeService.saveRecipe(recipeToCreate);

        List recipeList = new ArrayList();
        recipeList.add(recipeCreated);

        CreateRecipeResponse createRecipeResponse = new CreateRecipeResponse();
        createRecipeResponse.setMessage("Recipe successfully created!");
        createRecipeResponse.setRecipe(recipeList);

        return new ResponseEntity<>(createRecipeResponse, HttpStatus.OK);
    }

    @PatchMapping(
        path="/{recipeId}",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<UpdateRecipeResponse> updateRecipe(
        @PathVariable Integer recipeId,
        @Valid @RequestBody RecipeUpdate recipeDetails
    ) {
        Optional<RecipeEntity> currentRecipe = recipeService.getRecipeById(recipeId);
        UpdateRecipeResponse updateRecipeResponse = new UpdateRecipeResponse();

        if (currentRecipe.isPresent()) {
            RecipeEntity recipe = currentRecipe.get();
            BeanUtils.copyProperties(recipeDetails, recipe);

            RecipeEntity updatedRecipe = recipeService.saveRecipe(recipe);

            List recipeList = new ArrayList();
            recipeList.add(updatedRecipe);

            updateRecipeResponse.setMessage("Recipe successfully updated!");
            updateRecipeResponse.setRecipe(recipeList);
        } else {
            throw new NotFoundException("No Recipe found");
        }

        return new ResponseEntity<>(updateRecipeResponse, HttpStatus.OK);
    }

    @DeleteMapping(path="/{recipeId}")
    public ResponseEntity<DeleteRecipeResponse> deleteRecipe(@PathVariable Integer recipeId) {
        Optional<RecipeEntity> recipe = recipeService.getRecipeById(recipeId);
        DeleteRecipeResponse deleteRecipeResponse = new DeleteRecipeResponse();

        if (recipe.isPresent()) {
            recipeService.deleteRecipeById(recipeId);
            deleteRecipeResponse.setMessage("Recipe successfully removed!");
        } else {
            throw new NotFoundException("No Recipe found");
        }

        return new ResponseEntity(deleteRecipeResponse, HttpStatus.OK);
    }

}
