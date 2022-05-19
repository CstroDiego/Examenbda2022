/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.gagashin.ui;

import mx.itson.gagashin.entidades.Movimiento;
import mx.itson.gagashin.persistencia.MovimientoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Interfaz gráfica que muestra una tabla con los movimientos de una cuenta.
 *
 * @author Alan Fernando Romero Hernandez
 * @author Diego Casto Arce
 */
public class MovimientosListado extends javax.swing.JFrame {

  /** Identificador de cliente */
  int idCliente = 0;

  /** Inicializa los componentes de la interfaz */
  public MovimientosListado(int id) {
    this.idCliente = id;
    initComponents();
  }

  /** Actualiza los datos de la tabla */
  public void cargar() {
    List<Movimiento> list = MovimientoDAO.obtenerPorId(idCliente);
    DefaultTableModel modelo = (DefaultTableModel) tblMovimientos.getModel();
    modelo.setRowCount(0);
    for (Movimiento movimiento : list) {
      modelo.addRow(
          new Object[] {
            movimiento.getId(),
            movimiento.getIdCliente(),
            movimiento.getConcepto(),
            movimiento.getTipo(),
            movimiento.getMonto(),
            movimiento.getFecha()
          });
    }
  }

  /**
   * Este método se llama desde dentro del constructor para inicializar el formulario. ADVERTENCIA:
   * NO modifique este código. El editor de formularios siempre regenera el contenido de este
   * método.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    imgLogo = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblMovimientos = new javax.swing.JTable();
    btnRegresar = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jMenuBar1 = new javax.swing.JMenuBar();
    btnMovimientos = new javax.swing.JMenu();
    btnAgregarMovimiento = new javax.swing.JMenuItem();
    btnCancelarMovimiento = new javax.swing.JMenuItem();
    btnCuenta = new javax.swing.JMenu();
    btnEstadoCuenta = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(
        new java.awt.event.WindowAdapter() {
          public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
          }
        });

    imgLogo.setIcon(
        new javax.swing.ImageIcon(
            getClass().getResource("/mx/itson/gagashin/assets/Logo (TB).png"))); // NOI18N
    imgLogo.setBorderPainted(false);
    imgLogo.setContentAreaFilled(false);
    imgLogo.setFocusPainted(false);
    imgLogo.setFocusable(false);

    tblMovimientos.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null}
            },
            new String[] {"ID", "ID Cuenta", "Concepto", "Tipo", "Monto", "Fecha"}));
    jScrollPane1.setViewportView(tblMovimientos);

    btnRegresar.setText("Regresar");
    btnRegresar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRegresarActionPerformed(evt);
          }
        });

    jLabel2.setText("Listado de movimientos");

    btnMovimientos.setText("Movimientos");

    btnAgregarMovimiento.setText("Agregar");
    btnAgregarMovimiento.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAgregarMovimientoActionPerformed(evt);
          }
        });
    btnMovimientos.add(btnAgregarMovimiento);

    btnCancelarMovimiento.setText("Cancelar");
    btnCancelarMovimiento.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelarMovimientoActionPerformed(evt);
          }
        });
    btnMovimientos.add(btnCancelarMovimiento);

    jMenuBar1.add(btnMovimientos);

    btnCuenta.setText("Cuenta");

    btnEstadoCuenta.setText("Estado de cuenta");
    btnEstadoCuenta.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEstadoCuentaActionPerformed(evt);
          }
        });
    btnCuenta.add(btnEstadoCuenta);

    jMenuBar1.add(btnCuenta);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                jScrollPane1,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                888,
                                Short.MAX_VALUE)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout
                                                    .createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(113, 113, 113)
                                                    .addComponent(imgLogo))
                                            .addComponent(
                                                btnRegresar,
                                                javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addContainerGap()));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(imgLogo))
                    .addGap(18, 18, 18)
                    .addComponent(
                        jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(btnRegresar)
                    .addContainerGap()));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnRegresarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnRegresarActionPerformed
    this.dispose();
  } // GEN-LAST:event_btnRegresarActionPerformed

  private void btnAgregarMovimientoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnAgregarMovimientoActionPerformed
    MovimientoFormulario movimientoFormulario = new MovimientoFormulario(this, true, 0, idCliente);
    movimientoFormulario.setVisible(true);
    cargar();
  } // GEN-LAST:event_btnAgregarMovimientoActionPerformed

  private void btnCancelarMovimientoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnCancelarMovimientoActionPerformed
    int fila = tblMovimientos.getSelectedRow();
    if (fila >= 0) {
      int idMovimiento = (int) tblMovimientos.getValueAt(fila, 0);
      if (JOptionPane.showConfirmDialog(
              this,
              "¿Está seguro de cancelar el movimiento?",
              "Cancelar movimiento",
              JOptionPane.YES_NO_OPTION)
          == JOptionPane.YES_OPTION) {
        if (MovimientoDAO.eliminar(idMovimiento)) {
          JOptionPane.showMessageDialog(
              this,
              "Movimiento cancelado correctamente",
              "Cancelar movimiento",
              JOptionPane.INFORMATION_MESSAGE);
          cargar();
        } else {
          JOptionPane.showMessageDialog(
              this,
              "No se pudo cancelar el movimiento",
              "Cancelar movimiento",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    } else {
      JOptionPane.showMessageDialog(
          this, "Seleccione un movimiento", "Cancelar movimiento", JOptionPane.ERROR_MESSAGE);
    }
  } // GEN-LAST:event_btnCancelarMovimientoActionPerformed

  private void btnEstadoCuentaActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnEstadoCuentaActionPerformed
    CorteListado corteListado = new CorteListado(idCliente);
    corteListado.setVisible(true);
    cargar();
  } // GEN-LAST:event_btnEstadoCuentaActionPerformed

  private void formWindowOpened(
      java.awt.event.WindowEvent evt) { // GEN-FIRST:event_formWindowOpened
    tblMovimientos.getColumnModel().getColumn(0).setPreferredWidth(0);
    tblMovimientos.getColumnModel().getColumn(0).setMinWidth(0);
    tblMovimientos.getColumnModel().getColumn(0).setMaxWidth(0);
    tblMovimientos.getColumnModel().getColumn(1).setPreferredWidth(0);
    tblMovimientos.getColumnModel().getColumn(1).setMinWidth(0);
    tblMovimientos.getColumnModel().getColumn(1).setMaxWidth(0);

    cargar();
  } // GEN-LAST:event_formWindowOpened

  /**
   * Método principal de la clase.
   *
   * @param args La línea de argumentos de la aplicación.
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
      java.util.logging.Logger.getLogger(MovimientosListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MovimientosListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MovimientosListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MovimientosListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new MovimientosListado(0).setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem btnAgregarMovimiento;
  private javax.swing.JMenuItem btnCancelarMovimiento;
  private javax.swing.JMenu btnCuenta;
  private javax.swing.JMenuItem btnEstadoCuenta;
  private javax.swing.JMenu btnMovimientos;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JButton imgLogo;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblMovimientos;
  // End of variables declaration//GEN-END:variables
}
