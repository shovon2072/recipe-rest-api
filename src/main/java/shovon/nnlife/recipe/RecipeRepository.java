package shovon.nnlife.recipe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shovon.nnlife.recipe.io.entity.RecipeEntity;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Integer> {

}
