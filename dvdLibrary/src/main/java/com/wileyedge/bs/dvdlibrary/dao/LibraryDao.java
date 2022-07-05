/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wileyedge.bs.dvdlibrary.dao;

import com.wileyedge.bs.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Isaac Shadare
 */
public interface LibraryDao {
    
    DVD addDVD(String id, DVD dvd) throws LibraryDaoException;
    List<DVD> returnAllDVDs() throws LibraryDaoException;
    DVD removeDVD(String id) throws LibraryDaoException;
    DVD editRelease(String id, String releaseDate) throws LibraryDaoException;
    DVD editMPAA(String id, String mpaaRating) throws LibraryDaoException;
    DVD editDirector(String id, String directorName) throws LibraryDaoException;
    DVD editStudio(String id, String studio) throws LibraryDaoException;
    DVD editUserNote(String id, String userNote) throws LibraryDaoException;
    DVD getDVD(String id) throws LibraryDaoException;//use switch case after returnByTitle, let user choose
    List<DVD> returnByTitle(String title) throws LibraryDaoException;
    List<DVD> returnByYear(String years)throws LibraryDaoException;
    List<DVD> returnByMPAA(String rating)throws LibraryDaoException;
    List<DVD> returnByDirector(String director) throws LibraryDaoException;
    List<DVD> returnByStudio(String studio) throws LibraryDaoException;
    List<DVD> returnByNote(String note) throws LibraryDaoException;
}
