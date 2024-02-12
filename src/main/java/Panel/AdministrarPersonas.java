package Panel;

import Model.Ciudad;
import Model.Direccion;
import Model.Persona;
import Repository.CiudadImpl;
import Repository.DireccionImpl;
import Repository.PersonaImpl;
import Repository.Repository;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @Julián
 */
public class AdministrarPersonas extends javax.swing.JPanel {
    
    private static Repository repository= new PersonaImpl();
    private static Repository repositoryC=new CiudadImpl();
    private static Repository repositoryD=new DireccionImpl();
    
    public AdministrarPersonas() {
        initComponents();
        
        setSize(1000, 600); // Tamaño mediano
        List<Ciudad> ciudades = repositoryC.listar();
        for(Ciudad ciudad:ciudades){
            jcbCiudades.addItem(ciudad.getCiudad_nombre());
        }
//        jcbCiudades.addItem();
        
//        Color colorTranslucido = new Color(255, 255, 255, 128);
//        jTextField2.setBackground(colorTranslucido);
        jtfCodigo.setVisible(false);
        jbActualizar.setVisible(false);
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
        jcbCiudades = new javax.swing.JComboBox<>();
        jcbTipoDocumento = new javax.swing.JComboBox<>();
        jtfCodigo = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jbActualizar = new javax.swing.JButton();
        jbRegistrar = new javax.swing.JButton();
        jtfNumeroDocumento = new javax.swing.JTextField();
        jtfTelefono = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        jcbTipoDireccion = new javax.swing.JComboBox<>();
        jtfNumeroDireccion = new javax.swing.JTextField();

        setOpaque(false);

        jcbSeleccion.setBackground(new java.awt.Color(166, 181, 167));
        jcbSeleccion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbSeleccion.setForeground(new java.awt.Color(0, 0, 1));
        jcbSeleccion.setMaximumRowCount(5);
        jcbSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrar", "Modificar" }));
        jcbSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Que desea hacer?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(0, 0, 1))); // NOI18N
        jcbSeleccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionActionPerformed(evt);
            }
        });

        jcbCiudades.setBackground(new java.awt.Color(178, 144, 73));
        jcbCiudades.setEditable(true);
        jcbCiudades.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbCiudades.setForeground(new java.awt.Color(0, 0, 1));
        jcbCiudades.setMaximumRowCount(5);
        jcbCiudades.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Ciudades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jcbCiudades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jcbTipoDocumento.setBackground(new java.awt.Color(178, 144, 73));
        jcbTipoDocumento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbTipoDocumento.setForeground(new java.awt.Color(0, 0, 1));
        jcbTipoDocumento.setMaximumRowCount(5);
        jcbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta Identidad", "Cédula", "Pasaporte", "Carnet Extranjería", "Registro Civil", "Otro" }));
        jcbTipoDocumento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Tipo de Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jcbTipoDocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoDocumentoActionPerformed(evt);
            }
        });

        jtfCodigo.setBackground(new java.awt.Color(178, 144, 73));
        jtfCodigo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfCodigo.setForeground(new java.awt.Color(0, 0, 1));
        jtfCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Codigo Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jtfCodigo.setOpaque(true);
        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });

        jtfNombre.setBackground(new java.awt.Color(178, 144, 73));
        jtfNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfNombre.setForeground(new java.awt.Color(0, 0, 1));
        jtfNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Nombre Estudiante", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jtfNombre.setOpaque(true);

        jtfApellido.setBackground(new java.awt.Color(178, 144, 73));
        jtfApellido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfApellido.setForeground(new java.awt.Color(0, 0, 1));
        jtfApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Apellido Estudiante", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jtfApellido.setOpaque(true);

        jdcFechaNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "fecha nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N
        jdcFechaNacimiento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

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

        jtfNumeroDocumento.setBackground(new java.awt.Color(178, 144, 73));
        jtfNumeroDocumento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfNumeroDocumento.setForeground(new java.awt.Color(0, 0, 1));
        jtfNumeroDocumento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Numero documento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jtfNumeroDocumento.setOpaque(true);

        jtfTelefono.setBackground(new java.awt.Color(178, 144, 73));
        jtfTelefono.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfTelefono.setForeground(new java.awt.Color(0, 0, 1));
        jtfTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Telefono", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jtfTelefono.setOpaque(true);

        jcbGenero.setBackground(new java.awt.Color(178, 144, 73));
        jcbGenero.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbGenero.setForeground(new java.awt.Color(0, 0, 1));
        jcbGenero.setMaximumRowCount(5);
        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otro" }));
        jcbGenero.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Genero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jcbGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jcbTipoDireccion.setBackground(new java.awt.Color(178, 144, 73));
        jcbTipoDireccion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbTipoDireccion.setForeground(new java.awt.Color(0, 0, 1));
        jcbTipoDireccion.setMaximumRowCount(5);
        jcbTipoDireccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calle", "Carrera", "Avenida", "Transversal", "Diagonal", "Circular" }));
        jcbTipoDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Tipo de Direccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jcbTipoDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jtfNumeroDireccion.setBackground(new java.awt.Color(178, 144, 73));
        jtfNumeroDireccion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfNumeroDireccion.setForeground(new java.awt.Color(0, 0, 1));
        jtfNumeroDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Numero Dirección", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jtfNumeroDireccion.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTipoDocumento, 0, 1, Short.MAX_VALUE)
                            .addComponent(jcbCiudades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCodigo)
                            .addComponent(jcbSeleccion, 0, 140, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(191, 191, 191))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTipoDireccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfApellido)
                            .addComponent(jtfNumeroDocumento))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNumeroDireccion)
                            .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbGenero, 0, 160, Short.MAX_VALUE))
                        .addGap(69, 69, 69)
                        .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jcbGenero, jcbTipoDocumento, jtfNumeroDocumento, jtfTelefono});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jcbCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbTipoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNumeroDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jcbGenero, jcbTipoDocumento, jdcFechaNacimiento, jtfApellido, jtfNombre, jtfNumeroDocumento, jtfTelefono});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jcbCiudades, jcbTipoDireccion, jtfNumeroDireccion});

    }// </editor-fold>//GEN-END:initComponents

    
    
    private Ciudad datosCiudad(){
        Ciudad c=new Ciudad();
        
        String ciudad_nombre=(String)jcbCiudades.getSelectedItem();
        boolean ciudad_existe=false;
        
        List<Ciudad> ciudades = repositoryC.listar();
        for(Ciudad ciudad: ciudades){
            if(ciudad.getCiudad_nombre().equals(ciudad_nombre)){
                ciudad_existe=true;
                c=ciudad;
                break;
            }
        }
        
        if(ciudad_existe==false){
            c.setCiudad_nombre(ciudad_nombre);
//            repositoryC.guardar(c);
            jcbCiudades.addItem(ciudad_nombre);
            return c;
        }else{
            return c;
        }
    }
    
    private Direccion datosDireccion(){
        Direccion d=new Direccion();
        int id_ciudad=0,id_direccion=1;
        List<Ciudad> ciudades = repositoryC.listar();
        List<Direccion> direcciones = repositoryD.listar();
        List<Persona> personas=repository.listar();
        
        String ciudad_nombre=(String)jcbCiudades.getSelectedItem();
        String tipo_direccion=(String)jcbTipoDireccion.getSelectedItem();
        String numero_direccion=jtfNumeroDireccion.getText().trim();
        boolean direccion_existe=false;
        
        for(Direccion direccion:direcciones){
            if(direccion.getTipo().equals(tipo_direccion) && direccion.getNumero().equals(numero_direccion)){
                direccion_existe=true;
                id_direccion=direccion.getDirecion_id();
                break;
            }else{
                id_direccion=direccion.getDirecion_id();
            }
        }
        if(!direccion_existe){
            id_ciudad++;
        }
        d.setDirecion_id(id_direccion);
        d.setTipo(tipo_direccion);
        d.setNumero(numero_direccion);
        d.setCiudad(datosCiudad());
        return d;
    }
    
    private Persona datosPersona(){
        Persona p=new Persona();
        Direccion d=datosDireccion();
        //Establecimiento de datos
        String numero_documento = jtfNumeroDocumento.getText().trim();
        String telefono = jtfTelefono.getText().trim();
        String tipo_documento=(String) jcbTipoDocumento.getSelectedItem();
        String genero=(String) jcbGenero.getSelectedItem();
        String nombre=jtfNombre.getText().trim();
        String apellido=jtfApellido.getText().trim();
        Date fecha_nacimiento1=jdcFechaNacimiento.getDate();
        
        LocalDate fecha_nacimiento2;
        if (fecha_nacimiento1 != null) {
            fecha_nacimiento2 = fecha_nacimiento1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            // Maneja el caso en el que no se ha seleccionado ninguna fecha
            fecha_nacimiento2 = null; // o alguna otra acción
        }
        try 
        {
            int numero = Integer.parseInt(numero_documento);
//            int telefonoV= Integer.parseInt(telefono);
            p.setNumero_documento(numero);
            
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El número de documento y el telefono debe ser un valor numérico.");
        }
        p.setTelefono(telefono);
        p.setTipo_documento(tipo_documento);
        p.setGenero(genero);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setFecha_nacimiento(fecha_nacimiento2);
        System.out.println(d.getDirecion_id());
        System.out.println(d.getNumero());
        System.out.println(d.getTipo());
        p.setDireccion(datosDireccion());
        
        return p;
    }
    
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        List<Persona> personas = repository.listar();
        List<Ciudad> ciudades = repositoryC.listar();
        List<Direccion> direcciones = repositoryD.listar();
        
        int codigo = Integer.parseInt(jtfCodigo.getText());
        Persona persona=datosPersona();
        Direccion direccion=datosDireccion();
        Ciudad ciudad=datosCiudad();
        
        for (Persona p : personas) {
            if(codigo==p.getId()){
                p.setId(codigo);
                p.setNumero_documento(persona.getNumero_documento());
                p.setTelefono(persona.getTelefono());
                p.setTipo_documento(persona.getTipo_documento());
                p.setGenero(persona.getGenero());
                p.setNombre(persona.getNombre());
                p.setApellido(persona.getApellido());
                p.setFecha_nacimiento(persona.getFecha_nacimiento());
                p.setDireccion(direccion);
                repository.modificar(p);
                break;
            }
        }
        
        for (Direccion d: direcciones){
            if(codigo==d.getDirecion_id()){
                d.setDirecion_id(codigo);
                d.setCiudad(ciudad);
                d.setNumero(direccion.getNumero());
                d.setTipo(direccion.getTipo());
                repositoryD.modificar(d);
                break;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Persona Actualizada en el sistema.");

        
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed
        
        
        repositoryC.guardar(datosCiudad());
        repositoryD.guardar(datosDireccion());
        repository.guardar(datosPersona());
        
        JOptionPane.showMessageDialog(null, "Persona Registrada en el sistema.");
        
    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jcbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoDocumentoActionPerformed

    private void jcbSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionActionPerformed
        // TODO add your handling code here:
        String seleccion=(String)jcbSeleccion.getSelectedItem();
        if(seleccion.equals("Registrar")){
            jtfCodigo.setVisible(false);
            jbActualizar.setVisible(false);
            jbRegistrar.setVisible(true);
        }else if(seleccion.equals("Modificar")){
            jtfCodigo.setVisible(true);
            jbActualizar.setVisible(true);
            jbRegistrar.setVisible(false);
        }
    }//GEN-LAST:event_jcbSeleccionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JComboBox<String> jcbCiudades;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JComboBox<String> jcbSeleccion;
    private javax.swing.JComboBox<String> jcbTipoDireccion;
    private javax.swing.JComboBox<String> jcbTipoDocumento;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNumeroDireccion;
    private javax.swing.JTextField jtfNumeroDocumento;
    private javax.swing.JTextField jtfTelefono;
    // End of variables declaration//GEN-END:variables
}