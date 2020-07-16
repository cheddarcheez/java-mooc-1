/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class Container {
    private int cont;
   
    
    public Container(){
      this.cont=0;
    }
    public int contains(){
        return this.cont;
    }
    public void add(int amount){
        if(amount>0){
        cont= amount+ cont;
        }
        if(cont>100){
            cont=100;
        }
    }
    
    public void remove(int amount){
        if(amount<0){
            cont=cont;
        }
        cont=cont-amount;
        if(cont<0){
            cont=0;
        }
        
    }
    @Override
    public String toString(){
        return cont+"/100";
    }
          
}
