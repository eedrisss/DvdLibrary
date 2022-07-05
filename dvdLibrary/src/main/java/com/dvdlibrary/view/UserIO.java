/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.view;

/**
 *
 * @author Isaac Shadare
 */
public interface UserIO {
    
    public void print(String message);

    public String readString(String prompt);

    public int readInt(String prompt);

    public int readInt(String prompt, int min, int max);

    public double readDouble(String prompt);

    public double readDouble(String prompt, double min, double max);
}
