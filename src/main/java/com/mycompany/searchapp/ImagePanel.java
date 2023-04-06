package com.mycompany.searchapp;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
    private String impath="pictures\\i1.jpg";
    public ImagePanel(String path) {
       try {     
          impath=path;
          image = ImageIO.read(new File(impath));
       } catch (IOException ex) {
            // handle exception...
       }
    }
    public void setpath(String path){
        impath=path;
        //paintComponent(gm);
    }
   // Graphics gm;
    @Override
    public void paintComponent(Graphics g) {//,Panel f
        super.paintComponent(g);
       // gm=g;
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}