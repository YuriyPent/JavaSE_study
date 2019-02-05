package basejava;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class FirstApplet extends Applet{
    
    private String str1;
    private Date date;
    private String str2;
    
    public void init(){
        str1 = "Hello from applet !";
        date = new Date();
        str2 = "Today is: " + date;
    }
    
    public void paint(Graphics g){
        g.drawString(str1, 120, 40);
        g.drawString(str2, 40, 100);
    }

}
