package basejava.applet;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

class Framemenu extends JFrame {

    JButton ex = new JButton("Return");

    Framemenu() throws HeadlessException {
        add(ex);
        setLayout(null);
        ex.setBounds(20, 40, 100, 20);
        setBackground(new Color(100, 60, 120));
    }

    public void paint(Graphics g) {
        g.drawString("Hello, Deers!", 120, 100);
    }

    public boolean action(Event evt, Object ob) {
        String lb = (String) ob;
        if (lb.equals("Return")) {
            dispose();
        }
        return true;
    }
}
