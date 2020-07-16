

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
 
public class RecipeSearch {
 
    public static void main(String[] args) {
       
        ArrayList <Recipe> recipes= new ArrayList<>();
        Scanner scan= new Scanner (System.in);;
       
        UserInterface uı= new UserInterface (scan, recipes);
       
        uı.start();
    }
   
   
 
}
