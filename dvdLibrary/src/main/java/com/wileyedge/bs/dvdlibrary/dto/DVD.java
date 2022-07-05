package com.wileyedge.bs.dvdlibrary.dto;

public class DVD{
    private String id;//Use ID to init/search specifically, 
                      //because there can be multiple films with the same title
    private String title;//even though title isn't unique, it cannot be set/altered
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String userNote;
    
    //DVD cannot have default constructor without any title, must have at least an ID
    public DVD(String id){
        this.id = id;
    }
    
    public String getID(){
        return id;
    }
    //this is ONLY used during new DVD creation
    public void setTitle(String title){
       this.title= title;
    }
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

}