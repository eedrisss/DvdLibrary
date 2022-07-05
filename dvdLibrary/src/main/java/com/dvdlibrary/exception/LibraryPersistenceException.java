/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.exception;

/**
 *
 * @author Isaac Shadare
 */
public class LibraryPersistenceException extends Exception {

    /**
     * Creates a new instance of <code>LibraryPersistenceError</code> without
     * detail message.
     */
    public LibraryPersistenceException() {
    }

    /**
     * Constructs an instance of <code>LibraryPersistenceError</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LibraryPersistenceException(String msg) {
        super(msg);
    }
}
