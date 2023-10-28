/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfas;

import com.mycompany.tallerpoo.Triage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase representa la interfaz de usuario para realizar una operación
 * específica en el centro médico.
 * Proporciona la funcionalidad para buscar y mostrar la cantidad de triajes por
 * categoría (rojo, naranja, amarillo, verde, azul) en un rango de fechas.
 * 
 * @author Santi
 */
public class Op5GestorCentro extends javax.swing.JFrame {

    public static String triageUpdate;
    DefaultTableModel tabla = new DefaultTableModel();

     /**
     * Constructor de la clase Op5GestorCentro. Inicializa la interfaz gráfica de usuario.
     */
    public Op5GestorCentro() {
        initComponents();
        String[] titulo = new String[]{"Triages"};
        tabla.setColumnIdentifiers(titulo);
        tablaTriage.setModel(tabla);
        tablaTriage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tablaTriage.rowAtPoint(e.getPoint());
                int columna = 2;
                if (fila > -1) {
                    triageUpdate = (String) tablaTriage.getValueAt(fila, columna);
                }
            }
        }
        );
    }

    /**
     * Realiza una búsqueda y muestra la cantidad de triajes por categoría 
     * en la tabla.
     *
     * @param fecha Fecha de inicio del rango.
     * @param fecha2 Fecha de fin del rango.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    private void llamar(LocalDate fecha, LocalDate fecha2) throws Exception {
        ArrayList<Integer> triage = Triage.cantTriagePorFecha(fecha, fecha2);
        try {
            agregar(triage);
        } catch (Exception e) {
        }

    }

     /**
     * Agrega los resultados de la búsqueda a la tabla.
     *
     * @param lista Lista de cantidades de triajes por categoría.
     */
    private void agregar(ArrayList<Integer> lista) {
        try {
            if (lista.size() > 0) {
                String[] fila = new String[lista.size()]; // Crear un arreglo de objetos para la fila
                // Agregar los elementos a la fila
                fila[0] = "Cantidad rojos: " + lista.get(0);
                tabla.addRow(fila);
                fila[0] = "Cantidad naranjas: " + lista.get(1);
                tabla.addRow(fila);
                fila[0] = "Cantidad amarillos: " + lista.get(2);
                tabla.addRow(fila);
                fila[0] = "Cantidad verdes: " + lista.get(3);
                tabla.addRow(fila);
                fila[0] = "Cantidad azules: " + lista.get(4);
                tabla.addRow(fila);
            }

            // Agregar la fila a la tabla
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        fecha1 = new javax.swing.JTextField();
        fecha2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTriage = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anterior.setText("<< Atrás");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese la primera fecha");

        jLabel2.setText("Ingrese la segunda fecha");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        fecha1.setText("aaaa/mm/dd");

        fecha2.setText("aaaa/mm/dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fecha1)
                    .addComponent(anterior)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(buscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablaTriage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Lista de Triages"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTriage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento cuando se hace clic en el botón "Atrás".
     * Muestra la ventana anterior y cierra la actual.
     *
     * @param evt El evento de acción.
     */
    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        MenuGestorCentro atras = new MenuGestorCentro();
        atras.setVisible(true);
        atras.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_anteriorActionPerformed

    /**
     * Maneja el evento cuando se hace clic en el botón "Buscar". Realiza una
     * búsqueda en función de las fechas ingresadas y muestra los triages 
     * realizados en ese período.
     */
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String fechaUno = fecha1.getText();
        String fechaDos = fecha2.getText();
        if (validarFormatoFecha(fechaUno) && validarFormatoFecha(fechaDos)) {
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate primeraFecha = LocalDate.parse(fechaUno, formatter1);
            LocalDate segundaFecha = LocalDate.parse(fechaDos, formatter1);
            try {
                llamar(primeraFecha, segundaFecha);
            } catch (Exception ex) {
                Logger.getLogger(Op5GestorCentro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Las fechas no cumplen con el formato esperado, mostrar un mensaje de error.
            JOptionPane.showMessageDialog(this,
                    "Formato de fecha incorrecto. Utiliza yyyy/MM/dd.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_buscarActionPerformed

    /**
     * Valida el formato de una fecha ingresada.
     * @param fecha La fecha a validar.
     * @return `true` si la fecha tiene el formato correcto, `false` en caso contrario.
     */
    private boolean validarFormatoFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField fecha1;
    private javax.swing.JTextField fecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTriage;
    // End of variables declaration//GEN-END:variables
}
