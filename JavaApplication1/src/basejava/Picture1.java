package basejava;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;


@SuppressWarnings("serial")
public class Picture1 extends Frame implements ActionListener {

    Button exit = new Button("Exit");
    private final Ellipse2D.Double circle = new Ellipse2D.Double(20, 30, 100, 100);

    @SuppressWarnings("deprecation")
    Picture1() {
        resize(300, 300);
        setBackground(Color.yellow);
    }

    @Override
    public void paint(Graphics g) {
        //преобразовать к классу Graphics2D переменную Graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(
                new GradientPaint(0, 0, Color.red, 110, 110, Color.green, true));
        g2.fill(circle);
        g2.setPaint(Color.black);
        g2.drawString("JAVA+", 55, 80);
        add(exit);
        exit.setBounds(20, 140, 100, 20);
        exit.addActionListener(this);
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Picture1 p = new Picture1();
        p.resize(150, 180);
        p.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
