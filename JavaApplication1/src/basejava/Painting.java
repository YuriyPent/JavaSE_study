package basejava;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painting extends Frame implements ActionListener {

    private String s;
    Button print = new Button("Print");
    Button clear = new Button("Clear");
    Button exit = new Button("Exit");

    public Painting() throws HeadlessException {

        setLayout(null);//размещение элементов выполнить вручную
        s = "Hello From frame!";
        add(print);
        add(clear);
        add(exit);
        print.addActionListener(this);
        clear.addActionListener(this);;
        exit.addActionListener(this);
        print.setBounds(150, 90, 100, 20);
        clear.setBounds(150, 120, 100, 20);
        exit.setBounds(150, 150, 100, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e)//Обработчик событий от кнопок 
    {
        if (e.getSource() == exit) {
            System.exit(0);
        } else {
            if (e.getSource() == print) {
                Graphics z = getGraphics();
                z.drawString(s, 150, 200);
            } else {
                if (e.getSource() == clear) {
                    Graphics z = getGraphics();
                    z.clearRect(8, 110, 110, 35);//Очистка и заливка цветом
                }
            }
        }
    }

    public static void main(String[] args) {
        Painting pt = new Painting();
        pt.resize(400, 400);
        pt.setBackground(new Color(120, 100, 180));
        pt.show();
    }
}
