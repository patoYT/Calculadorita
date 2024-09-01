import javax.swing.JOptionPane;

public class prueba {
    public static void main(String[] args) {
        int cositas = 56;
        String cosotas = "";

        DecimalesRomanos prueba = new DecimalesRomanos();

        String cosas= prueba.decimalARomano(cositas);

        JOptionPane.showMessageDialog(null, cosas + " Estoy probando");
    }
}
