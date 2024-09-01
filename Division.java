import java.util.ArrayList;

class Division extends Operac {
    public Division(ArrayList<Double> numeros) {
        super(numeros);
    }

    @Override
    public ArrayList<Double> calcular() {
        // Verificación para evitar división por cero
        if (numeros.contains(0.0)) {
            throw new ArithmeticException("División por cero no permitida");
        }

        double cociente = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            cociente /= numeros.get(i);
        }
        ArrayList<Double> resultado = new ArrayList<>();
        resultado.add(cociente);
        return resultado;
    }
}