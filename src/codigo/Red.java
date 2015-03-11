/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class Red {
    private int x=300;
    private int y=300;
    private boolean facingRight = false;
    private boolean facingUp = false;
    private boolean facingLeft = false;
    private boolean facingDown = true;
    public Image red;
    
    public Red()
    {
         try {
            red = ImageIO.read((getClass().getResource("/imagenes/trainerRed.png")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaAnimacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void derecha(Graphics2D g2, int contador){
          x+=2;
               g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*31, //posicion inicial x dentro del SPRITESHEET
                2*32, // posicion inicial y dentro del spritesheet
                contador*31 + 31, //tamaño del tile (ancho)
                2*32 + 32, //tamaño del tile (alto)
                null);
          facingDown = false;
          facingUp= false;
          facingRight= true;
          facingLeft=false;

    }
    public void arriba(Graphics2D g2, int contador){
        y-=2;
               g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*31, //posicion inicial x dentro del SPRITESHEET
                3*32, // posicion inicial y dentro del spritesheet
                contador*31 + 31, //tamaño del tile (ancho)
                3*32 + 32, //tamaño del tile (alto)
                null);
          facingDown = false;
          facingUp= true;
          facingRight= false;
          facingLeft=false;          
    }
    public void izquierda(Graphics2D g2, int contador){

       x-=2;   
           g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*31, //posicion inicial x dentro del SPRITESHEET
                1*32, // posicion inicial y dentro del spritesheet
                contador*31 + 31, //tamaño del tile (ancho)
                1*32 + 32, //tamaño del tile (alto)
                null);
      facingDown = false;
      facingUp= false;
      facingRight= false;
      facingLeft=true;

    }
    public void abajo(Graphics2D g2, int contador){
          y+=2;
              g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*31, //posicion inicial x dentro del SPRITESHEET
                0*32, // posicion inicial y dentro del spritesheet
                contador*31 + 31, //tamaño del tile (ancho)
                0*32 + 32, //tamaño del tile (alto)
                null);
          facingDown = true;
          facingUp= false;
          facingRight= false;
          facingLeft=false;

    }
    public void parado(Graphics2D g2)           
    {

         if(facingDown){
              g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                1*31, //posicion inicial x dentro del SPRITESHEET
                0*32, // posicion inicial y dentro del spritesheet
                1*31 + 31, //tamaño del tile (ancho)
                0*32 + 32, //tamaño del tile (alto)
                null);
         }else if(facingRight)
         {
                              g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                1*31, //posicion inicial x dentro del SPRITESHEET
                2*32, // posicion inicial y dentro del spritesheet
                1*31 + 31, //tamaño del tile (ancho)
                2*32 + 32, //tamaño del tile (alto)
                null);
         }
         else if(facingLeft)
         {
                               g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                1*31, //posicion inicial x dentro del SPRITESHEET
                1*32, // posicion inicial y dentro del spritesheet
                1*31 + 31, //tamaño del tile (ancho)
                1*32 + 32, //tamaño del tile (alto)
                null);
         }
         else if(facingUp)
         {
                                g2.drawImage(red,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                1*31, //posicion inicial x dentro del SPRITESHEET
                3*32, // posicion inicial y dentro del spritesheet
                1*31 + 31, //tamaño del tile (ancho)
                3*32 + 32, //tamaño del tile (alto)
                null);
         }
             
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
