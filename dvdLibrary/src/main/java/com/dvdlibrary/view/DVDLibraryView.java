/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.view;

import com.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Isaac Shadare
 */
public class DVDLibraryView {
    private UserIO io;
   
    public DVDLibraryView(){
        this.io = new UserIOConsoleImpl();
        io.print("Welcome to the DVD library program!");
    }
    
    

    
    public String addDVD(){
       String title = io.readString("\nEnter the title of the dvd: ");
       String director = io.readString("Enter the name of the director: ");
       String mpaa = io.readString("Enter the mpaa rating for the film: ");
       String studio = io.readString("Enter the studio for the dvd: ");
       String date = io.readString("enter the release date for the movie: ");
       String note = io.readString("Enter your review of the film and any takeaways you havea fter watching: ");
       io.print("The details are being processed");
       return title + "," + director + ","  + mpaa  + ","  + studio  + ","  + date  + ","  + note ;      
    }
    
   
    public void viewAllDVDs(ArrayList<DVD> library){
        if(library.isEmpty()){
           io.print("\nThere are no dvds in the library");
           return;
        }
        Iterator iterator = library.listIterator();
        while(iterator.hasNext() == true){
            io.print(iterator.next().toString());
        }
        
    }
    
  
    public void displayDVD(DVD dvd){
        io.print(dvd.toString());
    }
    
    

    
    
    public String viewSingleDVD(){
        String title = io.readString("Enter the title of the DVD you want to view: ");
        return title;                    
    }
    
   
    public String removeDVD(){
        String title = io.readString("\nEnter the title of the DVD you want to remove ");
        io.print("The details of the DVD are being processed");
        return title;           
    }
    
   
    public int displayMenu(){
        System.out.println("\nMenu");
        System.out.println("Enter the number of the corresponding option from this menu:");
        System.out.println("====================================");
        System.out.println("1) View all DVDs");
        System.out.println("2) View a single DVD");
        System.out.println("3) Add a DVD to the library");
        System.out.println("4) Delete a DVD from the library");
        System.out.println("5) Exit the DVD library");    
        return io.readInt("Enter a number to select an option: ", 1, 5);
    }
    
    public void print(String message){
        io.print(message);
    }
}
