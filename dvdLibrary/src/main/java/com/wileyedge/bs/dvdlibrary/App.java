package com.wileyedge.bs.dvdlibrary;

import com.wileyedge.bs.dvdlibrary.controller.LibraryController;
import com.wileyedge.bs.dvdlibrary.dao.LibraryDao;
import com.wileyedge.bs.dvdlibrary.dao.LibraryDaoFileImpl;
import com.wileyedge.bs.dvdlibrary.ui.LibraryView;
import com.wileyedge.bs.dvdlibrary.ui.UserIO;
import com.wileyedge.bs.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args){
        UserIO myIO = new UserIOConsoleImpl();
        LibraryView myView = new LibraryView(myIO);
        LibraryDao myDao = new LibraryDaoFileImpl();
        LibraryController controller = new LibraryController(myView, myDao);
        controller.run();
    }
}

        