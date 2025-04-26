interface MealPlan {
    String getMealPlanName();
    String getMealDetails();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "Vegetarian Meal";
    }

    @Override
    public String getMealDetails() {
        return "A meal plan with plant-based foods like vegetables, grains, and legumes.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "Vegan Meal";
    }

    @Override
    public String getMealDetails() {
        return "A meal plan that excludes all animal products, including dairy and eggs.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "Keto Meal";
    }

    @Override
    public String getMealDetails() {
        return "A low-carb, high-fat meal plan that induces ketosis in the body.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealPlanName() {
        return "High-Protein Meal";
    }

    @Override
    public String getMealDetails() {
        return "A meal plan with a high intake of protein-rich foods like chicken, fish, and beans.";
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMealPlan() {
        System.out.println("Meal Plan: " + mealPlan.getMealPlanName());
        System.out.println("Details: " + mealPlan.getMealDetails());
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(T mealPlan) {
        Meal<T> meal = new Meal<>(mealPlan);
        meal.displayMealPlan();
    }

    public static <T extends MealPlan> boolean validateMealPlan(T mealPlan) {
        // In this case, validation can check if the meal plan is null or incomplete
        return mealPlan != null;
    }
}

class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        VegetarianMeal vegetarianMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal highProteinMeal = new HighProteinMeal();

        System.out.println("Generating Vegetarian Meal Plan:");
        if (MealPlanGenerator.validateMealPlan(vegetarianMeal)) {
            MealPlanGenerator.generateMealPlan(vegetarianMeal);
        }

        System.out.println("\nGenerating Vegan Meal Plan:");
        if (MealPlanGenerator.validateMealPlan(veganMeal)) {
            MealPlanGenerator.generateMealPlan(veganMeal);
        }

        System.out.println("\nGenerating Keto Meal Plan:");
        if (MealPlanGenerator.validateMealPlan(ketoMeal)) {
            MealPlanGenerator.generateMealPlan(ketoMeal);
        }

        System.out.println("\nGenerating High-Protein Meal Plan:");
        if (MealPlanGenerator.validateMealPlan(highProteinMeal)) {
            MealPlanGenerator.generateMealPlan(highProteinMeal);
        }
    }
}
