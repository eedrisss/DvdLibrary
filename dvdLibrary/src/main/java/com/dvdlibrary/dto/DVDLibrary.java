/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.dto;

import com.dvdlibrary.exception.LibraryPersistenceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Isaac Shadare
 */
public class DVDLibrary  {
    
    private ArrayList<DVD> library;
    
  
    public DVDLibrary(){
        this.library = new ArrayList();
    }
    

    public DVDLibrary(ArrayList library){
        this.library = library;
    }
    
    
    public ArrayList getLibrary() {
        return library;
    }
    
    
    public void setLibrary(ArrayList library) {
        this.library = library;
    }
    

    public DVD getDVD(String title) throws LibraryPersistenceException{
        for(DVD d : this.library){
            if(d.getTitle().equals(title))
                return d;
        }       
        
        throw new LibraryPersistenceException("ERROR: DVD title was not found in the collection");
    }   
    
    
    
   
    public void add(DVD dvd) {
        this.library.add(dvd);
    }
    
    public DVD remove(String title) throws LibraryPersistenceException{
        for(DVD d : library){
            if(d.getTitle().equals(title)){
                library.remove(d);
                return d;
            }                            
        }
        
        throw new LibraryPersistenceException("ERROR: DVD title was not found in the collection");
    }
    
    
    public boolean remove(DVD dvd) {
        return library.remove(dvd);
    }
    
    
    
    
   
   
}
