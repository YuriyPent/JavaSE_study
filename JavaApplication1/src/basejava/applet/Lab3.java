package basejava.applet;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Receiver;
import java.applet.Applet;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;

public class Lab3 extends JFrame implements ActionListener{

    private String msg = "Red";
    private JCheckBoxMenuItem cbg = new JCheckBoxMenuItem();
    private JCheckBox cbRed = new JCheckBox("Red",true);
    private JCheckBox cbBlue = new JCheckBox("Blue",false);
    private JCheckBox  cdYellow = new JCheckBox ("Yellow", false);
    private JButton btn = new JButton("Send Color");
    
    
    
    public void init(){
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
//        setLayout(null);
        add(cbRed);
        add(cbBlue);
        add(cdYellow);
        add(btn);
        btn.setBounds(10, 10, 80, 18);
        cbRed.setBounds(10, 30, 50, 18);
        cbBlue.setBounds(10, 50, 50, 18);
        cdYellow.setBounds(10, 70, 50, 18);
        btn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applet receiver = null;
        String receiverName = "receiverApplet";
//        receiver = getAppletContext().getApplet(receiverName);
//        if (receiver != null) {
//            if (!(receiver instanceof Receiver)) {
//                showStatus("Not an applet we have been looking for");
//            }else{
//                showStatus("OK");
//                ((Receiver)receiver).processRequest(returnValue());
//            }
//        }else{
//            showStatus("Can't find the specified applet");
//        }
    }
    
    public String returnValue(){
//        if (cbRed.getState()) {
//            return "Red";
//        }else{
//            if (cbBlue.getState()) {
//                return "Blue";
//            }else{
//                return "Yellow";
//            }
//        }
return "Yellow";
    }

}
