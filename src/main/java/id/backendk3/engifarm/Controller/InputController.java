package id.backendk3.engifarm.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputController implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed = "+e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released = "+e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Typed = "+e);
    }

}