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
    setGetLista l = new setGetLista();
    public GUI() {
        super("Flashcards - memorizer");
        this.getContentPane().add(this.JPanel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(250, 250);
        pack();
        setVisible(true);

        readfile.read();
        Collections.sort(setGetLista.getLista());
        y = (Lista_slowek) setGetLista.getLista().get(wiersz);
        txt_pl.setText(y.getS_polski());
        lbl_wiem.setText(String.valueOf(y.getWiem()));
        lbl_niewiem.setText(String.valueOf(y.getNie_wiem()));

        btn_wiem.addActionListener(e -> wiem());
        btn_odp.addActionListener(e -> txt_de.setText(y.getS_niemiecki()));
        btn_niewiem.addActionListener(e -> nie_wiem());
        jmi_save.addActionListener(e -> {
            PrintWriter zapis = null;
            try {
                zapis = new PrintWriter(setGetPath.getPath());
                for (int i = 0; i<setGetLista.getLista().size();i++) {
                    y = (Lista_slowek) l.getLista().get(i);
                    zapis.println(y.getS_polski() + ";" + y.getS_niemiecki() + ";" + y.getWiem() + ";" + y.getNie_wiem());
                    //System.out.println(y.getS_polski()+";"+y.getS_niemiecki()+";"+y.getWiem()+";"+y.getNie_wiem());
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            assert zapis != null;
            zapis.close();

            for (int i = 0; i<l.getLista().size();i++) {
                y=(Lista_slowek) l.getLista().get(i);
            }
        });
        jmi_dodaj.addActionListener(e -> new addWord1());
    }

            public void wiem() {
                int z =y.getWiem() + 1;
                y.setWiem(z);
                next();
            }

            public void nie_wiem() {
                y.setNie_wiem(y.getNie_wiem() + 1);
                next();
            }

             public void next(){
                wiersz++;
                y = (Lista_slowek) l.getLista().get(wiersz);
                txt_pl.setText(y.getS_polski());
                txt_de.setText("");
                lbl_wiem.setText(String.valueOf(y.getWiem()));
                lbl_niewiem.setText(String.valueOf(y.getNie_wiem()));

            }


}