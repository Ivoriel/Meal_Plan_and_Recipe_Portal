package pl.coderslab.model;

import java.sql.Date;
import java.util.Objects;


public class Recipe {
    private int id;
    private String name;
    private String ingredients;
    private String description;
    private Date created;
    private Date updated;
    private int preparationTime;
    private String preparation;
    private int adminId;
    private String urlAddress;

    public Recipe() {
        created = new Date(System.currentTimeMillis());
        updated = new Date(System.currentTimeMillis());
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        if (urlAddress!= null) {
            urlAddress = urlAddress.replace("watch?v=", "embed/");
        }
        this.urlAddress = urlAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getId() == recipe.getId() && getPreparationTime() == recipe.getPreparationTime() && getAdminId() == recipe.getAdminId() && getName().equals(recipe.getName()) && getIngredients().equals(recipe.getIngredients()) && Objects.equals(getDescription(), recipe.getDescription()) && getCreated().equals(recipe.getCreated()) && getUpdated().equals(recipe.getUpdated()) && getPreparation().equals(recipe.getPreparation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIngredients(), getDescription(), getCreated(), getUpdated(), getPreparationTime(), getPreparation(), getAdminId());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", preparationTime=" + preparationTime +
                ", preparation='" + preparation + '\'' +
                ", adminId=" + adminId +
                ", urlAddress='" + urlAddress + '\'' +
                '}';
    }
}
