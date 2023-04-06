package com.mycompany.searchapp;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class objectio {
    public void WriteObjectToFile(Object serObj,String filepath) {
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (IOException ex) {
        }
    }
    public Object read(String filepath) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(new File(filepath));
        ObjectInputStream oi = new ObjectInputStream(fi);
	return oi.readObject();
        
    } 
}