/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.view;

import java.util.Scanner;

/**
 *
 * @author Isaac Shadare
 */
public class UserIOConsoleImpl implements UserIO{
    Scanner reader;
    
    public UserIOConsoleImpl(){
        reader = new Scanner(System.in);
    }
    
    @Override
    public void print(String message){
        System.out.println(message);
    }
    
    @Override
    public String readString(String prompt){
        System.out.print(prompt);
        return reader.nextLine();
    }
    
    @Override
    public int readInt(String prompt){
        System.out.print(prompt);
        return Integer.parseInt(reader.nextLine());
    }
    
    @Override
    public int readInt(String prompt, int min, int max){
        int hold;
        do{
            System.out.print(prompt);
            hold = Integer.parseInt(reader.nextLine());
            if(hold >= min && hold <= max){
                return hold;
            }
            else{
               System.out.println("Your number was not between " + min + " and " + max + ". Please enter a number within this range");
            }
        }
        while(hold < min || hold > max);
       
        return min-1;
    }
    
    @Override
    public double readDouble(String prompt){
        System.out.print(prompt);
        return Double.parseDouble(reader.nextLine());
    }
    
    @Override
    public double readDouble(String prompt, double min, double max){
        double hold;
        do{
            System.out.print(prompt);
            hold = Double.parseDouble(reader.nextLine());
            if(hold >= min && hold <= max){
                return hold;
            }
            else{
               System.out.println("Your number was not between " + min + " and " + max + ". Please enter a number within this range");
            }
        }
        while(hold < min || hold > max);
        
        return min-1.0;
    }
      
}
