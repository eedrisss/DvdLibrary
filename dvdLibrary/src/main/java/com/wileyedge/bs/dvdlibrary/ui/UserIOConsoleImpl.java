package com.wileyedge.bs.dvdlibrary.ui;


import java.util.Scanner;

/**
 *
 * @author Isaac Shadare
 */
public class UserIOConsoleImpl implements UserIO{
    
    final private Scanner console = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        boolean invalidInput = true;
        double num = 0;
        while (invalidInput){
            try{
                //print the message msgPrompt (ex: asking for the # of cats!)
                String stringValue = this.readString(prompt);
                //get the input line and try to parse
                num = Double.parseDouble(stringValue); //if it's 'bob' it'll break
                invalidInput = false; //or you can use 'break;'
            }catch(NumberFormatException e){
                //If it explodes, it'll go here and do this. 
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
    double result;
    do{
        result = readDouble(prompt);
        }
    while(result <min || result > max);
    return result;

    }

    @Override
    public float readFloat(String prompt) {
        boolean invalidInput = true;
        float num = 0;
        while (invalidInput){
            try{
                //print the message msgPrompt (ex: asking for the # of cats!)
                String stringValue = this.readString(prompt);
                //get the input line and try to parse
                num = Float.parseFloat(stringValue); //if it's 'bob' it'll break
                invalidInput = false; //or you can use 'break;'
            }catch(NumberFormatException e){
                //If it explodes, it'll go here and do this. 
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
    float result;
    do{
        result = readFloat(prompt);
        }
    while(result <min || result > max);
    return result;

    }
    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput){
            try{
                //print the message msgPrompt (ex: asking for the # of cats!)
                String stringValue = this.readString(prompt);
                //get the input line and try to parse
                num = Integer.parseInt(stringValue); //if it's 'bob' it'll break
                invalidInput = false; //or you can use 'break;'
            }catch(NumberFormatException e){
                //If it explodes, it'll go here and do this. 
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do{
            result = readInt(prompt);
        }while(result <min || result > max);
    return result;
    }

    @Override
    public long readLong(String prompt) {
        boolean invalidInput = true;
        long num = 0;
        while (invalidInput){
            try{
                //print the message msgPrompt (ex: asking for the # of cats!)
                String stringValue = this.readString(prompt);
                //get the input line and try to parse
                num = Long.parseLong(prompt);; //if it's 'bob' it'll break
                invalidInput = false; //or you can use 'break;'
            }catch(NumberFormatException e){
                //If it explodes, it'll go here and do this. 
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
    long result;
        do{
            result = readLong(prompt);
        }while(result <min || result > max);
    return result;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }
    
}