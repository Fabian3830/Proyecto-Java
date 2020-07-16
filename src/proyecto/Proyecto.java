package proyecto;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Proyecto {
        public static String stringueadorF(float d) {
        String a = d + "";
        return a;
    }

    public static String stringueadorI(int d) {
        String a = d + "";
        return a;
    }
    public static int deme(String msj) {
       String q = JOptionPane.showInputDialog(msj);
        int a = Integer.parseInt(q);
         return a;
    }

    public static float transf(String g) {
        float a = Float.parseFloat(g);
        return a;
    }

    public static int transi(String g) {
        int a = Integer.parseInt(g);
        return a;
    }
    
    public static void main(String[] args) throws IOException {
        Menu menu=new Menu();
        menu.setVisible(true);
 
     
}
}
