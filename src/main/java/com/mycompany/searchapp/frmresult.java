/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.searchapp;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.Loader;
/**
 *
 * @author amani
 */
public class frmresult extends javax.swing.JFrame {

    /**
     * Creates new form frmresult
     */
    public frmresult() {
        initComponents();
        this.jComboBox3.setSelectedIndex(0);
        this.getContentPane().setBackground(new java.awt.Color(102,102,255));
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.jComboBox3.setSize(this.textField1.getSize());
       // DefaultListModel df=new DefaultListModel();
        //jres.setModel(df);
        //this.jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        //jLabel1.setVerticalAlignment(SwingConstants.TOP);
        this.getContentPane().setBackground(new java.awt.Color(102,102,255));
        this.setTitle("نتيجة البحث");
        textlog.setText("hh");
        
      
         this.jComboBox3.addActionListener(new ActionListener () {
    public void actionPerformed(ActionEvent e) {
         int i= jComboBox3.getSelectedIndex();
          if(psf!=null ){
              try {
                  setresults(psf,psf2,i);
              } catch (IOException ex) {
                  Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
    }
});
       // this.jLabel1.setText("<html> Type: TextFile <br> Size : 20 kb <br>Last edited : 30/10/2000 </html>");
       // this.jButton1.setVisible(false);
    /*   jres.removeAll();
           ListSelectionListener listSelectionListener = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
         // System.out.println("selcted\n");
          var j=jres.getSelectedIndex();
          var item=jList3.getModel().getElementAt(j);
          jList2.setSelectedIndex(j);
          jList3.setSelectedIndex(j);
         // System.out.println("\n"+item+"");
          try {
              setcontent(item);
          } catch (IOException ex) {
              Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    };
    ListSelectionListener ll2 = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
                var j=jList2.getSelectedIndex();
        //  var item=jres.getModel().getElementAt(j);
          jres.setSelectedIndex(j);
          jList3.setSelectedIndex(j);
      }};
    ListSelectionListener ll3 = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
                var j=jList3.getSelectedIndex();
         // var item=jres.getModel().getElementAt(j);
          jres.setSelectedIndex(j);
          jList2.setSelectedIndex(j);
      }};
        
    jres.addListSelectionListener(listSelectionListener);
    jList2.addListSelectionListener(ll2);
    jList3.addListSelectionListener(ll3);
    jres.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                    if (evt.getClickCount() == 2) {
                        showoutside();
                    } 
            }
        });
    jList2.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                    if (evt.getClickCount() == 2) {
                        showoutside();
                    } 
            }
        });
     jList3.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                    if (evt.getClickCount() == 2) {
                        showoutside();
                    } 
            }
        });
    this.jList2.setModel(new DefaultListModel());
    this.jList3.setModel(new DefaultListModel());
    this.jres1.setModel(new DefaultListModel());
    this.jlist21.setModel(new DefaultListModel());
    this.jlist31.setModel(new DefaultListModel());*/
}
    ArrayList<String> SortList(ArrayList<String> list,int rule) throws IOException
    {
        ArrayList<FilesValues> ls=new ArrayList<FilesValues>();
        for(var a:list){
            FilesValues fvs=new FilesValues();
            fvs.name=a;
            File f=new File(a);
            fvs.size=f.length();
            Path path=Path.of(f.getPath());
            var attr = Files.readAttributes(path, BasicFileAttributes.class);
            fvs.time=attr.creationTime().toMillis();
            ls.add(fvs);
        }
        comparer comp=new comparer();
        comp.rule=rule;
        ls.sort(comp);
        ArrayList<String> ls2=new ArrayList<String>();
        for(var a:ls){
            ls2.add(a.name);
        }
        return ls2;
    }
    ArrayList<String> psf;
    ArrayList<String> psf2;
    boolean first=true;
    public void setresults(ArrayList<String> sf,ArrayList<String> sf2,int rule) throws IOException{
        //var l=sf.split("\n");
        if (sf==null){
            return;
        }
        if(rule==0){
        psf=sf;psf2=sf2;}
        if(rule!=0){
            if(sf.size()-sf2.size()==0){
                sf=new ArrayList<String>();
            }
            else{
                      int ii=0;
        ArrayList<String> sf3=new ArrayList<String>(); 
        for (String l1 : sf) {
            if(sf.size()-ii==sf2.size()){
                break;
            }
            sf3.add(l1);
            ii++;
        }
            sf=sf3;
            }
            sf=SortList(sf,rule);
            sf2=SortList(sf2,rule);
        }
        var df=(DefaultTableModel)this.jTable1.getModel();
        
        var df2=(DefaultTableModel)this.jTable2.getModel();
        int rowCount = df.getRowCount();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    df.removeRow(i);
}
rowCount = df2.getRowCount();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    df2.removeRow(i);
}
      //  DefaultListModel df=new DefaultListModel();
      //  DefaultListModel df2=new DefaultListModel();
      //  DefaultListModel df3=new DefaultListModel();
      int i=0;
        for (String l1 : sf) {
            if(sf.size()-i==sf2.size()){
                break;
            }
            File f=new File(l1);
            String fname="";
            if (!"".equals(l1)){
             //   df.addElement(f.getName());
             fname=f.getName();
            }
            
            var s=f.getName();
            var g=s.split("\\.");
            String[] data={fname,g[g.length-1],l1};
            df.addRow(data);
            this.jTable1.isCellEditable(i, 0);
            this.jTable1.setCellEditor(null);
            this.jTable1.isCellEditable(i, 1);
            this.jTable1.isCellEditable(i, 2);
            i++;
         //   df3.addElement(l1);
          //  df2.addElement(g[g.length-1]);
        }
        i=0;
        for (String l1 : sf2) {
            File f=new File(l1);
            String fname="";
            if (!"".equals(l1)){
             //   df.addElement(f.getName());
             fname=f.getName();
            }
            
            var s=f.getName();
            var g=s.split("\\.");
            String[] data={fname,g[g.length-1],l1};
            df2.addRow(data);
            this.jTable2.isCellEditable(i, 0);
            this.jTable2.isCellEditable(i, 1);
            this.jTable2.isCellEditable(i, 2);
            this.jTable2.setCellEditor(null);
           
            i++;
         //   df3.addElement(l1);
          //  df2.addElement(g[g.length-1]);
        }
       if(first){
        this.jTable1.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent evt) {
                var a= jTable1.getSelectedRow();
                 try {
                     setcontent(jTable1.getModel().getValueAt(a, 2).toString());
                 } catch (IOException ex) {
                     Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    if (evt.getClickCount() == 2) {
                        showoutside();
                    }
                    
            }
        });
        this.jTable2.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent evt) {
                var a= jTable2.getSelectedRow();
                 try {
                     setcontent(jTable2.getModel().getValueAt(a, 2).toString());
                 } catch (IOException ex) {
                     Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
                 }

                    if (evt.getClickCount() == 2) {
                        showoutside();
                    }
                    
            }
        });}
       first=false;
      //  jres.setModel(df);
      //  jList2.setModel(df2);
      //  jList3.setModel(df3);
    }
    public void settable(ArrayList<String> sf){
    String[] columnNames = {"File name",
                        "Size (kb)",
                        "Date of creation",
                        "date of modification"};
    Object[][] data=new Object[columnNames.length][sf.size()];
    JTable table = new JTable(data, columnNames);
   
    }
    public String content;
    boolean pdfv=false;
    public String mypath;
    File ff;
    private void setcontent(String path) throws IOException{
        mypath=path;
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
        this.textlog1.setText(s);
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
        br.close();
        return data;
    }
    
    public LuceneTester lt; 
    public mythread mth;
                                            
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

        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textlog1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textlog = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        textField1 = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("معلومات الملف");

        textlog1.setBackground(new java.awt.Color(80, 153, 255));
        textlog1.setColumns(20);
        textlog1.setForeground(new java.awt.Color(255, 255, 255));
        textlog1.setRows(5);
        textlog1.setText("\n");
        jScrollPane3.setViewportView(textlog1);

        jButton1.setBackground(new java.awt.Color(80, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("عرض الملف");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        jButton2.setBackground(new java.awt.Color(80, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("عودة");
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(80, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("عرض الملفات المكررة");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        textlog.setBackground(new java.awt.Color(80, 153, 255));
        textlog.setColumns(20);
        textlog.setForeground(new java.awt.Color(255, 255, 255));
        textlog.setRows(5);
        textlog.setText("\n");
        jScrollPane1.setViewportView(textlog);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("تفاصيل البحث");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "اسم الملف", "نوع الملف", "عنوان الملف"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\tecyo\\Downloads\\aa-removebg-preview.png")); // NOI18N
        jButton4.setText("عبارة البحث");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.setRequestFocusEnabled(false);

        textField1.setBackground(new java.awt.Color(153, 204, 255));
        textField1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        textField1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ملفات وجدت من خلال الاسم");

        jComboBox3.setBackground(new java.awt.Color(153, 204, 255));
        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "لا ترتيب", "الأكبر أولا", "الأصغر أولا", "الأحدث أولا", "الأقدم أولا" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("الترتيب حسب");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "اسم الملف", "نوع الملف", "عنوان الملف"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(657, 657, 657)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(14, 14, 14))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated
    void showoutside(){
    
     File f=new File(mypath);
        try {
            Desktop.getDesktop().open(f);
        } catch (IOException ex) {
            Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        
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
        f.form4=this;
        f.word=lt.searchword;
        f.data=content;
        f.setselections(); 
        f.setVisible(true);
        f.myfile=ff;
        f.setLocationRelativeTo(null);//}
      //  this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        goback();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        repetition rep=new repetition();
        rep.form4=this;
        rep.setLocationRelativeTo(null);
        rep.lt=lt;
        rep.setTitle("الملفات المكررة");
        rep.fill();
        rep.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.textField1.setText(lt.searchword);
    }//GEN-LAST:event_formWindowOpened

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed
     public String readpdfv(File file) throws IOException{
        try ( //File file = new File("D:/example.pdf");
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
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmresult().setVisible(true);
            }
        });
    }
    public void settext(String s){
        textlog.setText(s);
        textlog.select(textlog.getText().length()-2, 0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private java.awt.TextField textField1;
    private javax.swing.JTextArea textlog;
    private javax.swing.JTextArea textlog1;
    // End of variables declaration//GEN-END:variables
}
