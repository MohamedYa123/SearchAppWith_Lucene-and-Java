/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

/**
 *
 * @author amani
 */

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Indexer {
   private IndexWriter writer;

   public Indexer(String indexDirectoryPath) throws IOException {
      //this directory will contain the indexes
      Directory indexDirectory = 
         FSDirectory.open(new File(indexDirectoryPath));

      //create the indexer
      writer = new IndexWriter(indexDirectory, 
         new StandardAnalyzer(Version.LUCENE_36),true, 
         IndexWriter.MaxFieldLength.UNLIMITED);
   }



   public void close() throws CorruptIndexException, IOException {
      writer.close();
   }

   private Document getDocument(File file) throws IOException {
      Document document = new Document();
      
      //index file contents
      Field contentField = new Field(LuceneConstants.CONTENTS, new FileReader(file));
      //index file name
      Field fileNameField = new Field(LuceneConstants.FILE_NAME,
         file.getName(),Field.Store.YES,Field.Index.NOT_ANALYZED);
      //index file path
      Field filePathField = new Field(LuceneConstants.FILE_PATH,
         file.getCanonicalPath(),Field.Store.YES,Field.Index.NOT_ANALYZED);

      document.add(contentField);
      document.add(fileNameField);
      document.add(filePathField);
     
      return document;
   }   
   public LuceneTester lt;
   public ArrayList<File> files_in=new ArrayList();
   private void indexFile(File file) throws IOException {
      lt.indexing_msg+= "\nIndexing "+file.getCanonicalPath();
      if (file.getName().endsWith(".pdf")){
          
      }
      files_in.add(file);
      Document document = getDocument(file);
      writer.addDocument(document);
   }
   int ik=0;
   int maxdepth=5000;
   public int createIndex(String dataDirPath, FileFilter filter,boolean searchall,int depth) 
      throws IOException {
      //get all files in the data directory
      File[] files = new File(dataDirPath).listFiles();
      if (files==null){
          return writer.numDocs();
      }
      depth++;
      for (File file : files) 
      {
         if(( !file.isDirectory())
            && !file.isHidden()
            && file.exists()
            && file.canRead()
            && accept(file)
         )
         {
           try{
            indexFile(file);
            lt.setindx( writer.numDocs(),ik);
            }
           catch(IOException ex){
           }
         }
         else if (file.isDirectory()&& searchall && !file.isHidden() &&depth<this.maxdepth){
              //if (file.isDirectory()){
                createIndex(file.getPath(),  filter, searchall,depth);
            //}
            
         }
         if (!file.isDirectory()){
         ik++;}
         /*if (ik %10==0 ){
             try{
        // lt.setindx( writer.numDocs(),ik);
             }
             catch(IOException ex)
             {
             }
             
         }  */       
      }
      return writer.numDocs();
   }
  public boolean accept(File file) throws IOException {
      try{
    return lt.rc.aply_limits(file);//file.getName().endsWith(".txt") ;
      }
      catch(IOException e){
          return false;
      }
  }
};
