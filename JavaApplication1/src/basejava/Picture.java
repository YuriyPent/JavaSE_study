package basejava;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Picture extends Frame implements ActionListener {

    private Image img;
    Button exit = new Button("Exit");
    Button pic = new Button("Picture");

    public Picture() {

        setLayout(null);
        add(exit);
        add(pic);
        exit.addActionListener(this);
        pic.addActionListener(this);
        exit.setBounds(150, 90, 100, 20);
        pic.setBounds(150, 120, 100, 20);
        String s = "3.gif";
        img = getToolkit().getImage(s);
        prepareImage(img, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit) {
            System.exit(0);
        } else {
            if (e.getSource() == pic) {
                Graphics g = getGraphics();
                g.drawImage(img, 10, 80, this);
                g.drawLine(10, 200, 200, 200);
                g.setColor(Color.blue);
                g.drawLine(10, 210, 200, 210);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Picture p = new Picture();
        p.resize(580, 630);
        p.setVisible(true);
    }
}