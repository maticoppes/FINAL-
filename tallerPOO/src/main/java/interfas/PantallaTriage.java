/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfas;
//hjk
import com.mycompany.tallerpoo.Triage;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import logica.ColorTriage;
import com.mycompany.tallerpoo.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alumno
 */
public class PantallaTriage extends javax.swing.JFrame {

    public static Paciente paci;
    public PantallaTriage(String paciente) {
        initComponents();
        paci= DatosTaller.getPacientes().getPorDni(Integer.parseInt(paciente));
        jLabel22.setText("Triage de " + paci.getNombre());
        
    }
    

   private void mostrar (JPanel p){
            p.setSize(800, 300);
            p.setLocation(0,0);
        
        }
   
   public String pasar(String [] array){
   ColorTriage pase = new ColorTriage();
   String resultado = pase.color(array);
   return resultado;
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        respiracion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lesionesGraves = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lesionesLeves = new javax.swing.JComboBox<>();
        txtColorFinal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pulso = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        edad = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        estadoMental = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtColorSugerido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dolorAbdomen = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        sangrado = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        vomitos = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        shock = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        conciencia = new javax.swing.JComboBox<>();
        btnaceptar = new javax.swing.JButton();
        btnCarga = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtMotivodeCambio = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        dolorPecho = new javax.swing.JComboBox<>();
        volver = new javax.swing.JButton();
        jFiebre = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();

        jLabel2.setText("Respiracion");

        jLabel6.setText("Pulso");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p.setPreferredSize(new java.awt.Dimension(700, 450));

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

        jLabel21.setText("Sangrado");

        dolorPecho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No presente", "Presente" }));
        dolorPecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolorPechoActionPerformed(evt);
            }
        });

        volver.setText("volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jFiebre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin fiebre", "Moderada", "Alta" }));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setText("jLabel22");

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lesionesLeves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtColorSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(estadoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lesionesGraves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(respiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(jLabel12)
                                            .addComponent(vomitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addComponent(jFiebre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(shock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pLayout.createSequentialGroup()
                                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(conciencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel17))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21)
                                                    .addComponent(sangrado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dolorPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel18)
                                    .addGroup(pLayout.createSequentialGroup()
                                        .addComponent(btnaceptar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCarga)
                                        .addGap(32, 32, 32)
                                        .addComponent(volver))
                                    .addComponent(txtMotivodeCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pulso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dolorAbdomen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))))
                    .addComponent(jLabel9)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(32, 32, 32)
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
                    .addComponent(dolorPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addGap(12, 12, 12)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lesionesGraves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFiebre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lesionesLeves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vomitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conciencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sangrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(txtColorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtColorSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMotivodeCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptar)
                    .addComponent(btnCarga)
                    .addComponent(volver))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        String fiebree = jFiebre.getSelectedItem().toString();
        String shockk = shock.getSelectedItem().toString();
        String lesionesLev = lesionesLeves.getSelectedItem().toString();
        String estadoMen = estadoMental.getSelectedItem().toString();
        String concienciaa = conciencia.getSelectedItem().toString();
        String vomitoss = vomitos.getSelectedItem().toString();
        String sangra = sangrado.getSelectedItem().toString();
        
        String lista [] = {res, pul, estadoMen, concienciaa,lesionGrav, edadd, 
            fiebree, vomitoss, dolorAb,shockk, lesionesLev,sangra,dolorPe};
        
        
        txtColorSugerido.setText(pasar(lista));
        
       
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        String colorSugerida=txtColorSugerido.getText();
        String colorfinal=txtColorFinal.getText();
        String motivo=txtMotivodeCambio.getText();
        LocalDate fecha= LocalDate.now();
        LocalTime hora =LocalTime.now();
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
        //String [] listado = {res, pul,dolorAb, dolorPe,lesionGrav,edadd,fiebree,
        //    shockk,lesionesLev,estadoMen,concienciaa,vomitoss,sangra};
        String listado [] = {res, pul, estadoMen, concienciaa,lesionGrav, edadd, 
            fiebree, vomitoss, dolorAb,shockk, lesionesLev,sangra,dolorPe};
        
        ColorTriage objeto = new ColorTriage();
        int [] pasados = objeto.numeros(listado);
        
        //String [] triage = new String[]{res, pul,dolorAb, dolorPe,lesionGrav,edadd,fiebree,
            //shockk,lesionesLev,estadoMen,concienciaa,vomitoss,sangra,colorSugerida, colorfinal, motivo, fecha, hora};
        
        ArrayList<AdmisionDeEmergencia>lista=DatosTaller.getAdmisiones().getAdmisiones();
        AdmisionDeEmergencia encontrado=new AdmisionDeEmergencia();
        for (AdmisionDeEmergencia admis : lista){
            if(paci==admis.getPaciente()){
                encontrado = admis;
            }
        }
        
        BoxDisponibles box = new BoxDisponibles(encontrado);
        box.setVisible(true);
        box.setLocationRelativeTo(null);
        
        Triage triage = new Triage(fecha, hora,pasados[0],pasados[1],pasados[2],pasados[3],pasados[4],pasados[5],pasados[6],pasados[7],pasados[8],pasados[9],pasados[10],pasados[11],pasados[12],colorSugerida,motivo,colorfinal, encontrado);                             
            
        encontrado.setTriage(triage);
        String ubi=(System.getProperty("user.dir") + "/Archivos/Triage.txt");
        DatosTaller.getTriages().agregar(triage);
        DatosTaller.getTriages().agregarArchivo(ubi,triage);
        
        
        String barra = File.separator;
        
        String Ubicacion = System.getProperty("user.dir") + barra + "Archivos"+barra+"EnEsperaPorAtender.txt";
        try {
            DatosTaller.getAdmisiones().eliminarDelArchivoPorDni(Ubicacion, encontrado.getPaciente().getDocumento());
        } catch (IOException ex) {
            System.out.println("error");
        }
    }//GEN-LAST:event_btnCargaActionPerformed

    private void dolorPechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolorPechoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dolorPechoActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        SeleccionPacienteConsulta objeto = new SeleccionPacienteConsulta();
        objeto.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverActionPerformed
    private void agregar(String archivoNombre, Paciente paciente, Box box){
        PrintWriter salida= null;
        try {
            File archivo= new File(archivoNombre);
            salida = new PrintWriter(new FileWriter(archivo, true ));            
                       
            salida.println(paciente.getDocumento()+","+paciente.getNombre()+","+LocalDate.now()+
                    ","+LocalTime.now()+","+paciente.getMotivo()+","+box.getNumero());
            
        } catch (IOException ex) {
            
        }
    }
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
    private javax.swing.JComboBox<String> jFiebre;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> lesionesGraves;
    private javax.swing.JComboBox<String> lesionesLeves;
    private javax.swing.JPanel p;
    private javax.swing.JComboBox<String> pulso;
    private javax.swing.JComboBox<String> respiracion;
    private javax.swing.JComboBox<String> sangrado;
    private javax.swing.JComboBox<String> shock;
    private javax.swing.JTextField txtColorFinal;
    private javax.swing.JTextField txtColorSugerido;
    private javax.swing.JTextField txtMotivodeCambio;
    private javax.swing.JButton volver;
    private javax.swing.JComboBox<String> vomitos;
    // End of variables declaration//GEN-END:variables
}
