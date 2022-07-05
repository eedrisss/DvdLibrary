package com.wileyedge.bs.dvdlibrary.dao;

import com.wileyedge.bs.dvdlibrary.dao.LibraryDaoException;
import com.wileyedge.bs.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class LibraryDaoFileImpl implements LibraryDao{

    private Map<String, DVD> libraryCollection = new HashMap<>();
    public static final String COLLECTION_FILE="collection.txt";
    public static final String DELIMITER = "::";
    
    /**
     *
     * @param title
     * @param dvd
     * @return
     * @throws LibraryDaoException
     */
    @Override
    public DVD addDVD(String id, DVD dvd) throws LibraryDaoException{
        loadCollection();
        DVD currentDVD = libraryCollection.put(id, dvd);
        writeCollection();
        return currentDVD;
    }

    @Override
    public List<DVD> returnAllDVDs() throws LibraryDaoException{
        loadCollection();
        return new ArrayList<DVD>(libraryCollection.values());
    }

    @Override
    public DVD removeDVD(String id) throws LibraryDaoException{
        loadCollection();
        DVD removedDVD = libraryCollection.remove(id);
        writeCollection();
        return removedDVD;    
    }

    @Override
    public DVD editRelease(String id, String releaseDate) throws LibraryDaoException {
        loadCollection();
        DVD currentDVD = libraryCollection.get(id);
        currentDVD.setReleaseDate(releaseDate);
        writeCollection();
        return currentDVD;
    }

    @Override
    public DVD editMPAA(String id, String mpaaRating) throws LibraryDaoException {
        loadCollection();
        DVD currentDVD = libraryCollection.get(id);
        currentDVD.setMpaaRating(mpaaRating);
        writeCollection();
        return currentDVD;
    }

    @Override
    public DVD editDirector(String id, String directorName)throws LibraryDaoException {
        loadCollection();
        DVD currentDVD = libraryCollection.get(id);
        currentDVD.setDirectorName(directorName);
        writeCollection();
        return currentDVD;   
    }

    @Override
    public DVD editStudio(String id, String studio) throws LibraryDaoException {
        loadCollection();
        DVD currentDVD = libraryCollection.get(id);
        currentDVD.setStudio(studio);
        writeCollection();
        return currentDVD;    
    }

    @Override
    public DVD editUserNote(String id, String userNote) throws LibraryDaoException {
        loadCollection();
        DVD currentDVD = libraryCollection.get(id);
        currentDVD.setUserNote(userNote);
        writeCollection();
        return currentDVD;  
    }

    @Override
    public DVD getDVD(String id) throws LibraryDaoException{
        loadCollection();
        return libraryCollection.get(id);
    }

    @Override
    public List<DVD> returnByTitle(String title) throws LibraryDaoException{
        loadCollection();
        List<DVD> returnList = new ArrayList<>();
        for(DVD dvd: libraryCollection.values()){
            if(dvd.getTitle().equalsIgnoreCase(title)){
                returnList.add(dvd);
            }
        }
        return returnList;
    }

    @Override
    public List<DVD> returnByYear(String years) throws LibraryDaoException {
        loadCollection();
        List<DVD> returnList = new ArrayList<>();
        for(DVD dvd: libraryCollection.values()){
            if(dvd.getReleaseDate().equalsIgnoreCase(years)){
                returnList.add(dvd);
            }
        }
        
        return returnList;
    }

    @Override
    public List<DVD> returnByMPAA(String rating) throws LibraryDaoException{
        loadCollection();
        List<DVD> returnList = new ArrayList<>();
        for(DVD dvd: libraryCollection.values()){
            if(dvd.getMpaaRating().equalsIgnoreCase(rating)){
                returnList.add(dvd);
            }
        }
        return returnList;
    }

    @Override
    public List<DVD> returnByDirector(String director) throws LibraryDaoException {
        loadCollection();
        List<DVD> returnList = new ArrayList<>();
        for(DVD dvd: libraryCollection.values()){
            if(dvd.getDirectorName().equalsIgnoreCase(director)){
                returnList.add(dvd);
            }
        }
        return returnList;  
    }

    @Override
    public List<DVD> returnByStudio(String studio) throws LibraryDaoException{
        loadCollection();
        List<DVD> returnList = new ArrayList<>();
        for(DVD dvd: libraryCollection.values()){
            if(dvd.getStudio().equalsIgnoreCase(studio)){
                returnList.add(dvd);
            }
        }
        return returnList;  
    }
    
    
    @Override
    public List<DVD> returnByNote(String userNote) throws LibraryDaoException{
        loadCollection();
        List<DVD> returnList = new ArrayList<>();
        for(DVD dvd: libraryCollection.values()){
            if(dvd.getUserNote().equalsIgnoreCase(userNote)){
                returnList.add(dvd);
            }
        }
        return returnList;
    }
    //unmarshalls DVD String to form a returnDVD object and sets parameters
    private DVD unmarshallDVD(String DVDAsText){
        String[] dvdToken = DVDAsText.split(DELIMITER);
        String dvdID = dvdToken[0];
        DVD returnDVD = new DVD(dvdID);
        returnDVD.setTitle(dvdToken[1]);
        returnDVD.setReleaseDate(dvdToken[2]);
        returnDVD.setMpaaRating(dvdToken[3]);
        returnDVD.setDirectorName(dvdToken[4]);
        returnDVD.setStudio(dvdToken[5]);
        returnDVD.setUserNote(dvdToken[6]);
        return returnDVD;
    }
    
    //reads collection.txt
    private void loadCollection() throws LibraryDaoException{
        Scanner in;
        
        try{
            in = new Scanner(new BufferedReader(new FileReader(COLLECTION_FILE)));
        }catch(FileNotFoundException e){
            throw new LibraryDaoException("Could not load File Data!", e);
        }
        String currentLine; 
        DVD currentDVD;
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            libraryCollection.put(currentDVD.getID(),currentDVD);
        }
        in.close();
    }
    private String marshallDVD(DVD dvd){
        String dvdAsText = dvd.getID() + DELIMITER;
        dvdAsText+= dvd.getTitle() + DELIMITER;
        dvdAsText+= dvd.getReleaseDate() + DELIMITER;
        dvdAsText+= dvd.getMpaaRating() + DELIMITER;
        dvdAsText+= dvd.getDirectorName() + DELIMITER;
        dvdAsText+= dvd.getStudio() + DELIMITER;
        dvdAsText+= dvd.getUserNote();
        
        return dvdAsText;
    }
    
    private void writeCollection() throws LibraryDaoException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(COLLECTION_FILE));
        }catch(IOException e){
            throw new LibraryDaoException("Could not save DVD data", e);
        }
        
        String dvdAsText;
        List<DVD> dvdList = this.returnAllDVDs();
        for(DVD currentDVD: dvdList){
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }

}