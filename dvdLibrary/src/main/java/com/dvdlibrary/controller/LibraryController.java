/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.controller;

import com.dvdlibrary.dto.DVD;
import com.dvdlibrary.exception.LibraryPersistenceException;
import com.dvdlibrary.service.IDVDService;
import com.dvdlibrary.view.DVDLibraryView;

/**
 *
 * @author Isaac Shadare
 */
public class LibraryController {
    private DVDLibraryView view;
    private IDVDService service;

    
    //Constructor
    public LibraryController(DVDLibraryView view, IDVDService service) {
        this.view = view;
        this.service = service;
    }
    
    
    public void listLibrary(){
            view.viewAllDVDs(service.getLibrary());      
    }
   
    public void viewDVD(){
        try{
            view.displayDVD(service.findDVD(view.viewSingleDVD()));
        }
        catch(LibraryPersistenceException crpe)
        {
            rehandleError(crpe.getMessage());
        }           
    }
    
    public void addDVD(){       
       String[] p = view.addDVD().split(",");
       service.addDVD(new DVD(p[0], p[1], p[2], p[3], p[4], p[5]));
    }
    
    public void removeDVD(){
        try{
            view.displayDVD(service.removeDVD(view.removeDVD()));
        }
        catch(LibraryPersistenceException lpe){
            rehandleError(lpe.getMessage());
        }
        
    }
    
   
    public void execute() {  
        int userChoice;
        do {
            userChoice = view.displayMenu();
        
            if(userChoice != 5) {
                switch (userChoice) {
                    case 1: 
                        listLibrary();
                        break;
                    case 2:
                        viewDVD();
                        break;
                    case 3:
                        addDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    default: 
                        view.print("Error: Invalid case");
                }
            }
            
        } while(userChoice != 5);
        
        view.print("Goodbye!");
        service.saveLibrary();
    }
    
    public void rehandleError(String error){
        view.print(error);
        execute();
    }
}
