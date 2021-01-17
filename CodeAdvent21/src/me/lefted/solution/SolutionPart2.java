package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionPart2 {

    public static final Function<String, String[]> FKT_GET_INGREDIENTS = line -> (line.contains("(") ? line.split(" \\(")[0].trim() : line).split(" ");
    public static final Function<String, String[]> FKT_GET_ALLERGENS = line -> line.contains("(") ? line.split("\\(contains ")[1].replace(")", "").split(", ")
	: null;

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	List<String> allergenfreeIngredients = getAllergenfreeIngredients(new ArrayList<>(input));

	List<String> input2 = removeAllergenfreeIngredients(new ArrayList<>(input), allergenfreeIngredients);
	Map<String, String> mapping = compileAllergentIngredientMap(input2);
	
	String found = compileSolutionString(mapping);
	System.out.println(String.format("found %s", found));
    }

    // arranges the ingredients alphabetically by their allergen
    public static String compileSolutionString(Map<String, String> mapping) {
	StringBuilder builder = new StringBuilder();

	for (int i = 0; i < mapping.size(); i++) {
	    if (i == mapping.size() - 1) {
		builder.append(mapping.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(entry -> entry.getValue()).toArray()[i]);
	    } else {
		builder.append(mapping.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(entry -> entry.getValue()).toArray()[i]).append(",");
	    }
	}

	return builder.toString();
    }

    public static Map<String, String> compileAllergentIngredientMap(List<String> input) {
	// map each allergent to every possible ingredient
	Map<String, Set<String>> allergentPossibleIngredientMap = new HashMap<>();

	for (String line : input) {

	    String[] ingredients = FKT_GET_INGREDIENTS.apply(line);
	    String[] allergens = FKT_GET_ALLERGENS.apply(line);

	    for (String allergent : allergens) {

		for (String ingredient : ingredients) {
		    if (canIngredientBeAllergent(ingredient, allergent, input)) {

			if (allergentPossibleIngredientMap.containsKey(allergent)) {
			    allergentPossibleIngredientMap.get(allergent).add(ingredient);
			} else {
			    allergentPossibleIngredientMap.put(allergent, new HashSet<>(Arrays.asList(ingredient)));
			}
		    }
		}
	    }
	}

	Map<String, String> mapping = new HashMap<>();

	// find the allergens which only match one certain ingredient
	while (!allergentPossibleIngredientMap.isEmpty()) {
	    // List<Entry<String, String>> entryToRemove = new ArrayList<>();
	    Map<String, String> entriesToRemove = new HashMap<>();

	    for (Entry<String, Set<String>> entry : allergentPossibleIngredientMap.entrySet()) {
		Set<String> ingredients = entry.getValue();
		String allergent = entry.getKey();

		if (mapping.containsKey(allergent))
		    continue;

		if (ingredients.size() == 1) {
		    String ingredient = ingredients.iterator().next();

		    // put it in final mapping
		    mapping.put(allergent, ingredient);
		    // remove it after for loop finishes
		    entriesToRemove.put(allergent, ingredient);
		}
	    }

	    // remove found entries from allergentPossibleIngredientMap
	    entriesToRemove.forEach((key, value) -> {
		allergentPossibleIngredientMap.remove(key);
		allergentPossibleIngredientMap.values().forEach(possibleIngredients -> possibleIngredients.remove(value));
	    });

	    // remove entries from entriesToRemove
	    entriesToRemove.clear();
	}

	return mapping;
    }

    public static List<String> removeAllergenfreeIngredients(List<String> input, List<String> allergenfreeIngredients) {
	List<String> input2 = new ArrayList<>();

	for (String line : input) {

	    List<String> ingredients = new ArrayList<>(Arrays.asList(FKT_GET_INGREDIENTS.apply(line)));
	    List<String> allergens = Arrays.asList(FKT_GET_ALLERGENS.apply(line));

	    // remove allergenfreeIngredients from ingredients in this line
	    ingredients.removeAll(allergenfreeIngredients);
	    StringBuilder lineBuilder = new StringBuilder();

	    // recompile the line
	    ingredients.forEach(ingredient -> lineBuilder.append(ingredient).append(" "));
	    lineBuilder.append(" (contains ");
	    IntStream.range(0, allergens.size()).forEach(index -> {
		if (index == allergens.size() - 1) {
		    lineBuilder.append(allergens.get(index)).append(")");
		} else {
		    lineBuilder.append(allergens.get(index)).append(", ");
		}
	    });

	    input2.add(lineBuilder.toString());
	}

	return input2;
    }

    /**
     * @return the ingredients that can't <b><u>possibly</u></b> be allergic
     */
    public static List<String> getAllergenfreeIngredients(List<String> input) {
	Map<String, Boolean> ingredientIsAllergicMap = new HashMap<>();

	// go through ingredients
	for (String line : input) {
	    String[] ingredients = FKT_GET_INGREDIENTS.apply(line);
	    String[] allergens = FKT_GET_ALLERGENS.apply(line);

	    for (String ingredient : ingredients) {

		// if food does contain allergens
		if (allergens != null) {

		    /*
		     * frist time found that the ingredient cant be current allergent -> set to true
		     * every other time -> true && already found value
		     */
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

		    if (!ingredientIsAllergicMap.containsKey(ingredient)) {
			ingredientIsAllergicMap.put(ingredient, cantBeAllergic);
		    } else {
			ingredientIsAllergicMap.put(ingredient, ingredientIsAllergicMap.get(ingredient).booleanValue() && cantBeAllergic);
		    }
		}
	    }
	}

	// return as list
	return ingredientIsAllergicMap.entrySet().stream().filter(entry -> entry.getValue()).map(entry -> entry.getKey()).collect(Collectors.toList());
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