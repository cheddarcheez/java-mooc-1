/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
 
public class UserInterface {
   
    private Scanner scan;
    private ArrayList <Recipe> recipes;
   
   
    public UserInterface (Scanner scan, ArrayList<Recipe> recipes) {
       
        this.scan= scan;
        this.recipes=recipes;
    }
   
    public void start () {
       
        ArrayList<String> list = new ArrayList<>();  //Container
       
        System.out.println("File to read:");
        String input = scan.nextLine();  // txt file name input
       
        // TEXTS
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
       
        // Read txt file
        try (Scanner read= new Scanner (Paths.get(input))) {
 
                while (read.hasNextLine()) { //true-false line by line
                       
                        String row= read.nextLine(); // each line
                   
                        if (row.isEmpty()) { //if line is empty. Look the whitespaces in the text. You'll figure out.
                           
                            transferOfRecipes(list, this.recipes); // put first part recipe in the list (container).
                           
                            list.clear(); // because we must apply this things again.
                           
                        } else { // dont add empty lines in the list. This is protection
                           
                            list.add(row); // add each lines in the list
                        }
                }
               
                transferOfRecipes(list, recipes); // this is important because we must add last recipe.
 
            }catch (Exception e) {
                   
                System.out.println("An error occured.."+e.getMessage());
           
            }
       
       
        // COMMANDS
        while (true) {
            System.out.println("Enter command:");
            String command= scan.nextLine();
           
            if (command.equals("stop")) {
                break;
            }
           
            if (command.equals("list")) {
               
               
                System.out.println("Recipes:");  
                for (Recipe value: recipes) {
                   
                    System.out.println(value);
                }    
            }else if (command.equals ("find name")) {
               
                System.out.println("Searched word:");
                String search= scan.nextLine();
               
                System.out.println("Recipes:");
               
                for (Recipe recipe: recipes) {
                   
                    if (recipe.getName().contains(search)) { // search name
                       
                        System.out.println(recipe);
                    }
                }
            }else if (command.equals ("find cooking time")) {
               
                System.out.println("Max cooking time:");
                int maxTime= Integer.valueOf(scan.nextLine());
               
                System.out.println("Recipes:");
               
                for (Recipe recipe: recipes) {
                   
                    if (maxTime>= recipe.getCookingTime()) { // search cook Time
                       
                        System.out.println(recipe);
                    }
                }
            }else if (command.equals("find ingredient")) {
               
                System.out.println("Ingredient:");
                String ing= scan.nextLine();
               
                for (Recipe recipe: recipes) {
                   
                    if (recipe.getIng().contains(ing)) { // search Ingredient
                       
                        System.out.println(recipe);
                       
                    }
                }
            }
        }
    }
   
    public void transferOfRecipes (ArrayList<String> list, ArrayList<Recipe> recipes) { // two parameter. first: container, second: recipes
       
        String name= list.get(0); //name of recipe
        int cookingTime = Integer.valueOf(list.get(1)); // cookingTime of recipe
        ArrayList<String> ing = new ArrayList<>(); // ingredients of recipe
       
        for (int i = 2; i < list.size(); i++) {  // Why did u start 2? Because first index: name, second index: cookingTime
                               
            ing.add(list.get(i)); // put 2 between (lastIndex-1) in the ingredients list
        }
                           
        recipes.add (new Recipe(name, cookingTime, ing));// three parameter. Look at the Recipe class' Constructer                    
                                               
    }
}
 