/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.service;

import com.dvdlibrary.dto.DVD;
import com.dvdlibrary.exception.LibraryPersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Isaac Shadare
 */
public interface IDVDService {
    
    public void editDVD(String title, String field, String edit) throws LibraryPersistenceException;
    
    public void addDVD(DVD dvd);
    
    public DVD removeDVD(String title) throws LibraryPersistenceException;
    
    public DVD findDVD(String title) throws LibraryPersistenceException;
    
    public ArrayList getLibrary();
    
    public void loadLibrary();
    
    public void saveLibrary();
    
    
}
