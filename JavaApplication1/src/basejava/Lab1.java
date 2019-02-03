package basejava;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//class Book {
//
//    String title;
//    int price;
//
//    Book(String title, int price) {
//        this.price = price;
//        this.title = title;
//    }
//}

public class Lab1 extends Frame implements ActionListener, KeyListener {

    Dlgwin dlg;
    Book book;
    Button b1 = new Button("Exit");
    Button b2 = new Button("Create object");
    Button b3 = new Button("Show object");
    Label lb = new Label("Introduction in Java");//добавлено
    TextField tf = new TextField();//добавлено

    public Lab1() {
        setLayout(null);//изменено
        add(tf);
        add(b1);
        add(b2);
        add(b3);
        add(lb);
        addKeyListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        lb.setBounds(200, 60, 200, 20);
        tf.setBounds(150, 250, 200, 20);
        b1.setBounds(200, 90, 100, 20);
        b2.setBounds(200, 120, 100, 20);
        b3.setBounds(200, 150, 100, 20);
        setBackground(new Color(120, 200, 120));
    }

    public String showTitle(Book z) {
        return z.title;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() == 'a') {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.exit(0);
        } else {
            if (e.getSource() == b2) {
                if (book == null) {
                    book = new Book("Pinoccio", 200);
                    dlg = new Dlgwin(book);
                    dlg.setSize(300,300);
                    dlg.setVisible(true);
                } else {
                    System.out.println("The object already exists");
                }
            } else {
                if (e.getSource() == b3) {
                    if (book != null) {
                        Font fnt = new Font("Courier", Font.BOLD, 24);
                        Graphics g = getGraphics();
                        this.setForeground(new Color(250,0,0));
                        g.setFont(fnt);
                        g.drawString(book.title.toUpperCase(), 20, 300);
                        tf.setText(book.title.toUpperCase());
                    }
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Lab1 f = new Lab1();
        f.setForeground(new Color(0, 0, 250));
        f.resize(500, 500);
        f.setVisible(true);
        f.requestFocus();
    }

}
