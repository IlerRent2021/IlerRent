/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ilerrent;

import java.awt.CardLayout;
import java.awt.Color;


/**
 *
 * @author jolug
 */
public class Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Usuario
     */
    Logica logica;
    public Usuario() {
        initComponents();
        logica=new Logica();
        logica.timer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsuario = new javax.swing.JPanel();
        jPanelLayaut = new javax.swing.JPanel();
        jPanelPerfil = new javax.swing.JPanel();
        jLabelFotoUsuario = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jLabelMovil1 = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jPanelReservasActivas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelHistorialReservas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelReservarAhora = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelHerramientas = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelReservasActivasLogo = new javax.swing.JLabel();
        jLabelHistorialReservasLogo = new javax.swing.JLabel();
        jLabelPefilicono = new javax.swing.JLabel();
        jLabelReservarAhora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelUsuario.setBackground(new java.awt.Color(176, 214, 243));

        jPanelLayaut.setLayout(new java.awt.CardLayout());

        jPanelPerfil.setBackground(new java.awt.Color(176, 214, 243));

        jLabelFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad/img/FotoUsuario.png"))); // NOI18N

        jLabelNombre.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNombre.setText("Nombre:");

        jLabelApellidos.setBackground(new java.awt.Color(0, 0, 0));
        jLabelApellidos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelApellidos.setText("Apellidos:");

        jLabelDireccion.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDireccion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDireccion.setText("Direccion:");

        jLabelFechaNacimiento.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelFechaNacimiento.setText("Fecha de nacimiento:");

        jLabelMovil1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMovil1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelMovil1.setText("Movil:");

        jLabelCorreo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCorreo.setText("Correo:");

        jLabelUsuario.setBackground(new java.awt.Color(0, 0, 0));
        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelUsuario.setText("Usuario");

        javax.swing.GroupLayout jPanelPerfilLayout = new javax.swing.GroupLayout(jPanelPerfil);
        jPanelPerfil.setLayout(jPanelPerfilLayout);
        jPanelPerfilLayout.setHorizontalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCorreo)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelApellidos)
                    .addComponent(jLabelDireccion)
                    .addComponent(jLabelFechaNacimiento)
                    .addComponent(jLabelMovil1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPerfilLayout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPerfilLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelUsuario))
                    .addComponent(jLabelFotoUsuario))
                .addGap(347, 347, 347))
        );
        jPanelPerfilLayout.setVerticalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPerfilLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelFotoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsuario)
                .addGap(77, 77, 77)
                .addComponent(jLabelNombre)
                .addGap(18, 18, 18)
                .addComponent(jLabelApellidos)
                .addGap(18, 18, 18)
                .addComponent(jLabelDireccion)
                .addGap(18, 18, 18)
                .addComponent(jLabelFechaNacimiento)
                .addGap(18, 18, 18)
                .addComponent(jLabelMovil1)
                .addGap(18, 18, 18)
                .addComponent(jLabelCorreo)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jPanelLayaut.add(jPanelPerfil, "Perfilicono");

        jPanelReservasActivas.setBackground(new java.awt.Color(176, 214, 243));

        jLabel3.setText("Panel reservas activas");

        javax.swing.GroupLayout jPanelReservasActivasLayout = new javax.swing.GroupLayout(jPanelReservasActivas);
        jPanelReservasActivas.setLayout(jPanelReservasActivasLayout);
        jPanelReservasActivasLayout.setHorizontalGroup(
            jPanelReservasActivasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservasActivasLayout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel3)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanelReservasActivasLayout.setVerticalGroup(
            jPanelReservasActivasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservasActivasLayout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel3)
                .addContainerGap(402, Short.MAX_VALUE))
        );

        jPanelLayaut.add(jPanelReservasActivas, "ReservasActivasLogo");

        jPanelHistorialReservas.setBackground(new java.awt.Color(176, 214, 243));

        jLabel1.setText("Panel historial reservas");

        javax.swing.GroupLayout jPanelHistorialReservasLayout = new javax.swing.GroupLayout(jPanelHistorialReservas);
        jPanelHistorialReservas.setLayout(jPanelHistorialReservasLayout);
        jPanelHistorialReservasLayout.setHorizontalGroup(
            jPanelHistorialReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistorialReservasLayout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel1)
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanelHistorialReservasLayout.setVerticalGroup(
            jPanelHistorialReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistorialReservasLayout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(402, Short.MAX_VALUE))
        );

        jPanelLayaut.add(jPanelHistorialReservas, "HistorialReservasLogo");

        jPanelReservarAhora.setBackground(new java.awt.Color(176, 214, 243));

        jLabel2.setText("Panel de reservar ahora");

        javax.swing.GroupLayout jPanelReservarAhoraLayout = new javax.swing.GroupLayout(jPanelReservarAhora);
        jPanelReservarAhora.setLayout(jPanelReservarAhoraLayout);
        jPanelReservarAhoraLayout.setHorizontalGroup(
            jPanelReservarAhoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservarAhoraLayout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel2)
                .addContainerGap(364, Short.MAX_VALUE))
        );
        jPanelReservarAhoraLayout.setVerticalGroup(
            jPanelReservarAhoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservarAhoraLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel2)
                .addContainerGap(377, Short.MAX_VALUE))
        );

        jPanelLayaut.add(jPanelReservarAhora, "card6");

        jPanelHerramientas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad/img/Logo.png"))); // NOI18N
        jPanelHerramientas.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 11, -1, -1));

        jLabelReservasActivasLogo.setBackground(new java.awt.Color(255, 153, 153));
        jLabelReservasActivasLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad/img/ReservasActivas.png"))); // NOI18N
        jLabelReservasActivasLogo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelReservasActivasLogoMouseMoved(evt);
            }
        });
        jLabelReservasActivasLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelReservasActivasLogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelReservasActivasLogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelReservasActivasLogoMouseExited(evt);
            }
        });
        jPanelHerramientas.add(jLabelReservasActivasLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 194, -1));

        jLabelHistorialReservasLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad/img/HistorialDeReservas.png"))); // NOI18N
        jLabelHistorialReservasLogo.setOpaque(true);
        jLabelHistorialReservasLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHistorialReservasLogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelHistorialReservasLogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelHistorialReservasLogoMouseExited(evt);
            }
        });
        jPanelHerramientas.add(jLabelHistorialReservasLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 194, -1));

        jLabelPefilicono.setBackground(new java.awt.Color(255, 153, 153));
        jLabelPefilicono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad/img/Perfilicono.png"))); // NOI18N
        jLabelPefilicono.setOpaque(true);
        jLabelPefilicono.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelPefiliconoMouseMoved(evt);
            }
        });
        jLabelPefilicono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPefiliconoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPefiliconoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPefiliconoMouseExited(evt);
            }
        });
        jPanelHerramientas.add(jLabelPefilicono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 123, 194, -1));

        jLabelReservarAhora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad/img/ReservarAhora.png"))); // NOI18N
        jLabelReservarAhora.setOpaque(true);
        jLabelReservarAhora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelReservarAhoraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelReservarAhoraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelReservarAhoraMouseExited(evt);
            }
        });
        jPanelHerramientas.add(jLabelReservarAhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 194, -1));

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addComponent(jPanelHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelLayaut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelLayaut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPefiliconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPefiliconoMouseClicked
        // TODO add your handling code here:
    CardLayout card = (CardLayout)jPanelLayaut.getLayout();
    card.show(jPanelLayaut, "Perfilicono");
    }//GEN-LAST:event_jLabelPefiliconoMouseClicked

    private void jLabelReservasActivasLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservasActivasLogoMouseClicked
        // TODO add your handling code here:
    CardLayout card = (CardLayout)jPanelLayaut.getLayout();
    card.show(jPanelLayaut, "ReservasActivasLogo");
    }//GEN-LAST:event_jLabelReservasActivasLogoMouseClicked

    private void jLabelHistorialReservasLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHistorialReservasLogoMouseClicked
        // TODO add your handling code here:
        CardLayout card = (CardLayout)jPanelLayaut.getLayout();
        card.show(jPanelLayaut, "HistorialReservasLogo");
    }//GEN-LAST:event_jLabelHistorialReservasLogoMouseClicked

    private void jLabelReservasActivasLogoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservasActivasLogoMouseMoved
        jLabelReservasActivasLogo.setOpaque(true);
    }//GEN-LAST:event_jLabelReservasActivasLogoMouseMoved

    private void jLabelReservasActivasLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservasActivasLogoMouseEntered
        jLabelReservasActivasLogo.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jLabelReservasActivasLogoMouseEntered

    private void jLabelReservasActivasLogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservasActivasLogoMouseExited
        jLabelReservasActivasLogo.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jLabelReservasActivasLogoMouseExited

    private void jLabelPefiliconoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPefiliconoMouseEntered
        jLabelPefilicono.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jLabelPefiliconoMouseEntered

    private void jLabelHistorialReservasLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHistorialReservasLogoMouseEntered
        jLabelHistorialReservasLogo.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jLabelHistorialReservasLogoMouseEntered

    private void jLabelReservarAhoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservarAhoraMouseEntered
        jLabelReservarAhora.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jLabelReservarAhoraMouseEntered

    private void jLabelPefiliconoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPefiliconoMouseExited
        jLabelPefilicono.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jLabelPefiliconoMouseExited

    private void jLabelHistorialReservasLogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHistorialReservasLogoMouseExited
        jLabelHistorialReservasLogo.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jLabelHistorialReservasLogoMouseExited

    private void jLabelReservarAhoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservarAhoraMouseExited
        jLabelReservarAhora.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jLabelReservarAhoraMouseExited

    private void jLabelPefiliconoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPefiliconoMouseMoved
        // TODO add your handling code here:
        jLabelPefilicono.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jLabelPefiliconoMouseMoved

    private void jLabelReservarAhoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservarAhoraMouseClicked
        // TODO add your handling code here:
        CardLayout card = (CardLayout)jPanelLayaut.getLayout();
        card.show(jPanelLayaut, "ReservarLogo");
    }//GEN-LAST:event_jLabelReservarAhoraMouseClicked

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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelFotoUsuario;
    private javax.swing.JLabel jLabelHistorialReservasLogo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMovil1;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPefilicono;
    private javax.swing.JLabel jLabelReservarAhora;
    private javax.swing.JLabel jLabelReservasActivasLogo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelHerramientas;
    private javax.swing.JPanel jPanelHistorialReservas;
    private javax.swing.JPanel jPanelLayaut;
    private javax.swing.JPanel jPanelPerfil;
    private javax.swing.JPanel jPanelReservarAhora;
    private javax.swing.JPanel jPanelReservasActivas;
    private javax.swing.JPanel jPanelUsuario;
    // End of variables declaration//GEN-END:variables
}
