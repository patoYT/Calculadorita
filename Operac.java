import java.util.ArrayList;
public abstract class Operac {
    protected ArrayList<Double> numeros;

    public Operac(ArrayList<Double> numeros) {
        this.numeros = numeros;
    }

    public abstract ArrayList<Double> calcular();
}
