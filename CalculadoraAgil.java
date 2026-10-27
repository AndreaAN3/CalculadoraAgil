
package calculadoraagil;

import javax.swing.*;
import java.awt.*;

public class CalculadoraAgil extends JFrame {

    private JTextField numero1;
    private JTextField numero2;
    private JLabel resultado;

    public CalculadoraAgil() {
        setTitle("Calculadora - Actividad 4");
        setSize(520, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        numero1 = new JTextField(12);
        numero2 = new JTextField(12);
        resultado = new JLabel("Resultado: ");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Primer número:"), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        panel.add(numero1, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Segundo número:"), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        panel.add(numero2, c);

        JButton sumar = new JButton("Sumar (+)");
        JButton restar = new JButton("Restar (-)");
        JButton multiplicar = new JButton("Multiplicar (*)");
        JButton dividir = new JButton("Dividir (/)");

        sumar.addActionListener(e -> calcular("+"));
        restar.addActionListener(e -> calcular("-"));
        multiplicar.addActionListener(e -> calcular("*"));
        dividir.addActionListener(e -> calcular("/"));

        JPanel botones = new JPanel(new FlowLayout());
        botones.add(sumar);
        botones.add(restar);
        botones.add(multiplicar);
        botones.add(dividir);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(botones, c);

        c.gridy = 3;
        panel.add(resultado, c);

        add(panel);
    }

    private void calcular(String operacion) {
        try {
            double a = Double.parseDouble(
                numero1.getText().trim()
            );

            double b = Double.parseDouble(
                numero2.getText().trim()
            );

            double r;

            switch (operacion) {
                case "+":
                    r = a + b;
                    break;

                case "-":
                    r = a - b;
                    break;

                case "*":
                    r = a * b;
                    break;

                case "/":
                    if (b == 0) {
                        JOptionPane.showMessageDialog(
                            this,
                            "No se puede dividir entre cero.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }
                    r = a / b;
                    break;

                default:
                    return;
            }

            resultado.setText("Resultado: " + r);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, ingresa dos números válidos.",
                "Datos incorrectos",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraAgil ventana = new CalculadoraAgil();
            ventana.setVisible(true);
        });
    }
}
