package cosas;

/*
Tendremos una lista de 10 objetos que se mueven rebotando por las paredes de un
Applet.  Cada objeto llevará una trayectoria diferente.  Los objetos pueden ser
cuadrados, rectángulos, círculos u óvalos de distintos colores.  Cuando, con el
ratón haga click en uno de ellos, este incrementará su velocidad durante 2
segundos y luego volverá a su velocidad original.
 */

import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class cosarara extends Applet implements Runnable{
    public static final int TIEMPO = 10;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    List<Objeto> objetos;
    int tiempoMayorVelocidad = 0;
    boolean timer = false;
    boolean fin = false;
    public static void main(String[] args) {

    }
    //INIT
    public void init(){
        imagen = this.createImage(300,300);
        this.resize(400,400);
        noseve = imagen.getGraphics();

        objetos = new ArrayList<Objeto>();
        for (int i = 0; i < 10; i++) {
            objetos.add(new Objeto((int)(Math.random()* 4)));
            //el tipo sale aleatoriamente, para comprobar que hay de todos los
            //tipos es conveniente lanzar el programa varias veces
        }
    }

    //START
    public void start(){
        animacion = new Thread(this);
        animacion.start(); //llama a run
    }

    public void update(Graphics g){ //lo llama el metodo repaint
        paint(g); //para no borrar
    }

    //PAINT
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 300, 300);

        for (int i = 0; i < objetos.size(); i++) {
            objetos.get(i).dibujar(noseve);
        }

        g.drawImage(imagen, 0, 0, this);
    }

    //RUN
    public void run(){
        do{
            for (int i = 0; i < objetos.size(); i++) {
                objetos.get(i).actualizar();
            }

            if(timer){
                tiempoMayorVelocidad += TIEMPO;
                if(tiempoMayorVelocidad >= 2000){ //2 SEGUUNDOS DE MOVIMIENTO RAPIDO
                    fin = true;
                }
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }

    public boolean mouseDown(Event eve, int x, int y) {
        for (int i = 0; i < objetos.size(); i++) {
            if(objetos.get(i).contains(x, y)){
                objetos.get(i).velx += 8;
                objetos.get(i).vely += 8;
                timer = true;
                if(fin){
                    timer = false;
                    tiempoMayorVelocidad = 0;
                    objetos.get(i).velx -= 8;
                    objetos.get(i).vely -= 8;
                    //pequeño fallo a veces no vuelve a la velocidad
                }

            }
        }
        return true;
    }
}
