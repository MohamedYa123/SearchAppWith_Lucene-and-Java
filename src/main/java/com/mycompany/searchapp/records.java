/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author medo1
 */
public class records extends javax.swing.JFrame {

    /**
     * Creates new form records
     */
    public records() {
        
        initComponents();
        
         this.getContentPane().setBackground(new java.awt.Color(102,102,255));
        this.jButton1.setVisible(false);
        reclists.removeAll();
        recfiles.removeAll();
        DefaultListModel df=new DefaultListModel();
        for(var l:stat.recs.records){
            //for(var k :l.searchresults){
            if (l.searchresults!=null){
                df.addElement("Search at "+l.time+" "+l.searchresults.size()+" Files found");}
            else{
                df.addElement("Search at "+l.time+" no "+" Files found");
            }
           // }
        }
                   ListSelectionListener listSelectionListener = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
         // System.out.println("selcted\n");
          jButton1ActionPerformed(null);
      }
      
    };
    reclists.addListSelectionListener(listSelectionListener);
        reclists.setModel(df);
        recfiles.setModel(new DefaultListModel());
    }
                                            
    public frm1 form1=null;
    public about form2=null;
    public records form3=null;
    public frmresult form4=null;
    public Fileview form5=null;
    void goback(){
        if (form1!=null){
            form1.setVisible(true);
            form1.setLocationRelativeTo(null);
        }
        if (form2!=null){
                 form2.setVisible(true);
            form2.setLocationRelativeTo(null);
        }
        if (form3!=null){
                    form3.setVisible(true);
            form3.setLocationRelativeTo(null);
        }
        if (form4!=null){
                    form4.setVisible(true);
            form4.setLocationRelativeTo(null);
        }
        if (form5!=null){
                    form5.setVisible(true);
            form5.setLocationRelativeTo(null);
        }
        this.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        recfiles = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        reclists = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(80, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("عرض النتيجة");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(80, 153, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("عبارة البحث");

        details.setBackground(new java.awt.Color(80, 153, 255));
        details.setColumns(20);
        details.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        details.setForeground(new java.awt.Color(255, 255, 255));
        details.setRows(5);
        jScrollPane3.setViewportView(details);

        recfiles.setBackground(new java.awt.Color(80, 153, 255));
        recfiles.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        recfiles.setForeground(new java.awt.Color(255, 255, 255));
        recfiles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(recfiles);

        reclists.setBackground(new java.awt.Color(80, 153, 255));
        reclists.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reclists.setForeground(new java.awt.Color(255, 255, 255));
        reclists.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(reclists);

        jButton2.setBackground(new java.awt.Color(80, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("عرض الملف");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(80, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("عودة");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButton1)
                        .addGap(67, 67, 67)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String content;
    boolean pdfv=false;
    File ff;
    String w;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int i=reclists.getSelectedIndex();
        DefaultListModel df=new DefaultListModel();
        if (stat.recs.records.get(i).searchresults!=null){
        for(var k : stat.recs.records.get(i).searchresults){
            df.addElement(k);
        }}
        recfiles.setModel(df);
        this.jTextField1.setText(stat.recs.records.get(i).word);
        var l=stat.recs.records.get(i);
        String s="";
        if (l.searchresults!=null){
        s+="Search at "+l.time+" "+l.searchresults.size()+" Files found";}
        else{
            s+=("Search at "+l.time+" no "+" Files found");
        }
        s+="\nSearch word : "+l.word;
        w=l.word;
        this.details.setText(s);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void setcontent(String path) throws IOException{
        pdfv=path.endsWith(".pdf");
        File f=new File(path);
        ff=f;
        content=readfile(f);
        Path path2=Path.of(f.getPath());
        var attr = Files.readAttributes(path2, BasicFileAttributes.class);
        FileTime fileTime = attr.creationTime();
        var ctime=new Date(fileTime.toMillis());
        var etime=new Date(attr.lastModifiedTime().toMillis());
        String s="Location : "+path;
        s+="\nCreation Time : "+ctime;
        s+="\nLast Edit Time : "+etime;
      //  this.textlog1.setText(s);
    }
    public String readfile(File file) throws FileNotFoundException, IOException{
            BufferedReader br
            = new BufferedReader(new FileReader(file));
        String data="";
        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        if (file.getName().endsWith(".pdf")){
            return "";
        }
        while ((st = br.readLine()) != null){
            data+=st+"\n";}
        return data;
    }
         public String readpdfv(File file) throws IOException{
        try ( //File file = new File("D:/example.pdf");
                var dc=Loader.loadPDF(file);
                PDDocument document = Loader.loadPDF(file))  {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfTextStripper.setStartPage(1);
            pdfTextStripper.setEndPage(5);
            String text  = pdfTextStripper.getText(document);
            return text;
            //this.jTextArea1.setText(text);
          //  System.out.println(text);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            String fpath=this.recfiles.getModel().getElementAt(recfiles.getSelectedIndex());
        try {
            this.setcontent(fpath);
        } catch (IOException ex) {
            Logger.getLogger(records.class.getName()).log(Level.SEVERE, null, ex);
        }
            if (pdfv){
            try {
                
                //  try {
                // pdfView f=new pdfView();
                //  f.setpdfv(ff);
                // f.setVisible(true);
                // f.setLocationRelativeTo(null);
                // } catch (IOException ex) {
                // Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
                // }
                content=readpdfv(ff);
            } catch (IOException ex) {
                Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    //    else{
        Fileview f=new Fileview();
        f.myfile=new File(fpath);
        f.form3=this;
        f.word=w;
        f.data=content;
        f.setselections(); 
        f.setVisible(true);
        f.setLocationRelativeTo(null);//}
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        goback();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea details;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> recfiles;
    private javax.swing.JList<String> reclists;
    // End of variables declaration//GEN-END:variables
}