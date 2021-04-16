import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;

public class GUI extends JFrame{
    private JTextArea txt_pl;
    private JTextArea txt_de;
    private JButton btn_wiem;
    private JButton btn_odp;
    private JButton btn_niewiem;
    private JLabel lbl_wiem;
    private JLabel lbl_niewiem;
    private JPanel JPanel1;
    private JMenuBar menuBar1;
    private JMenuItem jmi_save;
    private JMenuItem jmi_dodaj;

    int wiersz=0;
    public Lista_slowek y;
    readFile readfile = new readFile();
    public GUI() {
        super("Flashcards - memorizer");
        this.getContentPane().add(this.JPanel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(250, 250);
        pack();
        setVisible(true);

        readfile.read();
        Collections.sort(readfile.Lista);
        y = (Lista_slowek) readfile.Lista.get(wiersz);
        txt_pl.setText(y.getS_pl());
        lbl_wiem.setText(String.valueOf(y.getKnow()));
        lbl_niewiem.setText(String.valueOf(y.getD_know()));

        btn_wiem.addActionListener(e -> wiem());
        btn_odp.addActionListener(e -> txt_de.setText(y.getS_de()));
        btn_niewiem.addActionListener(e -> nie_wiem());
        readfile.setLista(readfile.Lista);
        jmi_save.addActionListener(e -> {
            PrintWriter zapis = null;
            try {
                zapis = new PrintWriter(setGetPath.getPath());
                for (int i = 0; i<readfile.Lista.size();i++) {
                    y = (Lista_slowek) readfile.Lista.get(i);
                    zapis.println(y.getS_pl() + ";" + y.getS_de() + ";" + y.getKnow() + ";" + y.getD_know());
                    System.out.println(y.getS_pl()+";"+y.getS_de()+";"+y.getKnow()+";"+y.getD_know());
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            assert zapis != null;
            zapis.close();

            for (int i = 0; i<readfile.Lista.size();i++) {
                y=(Lista_slowek) readfile.Lista.get(i);
            }
        });
        jmi_dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addWord1();
            }
        });
    }

            public void wiem() {
                int z =y.getKnow() + 1;
                y.setKnow(z);
                wiersz++;
                y = (Lista_slowek) readfile.Lista.get(wiersz);
                txt_pl.setText(y.getS_pl());
                txt_de.setText("");
                lbl_wiem.setText(String.valueOf(y.getKnow()));
                lbl_niewiem.setText(String.valueOf(y.getD_know()));
            }

            public void nie_wiem() {
                y.setD_know(y.getD_know() + 1);
                wiersz++;
                y = (Lista_slowek) readfile.Lista.get(wiersz);
                txt_pl.setText(y.getS_pl());
                txt_de.setText("");
                lbl_wiem.setText(String.valueOf(y.getKnow()));
                lbl_niewiem.setText(String.valueOf(y.getD_know()));
            }


}