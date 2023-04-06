/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
/**
 *
 * @author amani
 */
public class RulesClass {
    ArrayList<String> extensions=new ArrayList();
    long minimum_size=0;
    long maximum_size=1024*1024;
    Date cdmin;
    Date cdmax;
    Date edmin;
    Date edmax;
    public RulesClass(){
        
    }
    public void add_allowed_extension(String s){
     extensions.add(s);
    }
    public void set_size_limits(long min,long max){
    minimum_size=min;
    maximum_size=max;
    }
    public void set_Creationtime_limits(Date dmin,Date dmax){
        this.cdmin=dmin;
        this.cdmax=dmax;
    }
    public void set_edittime_limits(Date dmin,Date dmax){
        this.edmin=dmin;
        this.edmax=dmax;
    }
    boolean pub=false;
    public void set_public(){
        pub=true;
    }
    public boolean aply_limits(File f) throws IOException{
        boolean r=false;
        for(var ext:extensions){
            if (f.getName().endsWith(ext)){
                r=true;
                break;
            }
        }
        if (!r){
            return false;
        }
        if (pub){
            return pub;
        }
        long size=f.length();
        if (size<maximum_size &&size> minimum_size){
            r=true;
        }
        else {
            return false;
        }
       // String path=f.getPath();
        Path path=Path.of(f.getPath());
        var attr = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime fileTime = attr.creationTime();
        var ctime=new Date(fileTime.toMillis());
        if (ctime.getTime()<cdmax.getTime()&& ctime.getTime()>cdmin.getTime()){
            r=true;
        }
        else{
        r=false;
        return false;
        }
        FileTime fileTime2 = attr.lastModifiedTime();
        var etime=new Date(fileTime2.toMillis());
        if (etime.getTime()<edmax.getTime()&& etime.getTime()>edmin.getTime()){
            r=true;
        }
        else{
        r=false;
        return false;
        }
        return r;
    }
}
