package basejava.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Student {

    protected String id;
    protected String fname;
    protected String lname;
    protected String group;

    public Student(String id, String fname, String lname, String group) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.group = group;
    }

}

@SuppressWarnings("serial")
public class Lab4 extends Applet implements ActionListener {

    JPanel dat;
    JPanel but;
    Hashtable bd;

    JTextField idfld;
    JTextField fnamefld;
    JTextField lnamefld;
    JTextField groupfld;

    JButton clearbtn;
    JButton addbtn;
    JButton deletebtn;
    JButton searchbtn;

    @Override
    public void init() {
        bd = new Hashtable();
        setLayout(new BorderLayout());
        dat = new JPanel();
        dat.setLayout(new GridLayout(4, 2));
        dat.add(new JLabel("ID"));
        dat.add(idfld = new JTextField());
        dat.add(new JLabel("FirstName"));
        dat.add(fnamefld = new JTextField());
        dat.add(new JLabel("LastName"));
        dat.add(lnamefld = new JTextField());
        dat.add(new JLabel("Group"));
        dat.add(groupfld = new JTextField());
        but = new JPanel();
        but.setLayout(new GridLayout(1, 4));
        but.add(clearbtn = new JButton("Clear"));
        but.add(addbtn = new JButton("Add"));
        but.add(searchbtn = new JButton("Search"));
        but.add(deletebtn = new JButton("Delete"));
        add("Center", dat);
        add("South", but);
        clearbtn.addActionListener(this);
        addbtn.addActionListener(this);
        searchbtn.addActionListener(this);
        deletebtn.addActionListener(this);
    }

    public void clearFields() {
        idfld.setText("");
        fnamefld.setText("");
        lnamefld.setText("");
        groupfld.setText("");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == clearbtn) {
            clearFields();
        } else if (source == addbtn) {
            String id = idfld.getText();
            if (id != null) {
                Student st = new Student(id, fnamefld.getText(), lnamefld.getText(), groupfld.getText());
                bd.put(id, st);
            } else {
                showStatus("Need an ID");
            }
        } else if (source == deletebtn) {
            String id = idfld.getText();
            if (bd.remove(id) != null) {
                clearFields();
                showStatus("Deleted");
            }

        } else if (source == searchbtn) {
            String id = idfld.getText();
            Object ob = bd.get(id);
            if (ob != null) {
                fnamefld.setText(((Student) ob).fname);
                fnamefld.setText(((Student) ob).lname);
                fnamefld.setText(((Student) ob).group);
                idfld.setText(id);
            } else {
                showStatus("ID not found");
            }
        }
    }
}
