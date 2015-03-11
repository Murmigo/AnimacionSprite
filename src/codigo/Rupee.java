/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

 
public class Rupee {
  private Random aleatorio = new Random();
  boolean hayRupia = false;
  private int x = aleatorio.nextInt(600);
  private int y = aleatorio.nextInt(600);

  public Image rupee;
  Clip sonidoRupia;
    
    public Rupee()
    {
     try {      
          sonidoRupia = AudioSystem.getClip();
            sonidoRupia.open(AudioSystem.getAudioInputStream(getClass().getResource("/sonidos/OOT_Get_Rupee.wav")));
            
            rupee = ImageIO.read((getClass().getResource("/imagenes/rupeesEdit.png")));
        } catch (Exception ex) {
        }
    
    }
    public void dibujaRupia(Graphics2D g2){
          g2.drawImage(rupee,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+24,  //tamaño en el eje x del frame que quiero pintar
                y+32,  //tamaño en el eje y del frame que quiero pintar
                0*24, //posicion inicial x dentro del SPRITESHEET
                2*32, // posicion inicial y dentro del spritesheet
                0*24 + 24, //tamaño del tile (ancho)
                2*32 + 32, //tamaño del tile (alto)
                null);
    }
    public void cambiaRupia()
    {
        x = aleatorio.nextInt(600);
        y = aleatorio.nextInt(600);
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
