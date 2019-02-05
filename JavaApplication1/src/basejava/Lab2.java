package basejava;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2 extends Applet implements ActionListener {

    Button btnshow = new Button("SHOW");
    Button btnhide = new Button("HIDE");
    String msg = "";

    public void paint(Graphics g) {
        int x, y, xold, yold, step = 10;
        if (msg.equals("show")) {
            xold = 0;
            yold = (int) Math.abs(Math.sin(Math.PI * xold / 180)
                    * (getSize().height - 100));
            while (xold < 399) {
                x = xold + step;
                y = (int) Math.abs(Math.sin(Math.PI * xold / 180)
                        * (getSize().height - 100));
                g.drawLine(xold, yold, x, y);
                xold = x;
                yold = y;
            }
        }
    }

    public void graph(String msg1) {
        Graphics g = getGraphics();
        if (msg1.equals("show")) {
            repaint();
        } else {
            if (msg1.equals("hide")) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getSize().width, getSize().height);
            }
            showStatus(msg1);
        }
    }

    public void init() {
        setLayout(null);
        add(btnhide);
        add(btnshow);
        btnhide.setBounds(10, 40, 40, 20);
        btnshow.setBounds(10, 10, 40, 20);
        btnhide.addActionListener(this);
        btnshow.addActionListener(this);
        setBackground(Color.yellow);
    }

    @Override
    public void actionPerformed(ActionEvent a_e) {

        if (a_e.getSource() == btnshow) {
            msg = "show";
            graph(msg);
        } else {
            if (a_e.getSource() == btnhide) {
                msg = "hide";
                graph(msg);
            }
        }
    }
}
