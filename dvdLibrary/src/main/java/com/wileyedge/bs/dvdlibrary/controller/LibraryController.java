package com.wileyedge.bs.dvdlibrary.controller;

import com.wileyedge.bs.dvdlibrary.dao.LibraryDao;
import com.wileyedge.bs.dvdlibrary.dao.LibraryDaoException;
import com.wileyedge.bs.dvdlibrary.dto.DVD;
import com.wileyedge.bs.dvdlibrary.ui.LibraryView;
import java.util.List;
import java.util.Map;

public class LibraryController{
    
    //Controller HAS A view
    private LibraryView view;
    //(for now) CONTROLLER HAS A DAO(can integrate service layer later on)
    private LibraryDao dao;
    // For future enum integration MenuSelection menu;
    // For future enum integration PropertySelection propertySelection;
    
    //constructor
    public LibraryController(LibraryView view, LibraryDao dao){
        this.view = view;
        this.dao = dao;
        }
    
    
    //main method to run in app
    public void run(){
        boolean keepGoing = true;
        int menuSelection;
        while(keepGoing){
            try{
             menuSelection = getMenuSelection();
               switch(menuSelection){
                   case 1: //Add
                       addDVD();
                       break;
                   case 2: //edit
                       editDVD();
                       break;
                   case 3: //remove
                       removeDVD();
                       break;
                   case 4: //listAll
                       listAllDVD();
                       break;
                   case 5: 
                       listDVD();
                       break;
                   case 6://search by property
                       listByProperty();
                       break;
                   case 7: 
                       keepGoing=false;//Exit scenario
                       break;
                   default:
                      unknownCommand();//unknown command             
             }
               exitMessage();
            }catch(LibraryDaoException e){
                view.displayErrorMessage(e.getMessage());
            }
        }
    }
    
    
    //int for main menu selection
    private int getMenuSelection() {
        return view.menuPrintSelection();
    }
    //int for edit and search switch case
    //Use this for edit/search menu
    private int getPropertySelection(){
        return view.propertySelection();
    }

    
    //switch case to decide which property to edit(Title returns error)
    private void editDVD() throws LibraryDaoException{
        view.displayEditBanner();
        String dvdID = view.getID();
        DVD chosenDVD = dao.getDVD(dvdID);
        view.displayDVD(chosenDVD);
            int propertySelection;
            boolean keepGoing = true;
            while(keepGoing){
                propertySelection = getPropertySelection();
                switch(propertySelection){
                    case 1: 
                        editIDError();
                        break;
                    case 2://Title
                        editTitleError();
                        break;
                    case 3://ReleaseDate
                        editReleaseDate(dvdID);
                        break;
                    case 4://MPAARating
                        editRating(dvdID);
                        break;
                    case 5://Director
                        editDirector(dvdID);
                        break;
                    case 6://Studio
                        editStudio(dvdID);
                        break;
                    case 7://UserNote
                        editUserNote(dvdID);
                        break;
                    case 8://Exit
                        keepGoing = false;
                        break;
                    default: 
                      unknownCommand();
                }
        }
    }
    
    
    //add new DVD to file
    private void addDVD()throws LibraryDaoException {
        view.displayNewDVDBanner();
        DVD newDVD =view.getNewDVDInfo();
        dao.addDVD(newDVD.getID(), newDVD);
        view.displayCreationSuccessBanner();
        
    }
    
    
    //gets userID using view and removes from DAO
    private void removeDVD()throws LibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdID = view.getID();
        DVD choice = dao.removeDVD(dvdID);
        view.removeDVD(choice);
    }
    //returns all DVDs from DAO collection
    private void listAllDVD()throws LibraryDaoException {
        view.displayAllDVDBanner();
        List<DVD> collection = dao.returnAllDVDs();
        view.displayDVDList(collection);
    }
    
    //returns single DVD by ID
    private void listDVD() throws LibraryDaoException{
        view.displaySingleDVDBanner();
        String dvdID = view.getID();
        DVD choice = dao.getDVD(dvdID);
        view.displayDVD(choice);
    }
    
    //switch case to search and return list using Any Property of DVD except ID
    private void listByProperty()throws LibraryDaoException {
        view.displayFindByPropertyBanner();
        int propertySelection;
        boolean keepGoing = true;
        while(keepGoing){
            propertySelection= getPropertySelection();
           switch(propertySelection){
               case 1: 
                   findByID();//ID
                   break;
               case 2: //Title
                   findByTitle();
                   break;
               case 3: //Date
                   findByYear();
                   break;
               case 4: //Rating
                   findByRating();
                   break;
               case 5: //Director
                   findByDirector();
                   break;
               case 6: //Studio
                   findByStudio();
                   break;
               case 7: //User Note
                   findByUserNote();
                   break;
               case 8: //Exit
                   keepGoing= false;
                   break;
                   
               default: 
                   unknownCommand();
           } 
        }
    }
    
    //Output if command is Unknown
    private void unknownCommand()throws LibraryDaoException{
        view.unknownCommandBanner();
    }
    
    //Exit Banner
    private void exitMessage() throws LibraryDaoException{
       view.exitBanner();
    }
    
    
    //ALL EDIT METHODS BELOW
    //cannot edit Title after Submission
    private void editTitleError() {
        view.editTitleErrorBanner();
    }
    
    //edit ReleaseDate
    private void editReleaseDate(String dvdID)throws LibraryDaoException {
        view.displayEditReleaseDateBanner();
        String newDate = view.getReleaseDate();
        DVD changedDVD = dao.editRelease(dvdID, newDate);
    }
    
    //edit Rating
    private void editRating(String dvdID)throws LibraryDaoException {
        view.displayEditRatingBanner();
        String newRating = view.getRating();
        DVD changedDVD = dao.editMPAA(dvdID, newRating);
    }
    
    //edit Director
    private void editDirector(String dvdID)throws LibraryDaoException {
        view.displayEditDirectorBanner();
        String newDirector = view.getDirector();
        DVD changedDVD = dao.editDirector(dvdID, newDirector);
    }
    
    //edit Studio
    private void editStudio(String dvdID) throws LibraryDaoException{
        view.displayEditStudioBanner();
        String newStudio = view.getStudio();
        DVD changedDVD = dao.editStudio(dvdID, newStudio);       
    }
    
    //edit User Note
    private void editUserNote(String dvdID) throws LibraryDaoException{
        view.displayEditNoteBanner();
        String newNote = view.getNote();
        DVD changedDVD = dao.editUserNote(dvdID, newNote);        
    }
    
    
    //ALL FINDBY METHODS BELOW
    //search by Title
    private void findByTitle() throws LibraryDaoException{
        String title = view.getTitle();
        List<DVD> collection = dao.returnByTitle(title);
        view.displayDVDList(collection);
    }
    
    //search by Year
    private void findByYear() throws LibraryDaoException{
        String year = view.getYear();
        List<DVD> collection = dao.returnByYear(year);
        view.displayDVDList(collection);
    }
    
    //search by MPAA Rating
    private void findByRating() throws LibraryDaoException{
        String rating = view.getRating();
        List<DVD> collection = dao.returnByMPAA(rating);
        view.displayDVDList(collection);
    }
    
    //search By Director
    private void findByDirector() throws LibraryDaoException{
        String director = view.getDirector();
        List<DVD> collection = dao.returnByDirector(director);
        view.displayDVDList(collection);
    }
    
    //search By Studio
    private void findByStudio() throws LibraryDaoException{
        String studio = view.getStudio();
        List<DVD> collection = dao.returnByStudio(studio);
        view.displayDVDList(collection);
    }
    
    //search By User Note
    private void findByUserNote() throws LibraryDaoException{
        String userNote = view.getNote();
        List<DVD> collection = dao.returnByNote(userNote);
        view.displayDVDList(collection);
    }

    private void findByID() throws LibraryDaoException{
        view.displaySingleDVDBanner();
        String id = view.getID();
        DVD dvd = dao.getDVD(id);
        view.displayDVD(dvd);
    }

    private void editIDError() {
        view.editIDErrorBanner();
    }
    }