import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addWord1 extends JFrame{
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JButton dodajButton;
    private JPanel JPanel1;

    public addWord1() {
        super("Dodaj słowo");
        this.getContentPane().add(this.JPanel1);
        setLocation(333, 333);
        pack();
        setVisible(true);
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList l = new setGetLista().getLista();
                String pl = textPane1.getText();
                String de = textPane2.getText();
                setGetLista.getLista().add(new Lista_slowek(pl,de,0,0));
            }
        });
    }
}
