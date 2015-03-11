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

public class Link {
    /*private int x=100;
    private int y=100;
    private boolean facingRight = false;
    private boolean facingUp = false;
    private boolean facingLeft = false;
    private boolean facingDown = true;
    */
    private int x = 0;
    private int y =0;
    //Profesor
     private int contador = 0;
     int dir = 0;
     boolean parado = true;
    
    public Image link;
    
     public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
    public Link()
    {
         try {
            link = ImageIO.read((getClass().getResource("/imagenes/link.png")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaAnimacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
         public void dibuja (Graphics2D g2){
         int fila = 0;
         // si no está parado, hace lo que hacía antes
         if (!parado){
            switch (dir){
                case 1: fila = 5; mueve(-3,0);break;  //izquierda
                case 2: fila = 7; mueve(3,0);break;  //derecha
                case 3: fila = 6;mueve(0,-3); break;  //arriba
                case 4: fila = 4;mueve(0,3); break;  //abajo  
            }
            contador++;
         }
         else { // en este caso es que está parado, y tengo que dejar
             // el contador a 0 , y mostrar la fila correspondiente
            switch (dir){
                case 1: fila = 1; break;  //izquierda
                case 2: fila = 3; break;  //derecha
                case 3: fila = 2; break;  //arriba
                case 4: fila = 0; break;  //abajo  
            }
            contador=0;
         }
        g2.drawImage(link,
                   x,  //posición x dentro del buffer
                   y,  //posición y dentro del buffer
                   x+25,  //tamaño en el eje x del frame que quiero pintar
                   y+30,  //tamaño en el eje y del frame que quiero pintar
                   contador*120, //posicion inicial x dentro del SPRITESHEET
                   fila*130, // posicion inicial y dentro del spritesheet
                   contador*120 + 120, //tamaño del tile (ancho)
                   fila*130 + 130, //tamaño del tile (alto)
                   null
                   );
        //else { contador = 0;} // si está parado, reseteo el contador
         if (contador == 9) contador = 0;
     }
         
         public void mueve(int dx, int dy)
         {
             x=x+dx;
             y=y+dy;
             if(x<0) x=0;  
             else if(x>= 600) x= 600;
             if(y<0)y=0; 
             else if(y>= 620) y= 620;
             
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

 /*
    public void derecha(Graphics2D g2, int contador){
          x+=2;
          g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                7*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                7*130 + 130, //tamaño del tile (alto)
                null);
          facingDown = false;
          facingUp= false;
          facingRight= true;
          facingLeft=false;

    }
    public void arriba(Graphics2D g2, int contador){
        y-=2;
          g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                6*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                6*130 + 130, //tamaño del tile (alto)
                null);
          facingDown = false;
          facingUp= true;
          facingRight= false;
          facingLeft=false;          
    }
    public void izquierda(Graphics2D g2, int contador){

       x-=2;   
      g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                5*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                5*130 + 130, //tamaño del tile (alto)
                null);
      facingDown = false;
      facingUp= false;
      facingRight= false;
      facingLeft=true;

    }
    public void abajo(Graphics2D g2, int contador){
          y+=2;
          g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                4*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                4*130 + 130, //tamaño del tile (alto)
                null);
          facingDown = true;
          facingUp= false;
          facingRight= false;
          facingLeft=false;

    }
    public void parado(Graphics2D g2, int contador)           
    {

         if(facingDown){
              g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                0*120, //posicion inicial x dentro del SPRITESHEET
                0*130, // posicion inicial y dentro del spritesheet
                0*120 + 120, //tamaño del tile (ancho)
                0*130 + 130, //tamaño del tile (alto)
                null);
         }else if(facingRight)
         {
                           g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                0*120, //posicion inicial x dentro del SPRITESHEET
                3*130, // posicion inicial y dentro del spritesheet
                0*120 + 120, //tamaño del tile (ancho)
                3*130 + 130, //tamaño del tile (alto)
                null);
         }
         else if(facingLeft)
         {
                           g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                0*120, //posicion inicial x dentro del SPRITESHEET
                1*130, // posicion inicial y dentro del spritesheet
                0*120 + 120, //tamaño del tile (ancho)
                1*130 + 130, //tamaño del tile (alto)
                null);
         }
         else if(facingUp)
         {
                           g2.drawImage(link,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+20,  //tamaño en el eje x del frame que quiero pintar
                y+30,  //tamaño en el eje y del frame que quiero pintar
                0*120, //posicion inicial x dentro del SPRITESHEET
                2*130, // posicion inicial y dentro del spritesheet
                0*120 + 120, //tamaño del tile (ancho)
                2*130 + 130, //tamaño del tile (alto)
                null);
         }
             
    }*/
