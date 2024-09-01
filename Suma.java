import java.util.ArrayList;

public class Suma extends Operac{

    public Suma(ArrayList<Double> numeros){
        super(numeros);
    }

    @Override
    public ArrayList<Double> calcular(){
        double suma = 0;
        for (int i = 0; i < numeros.size(); i++) {
            suma += numeros.get(i);
        }
        ArrayList<Double> resultado = new ArrayList<>();
        resultado.add(suma);
        return resultado;
    }
}