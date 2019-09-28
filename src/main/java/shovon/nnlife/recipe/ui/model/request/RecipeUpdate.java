package shovon.nnlife.recipe.ui.model.request;

import javax.validation.constraints.NotNull;

public class RecipeUpdate {
    @NotNull(message = "Title can not be null")
    private String title;

    @NotNull(message = "Making time can not be null")
    private String makingTime;

    @NotNull(message = "Serves can not be null")
    private String serves;

    @NotNull(message = "Ingredients can not be null")
    private String ingredients;

    @NotNull(message = "Cost can not be null")
    private Integer cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMakingTime() {
        return makingTime;
    }

    public void setMakingTime(String makingTime) {
        this.makingTime = makingTime;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
