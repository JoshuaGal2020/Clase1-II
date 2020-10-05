/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.operacionBd;

import com.unab.edu.DAO.ClsEstudiante;
import com.unab.edu.DAO.ClsPersona;
import com.unab.edu.conexionamysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import com.unab.edu.entidades.Persona;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author patty
 */
public class crudEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form crudEstudiante
     */
    public crudEstudiante() {
        initComponents();
        MostrarES();
 //       MostrarP();
        displayMember();
    }
    int contador = 0;
    String valueMember[];

    void displayMember() {
        DefaultComboBoxModel cbdeault = new DefaultComboBoxModel();
        ClsPersona clasePersona = new ClsPersona();
        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
        valueMember = new String[Personas.size()];

        String filas[] = new String[5];
        for (var IterarDatosPersona : Personas) {
            filas[0] = String.valueOf(IterarDatosPersona.getIdpersona());
            filas[1] = IterarDatosPersona.getNombre();
            valueMember[contador] = filas[0];
            cbdeault.addElement(filas[1]);
            contador++;
        }
        cbPersonas.setModel(cbdeault);

    }

    void MostrarES() {
        String Titulos[] = {"ID EST", "MATRICULA", "IDPERSONA", "NOMBRE", "USUARIO", "PASSWORD", "NIE"};
        DefaultTableModel ES = new DefaultTableModel(null, Titulos);
        ClsEstudiante ClsJEstudiante = new ClsEstudiante();
        var MostrarEstudiante = ClsJEstudiante.MostrarEstudiante();
        String filas[] = new String[8];
        for (var iterador : MostrarEstudiante) {
            filas[0] = String.valueOf(iterador.getId());
            filas[1] = String.valueOf(iterador.getMatricula());
            filas[2] = String.valueOf(iterador.getIdpersona());
            filas[3] = iterador.getNombre();
            filas[4] = iterador.getUsu();
            filas[5] = iterador.getPass();
            filas[6] = String.valueOf(iterador.getNie());
            ES.addRow(filas);

        }
        tb_Estudiante.setModel(ES);
    }

////    void MostrarP() {
////        String TITULOS[] = {"ID", "NOMBRE"};
////        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
////        ClsPersona clasePersona = new ClsPersona();
////        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
////        String filas[] = new String[3];
////        for (var IterarDatosPersona : Personas) {
////            filas[0] = String.valueOf(IterarDatosPersona.getIdpersona());
////            filas[1] = IterarDatosPersona.getNombre();
////            ModeloTabla.addRow(filas);
////        }
////        tb_PersonaG.setModel(ModeloTabla);
////    }
    void Limpiar() {
        txtID.setText("");
        txtMatricula.setText("");
//      txtIdPersona.setText("");
        txtUsuario.setText("");
        txtPass.setText("");
        txtNie.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbMostrar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtNie = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnConexion = new javax.swing.JButton();
        cbPersonas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Estudiante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(102, 102, 255));

        tbMostrar.setBackground(new java.awt.Color(51, 204, 255));
        tbMostrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("ID ESTUDIANTE");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("MATRICULA");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("ID PERSONA");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("PASSWORD");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("NIE");

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar Datos");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnConexion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnConexion.setText("Probar Conexion");
        btnConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexionActionPerformed(evt);
            }
        });

        cbPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnGuardar)
                .addGap(61, 61, 61)
                .addComponent(btnEliminar)
                .addGap(57, 57, 57)
                .addComponent(btnActualizar)
                .addGap(58, 58, 58)
                .addComponent(btnConexion)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbPersonas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNie)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(242, 242, 242))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tbMostrar.addTab("Operaciones CRUD", jPanel1);

        tb_Estudiante.setBackground(new java.awt.Color(204, 255, 255));
        tb_Estudiante.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        tb_Estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "null", "Title 7"
            }
        ));
        tb_Estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_EstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Estudiante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );

        tbMostrar.addTab("Mostrar Datos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbMostrar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tbMostrar)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsEstudiante ESTU = new ClsEstudiante();
        Estudiante ES = new Estudiante();
        ES.setMatricula(Integer.parseInt(txtMatricula.getText()));
//      ES.setIdpersona(Integer.parseInt(txtIdPersona.getText()));
        ES.setIdpersona(Integer.parseInt(valueMember[cbPersonas.getSelectedIndex()]));
        ES.setUsu(txtUsuario.getText());
        ES.setPass(txtPass.getText());
        ES.setNie(Integer.parseInt(txtNie.getText()));
        ESTU.AgregarEstudiante(ES);
        Limpiar();
        MostrarES();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tb_EstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_EstudianteMouseClicked
        //MOVILIZACION DE TBPANE
        tbMostrar.setSelectedIndex(tbMostrar.indexOfComponent(jPanel1));
        //OBTENER LA FILA ACTUAL QUE EL USUARIO SELECCIONO
        int fila = tb_Estudiante.getSelectedRow();

        //GEVALUEAT SIRVE PARA CAPTURAR DATOS DE LAS TABLAS
        String ID = String.valueOf(tb_Estudiante.getValueAt(fila, 0));
        String matricula = String.valueOf(tb_Estudiante.getValueAt(fila, 1));
        String IdPersona = String.valueOf(tb_Estudiante.getValueAt(fila, 2));
        String usuario = String.valueOf(tb_Estudiante.getValueAt(fila, 4));
        String pass = String.valueOf(tb_Estudiante.getValueAt(fila, 5));
        String Nie = String.valueOf(tb_Estudiante.getValueAt(fila, 6));

        txtID.setText(ID);
        txtMatricula.setText(matricula);
//      txtIdPersona.setText(IdPersona);
        txtUsuario.setText(usuario);
        txtPass.setText(pass);
        txtNie.setText(Nie);
    }//GEN-LAST:event_tb_EstudianteMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ClsEstudiante estudiante = new ClsEstudiante();
        Estudiante est = new Estudiante();

        est.setId(Integer.parseInt(txtID.getText()));

        estudiante.BorrarEstudiante(est);
        Limpiar();
        MostrarES();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ClsEstudiante estudiante = new ClsEstudiante();
        Estudiante est = new Estudiante();

        est.setId(Integer.parseInt(txtID.getText()));
        est.setMatricula(Integer.parseInt(txtMatricula.getText()));
//        est.setIdpersona(Integer.parseInt(txtIdPersona.getText()));
        est.setUsu(txtUsuario.getText());
        est.setPass(txtPass.getText());
        est.setNie(Integer.parseInt(txtNie.getText()));

        estudiante.ActualizarEstudiante(est);
        Limpiar();
        MostrarES();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexionActionPerformed
        ConexionBd classconectar = new ConexionBd();
        Connection conectar = classconectar.RetornarConexion();
    }//GEN-LAST:event_btnConexionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//     txtIdPersona.setText(valueMember[cbPersonas.getSelectedIndex()]);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConexion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbPersonas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tbMostrar;
    private javax.swing.JTable tb_Estudiante;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNie;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
