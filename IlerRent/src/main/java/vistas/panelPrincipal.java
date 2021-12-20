package vistas;


import Conexion.Conexion;
import Logica.Sede;
import Logica.geocodificacion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.LayerGroup;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class panelPrincipal extends javax.swing.JPanel {

    JMapViewer theMap;
    /**
     * Creates new form panelPrincipal
     */
    public panelPrincipal() {
        initComponents();
        theMap = new JMapViewer();
        theMap.setBounds(0, 0, 1040, 1150);
        jPanelMapa.add(theMap);
        setBackground( Color.decode("#b0d6f3") );

        ImageIcon ic1=new ImageIcon("usuario.png");
        jLabelusuario.setIcon(ic1);
        jLabelusuario.setText("");
        ImageIcon ic2=new ImageIcon("login_80010mini.png");
        jLabelSalir.setIcon(ic2);
        jLabelSalir.setText("");
        ImageIcon ic3=new ImageIcon("buscar.png");
        jLabelBuscarInicio.setIcon(ic3);
        jLabelBuscarInicio.setText("");
        jLabelBuscarDestino.setIcon(ic3);
        jLabelBuscarDestino.setText("");
        
        ImageIcon ic4=new ImageIcon("Logo.png");
        jLabellogo.setIcon(ic4);
        jLabellogo.setText("");
//        jPanelFiltros.setBackground( Color.decode("#f2efe9"));
//        jPanelReserva.setBackground();
        
         /*(posición vertical, comienza, termina, donde comienza al iniciar programa)*/

        jSliderPrecio.setInverted(false); //se invierte el relleno del JSlider (desde donde comienza)

        jSliderPrecio.setPaintTicks(true); //las rayitas que marcan los números

        jSliderPrecio.setMajorTickSpacing(25); // de cuanto en cuanto los números en el slider

        jSliderPrecio.setMinorTickSpacing(5); //las rayitas de cuanto en cuanto

        jSliderPrecio.setPaintLabels(true);
        for(int i=0;i<30;i++){
            panelCoches panelCoches=new panelCoches();
            jPanelListadoCoches.add(panelCoches);
            panelCoches.setPreferredSize(new Dimension(165,165));
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMapa = new javax.swing.JPanel();
        jLabelusuario = new javax.swing.JLabel();
        jLabellogo = new javax.swing.JLabel();
        jTextFieldLugarInicio = new javax.swing.JTextField();
        jTextFieldLugarDestino = new javax.swing.JTextField();
        jLabelBuscarInicio = new javax.swing.JLabel();
        jLabelBuscarDestino = new javax.swing.JLabel();
        jSliderPrecio = new javax.swing.JSlider();
        jLabelPrecio = new javax.swing.JLabel();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jLabelModelo = new javax.swing.JLabel();
        jLabelMotor = new javax.swing.JLabel();
        jComboBoxMotor = new javax.swing.JComboBox<>();
        jPanelFiltros = new javax.swing.JPanel();
        jLabelFiltros = new javax.swing.JLabel();
        jLabelValorModelos = new javax.swing.JLabel();
        jLabelResumenModelo = new javax.swing.JLabel();
        jLabelResumenMotor = new javax.swing.JLabel();
        jLabelResumenPrecio = new javax.swing.JLabel();
        jLabelValorPrecio = new javax.swing.JLabel();
        jLabelValorMotor = new javax.swing.JLabel();
        JlabelInicioReservaTexto = new javax.swing.JLabel();
        jScrollPaneListadoCoches = new javax.swing.JScrollPane();
        jPanelListadoCoches = new javax.swing.JPanel();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelSalir = new javax.swing.JLabel();
        rSDateChooser2 = new rojeru_san.componentes.RSDateChooser();
        rSDateChooser3 = new rojeru_san.componentes.RSDateChooser();
        jPanelReserva = new javax.swing.JPanel();
        jLabelTituloreserva = new javax.swing.JLabel();
        JlabelInicioReserva = new javax.swing.JLabel();
        jLabelFinalReserva = new javax.swing.JLabel();
        jLabelCocheReserva = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1291, 1150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMapa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMapa.setPreferredSize(new java.awt.Dimension(800, 400));

        javax.swing.GroupLayout jPanelMapaLayout = new javax.swing.GroupLayout(jPanelMapa);
        jPanelMapa.setLayout(jPanelMapaLayout);
        jPanelMapaLayout.setHorizontalGroup(
            jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        jPanelMapaLayout.setVerticalGroup(
            jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        add(jPanelMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 860, 410));

        jLabelusuario.setText("mi usuario");
        add(jLabelusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, -1, -1));

        jLabellogo.setText("logo");
        add(jLabellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextFieldLugarInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldLugarInicio.setText("lugar de inicio");
        add(jTextFieldLugarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 373, 40));

        jTextFieldLugarDestino.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldLugarDestino.setText("lugar de destino");
        add(jTextFieldLugarDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 411, 40));

        jLabelBuscarInicio.setText("b");
        jLabelBuscarInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscarInicioMouseClicked(evt);
            }
        });
        add(jLabelBuscarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 30, 30));

        jLabelBuscarDestino.setText("b");
        add(jLabelBuscarDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 30, 30));

        jSliderPrecio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSliderPrecio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderPrecioStateChanged(evt);
            }
        });
        jSliderPrecio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSliderPrecioPropertyChange(evt);
            }
        });
        add(jSliderPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelPrecio.setText("Precio máximo:");
        add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 150, -1));

        jLabelModelo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelModelo.setText("Modelo:");
        add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jLabelMotor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelMotor.setText("Motor:");
        add(jLabelMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, -1, -1));

        jComboBoxMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMotorActionPerformed(evt);
            }
        });
        add(jComboBoxMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 130, -1));

        jPanelFiltros.setBackground(new java.awt.Color(170, 211, 223));
        jPanelFiltros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelFiltros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFiltros.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelFiltros.setText("Filtros");
        jPanelFiltros.add(jLabelFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabelValorModelos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelValorModelos.setText("0");
        jLabelValorModelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelValorModelosMouseClicked(evt);
            }
        });
        jPanelFiltros.add(jLabelValorModelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabelResumenModelo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelResumenModelo.setText("Modelo:");
        jPanelFiltros.add(jLabelResumenModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabelResumenMotor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelResumenMotor.setText("Motor:");
        jPanelFiltros.add(jLabelResumenMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabelResumenPrecio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelResumenPrecio.setText("Precio máximo:");
        jPanelFiltros.add(jLabelResumenPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, -1));

        jLabelValorPrecio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelValorPrecio.setText("0");
        jPanelFiltros.add(jLabelValorPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabelValorMotor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelValorMotor.setText("0");
        jLabelValorMotor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelValorMotorMouseClicked(evt);
            }
        });
        jPanelFiltros.add(jLabelValorMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        JlabelInicioReservaTexto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanelFiltros.add(JlabelInicioReservaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        add(jPanelFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 310, 410));

        jScrollPaneListadoCoches.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneListadoCoches.setVerifyInputWhenFocusTarget(false);

        jPanelListadoCoches.setLayout(new java.awt.GridLayout(0, 4));
        jScrollPaneListadoCoches.setViewportView(jPanelListadoCoches);

        add(jScrollPaneListadoCoches, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 610, 860, 376));

        jButtonConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 140, -1, -1));

        jLabelSalir.setText("salir");
        add(jLabelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 20, -1, -1));

        rSDateChooser2.setColorBackground(new java.awt.Color(61, 127, 175));
        rSDateChooser2.setColorButtonHover(new java.awt.Color(61, 127, 175));
        rSDateChooser2.setColorDiaActual(new java.awt.Color(85, 181, 251));
        rSDateChooser2.setColorForeground(new java.awt.Color(61, 127, 175));
        rSDateChooser2.setFuente(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rSDateChooser2.setPlaceholder("Fecha de fin");
        add(rSDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, 130, -1));

        rSDateChooser3.setColorBackground(new java.awt.Color(61, 127, 175));
        rSDateChooser3.setColorButtonHover(new java.awt.Color(61, 127, 175));
        rSDateChooser3.setColorDiaActual(new java.awt.Color(85, 181, 251));
        rSDateChooser3.setColorForeground(new java.awt.Color(61, 127, 175));
        rSDateChooser3.setFuente(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rSDateChooser3.setPlaceholder("Fecha de inicio");
        add(rSDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 150, -1));

        jPanelReserva.setBackground(new java.awt.Color(170, 211, 223));
        jPanelReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTituloreserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTituloreserva.setText("Resumen reserva");

        JlabelInicioReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        JlabelInicioReserva.setText("Inicio");

        jLabelFinalReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelFinalReserva.setText("Final");

        jLabelCocheReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelCocheReserva.setText("Coche");

        javax.swing.GroupLayout jPanelReservaLayout = new javax.swing.GroupLayout(jPanelReserva);
        jPanelReserva.setLayout(jPanelReservaLayout);
        jPanelReservaLayout.setHorizontalGroup(
            jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReservaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelTituloreserva))
                    .addComponent(JlabelInicioReserva)
                    .addComponent(jLabelFinalReserva)
                    .addComponent(jLabelCocheReserva))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanelReservaLayout.setVerticalGroup(
            jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelTituloreserva)
                .addGap(5, 5, 5)
                .addComponent(JlabelInicioReserva)
                .addGap(18, 18, 18)
                .addComponent(jLabelFinalReserva)
                .addGap(18, 18, 18)
                .addComponent(jLabelCocheReserva)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        add(jPanelReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 310, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
         jLabelValorModelos.setText(jComboBoxModelo.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jComboBoxMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMotorActionPerformed
        jLabelValorMotor.setText(jComboBoxMotor.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxMotorActionPerformed

    private void jLabelValorMotorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValorMotorMouseClicked
        jLabelValorMotor.setText("");
    }//GEN-LAST:event_jLabelValorMotorMouseClicked

    private void jLabelValorModelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValorModelosMouseClicked
        jLabelValorModelos.setText("");
    }//GEN-LAST:event_jLabelValorModelosMouseClicked

    private void jSliderPrecioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSliderPrecioPropertyChange
        jLabelValorPrecio.setText(Integer.toString(jSliderPrecio.getValue()));
    }//GEN-LAST:event_jSliderPrecioPropertyChange

    private void jSliderPrecioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPrecioStateChanged
        jLabelValorPrecio.setText(Integer.toString(jSliderPrecio.getValue()));
    }//GEN-LAST:event_jSliderPrecioStateChanged

    private void jLabelBuscarInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarInicioMouseClicked
        try {
            Conexion conn=new Conexion();
            Sede s=conn.buscarSede(jTextFieldLugarInicio.getText());
            geocodificacion g= s.getG();
            Coordinate c=new Coordinate(g.getLat(),g.getLon());
            LayerGroup ubic = new LayerGroup("Ubicacion");
            Layer capas = ubic.addLayer("Ruta");
            MapMarkerDot marcador = new MapMarkerDot(capas, g.getDireccion(), g.getLat(),g.getLon());
            theMap.addMapMarker(marcador);
            theMap.setDisplayPosition(c, g.getZoom());
            theMap.zoomIn();
        } catch (SQLException ex) {
            Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelBuscarInicioMouseClicked

//Comprobar fechas
//implementar la geocodificacion
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlabelInicioReserva;
    private javax.swing.JLabel JlabelInicioReservaTexto;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JComboBox<String> jComboBoxMotor;
    private javax.swing.JLabel jLabelBuscarDestino;
    private javax.swing.JLabel jLabelBuscarInicio;
    private javax.swing.JLabel jLabelCocheReserva;
    private javax.swing.JLabel jLabelFiltros;
    private javax.swing.JLabel jLabelFinalReserva;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelMotor;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelResumenModelo;
    private javax.swing.JLabel jLabelResumenMotor;
    private javax.swing.JLabel jLabelResumenPrecio;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelTituloreserva;
    private javax.swing.JLabel jLabelValorModelos;
    private javax.swing.JLabel jLabelValorMotor;
    private javax.swing.JLabel jLabelValorPrecio;
    private javax.swing.JLabel jLabellogo;
    private javax.swing.JLabel jLabelusuario;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPanelListadoCoches;
    private javax.swing.JPanel jPanelMapa;
    private javax.swing.JPanel jPanelReserva;
    private javax.swing.JScrollPane jScrollPaneListadoCoches;
    private javax.swing.JSlider jSliderPrecio;
    private javax.swing.JTextField jTextFieldLugarDestino;
    private javax.swing.JTextField jTextFieldLugarInicio;
    private rojeru_san.componentes.RSDateChooser rSDateChooser2;
    private rojeru_san.componentes.RSDateChooser rSDateChooser3;
    // End of variables declaration//GEN-END:variables
}
