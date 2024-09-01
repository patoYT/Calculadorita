import javax.swing.JOptionPane;
import java.util.ArrayList;
public class CositasArrayLists {
    protected ArrayList<Double> numeros;

    public CositasArrayLists(ArrayList<Double> numeros) {
        this.numeros = numeros;
    }

    public Double obtenerUltimoNumero() {
        if (numeros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        return numeros.get(numeros.size() - 1);
    }
}


