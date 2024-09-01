    import java.util.ArrayList;

    public class Resta extends Operac{

        public Resta(ArrayList<Double> numeros){
            super(numeros);
        }

        @Override
        public ArrayList<Double> calcular(){
            double resultado = numeros.get(0);
            for (int i = 1; i < numeros.size(); i++) {
                resultado -= numeros.get(i);
            }
            ArrayList<Double> resultadoLista = new ArrayList<>();
            resultadoLista.add(resultado);
            return resultadoLista;
        }
    }