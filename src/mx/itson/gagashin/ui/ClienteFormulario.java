/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mx.itson.gagashin.ui;

import mx.itson.gagashin.entidades.Cliente;
import mx.itson.gagashin.persistencia.ClienteDAO;

import javax.swing.*;

/** Interfaz gráfica para añadir o editar un cliente
 * @author Alan Fernando Romero Hernandez
 * @author Diego Castro Arce
 * */
public class ClienteFormulario extends javax.swing.JDialog {
  /** El id del cliente */
int id = 0;

  /**
   * Inicializa los componentes del formulario
   *
   * @param parent El formulario padre
   * @param modal Indica si el formulario es modal
   * @param id El id del cliente
   */
public ClienteFormulario(java.awt.Frame parent, boolean modal, int id) {
    super(parent, modal);
    this.id = id;
    initComponents();
    cargarFormulario();
  }

  /** Carga el contenido de la tabla */
public void cargarFormulario() {
    if (this.id != 0) {
      Cliente cliente = ClienteDAO.obtenerPorId(id);
      txtNombre.setText(cliente.getNombre());
      txtApellido.setText(cliente.getApellido());
      txtDireccion.setText(cliente.getDireccion());
      txtTelefono.setText(cliente.getTelefono());
      txtEmail.setText(cliente.getEmail());
      txtCredito.setText(cliente.getCredito());
      txtIntereses.setText(cliente.getIntereses());
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    txtNombre = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    txtApellido = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    txtDireccion = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    txtTelefono = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    txtEmail = new javax.swing.JTextField();
    btnGuardar = new javax.swing.JButton();
    jLabel7 = new javax.swing.JLabel();
    txtCredito = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    txtIntereses = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel1.setText("Cliente");

    jLabel2.setText("Nombre:");

    jLabel3.setText("Apellido:");

    jLabel4.setText("Dirección:");

    jLabel5.setText("Teléfono:");

    jLabel6.setText("Email:");

    btnGuardar.setText("Guardar");
    btnGuardar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnGuardarActionPerformed(evt);
          }
        });

    jLabel7.setText("Linea de credito:");

    txtCredito.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyTyped(java.awt.event.KeyEvent evt) {
            txtCreditoKeyTyped(evt);
          }
        });

    jLabel8.setText("Porcentaje fijo de intereses");

    txtIntereses.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyTyped(java.awt.event.KeyEvent evt) {
            txtInteresesKeyTyped(evt);
          }
        });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGap(0, 128, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(127, 127, 127))
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar)
                    .addContainerGap())
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIntereses)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtDireccion)
                            .addComponent(txtTelefono)
                            .addComponent(txtEmail)
                            .addComponent(txtCredito)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtNombre,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtApellido,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtDireccion,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtTelefono,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtEmail,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtCredito,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtIntereses,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnGuardar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void txtCreditoKeyTyped(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_txtCreditoKeyTyped
  } // GEN-LAST:event_txtCreditoKeyTyped

  private void txtInteresesKeyTyped(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_txtInteresesKeyTyped
  } // GEN-LAST:event_txtInteresesKeyTyped

  private void btnGuardarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnGuardarActionPerformed
    String nombre = txtNombre.getText();
    String descripcion = txtApellido.getText();
    String direccion = txtDireccion.getText();
    String telefono = txtTelefono.getText();
    String email = txtEmail.getText();

    String credito = txtCredito.getText();
    String intereses = txtIntereses.getText();
    boolean resultado =
        this.id == 0
            ? ClienteDAO.guardar(
                nombre, descripcion, direccion, telefono, email, credito, intereses)
            : ClienteDAO.editar(
                this.id, nombre, descripcion, direccion, telefono, email, credito, intereses);

    if (resultado) {
      JOptionPane.showMessageDialog(
          this,
          "El registro fue guardado correctamente",
          "REGISTRO GUARDADO",
          JOptionPane.INFORMATION_MESSAGE);
      dispose();
    } else {
      JOptionPane.showMessageDialog(
          this, "Ocurrió un error al guardar el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
      dispose();
    }
  } // GEN-LAST:event_btnGuardarActionPerformed

  /**
   * Método principal de la clase.
   *
   * @param args Los argumentos de la línea de comandos.
   */
public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ClienteFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ClienteFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ClienteFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ClienteFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            ClienteFormulario dialog = new ClienteFormulario(new javax.swing.JFrame(), true, 0);
            dialog.addWindowListener(
                new java.awt.event.WindowAdapter() {
                  @Override
                  public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                  }
                });
            dialog.setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnGuardar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JTextField txtApellido;
  private javax.swing.JTextField txtCredito;
  private javax.swing.JTextField txtDireccion;
  private javax.swing.JTextField txtEmail;
  private javax.swing.JTextField txtIntereses;
  private javax.swing.JTextField txtNombre;
  private javax.swing.JTextField txtTelefono;
  // End of variables declaration//GEN-END:variables
}
