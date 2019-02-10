package basejava.applet;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class Forma extends JFrame implements ActionListener, MouseListener {

    JButton exit = new JButton("Exit");
    JPopupMenu menu = new JPopupMenu("Pop");//Всплывающее меню
    JMenuItem it1 = new JMenuItem("Show");
    JMenuItem it2 = new JMenuItem("Quit");

    Forma() {

        setLayout(null);
        add(exit);
        addMouseListener(this);

        add(menu);
        menu.add(it1);
        menu.add(it2);
        it1.addActionListener(this);
        it2.addActionListener(this);

        enableEvents(AWTEvent.MOUSE_EVENT_MASK);//Активизация событий от мыши
        exit.addActionListener(this);
        exit.setBounds(10, 20, 100, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else {
            if (e.getSource() == it2) {
                setBackground(Color.yellow);
                Framemenu fr = new Framemenu();
                fr.setSize(300, 300);
                fr.setVisible(true);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
            menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        Forma f = new Forma();
        f.setSize(400, 400);
        f.setBackground(new Color(100, 60, 120));
        f.setVisible(true);
    }
}
