package basejava.applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.net.*;

public class Receiver extends Applet {

    private String receivedMsg = "Red";
    private Label label = new Label("zdem", Label.CENTER);
    public Button BtnShow = new Button("HTML-page");
    URL myurl = null;
    String s;

    public void init() {
        setLayout(null);
        add(label);
        add(BtnShow);
        label.setBounds(10, 10, 200, 20);
        BtnShow.setBounds(10, 50, 80, 20);
        showStatus("init is working");
        repaint();
        try {
            s = "Lab3.html";
            myurl = new URL(s);
            label.setText("" + myurl);
        } catch (MalformedURLException e) {
            showStatus("error of url" + e.getMessage());
            label.setText("Badforurl");
        }
    }

    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Button) {
            label.setText("changing url");
            getAppletContext().showDocument(myurl, "_blank");
            return true;
        }
        return false;
    }

    public void paint(Graphics g) {
        g.drawString("Hello", 20, 50);
        if (receivedMsg.equals("Red")) {
            g.setColor(Color.red);
        } else {
            if (receivedMsg.equals("Blue")) {
                g.setColor(Color.blue);
            } else {
                g.setColor(Color.yellow);
                g.fillRect(0, 0, getSize().width, getSize().height);
            }
        }
    }

    public void processRequest(String senderName) {
        label.setText(senderName);
        receivedMsg = senderName;
        repaint();
    }
}
