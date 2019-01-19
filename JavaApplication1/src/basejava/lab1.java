package basejava;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Book {

    String title;
    int price;

    Book(String title, int price) {
        this.price = price;
        this.title = title;
    }
}

public class lab1 extends Frame implements ActionListener {

    Book book;
    Button b1 = new Button("Exit");
    Button b2 = new Button("Create object");
    Button b3 = new Button("Show object");

    public lab1() throws HeadlessException {
        setLayout(null);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.setBounds(200, 50, 100, 20);
        b2.setBounds(200, 80, 100, 20);
        b3.setBounds(200, 110, 100, 20);
        setBackground(new Color(120, 200, 120));
    }

    public String showTitle(Book z) {
        return z.title;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.exit(0);
        } else {
            if (e.getSource() == b2) {
                if (book == null) {
//                    String s = "Pinoccio";
//                    int z = 200;
                    book = new Book("Pinoccio", 200);
                } else {
                    System.out.println("The object already exists");
                }
            } else {
                if (e.getSource() == b3) {
                    if (book != null) {
                        Graphics g = getGraphics();
                        g.drawString(this.showTitle(book), 200, 200);
//                        this.setForeground(new Color(250,0,0));
//                        Font fnt = new Font("Courier", Font.BOLD, 24);
//                        g.setFont(fnt);
//                        setForeground(new Color(250, 0, 0));

//                        g.drawString(book.title.toUpperCase(), 200, 200);
                    }
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        lab1 f = new lab1();
        f.resize(500, 500);
        f.setVisible(true);
    }

}
