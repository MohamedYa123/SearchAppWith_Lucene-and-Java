/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
/**
 *
 * @author tecyo
 */
public class SearchRepeater {
    ArrayList<ArrayList<FilesValues>> filesrepeated=new ArrayList();
    public void Search(ArrayList<File> files)
    {
        ArrayList<FilesValues> filesprops=new ArrayList();
        for(int i=0;i<files.size();i++)
        {
            FilesValues fv=new FilesValues();
            fv.size= files.get(i).length();
            fv.name=files.get(i).getAbsolutePath();
            fv.justname=files.get(i).getName();
            filesprops.add(fv);
        }
        comparer comp=new comparer();
        Collections.sort(filesprops,comp);
        long size=-1;
        for(var a:filesprops){
            if(a.size==size){
                filesrepeated.get(filesrepeated.size()-1).add(a);
            }
            else{
            filesrepeated.add(new ArrayList());
            size=a.size;
            }
        }
    }
}
