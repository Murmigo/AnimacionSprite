package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

/**
 *
 * @author Jorge Cisneros
 */
public class VentanaAnimacion extends javax.swing.JFrame {
    //PROFE
//buffer para pintar sobre el jPanel
    BufferedImage buffer = null;
    //ancho y alto de la pantalla
    int anchoPantalla = 700;
    int altoPantalla = 700;
    
    //temporizador para crear la animación
    Timer temporizador = new Timer( 40, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            bucleJuego();
        }
    });

    Link link = new Link();
    Rupee rupia =new Rupee();
    
    ArrayList <Stalfos> listaStalfos = new ArrayList();
    ArrayList <Disparo> listaDisparos = new ArrayList();
    
    
    
    
    
    private Random aleatorio = new Random();
    
    boolean dibujarRupia = true;
    
    Clip sonidoFondo; 
    
    // variable para guardar la direccion
    //si vale 0 => parado
    //si vale 1 => izquierda
    //si vale 2 => derecha
    //si vale 3 => arriba
    //si vale 4 => abajo
    int direccion = 0;
    int cuentaRupias = 0;
    int spawn =0;
    /**
     * Creates new form VentanaAnimacion
     */
    public VentanaAnimacion() {
        initComponents();
        this.setSize(anchoPantalla, altoPantalla);
         try {      
          sonidoFondo = AudioSystem.getClip();
            sonidoFondo.open(AudioSystem.getAudioInputStream(getClass().getResource("/sonidos/lozwrld.mid")));
        } catch (Exception ex) {
        }
        buffer = (BufferedImage) jPanel1.createImage(anchoPantalla, altoPantalla);
        sonidoFondo.loop(1000);
        sonidoFondo.start();
        temporizador.start();
    }
    private void disparar()
    {
        Disparo d= new Disparo(link.getX(),link.getY(), link.getDir());
        listaDisparos.add(d);

    }   
    private void dibujaListaDisparos(Graphics2D g2)
    {
        for(int i=0; i<listaDisparos.size();i++)
        {
            Disparo d = listaDisparos.get(i);
            d.dibuja(g2);
        
        }
    
    }
    private void bucleJuego(){
        //primero apunto al buffer
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //borro la pantalla
        g2.setColor(Color.black);
        g2.fillRect(0, 0, anchoPantalla, altoPantalla);
        
        //Dibujo la rupia
        if(dibujarRupia)
            rupia.dibujaRupia(g2);
        else{
            rupia.hayRupia = false;
            rupia.cambiaRupia();
            dibujarRupia = true;
            rupia.dibujaRupia(g2);
        }
        
        ///////////////////// dibujo a link //////////////
        if(!link.parado)
        link.setDir(direccion);
        link.dibuja(g2);

        spawn++;
        if(spawn%120 ==0)
            creaStalfos();
            dibujaArrayStalfos(g2);
            dibujaListaDisparos(g2);
        
        //creaStalfos(g2, stalfos);
        //movimientoEsqueleto(stalfos);
        
        if(link.getX()>= rupia.getX()-5&& link.getX()<= rupia.getX()+10 && link.getY()>= rupia.getY()-5&&link.getY()<= rupia.getY()+10 && dibujarRupia == true)
        {
           hayColisionRupia();          
        }
    
        /////////////////////////////////////////////////
        //apunto al jPanel y repinto con el nuevo buffer
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer , 0, 0 , null);
    
    }
    private void creaStalfos()
    {      
        Stalfos stalfos = new Stalfos();
        stalfos.setX(aleatorio.nextInt(anchoPantalla));
        stalfos.setY(aleatorio.nextInt(altoPantalla));
        stalfos.setDir(0);
        listaStalfos.add(stalfos);
     
    }
    private void hayColisionRupia(){
         rupia.sonidoRupia.setFramePosition(0);
         rupia.sonidoRupia.stop();
         dibujarRupia=false;
         rupia.sonidoRupia.start();
         rupia.hayRupia =false;   
         cuentaRupias++;
         jLabel1.setText(""+cuentaRupias);
    }
    
    private void movimientoEsqueleto(Stalfos esqueleto)
    {
        int horizontal = link.getX();
        int vertical = link.getY();
        
        esqueleto.mueve(horizontal,vertical);
    }
    
    private void dibujaArrayStalfos(Graphics2D g2)
    {
        for (int i=0; i<listaStalfos.size();i++){
            Stalfos s = listaStalfos.get(i);
            movimientoEsqueleto(s);
            s.dibuja(g2);
        }
    }




////////////////////////////////////////////////////////////////7
    ///////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////77
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////7

//buffer para pintar sobre el jPanel
   /* BufferedImage buffer = null;
    //ancho y alto de la pantalla
    int anchoPantalla = 700;
    int altoPantalla = 700;
    
    //Definimos la clase Link
    Link link = new Link();
    Red rojo = new Red();
    
    
    int opcion = 0;
    int opcionRed =0;
    int cuentaRupias = 0;
    
    
   
    boolean caminandoLink =false;
    boolean caminandoRojo =false;
    
    
    
    Rectangle2D.Double rectanguloLink = new Rectangle2D.Double();
    Rectangle2D.Double rectanguloRupia = new Rectangle2D.Double();
    //temporizador para crear la animación
    Timer temporizador = new Timer( 30, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            bucleJuego();
        }
    });

    
    int contador =0;
    int contadorRed =0;
    */
    /**
     * Creates new form VentanaAnimacion
     */
    /*
    public VentanaAnimacion() {
        initComponents();
       
        this.setSize(anchoPantalla, altoPantalla);
        buffer = (BufferedImage) jPanel1.createImage(anchoPantalla, altoPantalla);
        
        temporizador.start();
    }

    private void bucleJuego(){
        //primero apunto al buffer
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //borro la pantalla
        g2.setColor(Color.white);
        g2.fillRect(0, 0, anchoPantalla, altoPantalla);
        ///////////////////// dibujo a link //////////////
        contador++;
        contadorRed++;
         if(contador ==10)
        {
            contador =0;
        }
         
         if(contadorRed == 3){
             contadorRed=0;
         }
        
         /*   switch(opcionRed){
           case 0:
                rojo.parado(g2); // Si no pulsas tecla
               break;
            case 1:rojo.arriba(g2, contadorRed); // W
                break;
            case 2:rojo.abajo(g2, contadorRed); //S
                break;
            case 3:rojo.izquierda(g2, contadorRed); //A
                break;
            case 4:rojo.derecha(g2, contadorRed); //D
                break;
        }*//*
        switch(opcion){
           case 0:
                link.parado(g2, contador); // Si no pulsas tecla
               break;
            case 1:link.arriba(g2, contador); // W
                break;
            case 2:link.abajo(g2, contador); //S
                break;
            case 3:link.izquierda(g2, contador); //A
                break;
            case 4:link.derecha(g2, contador); //D
                break;
        }


        rectanguloLink.setFrame(link.getX(), link.getY(), link.getX()-100, link.getY()-100);
       
        /////////////////////////////////////////////////
        //apunto al jPanel y repinto con el nuevo buffer
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer , 0, 0 , null);
        
        
    }
    
    private void controlaBotones(java.awt.event.KeyEvent evt)
    {
    if(evt.getKeyCode()==KeyEvent.VK_W)
        {
            caminandoLink =true;
            opcion = 1;
        }
        else if(evt.getKeyCode()==KeyEvent.VK_S)
        {
            caminandoLink =true;
            opcion =2;
        }
        else if(evt.getKeyCode()==KeyEvent.VK_A)
        {
            caminandoLink =true;
            opcion=3;
        }
        else if(evt.getKeyCode()==KeyEvent.VK_D)
        {
            caminandoLink =true;
            opcion=4;
        }
        else
        {
           caminandoLink =false;
            opcion=0;
        }
    
    }
    /*
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 440, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //profe
        switch (evt.getKeyCode()){
            case KeyEvent.VK_A: direccion = 1; link.parado = false; break;
            case KeyEvent.VK_D: direccion = 2; link.parado = false; break;
            case KeyEvent.VK_W: direccion = 3; link.parado = false; break;
            case KeyEvent.VK_S: direccion = 4; link.parado = false; break;
            default: link.parado=true; break;
        }
       
       // controlaBotones(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_SPACE){
            disparar();
            link.parado=true;
        }
        //Profe
        link.parado = true;
    }//GEN-LAST:event_formKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAnimacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
