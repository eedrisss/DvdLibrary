/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.app;

import com.dvdlibrary.controller.LibraryController;
import com.dvdlibrary.exception.LibraryPersistenceException;
import com.dvdlibrary.service.DVDService;
import com.dvdlibrary.service.IDVDService;
import com.dvdlibrary.view.DVDLibraryView;

/**
 *
 * @author Isaac Shadare
 */
public class DVDApp {
    /** Entry point to the program
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        try{
            DVDLibraryView view = new DVDLibraryView();
            IDVDService service = new DVDService("dvdlibrary.txt");
            service.loadLibrary();
            
            LibraryController controller = new LibraryController(view, service); 
            controller.execute();
        }
        catch(LibraryPersistenceException lpe){
            System.out.println(lpe.getMessage());
        }
        
        
    }
}
