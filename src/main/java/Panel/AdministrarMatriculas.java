package Panel;

import Model.Asignatura;
import Model.Departamento;
import Model.Estudiante;
import Model.Horario;
import Model.Matricula;
import Model.Periodo;
import Model.Persona;
import Model.Pro_Per_Cur_Asig;
import Model.Programa;
import Model.Salon;
import Repository.AsignaturaImpl;
import Repository.DepartamentoImpl;
import Repository.EstudianteImpl;
import Repository.HorarioImpl;
import Repository.MatriculaImpl;
import Repository.PersonaImpl;
import Repository.Pro_Per_Cur_AsigImpl;
import Repository.ProgramaImpl;
import Repository.Repository;
import Repository.SalonImpl;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 * @Julián
 */
public class AdministrarMatriculas extends javax.swing.JPanel {
    
    private static final Repository estudianteRepository = new EstudianteImpl();
    private static final Repository personaRepository = new PersonaImpl();
    private static final Repository programarepository = new ProgramaImpl();
    private static final Repository asignaturaRepository = new AsignaturaImpl();
    private static final Repository multitablaRepository = new Pro_Per_Cur_AsigImpl();
    private static final Repository matriculaRepository = new MatriculaImpl();
    private static final Repository horarioRepository = new HorarioImpl();
    List<Horario> listaHorarios=horarioRepository.listar();
    List<Matricula> listaMatriculas=matriculaRepository.listar();
    List<Programa> listaProgramas=programarepository.listar();
    List<Asignatura> listaAsignaturas=asignaturaRepository.listar();
    List<Persona> listaPersonas=personaRepository.listar();
    List<Estudiante> listaEstudiantes=estudianteRepository.listar();
    List<Pro_Per_Cur_Asig> listaMultitablas=multitablaRepository.listar();
    
    
    public AdministrarMatriculas() {
        initComponents();
        
        setSize(1000, 600); // Tamaño mediano
        jtfCodigoDepartamento.setVisible(false);
        jbActualizar.setVisible(false);
        jbRegistrar.setVisible(true);
        
        actualizarListas();
        rellenarEstudiantes();
        rellenarProgramas();
        rellenarAsignaturas();
        
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
        jcbEstudiantes = new javax.swing.JComboBox<>();
        jcbIdEstudiante = new javax.swing.JComboBox<>();
        jcbProgramas = new javax.swing.JComboBox<>();
        jcbAsignaturas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

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
        jLabel3.setText("Aquí podrá registrar y actualizar Matriculas");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 380, 40));

        jLabel4.setBackground(new java.awt.Color(242, 242, 150));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("digite numero de un Matricula para ver si existe");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 400, 40));

        jcbEstudiantes.setBackground(new java.awt.Color(166, 181, 167));
        jcbEstudiantes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbEstudiantes.setForeground(new java.awt.Color(255, 255, 255));
        jcbEstudiantes.setMaximumRowCount(5);
        jcbEstudiantes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Estudiantes Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jcbEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbEstudiantes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbEstudiantesFocusGained(evt);
            }
        });
        jcbEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstudiantesActionPerformed(evt);
            }
        });
        add(jcbEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 40));

        jcbIdEstudiante.setBackground(new java.awt.Color(166, 181, 167));
        jcbIdEstudiante.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbIdEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        jcbIdEstudiante.setMaximumRowCount(5);
        jcbIdEstudiante.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Id Estudiante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jcbIdEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbIdEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdEstudianteActionPerformed(evt);
            }
        });
        add(jcbIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 100, 40));

        jcbProgramas.setBackground(new java.awt.Color(166, 181, 167));
        jcbProgramas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbProgramas.setForeground(new java.awt.Color(255, 255, 255));
        jcbProgramas.setMaximumRowCount(5);
        jcbProgramas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Programas Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jcbProgramas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProgramasActionPerformed(evt);
            }
        });
        add(jcbProgramas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 310, 40));

        jcbAsignaturas.setBackground(new java.awt.Color(166, 181, 167));
        jcbAsignaturas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbAsignaturas.setForeground(new java.awt.Color(255, 255, 255));
        jcbAsignaturas.setMaximumRowCount(5);
        jcbAsignaturas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Asignaturas Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jcbAsignaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAsignaturasActionPerformed(evt);
            }
        });
        add(jcbAsignaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 210, 40));

        jButton1.setText("Actualizar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarListas(){
        listaProgramas=programarepository.listar();
        listaAsignaturas=asignaturaRepository.listar();
        listaPersonas=personaRepository.listar();
        listaEstudiantes=estudianteRepository.listar();
        listaMatriculas=matriculaRepository.listar();
        listaHorarios=horarioRepository.listar();
    }
    
    private void rellenarEstudiantes(){
        jcbEstudiantes.removeAllItems();
        
        String nombre;
        
        for (Persona p : listaPersonas) {
            
            for (Estudiante e : listaEstudiantes) {
                if(e.getPersona_id()==p.getId()){
                    nombre=p.getNombre()+" "+p.getApellido();
                    jcbEstudiantes.addItem(nombre);
                }

            }
        }
    }
    
    private void rellenarIdEstudiantes(){
        jcbIdEstudiante.removeAllItems();
        String nombre_seleccionado=(String) jcbEstudiantes.getSelectedItem();
        String nombre_comparativo;
        int codigo_persona=0;
        for (Persona p : listaPersonas) {
            nombre_comparativo=p.getNombre()+" "+p.getApellido();
            if(nombre_seleccionado.equals(nombre_comparativo)){
                codigo_persona=p.getId();
            }
        }
        
        for (Estudiante e : listaEstudiantes) {
            if(e.getPersona_id()==codigo_persona){
                jcbIdEstudiante.addItem(String.valueOf( e.getEstudiante_id()));
            }
        }
    }
    
    private void rellenarProgramas(){
        jcbProgramas.removeAllItems();
        for (Programa p : listaProgramas) {
            jcbProgramas.addItem(p.getNombre());
        }
    }
    
    private void rellenarAsignaturas(){
        actualizarListas();
        jcbAsignaturas.removeAllItems();
        String nombre_programa_seleccionado=(String) jcbProgramas.getSelectedItem();
        TreeSet<Integer> listaIdAsignaturas = new TreeSet<>();
        int codigo_programa=0;
        for (Programa p : listaProgramas) {
            if(nombre_programa_seleccionado.equals(p.getNombre())){
                codigo_programa=p.getPrograma_id();
            }
        }
        for (Pro_Per_Cur_Asig m : listaMultitablas) {
            if(codigo_programa==m.getPrograma_id()){
                listaIdAsignaturas.add(m.getAsignatura_id());
            }
        }
        
        for (Asignatura a : listaAsignaturas) {
            for (Integer IdAsignatura : listaIdAsignaturas) {
                if(a.getAsignatura_id()==IdAsignatura){
                    jcbAsignaturas.addItem(a.getNombre_combinado());
                }
            }
        }

    }
    
    private int codigo_programa(){
        String nombre_programa=(String)jcbProgramas.getSelectedItem();
        int codigo_programa=0;
        for (Programa p : listaProgramas) {
            if(nombre_programa.equals(p.getNombre())){
                codigo_programa=p.getPrograma_id();
                break;
            }
        }
        return codigo_programa;
    }
    
    private int codigo_asignatura(){
        int codigo_asignatura=0;
        String nombre_asignatura=(String)jcbAsignaturas.getSelectedItem();
        System.out.println("nombre asignatura: "+nombre_asignatura);
        for (Asignatura a : listaAsignaturas) {
            System.out.println("Entro a la lista de las asignaturas");
            if(a.getNombre_combinado().equals(nombre_asignatura)){
                codigo_asignatura=a.getAsignatura_id();
                return codigo_asignatura;
            }
        }
        return codigo_asignatura;
    }
    
    private int codigo_estudiante(){
        int codigo_estudiante=0;
        String nombre_obtenido=(String) jcbEstudiantes.getSelectedItem();
        String nombre;
        
        for (Persona p : listaPersonas) {
            for (Estudiante e : listaEstudiantes) {
                nombre=p.getNombre()+" "+p.getApellido();
                if(nombre.equals(nombre_obtenido)){
                    codigo_estudiante=e.getEstudiante_id();
                }
            }
        }
        return codigo_estudiante;
    }
    
    private Matricula datosMatricula(){
        actualizarListas();
        Matricula m=new Matricula();
        int codigo_programa=codigo_programa();
        String codigo_estudiante1=(String) jcbIdEstudiante.getSelectedItem();
        int codigo_estudiante=Integer.parseInt(codigo_estudiante1);
        m.setAlumno_id(codigo_estudiante);
        m.setPrograma_id(codigo_programa);
        System.out.println("***Datos Matricula***");
        System.out.println("codigo del estudiante: "+codigo_estudiante);
        System.out.println("codigo del programa: "+codigo_programa);
        return m;
    }
    
    private Horario datosHorario(){
        actualizarListas();
        Horario h=new Horario();
        int codigo_asignatura=codigo_asignatura(),id_ultimo=0;
        if (!listaAsignaturas.isEmpty()) {
            Asignatura ultimaAsignatura = listaAsignaturas.get(listaAsignaturas.size() - 1);
            id_ultimo=ultimaAsignatura.getSalon_id();
        } else {
            JOptionPane.showMessageDialog(null, "Datos Incompletos");
        }
        h.setAsignatura_id(codigo_asignatura);
        h.setMatricula_id(id_ultimo);
        System.out.println("**Datos Horarios**");
        System.out.println("Codigo de la aignatura: "+codigo_asignatura);
        System.out.println("Codigo de la matricula: "+id_ultimo);
        return h;
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
        matriculaRepository.guardar(datosMatricula());
        horarioRepository.guardar(datosHorario());
        JOptionPane.showMessageDialog(null, "Datos guardados");
        
    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
//        salonRepository.modificar(datosSalon());
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

    private void jcbEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstudiantesActionPerformed
        // TODO add your handling code here:
        actualizarListas();
        rellenarIdEstudiantes();
    }//GEN-LAST:event_jcbEstudiantesActionPerformed

    private void jcbIdEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbIdEstudianteActionPerformed

    private void jcbProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProgramasActionPerformed
        // TODO add your handling code here:
        actualizarListas();
        rellenarAsignaturas();
    }//GEN-LAST:event_jcbProgramasActionPerformed

    private void jcbAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAsignaturasActionPerformed
        // TODO add your handling code here:
        actualizarListas();
        rellenarAsignaturas();
    }//GEN-LAST:event_jcbAsignaturasActionPerformed

    private void jcbEstudiantesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbEstudiantesFocusGained
        // TODO add your handling code here:
//        actualizarListas();
//        rellenarEstudiantes();
    }//GEN-LAST:event_jcbEstudiantesFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        actualizarListas();
        rellenarEstudiantes();
//        rellenarIdEstudiantes();
        rellenarProgramas();
        rellenarAsignaturas();
        JOptionPane.showMessageDialog(null, "Datos actualizados");
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JComboBox<String> jcbAsignaturas;
    private javax.swing.JComboBox<String> jcbEstudiantes;
    private javax.swing.JComboBox<String> jcbIdEstudiante;
    private javax.swing.JComboBox<String> jcbProgramas;
    private javax.swing.JComboBox<String> jcbSeleccion;
    private javax.swing.JTextField jtfCodigoDepartamento;
    // End of variables declaration//GEN-END:variables
}