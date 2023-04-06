/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 *
 * @author amani
 */
public class stat {
    public static String path="data.xy";
    public static allsearches recs;
    public static String datapath="";
    public static Connection conent;
    public static void save(){
        objectio obj=new objectio();
        obj.WriteObjectToFile(recs, path);
    }
    public static allsearches read() throws IOException, FileNotFoundException, ClassNotFoundException{
        objectio obj=new objectio();
        File f=new File(path);
        System.out.println(f.getAbsolutePath());
        recs=(allsearches)obj.read(path);
        return recs;
    }
    public static void load_db() throws SQLException, ClassNotFoundException{
        String hostname="localhost";
        String InstanceName="MOHAMEDYASSER\\SQLEXPRESS";
        String dbname="amany";
        String user="sa";
        String password="123456789";
        //DESKTOP-E2QBF24\SQLEXPRESS
        String con="jdbc:sqlserver://"+hostname+":1433"
            + ";instance="+InstanceName+"databaseName="+dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      //  String conn="jdbc:sqlserver://localhost:1433;DatabaseName=amany;instance=DESKTOP-E2QBF24;encrypt=true;TrustServerCertificate=true;";
      //  String con2="Data Source=DESKTOP-E2QBF24\\SQLEXPRESS;Initial Catalog=db;Integrated Security=true";
      var con3=   "jdbc:sqlserver://localhost:1433;Initial Catalog=db;Integrated Security=true";
      var con4="Data Source=SQL8005.site4now.net;Initial Catalog=db_a96cf2_medo;User Id=db_a96cf2_medo_admin;Password=Doublemedo123;TrustServerCertificate=True";
      var con5="jdbc:sqlserver://MOHAMEDYASSER\\SQLEXPRESS;databaseName=hospitalDB;TrustServerCertificate=True;Trusted_Connection=True";
    //  conent = DriverManager.getConnection(con,user,password);   
     // conent = DriverManager.getConnection(con5,"","");   
    }
   
    public static void save_db(){
       
    }
}
