/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author tecyo
 */
public class comparer implements Comparator<FilesValues>{
    int rule;
    @Override
    public int compare(FilesValues t, FilesValues f) {
        long a1=0;
        long a2=0;
        if(rule==1){
            a1=f.size;
            a2=t.size;
        }
        else if (rule==2){
            a1=t.size;
            a2=f.size;
        }
        else if(rule==3){
            a1=f.time;
            a2=t.time;
        }
        else if(rule==4){
            a1=t.time;
            a2=f.time;
        }
        if (a1 == a2)
            return 0;
        else if (a1> a2)
            return 1;
        else
            return -1;
        
    }

    
   
    
}
