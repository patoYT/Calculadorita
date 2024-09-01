import java.util.ArrayList;

class Multiplicacion extends Operac {
    public Multiplicacion(ArrayList<Double> numeros) {
        super(numeros);
    }

    @Override
    public ArrayList<Double> calcular() {
        double producto = 1.0;
        for (int i = 0; i < numeros.size(); i++) {
            producto *= numeros.get(i);
        }
        ArrayList<Double> resultado = new ArrayList<>();
        resultado.add(producto);
        return resultado;
    }
}