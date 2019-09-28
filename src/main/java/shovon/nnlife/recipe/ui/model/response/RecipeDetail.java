package shovon.nnlife.recipe.ui.model.response;

public class RecipeDetail {
    private String id;
    private String title;
    private String makingTime;
    private String serves;
    private String ingredients;
    private String cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
