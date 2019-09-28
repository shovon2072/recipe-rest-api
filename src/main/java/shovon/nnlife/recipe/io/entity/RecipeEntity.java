package shovon.nnlife.recipe.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="recipes")
public class RecipeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable=false, length=100)
    private String title;

    @Column(name = "making_time", nullable=false, length=100)
    private String makingTime;

    @Column(name = "serves", nullable=false, length=100)
    private String serves;

    @Column(name = "ingredients", nullable=false, length=300)
    private String ingredients;

    @Column(name = "cost", nullable=false)
    private Integer cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
