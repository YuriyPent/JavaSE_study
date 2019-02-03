package basejava;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painting extends Frame implements ActionListener {

    private String s;
    private Canvas cs = new Canvas();
    Button print = new Button("Print");
    Button clear = new Button("Clear");
    Button exit = new Button("Exit");

    Painting() {

        setLayout(null);//размещение элементов выполнить вручную
        s = "Hello From frame!";
        add(print);
        add(clear);
        add(exit);
        add(cs);
        print.addActionListener(this);
        clear.addActionListener(this);;
        exit.addActionListener(this);
        print.setBounds(150, 90, 100, 20);
        clear.setBounds(150, 120, 100, 20);
        exit.setBounds(150, 150, 100, 20);
        cs.setBounds(150, 180, 120, 20);
        cs.setBackground(Color.yellow);
    }

    @Override
    public void actionPerformed(ActionEvent e)//Обработчик событий от кнопок 
    {
        if (e.getSource() == exit) {
            System.exit(0);
        } else {
            if (e.getSource() == print) {
                int x = (int) Math.round((Math.random() * 20 + 10));
                int y = (int) Math.round((Math.random() * 100 + 110));
                cs.move(x, y);
                cs.getGraphics().drawString(s, 10, 10);
            } else {
                if (e.getSource() == clear) {
                    cs.getGraphics().clearRect(0, 0, 170, 135);
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Painting pt = new Painting();
        pt.resize(400, 400);
        pt.setBackground(new Color(120, 100, 180));
        pt.show();
    }
}