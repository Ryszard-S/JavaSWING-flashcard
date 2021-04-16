import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addWord1 extends JFrame{
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JButton dodajButton;
    private JPanel JPanel1;
    readFile r = new readFile();

    //Don't work !!
    public addWord1() {
        super("Add word");
        this.getContentPane().add(this.JPanel1);
        setLocation(333, 333);
        pack();
        setVisible(true);
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pl = textPane1.getText();
                String de = textPane2.getText();
                ArrayList x = r.getLista();
            }
        });
    }
}
