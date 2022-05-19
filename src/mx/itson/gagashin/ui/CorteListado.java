/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.gagashin.ui;

import mx.itson.gagashin.entidades.Movimiento;
import mx.itson.gagashin.persistencia.ClienteDAO;
import mx.itson.gagashin.persistencia.MovimientoDAO;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Interfaz gráfica para el listado de movimientos
 *
 * @author Alan Fernando Romero Hernandez
 * @author Diego Castro Arce
 */
public class CorteListado extends javax.swing.JFrame {

  /** Numero del mes del periodo de corte */
  int periodo = 1;

  /** El id del cliente */
  int idCliente = 0;

  /**
   * Inicializa los componentes de la interfaz
   *
   * @param idCliente El id del cliente
   */
  public CorteListado(int idCliente) {
    this.idCliente = idCliente;

    initComponents();
  }

  /** Actualiza los datos de la tabla */
  public void cargar() {
    List<Movimiento> list = MovimientoDAO.obtenerPorFecha(periodo, idCliente);
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
    float fila = 0;
    float totalbruto = 0;
    float abono = 0;
    float totalAbono = 0;

    for (int i = 0; i < tblMovimientos.getRowCount(); i++) {
      fila = Float.parseFloat(tblMovimientos.getValueAt(i, 4).toString());
      totalbruto += fila;
      if (tblMovimientos.getValueAt(i, 3).toString().equals("Abono")) {
        abono = Float.parseFloat(tblMovimientos.getValueAt(i, 4).toString());
        totalAbono += abono;
      }
    }

    float total = totalbruto - totalAbono;

    lblTotal.setText(String.valueOf(total - totalAbono));
    lblPromedio.setText(String.valueOf((total - totalAbono) / 30));
    lblIntereses.setText(
        String.valueOf(
            (total - totalAbono) + ((total - totalAbono) / ClienteDAO.intereses(idCliente))));
    lblTasaInteres.setText(String.valueOf((total - totalAbono) / ClienteDAO.intereses(idCliente)));
    lblAbono.setText(String.valueOf(totalAbono));
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
    jLabel1 = new javax.swing.JLabel();
    btnPeriodo = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblMovimientos = new javax.swing.JTable();
    btnRegresar = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    lblTotal = new javax.swing.JLabel();
    lblIntereses = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    lblPromedio = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    lblTasaInteres = new javax.swing.JLabel();
    filler1 =
        new javax.swing.Box.Filler(
            new java.awt.Dimension(0, 100),
            new java.awt.Dimension(0, 100),
            new java.awt.Dimension(32767, 100));
    jLabel5 = new javax.swing.JLabel();
    lblAbono = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(900, 500));
    setResizable(false);
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

    jLabel1.setText("Estado de cuenta");

    btnPeriodo.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {
              "Enero",
              "Febrero",
              "Marzo",
              "Abril",
              "Mayo",
              "Junio",
              "Julio",
              "Agosto",
              "Septiembre",
              "Octubre",
              "Noviembre",
              "Diciembre"
            }));
    btnPeriodo.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPeriodoActionPerformed(evt);
          }
        });

    tblMovimientos.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null},
              {null, null, null, null, null, null}
            },
            new String[] {"ID", "ID Cuenta", "Concepto", "Tipo", "Monto", "Fecha"}));
    tblMovimientos.setMinimumSize(new java.awt.Dimension(886, 260));
    tblMovimientos.setPreferredSize(new java.awt.Dimension(886, 260));
    jScrollPane1.setViewportView(tblMovimientos);

    btnRegresar.setText("Regresar");
    btnRegresar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRegresarActionPerformed(evt);
          }
        });

    jLabel2.setText("Total bruto:");

    jLabel3.setText("Total más intereses:");

    lblTotal.setText("jLabel4");

    lblIntereses.setText("jLabel5");

    jLabel6.setText("Gasto promedio diario:");

    lblPromedio.setText("jLabel7");

    jLabel4.setText("Total de intereses generado:");

    lblTasaInteres.setText("jLabel5");

    jLabel5.setText("Total abonado a la cuenta:");

    lblAbono.setText("jLabel7");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addContainerGap(
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addComponent(jLabel1)
                                                    .addGap(129, 129, 129))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(
                                                        btnPeriodo,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        199,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))
                                    .addComponent(imgLogo))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1)
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(jLabel3)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(lblIntereses)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED,
                                                                        68,
                                                                        Short.MAX_VALUE)
                                                                    .addComponent(
                                                                        filler1,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout
                                                                            .DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE))
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(jLabel2)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(lblTotal)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING)
                                                                            .addGroup(
                                                                                layout
                                                                                    .createSequentialGroup()
                                                                                    .addComponent(
                                                                                        jLabel4)
                                                                                    .addPreferredGap(
                                                                                        javax.swing
                                                                                            .LayoutStyle
                                                                                            .ComponentPlacement
                                                                                            .RELATED)
                                                                                    .addComponent(
                                                                                        lblTasaInteres))
                                                                            .addGroup(
                                                                                layout
                                                                                    .createSequentialGroup()
                                                                                    .addComponent(
                                                                                        jLabel6)
                                                                                    .addPreferredGap(
                                                                                        javax.swing
                                                                                            .LayoutStyle
                                                                                            .ComponentPlacement
                                                                                            .RELATED)
                                                                                    .addComponent(
                                                                                        lblPromedio)
                                                                                    .addGap(
                                                                                        131, 131,
                                                                                        131)
                                                                                    .addComponent(
                                                                                        jLabel5)
                                                                                    .addPreferredGap(
                                                                                        javax.swing
                                                                                            .LayoutStyle
                                                                                            .ComponentPlacement
                                                                                            .RELATED)
                                                                                    .addComponent(
                                                                                        lblAbono)))
                                                                    .addGap(0, 62, Short.MAX_VALUE))
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING,
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                                    .addComponent(btnRegresar)))))))
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
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(
                                btnPeriodo,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(imgLogo)))
                    .addGap(18, 18, 18)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        300,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(
                                        filler1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(lblTotal)
                                            .addComponent(jLabel6)
                                            .addComponent(lblPromedio)
                                            .addComponent(jLabel5)
                                            .addComponent(lblAbono))
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .BASELINE)
                                                            .addComponent(jLabel3)
                                                            .addComponent(lblIntereses)
                                                            .addComponent(jLabel4)
                                                            .addComponent(lblTasaInteres))
                                                    .addContainerGap(
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout
                                                    .createSequentialGroup()
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addComponent(btnRegresar)
                                                    .addGap(29, 29, 29)))))));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnPeriodoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnPeriodoActionPerformed
    String periodo = (String) btnPeriodo.getSelectedItem();
    switch (periodo) {
      case "Enero":
        periodo = "01";
        break;
      case "Febrero":
        periodo = "02";
        break;
      case "Marzo":
        periodo = "03";
        break;
      case "Abril":
        periodo = "04";
        break;
      case "Mayo":
        periodo = "05";
        break;

      case "Junio":
        periodo = "06";
        break;
      case "Julio":
        periodo = "07";
        break;
      case "Agosto":
        periodo = "08";
        break;
      case "Septiembre":
        periodo = "09";
        break;
      case "Octubre":
        periodo = "10";
        break;
      case "Noviembre":
        periodo = "11";
        break;
      case "Diciembre":
        periodo = "12";
        break;
    }
    this.periodo = Integer.parseInt(periodo);
    cargar();
  } // GEN-LAST:event_btnPeriodoActionPerformed

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

  private void btnRegresarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnRegresarActionPerformed
    this.dispose();
  } // GEN-LAST:event_btnRegresarActionPerformed

  /**
   * Método principal de la interfaz.
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
      java.util.logging.Logger.getLogger(CorteListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(CorteListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(CorteListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(CorteListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new CorteListado(0).setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> btnPeriodo;
  private javax.swing.JButton btnRegresar;
  private javax.swing.Box.Filler filler1;
  private javax.swing.JButton imgLogo;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblAbono;
  private javax.swing.JLabel lblIntereses;
  private javax.swing.JLabel lblPromedio;
  private javax.swing.JLabel lblTasaInteres;
  private javax.swing.JLabel lblTotal;
  private javax.swing.JTable tblMovimientos;
  // End of variables declaration//GEN-END:variables
}
