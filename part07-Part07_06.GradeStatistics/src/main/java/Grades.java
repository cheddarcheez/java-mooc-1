/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */

import java.util.ArrayList;

public class Grades {
    private ArrayList<Integer> grades;
    private int[] grade;
    
    public Grades(){
        this.grades= new ArrayList<>();
    }
    public void addGrade(int number){
        this.grades.add(number);
    }
    public double pointAverage(){
        int sum=0;
        int count=grades.size();
        if(this.grades.isEmpty()){
            return -1;
        }
        for(int i=0;i<count;i++){
            sum=sum+ grades.get(i);
        }
        return 1.0*sum/count;
    }
    public double passingPointsAverage(){
        int sum=0;
        int count=0;
        if(this.grades.isEmpty()){
            return -1;
        }
        for(int i=0;i<grades.size();i++){
            if(grades.get(i)>=50){
                sum=sum+grades.get(i);
                count++;
            }
        }
        return 1.0*sum/count;
    }
    public double passPercentage(){
        int passingcount=0;
        int count=0;
        if(this.grades.isEmpty()){
            return -1;
        }
        for(int i=0;i<grades.size();i++){
            if(grades.get(i)>=50){
                passingcount++;
                count++;
            }else{
                count++;
            }
        }
        return (100.0*passingcount)/count;
    }
    public void printStars(int number){
        int stars= grades.get(number);
        for(int i=0;i<stars;i++){
            System.out.print("*");
        }
    }
    public int eachGrade(){
        int gradie=0;
        grade= new int[6];
        for(int i=0;i<grades.size();i++){
            if(grades.get(i)<50){
                gradie=0;
                grade[0]++; 
            }else if(grades.get(i)<60&&grades.get(i)>49){ 
                gradie=1;
                grade[1]++; 
            }else if(grades.get(i)<70&&grades.get(i)>59){ 
                gradie=2;
                grade[2]++; 
            }else if(grades.get(i)<80&&grades.get(i)>69){ 
                gradie=3;
                grade[3]++; 
            }else if(grades.get(i)<90&&grades.get(i)>79){
                gradie=4;
                grade[4]++; 
            }else if(grades.get(i)<101&&grades.get(i)>=90){ 
                gradie=5;
                grade[5]++; 
            } 
        }
        return gradie;
    }
    public void stars(int number){
        for(int i=0;i<number;i++){
            System.out.print("*");
        }
    }
    public void print(){
        eachGrade();
        for(int x=5;x>=0;x--){
            System.out.print(x+ ": ");
            stars(grade[x]);
            System.out.println("");
        }
    }
    
}
