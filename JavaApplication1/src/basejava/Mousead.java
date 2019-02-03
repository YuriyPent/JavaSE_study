package basejava;

import java.awt.*;
import java.awt.event.*;

class Adapter extends MouseAdapter{
    Mousead x;

    Adapter(Mousead x) {
        this.x = x;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x.setBackground(new Color((int)(250*Math.random()),100,100));
    }
    
}
public class Mousead extends Frame{

    public Mousead(){
        Adapter ad = new Adapter(this);
        this.addMouseListener(ad);
    }
    public static void main(String[] args) {
        Mousead nn = new Mousead();
        nn.resize(100, 200);
        nn.show();
    }

}
