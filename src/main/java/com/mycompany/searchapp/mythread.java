/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.queryParser.ParseException;

/**
 *
 * @author amani
 */
public class mythread extends Thread {
    @Override
    public void run(){
        try {
            lt.main(text,bol);
        } catch (IOException ex) {
            Logger.getLogger(mythread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(mythread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(mythread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public LuceneTester lt; 
    public String text;
    public boolean bol;
}
