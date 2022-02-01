package vistas;


import Conexion.BBDD;
import Conexion.Conexion;
import Logica.Logica;
import Logica.Sede;
import Logica.Vehiculo;
import Logica.geocodificacion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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

    Date fechaActual;
    JMapViewerTree theMap;
    Logica logica;
    Conexion conexion;
    /**
     * Creates new form panelPrincipal
     */
    public panelPrincipal() {
        initComponents();
        conexion = new Conexion();
        fechaActual=new Date();
        logica=new Logica();
        theMap = new JMapViewerTree("prueba");
        int height=jPanelMapa.getPreferredSize().height;
        theMap.setBounds(jPanelMapa.getX(), jPanelMapa.getX(), jPanelMapa.getPreferredSize().width, jPanelMapa.getPreferredSize().height);
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
        jScrollPaneListadoCoches.getVerticalScrollBar().setUnitIncrement(15);
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
//        String SeleccionComboBoxModelo = jComboBoxModelo.getSelectedItem().toString();
//        try {
//           Connection con = conexion.openConnection();
//           Statement Sent = con.createStatement();
//           ResultSet rsb = Sent.executeQuery("select "+ SeleccionComboBoxModelo +"");
//        } catch (Exception e) {
//            
//        }
        

        
        

        Image img= new ImageIcon("calendario.png").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(25, 25, Image.SCALE_DEFAULT));

        logica.añadirCoches(jPanelListadoCoches);
        jDateChooserfin.setIcon(img2);
        jDateChooserinicio.setIcon(img2);
        ((JTextField) this.jDateChooserinicio.getDateEditor()).setEditable(false); 
        ((JTextField) this.jDateChooserfin.getDateEditor()).setEditable(false); 

        
        
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
        jPanelReserva = new javax.swing.JPanel();
        jLabelTituloreserva = new javax.swing.JLabel();
        JlabelInicioReserva = new javax.swing.JLabel();
        JlabelInicioReservaDatos = new javax.swing.JLabel();
        jLabelFinalReserva = new javax.swing.JLabel();
        JlabelFinalReservaDatos = new javax.swing.JLabel();
        jLabelCocheReserva = new javax.swing.JLabel();
        jLabelPrecioFinal = new javax.swing.JLabel();
        jLabelCocheReservaDatos = new javax.swing.JLabel();
        jLabelPrecioFinalDatos = new javax.swing.JLabel();
        JlabelLugarInicioReserva = new javax.swing.JLabel();
        jLabellugarFinalReserva = new javax.swing.JLabel();
        JlabelLugarInicioReservaDatos = new javax.swing.JLabel();
        jLabellugarFinalReservaDatos = new javax.swing.JLabel();
        jDateChooserfin = new com.toedter.calendar.JDateChooser();
        jDateChooserinicio = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1291, 1150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMapa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMapa.setPreferredSize(new java.awt.Dimension(860, 410));

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
        jLabelusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelusuarioMouseClicked(evt);
            }
        });
        add(jLabelusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, -1, -1));

        jLabellogo.setText("logo");
        add(jLabellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextFieldLugarInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldLugarInicio.setText("lugar de inicio");
        jTextFieldLugarInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldLugarInicioMouseClicked(evt);
            }
        });
        add(jTextFieldLugarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 373, 40));

        jTextFieldLugarDestino.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldLugarDestino.setText("lugar de destino");
        jTextFieldLugarDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldLugarDestinoMouseClicked(evt);
            }
        });
        add(jTextFieldLugarDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 411, 40));

        jLabelBuscarInicio.setText("b");
        jLabelBuscarInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscarInicioMouseClicked(evt);
            }
        });
        add(jLabelBuscarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 30, 30));

        jLabelBuscarDestino.setText("b");
        jLabelBuscarDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscarDestinoMouseClicked(evt);
            }
        });
        add(jLabelBuscarDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 30, 30));

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

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BMW", "AUDI", "CITROEN", "MERCEDES", "PEUGEOT", "MASERATI", "FORD", "VOLKSWAGEN", "PORSCHE", "TOYOTA" }));
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

        jComboBoxMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Diesel", "Electrico" }));
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

        jScrollPaneListadoCoches.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneListadoCoches.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneListadoCoches.setAutoscrolls(true);
        jScrollPaneListadoCoches.setVerifyInputWhenFocusTarget(false);

        jPanelListadoCoches.setAutoscrolls(true);
        jPanelListadoCoches.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelListadoCochesPropertyChange(evt);
            }
        });
        jPanelListadoCoches.setLayout(new java.awt.GridLayout(0, 4));
        jScrollPaneListadoCoches.setViewportView(jPanelListadoCoches);

        add(jScrollPaneListadoCoches, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 610, 860, 376));

        jButtonConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 140, -1, -1));

        jLabelSalir.setText("salir");
        add(jLabelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 20, -1, -1));

        jPanelReserva.setBackground(new java.awt.Color(170, 211, 223));
        jPanelReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTituloreserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTituloreserva.setText("Resumen reserva");

        JlabelInicioReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        JlabelInicioReserva.setText("Fecha Inicio:");

        JlabelInicioReservaDatos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabelFinalReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelFinalReserva.setText("Fecha Final:");

        JlabelFinalReservaDatos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabelCocheReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelCocheReserva.setText("Coche:");

        jLabelPrecioFinal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelPrecioFinal.setText("Precio total:");

        jLabelCocheReservaDatos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabelPrecioFinalDatos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        JlabelLugarInicioReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        JlabelLugarInicioReserva.setText("Lugar de inicio:");

        jLabellugarFinalReserva.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabellugarFinalReserva.setText("Lugar de final:");

        JlabelLugarInicioReservaDatos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabellugarFinalReservaDatos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanelReservaLayout = new javax.swing.GroupLayout(jPanelReserva);
        jPanelReserva.setLayout(jPanelReservaLayout);
        jPanelReservaLayout.setHorizontalGroup(
            jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCocheReserva)
                    .addComponent(JlabelInicioReserva)
                    .addComponent(jLabelFinalReserva)
                    .addComponent(jLabelPrecioFinal))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelReservaLayout.createSequentialGroup()
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReservaLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabelTituloreserva))
                    .addGroup(jPanelReservaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlabelLugarInicioReserva)
                            .addComponent(jLabellugarFinalReserva))
                        .addGap(75, 75, 75)
                        .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JlabelFinalReservaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JlabelInicioReservaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabellugarFinalReservaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JlabelLugarInicioReservaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jLabelCocheReservaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPrecioFinalDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanelReservaLayout.setVerticalGroup(
            jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelTituloreserva)
                .addGap(18, 18, 18)
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JlabelLugarInicioReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlabelLugarInicioReservaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabellugarFinalReservaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabellugarFinalReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlabelInicioReserva)
                    .addComponent(JlabelInicioReservaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFinalReserva)
                    .addComponent(JlabelFinalReservaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCocheReserva)
                    .addComponent(jLabelCocheReservaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecioFinal)
                    .addComponent(jLabelPrecioFinalDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        add(jPanelReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 310, 370));

        jDateChooserfin.setBackground(new java.awt.Color(61, 127, 175));
        jDateChooserfin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserfinPropertyChange(evt);
            }
        });
        add(jDateChooserfin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 60, 180, -1));

        jDateChooserinicio.setBackground(new java.awt.Color(61, 127, 175));
        jDateChooserinicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserinicioPropertyChange(evt);
            }
        });
        add(jDateChooserinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 160, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
         jLabelValorModelos.setText(jComboBoxModelo.getSelectedItem().toString());
         logica.filtrarCoches(jPanelListadoCoches, "modelo", jComboBoxModelo.getSelectedItem().toString(), true);
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jComboBoxMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMotorActionPerformed
        jLabelValorMotor.setText(jComboBoxMotor.getSelectedItem().toString());
        logica.filtrarCoches(jPanelListadoCoches, "motor", jComboBoxMotor.getSelectedItem().toString(), true);
    }//GEN-LAST:event_jComboBoxMotorActionPerformed

    private void jLabelValorMotorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValorMotorMouseClicked
        logica.filtrarCoches(jPanelListadoCoches, "motor", jLabelValorMotor.getText(), false);
        jLabelValorMotor.setText("");
    }//GEN-LAST:event_jLabelValorMotorMouseClicked

    private void jLabelValorModelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValorModelosMouseClicked
        logica.filtrarCoches(jPanelListadoCoches, "modelo", jLabelValorModelos.getText(), false);
        jLabelValorModelos.setText("");
    }//GEN-LAST:event_jLabelValorModelosMouseClicked

    //eliminar evento
    private void jSliderPrecioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSliderPrecioPropertyChange
        jLabelValorPrecio.setText(Integer.toString(jSliderPrecio.getValue()));
    }//GEN-LAST:event_jSliderPrecioPropertyChange

    private void jSliderPrecioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPrecioStateChanged
        jLabelValorPrecio.setText(Integer.toString(jSliderPrecio.getValue()));
        logica.filtrarCoches(jPanelListadoCoches, "precio", Double.toString(jSliderPrecio.getValue()), true);
        
    }//GEN-LAST:event_jSliderPrecioStateChanged

    private void jLabelBuscarInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarInicioMouseClicked
        
        logica.filtrarCoches(jPanelListadoCoches, "sede", jTextFieldLugarInicio.getText(), true);
        Sede s=logica.buscarsede(jTextFieldLugarInicio.getText());
        geocodificacion g= s.getG();
        LayerGroup ubic = new LayerGroup("Ubicacion");
        Layer capas = ubic.addLayer("Ruta");
        MapMarkerDot marcador = new MapMarkerDot(capas, s.getCiudad(), s.getLat(),s.getLon());
        map().addMapMarker(marcador);
        Coordinate c=new Coordinate(g.getLat(),g.getLon());
        theMap.getViewer().setDisplayPosition(c, s.getG().getZoom());
        theMap.getViewer().zoomIn();
        JlabelInicioReserva.setText(JlabelInicioReserva.getText()+jTextFieldLugarInicio.getText());
        
        JlabelLugarInicioReservaDatos.setText(g.getDireccion());
        logica.getReservaActual().setLugar_inicio(s);
    }//GEN-LAST:event_jLabelBuscarInicioMouseClicked

    private void jDateChooserfinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserfinPropertyChange
        
        System.out.println(jDateChooserfin.getDate());
        //comprueba si la fecha de inicio de la reserva y la fin de la reverva no son nulas
        if((jDateChooserfin.getDate()!=null)&&(jDateChooserinicio.getDate()!=null )){ 
            
            //comprueba que la fecha de fin sea mas tarde que la fecha de inicio
            //si no es asi asigna a la fecha de fin la fecha de inicio
            if(jDateChooserfin.getDate().before( jDateChooserinicio.getDate())){
                JOptionPane.showMessageDialog(null, "La fecha de inicio es mayor que la final.\nElija una fecha válida.\nSe pondrá por defecto la fecha de inicio");
                jDateChooserfin.setDate(jDateChooserinicio.getDate());
            }else{
                JOptionPane.showMessageDialog(null, "Se eligió la fecha: "+FormatearFecha(jDateChooserfin.getDate()));
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            JlabelFinalReservaDatos.setText(FormatearFecha(jDateChooserfin.getDate()));
            logica.getReservaActual().setFecha_destino(jDateChooserfin.getDate());
            
            //jLabelPrecioFinalDatos.setText(String.valueOf(calcularDias()));
        }
    }//GEN-LAST:event_jDateChooserfinPropertyChange

    public int calcularDias(){
        long diffInMillies = Math.abs(jDateChooserinicio.getDate().getTime() - jDateChooserfin.getDate().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return  (int)Math.ceil(diff+1);   
    }
    private void jDateChooserinicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserinicioPropertyChange
        //comprueba si la fecha de inicio de la reserva no es nula
        if(jDateChooserinicio.getDate()!=null) {   
            
            //comprueba que la fecha de inicio sea mayor que la fecha actual
            if(jDateChooserinicio.getDate().before(fechaActual)){
                JOptionPane.showMessageDialog(null, "Fecha anterior a la actual.\nSe pondrá por defecto la actual");
                jDateChooserinicio.setDate(fechaActual);
            //comprueba que la fecha de fin sea mas tarde que la fecha de inicio
            //si no es asi asigna ala fecha de inicio, la fecha actual    
            }else if((jDateChooserfin.getDate()!=null)&&(jDateChooserfin.getDate().before( jDateChooserinicio.getDate()))){
                JOptionPane.showMessageDialog(null, "La fecha de inicio es mayor que la final.\nElija una fecha válida.\nSe pondrá por defecto la actual");
                jDateChooserinicio.setDate(fechaActual);
            }else{
                JOptionPane.showMessageDialog(null, "Se eligió la fecha: "+FormatearFecha(jDateChooserinicio.getDate()));
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            JlabelInicioReservaDatos.setText(FormatearFecha(jDateChooserinicio.getDate()));
            logica.getReservaActual().setFecha_inicio(jDateChooserinicio.getDate());
        }
        
        
    }//GEN-LAST:event_jDateChooserinicioPropertyChange

    public String FormatearFecha(Date date){
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    private void jTextFieldLugarDestinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldLugarDestinoMouseClicked
        jTextFieldLugarDestino.setText("");
    }//GEN-LAST:event_jTextFieldLugarDestinoMouseClicked

    private void jTextFieldLugarInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldLugarInicioMouseClicked
        jTextFieldLugarInicio.setText("");
    }//GEN-LAST:event_jTextFieldLugarInicioMouseClicked

    private void jLabelBuscarDestinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarDestinoMouseClicked
        Sede s=logica.buscarsede(jTextFieldLugarDestino.getText());
        geocodificacion g= s.getG();
        LayerGroup ubic = new LayerGroup("Ubicacion");
        Layer capas = ubic.addLayer("Ruta");
        MapMarkerDot marcador = new MapMarkerDot(capas, s.getCiudad(), s.getLat(),s.getLon());
        map().addMapMarker(marcador);
        Coordinate c=new Coordinate(g.getLat(),g.getLon());
        theMap.getViewer().setDisplayPosition(c, s.getG().getZoom());
        theMap.getViewer().zoomIn();
        logica.getReservaActual().setLugar_destino(s);
        //jLabelFinalReserva.setText(jLabelFinalReserva.getText()+jTextFieldLugarDestino.getText());
        jLabellugarFinalReservaDatos.setText(g.getDireccion());
    }//GEN-LAST:event_jLabelBuscarDestinoMouseClicked

    private void jPanelListadoCochesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelListadoCochesPropertyChange
        Vehiculo v=logica.cocheSeleccionado(jPanelListadoCoches);
        if(v!=null){ 
             jLabelCocheReservaDatos.setText(v.getModelo());
             if(jDateChooserfin.getDate()!=null&&jDateChooserinicio.getDate()!=null)
             jLabelPrecioFinalDatos.setText(String.valueOf(calcularDias()*Double.parseDouble(v.getPrecio())));
             logica.getReservaActual().setVehiculo(v);
             logica.getReservaActual().setPrecio_total(String.valueOf(calcularDias()*Double.parseDouble(v.getPrecio())));
        }else{
             jLabelCocheReservaDatos.setText("");
             jLabelPrecioFinalDatos.setText("");
        }
    }//GEN-LAST:event_jPanelListadoCochesPropertyChange

    private void jLabelusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelusuarioMouseClicked
        new Usuario().setVisible(true);
        
    }//GEN-LAST:event_jLabelusuarioMouseClicked

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        Vehiculo v=logica.cocheSeleccionado(jPanelListadoCoches);
        if(JlabelLugarInicioReservaDatos.getText() != "" && jLabellugarFinalReservaDatos.getText() != "" && JlabelInicioReservaDatos.getText() != "" && JlabelFinalReservaDatos.getText() != "" && ((Vehiculo)v) != null && jLabelPrecioFinalDatos != null){
            logica.añadirReserva();
//        new BBDD().GDreserva(JlabelLugarInicioReservaDatos.getText(), jLabellugarFinalReservaDatos.getText(), JlabelInicioReservaDatos.getText(), JlabelFinalReservaDatos.getText(),((Vehiculo)v).getID(),jLabelPrecioFinalDatos.getText());
        }else{
            JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos para realizar su reserva", "Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    
        
        

    private JMapViewer map() {
        return theMap.getViewer();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlabelFinalReservaDatos;
    private javax.swing.JLabel JlabelInicioReserva;
    private javax.swing.JLabel JlabelInicioReservaDatos;
    private javax.swing.JLabel JlabelInicioReservaTexto;
    private javax.swing.JLabel JlabelLugarInicioReserva;
    private javax.swing.JLabel JlabelLugarInicioReservaDatos;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JComboBox<String> jComboBoxMotor;
    private com.toedter.calendar.JDateChooser jDateChooserfin;
    private com.toedter.calendar.JDateChooser jDateChooserinicio;
    private javax.swing.JLabel jLabelBuscarDestino;
    private javax.swing.JLabel jLabelBuscarInicio;
    private javax.swing.JLabel jLabelCocheReserva;
    private javax.swing.JLabel jLabelCocheReservaDatos;
    private javax.swing.JLabel jLabelFiltros;
    private javax.swing.JLabel jLabelFinalReserva;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelMotor;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPrecioFinal;
    private javax.swing.JLabel jLabelPrecioFinalDatos;
    private javax.swing.JLabel jLabelResumenModelo;
    private javax.swing.JLabel jLabelResumenMotor;
    private javax.swing.JLabel jLabelResumenPrecio;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelTituloreserva;
    private javax.swing.JLabel jLabelValorModelos;
    private javax.swing.JLabel jLabelValorMotor;
    private javax.swing.JLabel jLabelValorPrecio;
    private javax.swing.JLabel jLabellogo;
    private javax.swing.JLabel jLabellugarFinalReserva;
    private javax.swing.JLabel jLabellugarFinalReservaDatos;
    private javax.swing.JLabel jLabelusuario;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPanelListadoCoches;
    private javax.swing.JPanel jPanelMapa;
    private javax.swing.JPanel jPanelReserva;
    private javax.swing.JScrollPane jScrollPaneListadoCoches;
    private javax.swing.JSlider jSliderPrecio;
    private javax.swing.JTextField jTextFieldLugarDestino;
    private javax.swing.JTextField jTextFieldLugarInicio;
    // End of variables declaration//GEN-END:variables
}
