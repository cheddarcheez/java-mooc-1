/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scanner;
    private Grades grades; 
    
    public UserInterface(Scanner scanner, Grades grades){
        this.scanner = scanner;
        this.grades = grades;
        
        
    }
    public void start(){
        System.out.println("Enter point totals, -1 stops: ");
        while(true){
            
            int input = Integer.valueOf(scanner.nextLine());
            if(input == -1){
                break;
            }
            if(input >= 0 && input <= 100){
                this.grades.addGrade(input);
            }
        }
        System.out.println("Point average (all): "+ grades.pointAverage());
        if(grades.passingPointsAverage()!=0){
            System.out.println("Point average (passing): "+ grades.passingPointsAverage());
        }else{
            System.out.println("Point average (passing): -");
        }
        System.out.println("Pass percentage: "+ grades.passPercentage());
        grades.print();
    }
}
