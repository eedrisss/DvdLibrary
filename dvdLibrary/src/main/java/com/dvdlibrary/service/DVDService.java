/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.service;

import com.dvdlibrary.dao.DVDao;
import com.dvdlibrary.dao.IDVDao;
import com.dvdlibrary.dto.DVD;
import com.dvdlibrary.exception.LibraryPersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Isaac Shadare
 */
public class DVDService implements IDVDService {

    
    
    IDVDao dao;
    
    public DVDService(String filePath) throws LibraryPersistenceException{
        try{
            this.dao = new DVDao(filePath);
        }
        catch(LibraryPersistenceException lpe){
            throw lpe;
        }
    }
    
    public DVDService(IDVDao dao){
        this.dao = dao;
    }
    
    

    @Override
    public void editDVD(String title, String field, String edit) throws LibraryPersistenceException{
        try{
            dao.editDVD(title, field, edit);
        }
        catch(LibraryPersistenceException lpe){
            throw lpe;
        }
        
    }

    @Override
    public void addDVD(DVD dvd) {
        dao.addDVD(dvd);
    }

    @Override
    public DVD removeDVD(String title) throws LibraryPersistenceException {
        try{
           return dao.removeDVD(title);
        }
        catch(LibraryPersistenceException lpe){
            throw lpe;
        }                                
    }

    @Override
    public DVD findDVD(String title) throws LibraryPersistenceException {
        return dao.find(title);
    }
    
    @Override
    public ArrayList getLibrary() {
        return dao.getLibrary();
    }
    
    public void saveLibrary(){
        dao.save(dao.getLibrary());
    }
    
    public void loadLibrary(){
        dao.setLibrary(dao.load());
    }
}
