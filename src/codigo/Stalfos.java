/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */



public class Stalfos {
    
     private int x = 0;
    private int y =0;
    //Profesor
    private int dir =1;

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
    private int contador = 0, contador2 = 0;//El contador 2 controla el tiempo
    public Image stalfos;
    
    
    
    
    
    private boolean facingRight =true, facingUp = false;
        public Stalfos()
    {
         try {
            stalfos = ImageIO.read((getClass().getResource("/imagenes/stalfos.png")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaAnimacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        public void dibuja (Graphics2D g2){
         int fila = 0;
         // si no está parado, hace lo que hacía antes
 // en este caso es que está parado, y tengo que dejar
             // el contador a 0 , y mostrar la fila correspondiente
            switch (dir){
                case 0: fila = 0; break;  //abajo
                case 1: fila = 1; break;  //izquierda
                case 2: fila = 2; break;  //derecha
                case 3: fila = 3; break;  //arriba
            }
            contador2++;
            if(contador2 ==5 || contador2 == 15|| contador2 == 10)
                contador++;
         
        g2.drawImage(stalfos,
                   x,  //posición x dentro del buffer
                   y,  //posición y dentro del buffer
                   x+20,  //tamaño en el eje x del frame que quiero pintar
                   y+30,  //tamaño en el eje y del frame que quiero pintar
                   contador*67, //posicion inicial x dentro del SPRITESHEET
                   fila*105, // posicion inicial y dentro del spritesheet
                   contador*67 + 67, //tamaño del tile (ancho)
                   fila*105 + 105, //tamaño del tile (alto)
                   null
                   );
        //else { contador = 0;} // si está parado, reseteo el contador
         if (contador2 == 20){ 
             contador = 0; 
             contador2=0;
                     }
        }
        
        public void mueve(int dx, int dy)
         {
             if(dx>x){
                 dir = 2; x+=1;
             }else if(dx<x){ dir = 1; x-=1;}
             //else if(dx==x){dir=dir;x=x;}
             if(dy>y){ y+=1; dir = 0;
             }else if(dy<y){ y-=1; dir= 3;}
             //else if(dy == y){dir=dir; y=y;}
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
