import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Calculadora extends JFrame implements ActionListener {

    // Componentes de la interfaz
    private JLabel pantalla;
    private JButton[][] botones = new JButton[3][3];
    private ArrayList<Double> numeros = new ArrayList<>();
    private JButton borrar, deciBina, deciRoma, suma, resta, multiplicacion, division, resultado;
    private String operacionActual = ""; // Para almacenar la operación actual

    private Container contenedor;

    // Constructor
    public Calculadora() {
        super("CALCULADORA");

        // Configuración del contenedor
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        // Creación de la pantalla
        pantalla = new JLabel(" ");
        pantalla.setHorizontalAlignment(JLabel.CENTER);
        pantalla.setFont(new Font("Arial", Font.BOLD, 36)); // Agrandamos el tamaño de la fuente
        contenedor.add(pantalla, BorderLayout.NORTH);

        // Creación de los botones numéricos
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton(String.valueOf(i * 3 + j + 1));
                botones[i][j].addActionListener(this);
                panelBotones.add(botones[i][j]);
            }
        }
        contenedor.add(panelBotones, BorderLayout.CENTER);

        // Creación de los botones de operaciones
        JPanel panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(5, 1));
        suma = new JButton("+");
        suma.addActionListener(this);
        panelOperaciones.add(suma);

        resta = new JButton("-");
        resta.addActionListener(this);
        panelOperaciones.add(resta);

        multiplicacion = new JButton("*");
        multiplicacion.addActionListener(this);
        panelOperaciones.add(multiplicacion);

        division = new JButton("/");
        division.addActionListener(this);
        panelOperaciones.add(division);

        resultado = new JButton("=");
        resultado.addActionListener(this);
        panelOperaciones.add(resultado);

        contenedor.add(panelOperaciones, BorderLayout.EAST);

        JPanel panelFunciones = new JPanel();
        panelFunciones.setLayout(new FlowLayout());
        borrar = new JButton("CE");
        borrar.addActionListener(this);
        panelFunciones.add(borrar);

        deciBina = new JButton("D = B");
        deciBina.addActionListener(this);
        panelFunciones.add(deciBina);

        deciRoma = new JButton("D = R");
        deciRoma.addActionListener(this);
        panelFunciones.add(deciRoma);

        contenedor.add(panelFunciones, BorderLayout.SOUTH);

        Font fuenteBotones = new Font("Arial", Font.BOLD, 18);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setFont(fuenteBotones);
            }
        }
        setSize(340, 350);
        setVisible(true);
        setLocation(200, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
    
        // Si se presiona un número
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (botonPresionado == botones[i][j]) {
                    pantalla.setText(pantalla.getText() + botonPresionado.getText());
                }
            }
        }

        // Si se presiona una operación
        if (botonPresionado == suma || botonPresionado == resta || botonPresionado == multiplicacion || botonPresionado == division || botonPresionado == deciRoma) {
            if (!pantalla.getText().isEmpty()) {
                numeros.add(Double.parseDouble(pantalla.getText()));
                operacionActual = botonPresionado.getText();
                pantalla.setText(" "); // Limpiar la pantalla para el siguiente número
            }
        }
        JOptionPane.showMessageDialog(null, numeros);

        switch (botonPresionado.getText()) {
            case "D = R":
            if (!numeros.isEmpty()) {

                CositasArrayLists obtenerUltimo = new CositasArrayLists(numeros);
                double ultimodato = obtenerUltimo.obtenerUltimoNumero();
                DecimalesRomanos convertir = new DecimalesRomanos();
                String corvertido = convertir.decimalARomano((int) ultimodato);
                pantalla.setText(corvertido);

                JOptionPane.showMessageDialog(null, "Provando dsdwqfzs");
            }

                break;
        
            default:
                break;
        }
        // Si se presiona "=" para obtener el resultado
        if (botonPresionado == resultado) {
            if (!pantalla.getText().isEmpty()) {
                numeros.add(Double.parseDouble(pantalla.getText()));
                Operac operacion = null;

                switch (operacionActual) {
                    case "+":
                        operacion = new Suma(numeros);
                        break;
                    case "-":
                        operacion = new Resta(numeros);
                        break;
                    case "*":
                        operacion = new Multiplicacion(numeros);
                        break;
                    case "/":
                        operacion = new Division(numeros);
                        break;
                }

                if (operacion != null) {
                    double resultadoOperacion = operacion.calcular().get(0);
                    pantalla.setText(String.valueOf(resultadoOperacion));
                    numeros.clear(); // Limpiar lista de números después de la operación
                }
            }
        }

        // Si se presiona "CE" para limpiar la pantalla y la lista de números
        if (botonPresionado == borrar) {
            pantalla.setText(" ");
            numeros.clear();
        }
    }
}
