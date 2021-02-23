package Days;

import java.io.File;
import java.util.*;
public class Day21_1 {
    public static void main(String[] args) throws Exception{
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        //TODO: How many times do any of those ingredients(the ones that don't contain any allergens) appear?
        HashMap<String,HashSet<String>> allergens = new HashMap<>();
        HashSet<String> totalAllergens = new HashSet<>();
        TreeSet<String> allergentIngredients = new TreeSet<>();
        ArrayList<ArrayList<HashSet<String>>> recipes = new ArrayList<>();

        while(scan.hasNextLine()){
            ArrayList<String[]> temp = new ArrayList<>();
            String[] ingredientList = scan.nextLine().replace("(",".").replace(")","").split("\\.");
            HashSet<String> tempIngredients = new HashSet<>();
            HashSet<String> tempAllergens = new HashSet<>();
            String[] ingredients = ingredientList[0].split(" ");
            String[] allergens1 = ingredientList[1].substring(9).split(", ");

            tempAllergens.addAll(Arrays.asList(allergens1));
            tempIngredients.addAll(Arrays.asList(ingredients));
            ArrayList<HashSet<String>> arr = new ArrayList<>();

            arr.add(tempIngredients);
            arr.add(tempAllergens);
            totalAllergens.addAll(tempAllergens);
            recipes.add(arr);

        }

        for(String allergen : totalAllergens){
            //System.out.println(allergen);
            for(ArrayList<HashSet<String>> recipe : recipes){
               if(recipe.get(1).contains(allergen)) {
                  if(allergens.get(allergen) != null) {

                      allergens.get(allergen).retainAll(recipe.get(0));
                  }else{
                      HashSet<String> copy = new HashSet<>();
                      copy.addAll(recipe.get(0));
                      allergens.put(allergen,copy);
                  }
               }
            }

            HashSet<String> ingredients = allergens.get(allergen);

            if(ingredients.size() == 1){

                String ingredient = (String) ingredients.toArray()[0];

                for(String allergen1 : allergens.keySet()){
                    if(!allergen1.equals(allergen))
                        allergens.get(allergen1).remove(ingredient);
                }
                for(ArrayList<HashSet<String>> recipe : recipes){
                    recipe.get(0).remove(ingredient);
                }

            }
            /*
            System.out.println(allergens.get(allergen));
            System.out.println("---------------");
             */

        }

        boolean test = true;

        while(test) {
            test = false;
            for (String allergen3 : allergens.keySet()) {

                if (allergens.get(allergen3).size() == 1) {
                    String ingredient1 = (String) allergens.get(allergen3).toArray()[0];
                    for (String allergen4 : allergens.keySet()) {
                        if (!allergen4.equals(allergen3))
                            allergens.get(allergen4).remove(ingredient1);
                    }
                } else {
                    test = true;
                }
            }
        }

        int cont = 0;
        String dangerousList = "";
        TreeSet<String> sorted = new TreeSet<>();
        for(String allergen2 : allergens.keySet()){
            allergentIngredients.add((String) allergens.get(allergen2).toArray()[0]);
            sorted.add(allergen2);
        }
        for(ArrayList<HashSet<String>> recipe: recipes){
            HashSet<String> clone = new HashSet<>();
            clone.addAll(recipe.get(0));
            clone.removeAll(allergentIngredients);
            cont += clone.size();
        }

        for(String al : sorted) {
            dangerousList += allergens.get(al).toArray()[0]+",";
        }
        System.out.println(dangerousList);
    }

}
