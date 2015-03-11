/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class Disparo {

  private int x;
  private int y;
  private int dir;

  public Image disparo;
    
    public Disparo(int _x,int _y, int _dir)
    {
     try {    
         
        disparo = ImageIO.read((getClass().getResource("/imagenes/flechaZelda.png")));
        
        } catch (IOException ex) {
        }
    x=_x;
    y=_y;
    dir=_dir;
    }
    public void dibuja(Graphics2D g2)
    {
        int fila =0;
        int columna = 0;
        switch (dir){
                case 1: fila = 1; columna =1; x-=8; break;  //arriba
                case 2: fila = 1; columna = 0;x+=8; break;  //abajo
                case 3: fila = 0; columna = 0;y-=8; break;  //derecha
                case 4: fila = 0;columna =1; y+=8; break;  //izquierda
            }
        g2.drawImage(disparo,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+24,  //tamaño en el eje x del frame que quiero pintar
                y+24,  //tamaño en el eje y del frame que quiero pintar
                columna*24, //posicion inicial x dentro del SPRITESHEET
                fila*24, // posicion inicial y dentro del spritesheet
                columna*24 + 24, //tamaño del tile (ancho)
                fila*24 + 24, //tamaño del tile (alto)
                null);
    
    
    }
}
