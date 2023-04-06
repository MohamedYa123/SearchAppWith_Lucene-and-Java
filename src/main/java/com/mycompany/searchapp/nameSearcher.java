/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author amani
 */
public class nameSearcher {
    public void Search(ArrayList<File> files,String word){
        results=new ArrayList();
        for(var l : files){
            if (l.getName().contains(word)){
                results.add(l.getPath());
            }
        }
    }
    public void Search_repeatedFiles(ArrayList<File> files)
    {
        
    }
    public ArrayList< String> results;
}

