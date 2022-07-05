/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.dao;

import com.dvdlibrary.dto.DVD;
import com.dvdlibrary.exception.LibraryPersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaac Shadare
 */
public interface IDVDao {    
    
    public void addDVD(DVD dvd);
    
    public ArrayList getLibrary();
    
    public DVD removeDVD(String title) throws LibraryPersistenceException;

    public DVD find(String id) throws LibraryPersistenceException;
    
    public void editDVD(String title, String field, String edit) throws LibraryPersistenceException;

    public void save(ArrayList<DVD> library);
    
    public void setLibrary(ArrayList<DVD> library);
    
    public ArrayList<DVD> load();
    
}
