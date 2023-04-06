/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author tecyo
 */
public class FilesValues {
     public long size=0;
     public String name;
     public String justname;
     public long time;
     
    public int compare(FilesValues f) {
          if (size == f.size)
            return 0;
        else if (size > f.size)
            return 1;
        else
            return -1;
    }
}

