/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfas;

import com.mycompany.taller.Triage;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import logica.ColorTriage;

/**
 *
 * @author Alumno
 */
public class PantalllaTriage extends javax.swing.JFrame {
    public PantalllaTriage() {
        initComponents();
        
        
    }

   private void mostrar (JPanel p){
            p.setSize(800, 300);
            p.setLocation(0,0);
        
        }
   
     public void cargar(String algo){
       System.out.println(algo);
       resultado.setText(algo);
   }    
   
   public void pasar(String [] array){
   ColorTriage pase = new ColorTriage();
   pase.color(array);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        respiracion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lesionesGraves = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lesionesLeves = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pulso = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        edad = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        estadoMental = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        resultado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dolorAbdomen = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        sangrado = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        vomitos = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        dolorPecho = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        shock = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        conciencia = new javax.swing.JComboBox<>();
        btnaceptar = new javax.swing.JButton();
        btnCarga = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        fiebre1 = new javax.swing.JComboBox<>();

        jLabel2.setText("Respiracion");

        jLabel6.setText("Pulso");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p.setPreferredSize(new java.awt.Dimension(700, 450));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Triage");

        jLabel3.setText("Respiracion");

        respiracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Moderada", "Grave" }));
        respiracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respiracionActionPerformed(evt);
            }
        });

        jLabel5.setText("Lesiones graves");

        lesionesGraves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No presentes", "Presentes" }));

        jLabel9.setText("Lesiones leves");

        lesionesLeves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No presentes", "Presentes" }));

        jLabel4.setText("Color sugerido");

        jLabel8.setText("Pulso");

        pulso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Anormal" }));
        pulso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsoActionPerformed(evt);
            }
        });

        jLabel7.setText("Edad");

        edad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adulto", "Niño o anciano" }));

        jLabel10.setText("Estado Mental");

        estadoMental.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Leve", "Grave" }));

        jLabel11.setText("Color final");

        jLabel13.setText("Dolor abdominal");

        dolorAbdomen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nopresente", "Moderado", "Severo" }));

        jLabel14.setText("Fiebre");

        sangrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No presente", "Sangrado moderado", "Sangrado intenso" }));
        sangrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sangradoActionPerformed(evt);
            }
        });

        jLabel12.setText("Vomitos");

        vomitos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin vomitos", "Moderado", "Intensos" }));

        jLabel15.setText("Dolor en el pecho o Dificultad para respirar");

        dolorPecho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No presente", "Presente" }));

        jLabel16.setText("Signos de shock");

        shock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No presentes", "Presentes" }));

        jLabel17.setText("Conciencia");

        conciencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conciente y alerta", "Perdidadeconciencia" }));

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btnCarga.setText("Cargar");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });

        jLabel18.setText("Ingrese el motivo del cambio;");

        jTextField4.setText("aaaa/mm/dd");

        jLabel19.setText("Fecha");

        jLabel20.setText("Hora");

        jTextField5.setText("hh:mm");

        jLabel21.setText("Sangrado");

        fiebre1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin fiebre", "Moderada", "Alta" }));
        fiebre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiebre1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(sangrado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pLayout.createSequentialGroup()
                            .addGap(262, 262, 262)
                            .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dolorAbdomen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel1)))
                            .addGap(18, 18, 18)
                            .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(fiebre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52)
                                    .addComponent(jLabel21)))))
                    .addGroup(pLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pLayout.createSequentialGroup()
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lesionesLeves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(estadoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)))
                            .addGroup(pLayout.createSequentialGroup()
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lesionesGraves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(respiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pulso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addGroup(pLayout.createSequentialGroup()
                                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                                                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18))
                                                .addGroup(pLayout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addGap(51, 51, 51)))
                                            .addGroup(pLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(103, 103, 103)))
                                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pLayout.createSequentialGroup()
                                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dolorPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12)
                                                    .addComponent(vomitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14))
                                                .addGap(18, 18, 18)
                                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel17)
                                                    .addComponent(shock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(conciencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel18)
                                            .addGroup(pLayout.createSequentialGroup()
                                                .addComponent(btnaceptar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCarga))
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel9))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(respiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pulso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dolorAbdomen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(fiebre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(jLabel14)
                        .addComponent(jLabel16))
                    .addComponent(sangrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lesionesGraves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dolorPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lesionesLeves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vomitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conciencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel18))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))))
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)))
                    .addGroup(pLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnaceptar)
                        .addComponent(btnCarga)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void respiracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respiracionActionPerformed

    }//GEN-LAST:event_respiracionActionPerformed

    private void pulsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pulsoActionPerformed

    private void sangradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sangradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sangradoActionPerformed

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed

        String res = respiracion.getSelectedItem().toString();
        String pul = pulso.getSelectedItem().toString();
        String dolorAb = dolorAbdomen.getSelectedItem().toString();
        String dolorPe = dolorPecho.getSelectedItem().toString();
        String lesionGrav = lesionesGraves.getSelectedItem().toString();
        String edadd = edad.getSelectedItem().toString();
        String fiebree = sangrado.getSelectedItem().toString();
        String shockk = shock.getSelectedItem().toString();
        String lesionesLev = lesionesLeves.getSelectedItem().toString();
        String estadoMen = estadoMental.getSelectedItem().toString();
        String concienciaa = conciencia.getSelectedItem().toString();
        String vomitoss = vomitos.getSelectedItem().toString();
        String sangra = sangrado.getSelectedItem().toString();
        String [] lista = {res, pul,dolorAb, dolorPe,lesionGrav,edadd,fiebree,
            shockk,lesionesLev,estadoMen,concienciaa,vomitoss,sangra};
        pasar(lista);
        
       
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        
    }//GEN-LAST:event_btnCargaActionPerformed

    private void fiebre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiebre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fiebre1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarga;
    private javax.swing.JButton btnaceptar;
    private javax.swing.JComboBox<String> conciencia;
    private javax.swing.JComboBox<String> dolorAbdomen;
    private javax.swing.JComboBox<String> dolorPecho;
    private javax.swing.JComboBox<String> edad;
    private javax.swing.JComboBox<String> estadoMental;
    private javax.swing.JComboBox<String> fiebre1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JComboBox<String> lesionesGraves;
    private javax.swing.JComboBox<String> lesionesLeves;
    private javax.swing.JPanel p;
    private javax.swing.JComboBox<String> pulso;
    private javax.swing.JComboBox<String> respiracion;
    private javax.swing.JTextField resultado;
    private javax.swing.JComboBox<String> sangrado;
    private javax.swing.JComboBox<String> shock;
    private javax.swing.JComboBox<String> vomitos;
    // End of variables declaration//GEN-END:variables
}
