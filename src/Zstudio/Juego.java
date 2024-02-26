package Zstudio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Juego extends JPanel {

    Laberinto laberinto=new Laberinto();
    Personaje personaje=new Personaje();
    public static int nivel=1;

    public Juego() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPresinada(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setFocusable(true);
    }

    public void paint(Graphics grafico){
        laberinto.paint(grafico);
        personaje.paint(grafico);
    }

    public static int cambiaNivel(){
        return nivel++;
    }

    public static int obtieneNivel(){
        return nivel;
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "¿Estas listo?");
        JFrame miVentana = new JFrame("Laberinto");
        Juego game = new Juego();
        miVentana.add(game);
        miVentana.setSize(920, 540);
        miVentana.setLocation(300, 200);
        miVentana.setVisible(true);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            miVentana.repaint();

            if(obtieneNivel()>3){
                JOptionPane.showMessageDialog(null, "Bye Bye");
                System.exit(0);
            }

        }


    }
}
