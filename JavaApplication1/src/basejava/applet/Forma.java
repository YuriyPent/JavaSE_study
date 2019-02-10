package basejava.applet;

import java.awt.Color;
import java.awt.Event;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Forma extends JFrame implements ActionListener, MouseListener{

    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Operations");
    JMenu m2 = new JMenu("TheEnd");

    public Forma() throws HeadlessException {

        m1.add(new JMenuItem("Show"));
        m2.add(new JMenuItem("Quit"));
        mb.add(m1);
        mb.add(m2);
        setJMenuBar(mb);
        setBackground(new Color(200, 20, 100));
    }

    public boolean action(Event evt, Object ob) {
        String lbl = (String) ob;
        if (lbl.equals("Quit")) {
            System.exit(0);
            return true;
        } else {
            if (lbl.equals("Show")) {
                Framemenu fr = new Framemenu();
                fr.setSize(300, 300);
                fr.setVisible(true);
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Forma f =new Forma();
        f.setSize(400, 400);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
