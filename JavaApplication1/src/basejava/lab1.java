package basejava;

import java.awt.*;
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
    Label lb = new Label("Introduction in Java");//добавлено
    TextField tf = new TextField();//добавлено

    public lab1() {
        setLayout(new BorderLayout());//изменено
        add(tf, BorderLayout.SOUTH);//добавлено
        add(b1, BorderLayout.WEST);//изменено
        add(b2, BorderLayout.CENTER);//изменено
        add(b3, BorderLayout.EAST);//изменено
        add(lb, BorderLayout.NORTH);//добавлено
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
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
                    book = new Book("Pinoccio", 200);
                } else {
                    System.out.println("The object already exists");
                }
            } else {
                if (e.getSource() == b3) {
                    if (book != null) {
                        tf.setText(book.title.toUpperCase());//добавлено
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
