/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

/**
 *
 * @author amani
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
public class LuceneTester {
	
   public  String indexDir = "Index";
   public String dataDir = "Data";
   public ArrayList<String> alldirs=new ArrayList();
   public ArrayList<String> ls;
   Indexer indexer;
   Searcher searcher;
   boolean searchalldirs=false;
   boolean searchrepeated=false;
   public boolean imdone=false;
   public RulesClass rc=null;
   public  void main(String word,boolean s) throws IOException, ParseException, java.text.ParseException {
       if (alldirs.isEmpty()){
       alldirs.add(dataDir);
       if("".equals(dataDir)){
           return;
       }
       }
        imdone=false;
         ls=new ArrayList();
       for(int i=0;i<alldirs.size();i++)
       {
      dataDir=alldirs.get(i);
       searchword=word;
      
      // indexer=new Indexer(dataDir);
      try {
          searchalldirs=s;
        // tester = new LuceneTester();
        if (rc==null){
            rc=new RulesClass();
            rc.set_public();
           /* rc.maximum_size=1024*1024*1024;
            ZoneId defaultZoneId = ZoneId.systemDefault();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = format.parse("1970/01/01 00:00:00:00");
            rc.cdmin= date;
            rc.edmin= date;
            rc.cdmax=Date.from( LocalDate.now().atStartOfDay(defaultZoneId).toInstant());
            rc.edmax=Date.from( LocalDate.now().atStartOfDay(defaultZoneId).toInstant());*/
            rc.add_allowed_extension(".txt");
            rc.add_allowed_extension(".java");
            rc.add_allowed_extension(".py");
            rc.add_allowed_extension(".pdf");
            rc.add_allowed_extension(".doc");
        }
         createIndex();
         search(word);
         searchnames(word);
         if (true){
             //بحث الملفات المكررة
             lookrepeatedFiles();
        }
         
      } catch (IOException e) {
          
         Date dt=new Date(System.currentTimeMillis());
         SearchRecord sc=new SearchRecord(ls,dt,word);
         stat.recs.records.add(sc);
        // e.printStackTrace();
      }
       //  e.printStackTrace();
      
       }
       Date dt=new Date(System.currentTimeMillis());
         SearchRecord sc=new SearchRecord(ls,dt,word);
         stat.recs.records.add(sc);
       imdone=true;
      stat.save();
   }
   public String searchword;
   public String indexing_msg="";
   public String searching_msg="";
   public String indx_time="";
   long startTime;
   int numIndexed;
   private void createIndex() throws IOException {
       indexer=new Indexer(indexDir);
      indexer.lt=this;
      startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter(),searchalldirs,0);
      long endTime = System.currentTimeMillis();
      indexer.close();
      //System.out.println(numIndexed+" File indexed, time taken: "
      //   +(endTime-startTime)+" ms");	
      indexing_msg+="\n"+numIndexed+" File indexed, time taken: "   +(endTime-startTime)+" ms";
   }
   public void setindx(int nr,int allnum){
       long endTime = System.currentTimeMillis();
       long n= (endTime-startTime);
       indx_time="Files found : "+allnum+"\nFiles indexed "+nr+"\nTime : "+n/1000+" seconds";
   }
   
   private void search(String searchQuery) throws IOException, ParseException {
       if(numIndexed==0){
           return;
       }
      searcher = new Searcher(indexDir);
       startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery,numIndexed);
      long endTime = System.currentTimeMillis();
    //  ls=new ArrayList();
     // System.out.println(hits.totalHits +
       //  " documents found. Time :" + (endTime - startTime));
      searching_msg+="\n \" "+dataDir+" \" : "+hits.scoreDocs.length +
         " documents found. Time :" + (endTime - startTime)/1000+" seconds";
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
           // System.out.println("File: "
           // + doc.get(LuceneConstants.FILE_PATH));
         //   searching_msg+="\nFile: "+ doc.get(LuceneConstants.FILE_PATH);
            ls.add(doc.get(LuceneConstants.FILE_PATH));
      }
      searcher.close();
   }
   public nameSearcher nm=new nameSearcher();
   private void searchnames(String word){
       startTime = System.currentTimeMillis();
       nm=new nameSearcher();
       nm.Search(indexer.files_in, word);
       long endTime = System.currentTimeMillis();
       searching_msg+="\n"+nm.results.size() +
         " Files found By name. Time :" + (endTime - startTime)/1000+" seconds";
       ls.addAll(nm.results);
   }
   public SearchRepeater sch=new SearchRepeater();
   public void lookrepeatedFiles(){
    
    sch.Search(indexer.files_in);
    int filesFound=0;
    for(var a:sch.filesrepeated){
        if(a.size()!=0){
            filesFound++;
        }
    }
    searching_msg+="\nRepeated Files found : "+filesFound;
   }
}