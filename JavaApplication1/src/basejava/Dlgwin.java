package basejava;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

class Book {

    String title;
    int price;

    Book(String s, int i) {
        this.title = s;
        this.price = i;
    }
}

public class Dlgwin extends Frame implements ActionListener {

    Book bb;
    String param;
    Button bexit = new Button("Exit from dialog");
    Button bread = new Button("ReadFromButton");
    TextField tfl = new TextField();

    public Dlgwin(Book z) throws HeadlessException {

        bb = z;
        param = z.title;
        setLayout(null);
        add(bexit);
        add(bread);
        add(tfl);
        bexit.addActionListener(this);
        bread.addActionListener(this);
        tfl.setBounds(80, 200, 100, 20);
        tfl.setText(param);
        bexit.setBounds(80, 150, 150, 20);
        bread.setBounds(80, 180, 150, 20);
        setBackground(new Color(200, 200, 100));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bexit) {
            bb.title = tfl.getText();
            try {
                FileOutputStream os = new FileOutputStream("d1.dat");
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(bb.title);
                dos.close();
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, "Error " + err);
            }
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, bb.title);
        } else {
            if (e.getSource() == bread) {
                try {
                    FileInputStream is = new FileInputStream("d1.dat");
                    DataInputStream dis = new DataInputStream(is);
                    tfl.setText(dis.readUTF());
                    dis.close();
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(null, "Error " + err);
                }

            }
        }
    }

}
