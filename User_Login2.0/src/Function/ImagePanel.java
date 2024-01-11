/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sahib
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author IBM
 */
public class ImagePanel extends javax.swing.JPanel {
private Image BackGroundimage;


public ImagePanel(){

}

    public Image getImage() {
        return BackGroundimage;
    }

    public void setImage(Image image) {
        this.BackGroundimage = image;
        Dimension size=new Dimension(this.getWidth(),this.getHeight());
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setOpaque(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    @Override
public void paintComponent(Graphics g){
if(this.BackGroundimage!=null){
g.drawImage(BackGroundimage, 0, 0,this.getWidth(),this.getHeight(),null);
}
}
}

