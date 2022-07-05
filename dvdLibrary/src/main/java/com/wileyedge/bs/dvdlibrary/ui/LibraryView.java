package com.wileyedge.bs.dvdlibrary.ui;

import com.wileyedge.bs.dvdlibrary.controller.MenuSelection;
import com.wileyedge.bs.dvdlibrary.dto.DVD;
import java.util.List;

public class LibraryView{
    
    
    private UserIO io;
    //constructor
    public LibraryView(UserIO io){
        this.io = io;
    }
    
    
    //Main Menu
    public int menuPrintSelection(){
        io.print("Main Menu");
        io.print("1. Add new DVD");
        io.print("2. Edit DVD Info");
        io.print("3. Remove DVDs");
        io.print("4. List all DVDS");
        io.print("5. Display DVD Info");
        io.print("6. Search By Properties");
        io.print("7. Exit");
        return io.readInt("Please select from the above choices", 1, 7);
    }
    
    //Edit and Property Search Menu
    public int propertySelection(){
        io.print("1. ID");
        io.print("2. Title");
        io.print("3. Release Date");
        io.print("4. MPAA Rating");
        io.print("5. Director");
        io.print("6. Studio");
        io.print("7. User Note");
        io.print("8. Exit");
        return io.readInt("Please select from the above choices", 1, 8);
    }
    
    
    //Use this to ask user which DVD to find (using ID)
    public String getID() {
        return io.readString("Please enter a student ID");
    }

    
    //display singular DVD
    public void displayDVD(DVD chosenDVD) {
       if(chosenDVD !=null){
           io.print("ID: " + chosenDVD.getID());
           io.print("Title: " + chosenDVD.getTitle());
           io.print("Release Date: " + chosenDVD.getReleaseDate());
           io.print("MPAA Rating: " + chosenDVD.getMpaaRating());
           io.print("Director: " + chosenDVD.getDirectorName());
           io.print("Studio: " + chosenDVD.getStudio());
           io.print("User Note: " + chosenDVD.getUserNote());
       }else{
           io.print("This DVD is not part of the collection!");
       }
       io.readString("Please hit Enter to continue!");        
    }
    
    
    //Get user input for NEW DVD(add method)
    public DVD getNewDVDInfo() {
       String dvdID = io.readString("Please enter DVD ID");
       String title = io.readString("Please Enter Title");
       String releaseDate = io.readString("Please Enter Release Date");
       String rating = io.readString("Please Enter MPAA Rating");
       String director = io.readString("please Enter Director");
       String studio= io.readString("please Enter Studio");
       String userNote = io.readString("please Enter User Note");
       DVD result = new DVD(dvdID);
       result.setTitle(title);
       result.setReleaseDate(releaseDate);
       result.setMpaaRating(rating);
       result.setDirectorName(director);
       result.setStudio(studio);
       result.setUserNote(userNote);
       return result;
    }
    
    
    //IO output for removing DVD
    public void removeDVD(DVD choice){
       if(choice!=null){
           io.print("DVD succesfully removed");
       }else{
           io.print("This DVD is not part of the collection!");
       }
       io.readString("Please hit enter to continue!");
    }
    
    
    //Format View for Lists of DVDs
    public void displayDVDList(List<DVD> collection) {
       if(!collection.isEmpty()){
       for(DVD dvd: collection){
           String dvdInfo = String.format("%s %s %s %s %s %s %s", dvd.getID(), 
                                          dvd.getTitle(), dvd.getReleaseDate(), 
                                          dvd.getMpaaRating(), dvd.getDirectorName(), 
                                          dvd.getStudio(), dvd.getUserNote());
                  io.print(dvdInfo);
       }
       }else{
           io.print("Collection is empty!");
       }
              io.readString("Please hit Enter to continue!");
    }

    
    //Show if Error Occurs
    public void displayErrorMessage(String message) {
        io.print("------------------ERROR----------------");
        io.print(message);
    }
    
    
    //Show if Unknown Command is inputted
    public void unknownCommandBanner() {
        io.print("--------------------UNKNOWN COMMAND-------------------");
    }
   
    
    //ALL THE BANNERS
    public void exitBanner() {
       io.print("--------------------GOOD BYE--------------------"); 
    }

    
    public void displayEditBanner() {
        io.print("--------------------EDIT DVD--------------------");
    }

   
    public void displayCreationSuccessBanner() {
        io.print("--------------------DVD SUCCESSFULLY ADDED--------------------");
    }

    
    public void displayNewDVDBanner() {
        io.print("--------------------ADD DVD--------------------");
    }

    
    public void displayRemoveDVDBanner() {
        io.print("--------------------REMOVE DVD--------------------");
    }

    
    public void displayAllDVDBanner() {
        io.print("--------------------DISPLAY ALL DVDS--------------------");
    }

    
    public void displaySingleDVDBanner() {
        io.print("--------------------DISPLAY SINGLE DVD--------------------");
    }


    public void displayFindByPropertyBanner() {
        io.print("--------------------SEARCH BY PROPERTY--------------------");
    }

    public void editIDErrorBanner() {
        io.print("--------------------CANNOT EDIT ID!--------------------");
    }
    
    public void editTitleErrorBanner() {
        io.print("--------------------CANNOT EDIT TITLE--------------------");
    }

    
    public void displayEditReleaseDateBanner() {
        io.print("--------------------EDIT RELEASE DATE--------------------");
    }

    
    public void displayEditRatingBanner() {
        io.print("--------------------EDIT MPAA RATING--------------------");
    }

    
    public void displayEditDirectorBanner() {
        io.print("--------------------EDIT DIRECTOR--------------------");
    }


    public void displayEditStudioBanner() {
        io.print("--------------------EDIT STUDIO--------------------");
    }


    public void displayEditNoteBanner() {
        io.print("--------------------EDIT USER NOTE--------------------");
    }

    
    //ALL THE METHODS TO GET PROPERTIES FOR EDIT/SEARCH
    public String getReleaseDate() {
        return io.readString("Please enter new release date");
    }

    
    public String getRating() {
        return io.readString("Please enter rating to search/edit");
    }

    
    public String getDirector() {
        return io.readString("Please enter director to search/edit");
    }
     
    
    public String getStudio() {
        return io.readString("Please enter studio to search/edit");
    }

    
    public String getNote() {
        return io.readString("Please enter note to search/edit");
    }

    
    public String getTitle() {
        return io.readString("Please enter title to search");
    }

    
    public String getYear() {
        return io.readString("Please enter year to search");
    }


    
    
}
