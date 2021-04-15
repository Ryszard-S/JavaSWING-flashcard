

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
    String[] y;
    public ArrayList Lista = new ArrayList<>();

    public ArrayList getLista() {
        return Lista;
    }

    public void setLista(ArrayList Lista) {
        this.Lista = Lista;
    }
    Lista_slowek l;
    public void read() {
        Scanner file = null;
        try {
            file = new Scanner(new File(setGetPath.getPath()),StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        while(file.hasNext()) {
            String x = file.nextLine();
            y = x.split(";");
            String q1 = y[0];
            String q2 = y[1];
            Integer q3 = Integer.parseInt(y[2]);
            Integer q4 = Integer.parseInt(y[3]);
            l= new Lista_slowek(q1,q2,q3,q4);
            Lista.add(l);
    }
        file.close();
        setLista(Lista);
    }
}
