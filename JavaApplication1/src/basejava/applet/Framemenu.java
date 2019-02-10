package basejava.applet;

import java.awt.Event;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;

class Framemenu extends JFrame { //Класс вспомогательной формы

    JButton ex = new JButton("Return");

    Framemenu() {
        add(ex);
        setLayout(null);
        ex.setBounds(20, 40, 100, 20);
    }

    public void paint(Graphics g) {
        g.drawString("Hello, Deers!", 120, 100);
    }

    public boolean action(Event evt, Object ob) {
        String lb = (String) ob;
        if (lb.equals("Return")) {
            dispose();//Закрыть и удалить вспомогательную форму
        }
        return true;
    }
}
