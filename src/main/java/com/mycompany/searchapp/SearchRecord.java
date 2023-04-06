/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author amani
 */
public class SearchRecord implements Serializable{
    public ArrayList<String> searchresults;
    public Date time;
    public String word;
    public SearchRecord(ArrayList<String> searchresults,Date time,String word){
        this.searchresults=searchresults;
        this.time=time;
        this.word=word;
    }

    SearchRecord() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

