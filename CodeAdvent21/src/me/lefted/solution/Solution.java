package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static final Function<String, String[]> FKT_GET_INGREDIENTS = line -> (line.contains("(") ? line.split(" \\(")[0].trim() : line).split(" ");
    public static final Function<String, String[]> FKT_GET_ALLERGENS = line -> line.contains("(") ? line.split("\\(contains ")[1].replace(")", "").split(", ")
	: null;

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	List<String> allergenfreeIngredients = getAllergenfreeIngredients(input);

	int found = calcSolution(allergenfreeIngredients, input);
	System.out.println(String.format("found %s", found));
    }

    /**
     * @return how many times the allergenfree ingredients appear
     */
    public static int calcSolution(List<String> allergenfreeIngredients, List<String> input) {
	return input.stream().mapToInt(line -> (int) Stream.of(FKT_GET_INGREDIENTS.apply(line)).filter(ingredient -> allergenfreeIngredients.contains(
	    ingredient)).count()).sum();
    }

    /**
     * @return the ingredients that can't possibly be allergic
     */
    public static List<String> getAllergenfreeIngredients(List<String> input) {
	Map<String, Boolean> ingredientAllergicMap = new HashMap<>();

	// go through ingredients
	for (String line : input) {
	    String[] ingredients = FKT_GET_INGREDIENTS.apply(line);
	    String[] allergens = FKT_GET_ALLERGENS.apply(line);

	    for (String ingredient : ingredients) {

		// if food does contain allergens
		if (allergens != null) {

		    Boolean cantBeAllergic = null;
		    // iterate over allergens and check if the ingredient can't possibly be the allergent
		    for (String allergent : allergens) {

			if (cantBeAllergic == null && !canIngredientBeAllergent(ingredient, allergent, input)) {
			    cantBeAllergic = true;
			} else if (cantBeAllergic != null) {
			    cantBeAllergic = cantBeAllergic.booleanValue() && !canIngredientBeAllergent(ingredient, allergent, input);
			}
		    }
		    cantBeAllergic = cantBeAllergic == null ? false : cantBeAllergic;

		    if (!ingredientAllergicMap.containsKey(ingredient)) {
			ingredientAllergicMap.put(ingredient, cantBeAllergic);
		    } else {
			ingredientAllergicMap.put(ingredient, ingredientAllergicMap.get(ingredient).booleanValue() && cantBeAllergic);
		    }
		}
	    }
	}
	return ingredientAllergicMap.entrySet().stream().filter(entry -> entry.getValue()).map(entry -> entry.getKey()).collect(Collectors.toList());
    }

    /**
     * @return false if ingredient can't possibly be allergic
     */
    public static boolean canIngredientBeAllergent(String ingredient, String allergent, List<String> input) {

	for (String line : input) {

	    List<String> allergens = Arrays.asList(FKT_GET_ALLERGENS.apply(line));
	    List<String> ingredients = Arrays.asList(FKT_GET_INGREDIENTS.apply(line));

	    if (allergens.contains(allergent) && !ingredients.contains(ingredient)) {
		return false;
	    }
	}

	return true;
    }
}