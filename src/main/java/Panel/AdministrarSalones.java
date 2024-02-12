package Panel;

import Model.Departamento;
import Model.Periodo;
import Model.Programa;
import Model.Salon;
import Repository.DepartamentoImpl;
import Repository.Repository;
import Repository.SalonImpl;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 * @Julián
 */
public class AdministrarSalones extends javax.swing.JPanel {
    
    private static final Repository salonRepository= new SalonImpl();
    List<Salon> listaSalones=salonRepository.listar();
    
    
    public AdministrarSalones() {
        initComponents();
        
        setSize(1000, 600); // Tamaño mediano
        jtfCodigoDepartamento.setVisible(false);
        jbActualizar.setVisible(false);
        jbRegistrar.setVisible(true);
        
        
        JComponent editor = jsCapacidad.getEditor();
        if (editor instanceof JSpinner.DefaultEditor defaultEditor) {
            defaultEditor.getTextField().setEnabled(false);
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

        jcbSeleccion = new javax.swing.JComboBox<>();
        jbRegistrar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jtfCodigoDepartamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNombreEdificio = new javax.swing.JTextField();
        jsCapacidad = new javax.swing.JSpinner();
        jcbPisos = new javax.swing.JComboBox<>();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbSeleccion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbSeleccion.setForeground(new java.awt.Color(255, 255, 254));
        jcbSeleccion.setMaximumRowCount(5);
        jcbSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrar", "Modificar" }));
        jcbSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Que desea hacer?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jcbSeleccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionActionPerformed(evt);
            }
        });
        add(jcbSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 330, 169, 40));

        jbRegistrar.setBackground(new java.awt.Color(0, 0, 1));
        jbRegistrar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(178, 144, 73));
        jbRegistrar.setText("Registrar");
        jbRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(178, 144, 73), java.awt.Color.black, java.awt.Color.lightGray));
        jbRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });
        add(jbRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 100, 30));

        jbActualizar.setBackground(new java.awt.Color(0, 0, 1));
        jbActualizar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(178, 144, 73));
        jbActualizar.setText("Actualizar");
        jbActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(178, 144, 73), java.awt.Color.black, java.awt.Color.lightGray));
        jbActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });
        add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 100, 30));

        jtfCodigoDepartamento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfCodigoDepartamento.setForeground(new java.awt.Color(255, 255, 254));
        jtfCodigoDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Codigo del Salon", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jtfCodigoDepartamento.setOpaque(true);
        jtfCodigoDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoDepartamentoActionPerformed(evt);
            }
        });
        jtfCodigoDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoDepartamentoKeyReleased(evt);
            }
        });
        add(jtfCodigoDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 169, -1));

        jLabel3.setBackground(new java.awt.Color(242, 242, 150));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Aquí podrá registrar y actualizar Salones");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 380, 40));

        jLabel4.setBackground(new java.awt.Color(242, 242, 150));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("digite numero de un Salon para ver si existe");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 400, 40));

        jtfNombreEdificio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfNombreEdificio.setForeground(new java.awt.Color(255, 255, 254));
        jtfNombreEdificio.setToolTipText("");
        jtfNombreEdificio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Nombre del Edificio", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jtfNombreEdificio.setOpaque(true);
        add(jtfNombreEdificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 230, -1));

        jsCapacidad.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jsCapacidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 127, 1));
        jsCapacidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Capacidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N
        jsCapacidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jsCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 90, 40));

        jcbPisos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbPisos.setForeground(new java.awt.Color(255, 255, 255));
        jcbPisos.setMaximumRowCount(5);
        jcbPisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jcbPisos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Pisos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jcbPisos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbPisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPisosActionPerformed(evt);
            }
        });
        add(jcbPisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 70, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarListas(){
        listaSalones=salonRepository.listar();
    }
    
    private Salon datosSalon(){
        actualizarListas();
        Salon s=new Salon();
        int id_ultimo=0;
        if (!listaSalones.isEmpty()) {
            Salon ultimoSalon = listaSalones.get(listaSalones.size() - 1);
            id_ultimo=ultimoSalon.getSalon_id();
            id_ultimo++;
        } else {
            id_ultimo=1;
        }
        String nombre_edificio=jtfNombreEdificio.getText();
        String pisos_str=(String) jcbPisos.getSelectedItem();
        byte pisos=Byte.parseByte(pisos_str);
        Number capacidadNumber = (Number) jsCapacidad.getValue();
        int capasidadInt = capacidadNumber.intValue();
        byte capasidad = (byte) capasidadInt;
        char letra=nombre_edificio.charAt(0);
        String codigo_especifico = letra+"-"+pisos+"-"+id_ultimo;
        
        s.setCapacidad_alumnos(capasidad);
        s.setNombre_edificio(nombre_edificio);
        s.setNumero_especifico(codigo_especifico);
        s.setPiso(pisos);
        
        return s;
    }
    
    private void jcbSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionActionPerformed
        // TODO add your handling code here:
        String seleccion=(String)jcbSeleccion.getSelectedItem();
        if(seleccion.equals("Registrar")){
            jtfCodigoDepartamento.setVisible(false);
            jbActualizar.setVisible(false);
            jbRegistrar.setVisible(true);
        }else if(seleccion.equals("Modificar")){
            jtfCodigoDepartamento.setVisible(true);
            jbActualizar.setVisible(true);
            jbRegistrar.setVisible(false);
        }
    }//GEN-LAST:event_jcbSeleccionActionPerformed

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed
        
        salonRepository.guardar(datosSalon());
//        lecturaModal();
        JOptionPane.showMessageDialog(null, "Datos guardados");
        
    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        salonRepository.modificar(datosSalon());
        JOptionPane.showMessageDialog(null, "Datos modificados");

    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jtfCodigoDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoDepartamentoActionPerformed

    private void jtfCodigoDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoDepartamentoKeyReleased
        // TODO add your handling code here:
        
        if(jtfCodigoDepartamento.getText().equals("")){
        }else{
        }
        
        
    }//GEN-LAST:event_jtfCodigoDepartamentoKeyReleased

    private void jcbPisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPisosActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JComboBox<String> jcbPisos;
    private javax.swing.JComboBox<String> jcbSeleccion;
    private javax.swing.JSpinner jsCapacidad;
    private javax.swing.JTextField jtfCodigoDepartamento;
    private javax.swing.JTextField jtfNombreEdificio;
    // End of variables declaration//GEN-END:variables
}