package cosas;

import java.awt.*;

public class Objeto extends Rectangle{
    Color color;
    int vely, velx;
    public static final int CUADRADO = 0;
    public static final int OVALO = 1;
    public static final int RECTANGULO = 2;
    public static final int CIRCULO = 3;
    int tipo;
    Color colores[] = {Color.pink, Color.white, Color.red, Color.orange};

    //constructor
    public Objeto(int t){
        super((int)(Math.random()* 250), (int)(Math.random()* 250), 50, 30);
        color = colores[(int)(Math.random()* 4)];
        velx = (int)(Math.random()* 4) + 2;
        vely = (int)(Math.random()* 4) + 2;
        tipo = t;
    }

    public void dibujar(Graphics j){
        switch(tipo){
            case CUADRADO:
                j.setColor(color);
                j.fillRect(x, y, 30, 30);
                break;
            case OVALO:
                j.setColor(color);
                j.fillOval(x, y, width, height);
                break;
            case RECTANGULO:
                j.setColor(color);
                j.fillRect(x, y, width, height);
            case CIRCULO:
                j.setColor(color);
                j.fillOval(x, y, 30, 30);
        }
    }

    public void actualizar(){
        x += velx;
        y += vely;
        if((x < 0) || (x > (300-width))){
            velx = -velx;
        }
        if((y < 0) || (y > (300-height))){
            vely = -vely;
        }
    }
}