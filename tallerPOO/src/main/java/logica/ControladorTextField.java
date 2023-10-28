
package logica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Validar JTextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(20);

        // Agregar un ActionListener al JTextField
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField.getText();
                if (esTextoValido(texto)) {
                    // Hacer algo con el texto válido
                    JOptionPane.showMessageDialog(null, "Texto válido: " + texto);
                } else {
                    JOptionPane.showMessageDialog(null, "El texto no es válido");
                }
            }
        });

        frame.add(textField);
        frame.pack();
        frame.setVisible(true);
    }

    // Función para validar si es texto
    public static boolean esTextoValido(String valor) {
        return valor.matches("[a-zA-Z ]*");
    }
}