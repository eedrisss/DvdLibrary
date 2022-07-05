/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.wileyedge.bs.dvdlibrary.controller;

/**
 *
 * @author Isaac Shadare
 */
public enum MenuSelection {
    ADD(1), EDIT(2), REMOVE(3), GETALL(4), GETSINGLE(5), GETBYPROPERTY(6), EXIT(7);
 
    final int menuChoice;
    
    MenuSelection(int menuChoice){
        this.menuChoice = menuChoice;
    }
}
