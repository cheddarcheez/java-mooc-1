
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class UserInterface {
    
    private Container con1;
    private Container con2;
    private int amount;

    
    public UserInterface(Container con1,Container con2){
        this.con1= new Container();
        this.con2= new Container();
        this.amount=0;

    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        
        while(true){
        System.out.println("First: "+ this.con1);
        System.out.println("Second: "+ this.con2);
        String input = scanner.nextLine();
        if(input.equals("quit")){
            break;
        }
        String[] parts = input.split(" ");
        String command = parts[0];
        int amount = Integer.valueOf(parts[1]);
        
        if(command.equals("add")){
            this.con1.add(amount);
            continue;
        }
        if(command.equals("move")){
                //Move behavior
                if(amount > con1.contains()){
                    amount = con1.contains(); //desiredAmount = firstContainerVolume
                    con1.remove(amount); //firstContainerVolume - desiredAmount = newFirstContainerVolume
                    con2.add(amount); //newSecondContainerVolume = secondContainerVolume + desiredAmount
                }else{
                    con1.remove(amount); //firstContainerVolume - desiredAmount = newFirstContainerVolume
                    con2.add(amount); //newSecondContainerVolume = secondContainerVolume + desiredAmount
                }
                //this.con1.remove(amount);
                //this.con2.add(amount);
            }
        if(command.equals("remove")){
            this.con2.remove(amount);
            continue;
        }
        }
    }      
}
