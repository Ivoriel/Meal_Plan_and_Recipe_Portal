package pl.coderslab.model;

public class DashboardPlanItem {
    String planName;
    String dayName;
    String mealName;
    String recipeName;
    Integer id;

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public String getDayName() {
        return dayName;
    }

    public String getMealName() {
        return mealName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Integer getId() {
        return id;
    }
}
