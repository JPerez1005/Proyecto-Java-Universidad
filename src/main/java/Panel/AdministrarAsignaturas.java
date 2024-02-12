package Panel;

import Model.Asignatura;
import Model.Curso;
import Model.Departamento;
import Model.Periodo;
import Model.Persona;
import Model.Pro_Per_Cur_Asig;
import Model.Profesor;
import Model.Programa;
import Model.Salon;
import Repository.AsignaturaImpl;
import Repository.CursoImpl;
import Repository.DepartamentoImpl;
import Repository.PeriodoImpl;
import Repository.PersonaImpl;
import Repository.Pro_Per_Cur_AsigImpl;
import Repository.ProfesorImpl;
import Repository.ProgramaImpl;
import Repository.Repository;
import Repository.SalonImpl;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.event.ItemEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import raven.datetime.component.time.TimeEvent;
import raven.datetime.component.time.TimeSelectionListener;

/**
 * @Julián
 */
public class AdministrarAsignaturas extends javax.swing.JPanel {
    
    private static final Repository departamentoRepository= new DepartamentoImpl();
    private static final Repository programaRepository=new ProgramaImpl();
    private static final Repository cursoRepository=new CursoImpl();
    private static final Repository periodoRepository=new PeriodoImpl();
    private static final Repository multitablasRepository=new Pro_Per_Cur_AsigImpl();
    private static final Repository profesorRepository=new ProfesorImpl();
    private static final Repository personasRepository=new PersonaImpl();
    private static final Repository asignaturaRepository=new AsignaturaImpl();
    private static final Repository salonRepository= new SalonImpl();
    List<Salon> listaSalones=salonRepository.listar();
    List<Persona> listaPersonas=personasRepository.listar();
    List<Departamento> listaDepartamentos=departamentoRepository.listar();
    List<Programa> listaProgramas=programaRepository.listar();
    List<Curso> listaCursos=cursoRepository.listar();
    List<Pro_Per_Cur_Asig> listaMultitablas=multitablasRepository.listar();
    List<Periodo> listaPeriodos=periodoRepository.listar();
    List<Profesor> listaProfesores=profesorRepository.listar();
    List<Asignatura> listaAsignaturas=asignaturaRepository.listar();
    
    public AdministrarAsignaturas() {
        initComponents();
        
        setSize(1000, 600); // Tamaño mediano
        jtfCodigoDepartamento.setVisible(false);
        jbActualizar.setVisible(false);
        jbRegistrar.setVisible(true);
        
        jcbSemestre.setVisible(true);
        jcbCursos.setVisible(false);
        jcbSalones.setVisible(false);
        for (Programa programa : listaProgramas) {
            jcbProgramas.addItem(programa.getNombre());
        }
        
        
        
        timePicker.setEditor(jftfPrueba);
        timePicker.now();
        timePicker.setOrientation(SwingConstants.HORIZONTAL);
        timePicker.addTimeSelectionListener(new TimeSelectionListener(){
            @Override
            public void timeSelected(TimeEvent te){
                DateTimeFormatter df=DateTimeFormatter.ofPattern("hh:mm a");
                System.out.println(timePicker.getSelectedTime());
                LocalTime selectedTime = timePicker.getSelectedTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // Definir el formato deseado
                String formattedTime = selectedTime.format(formatter); // Convertir el LocalTime a String con el formato definido
                jftfEditorReloj.setText(formattedTime); // Establecer el texto en el JFormattedTextField
                
            }
        });
        jftfEditorReloj.setEditable(false);
        
        
        JComponent editor = jsCupos.getEditor();
        if (editor instanceof DefaultEditor defaultEditor) {
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

        timePicker = new raven.datetime.component.time.TimePicker();
        jcbSeleccion = new javax.swing.JComboBox<>();
        jbRegistrar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jtfCodigoDepartamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNombreAsignatura = new javax.swing.JTextField();
        jcbSemestre = new javax.swing.JComboBox<>();
        jcbProgramas = new javax.swing.JComboBox<>();
        jcbCursos = new javax.swing.JComboBox<>();
        jcbCreditos = new javax.swing.JComboBox<>();
        jftfEditorReloj = new javax.swing.JFormattedTextField();
        jftfPrueba = new javax.swing.JFormattedTextField();
        jsCupos = new javax.swing.JSpinner();
        jcbDiaSemana = new javax.swing.JComboBox<>();
        jcbProfesores = new javax.swing.JComboBox<>();
        jcbSalones = new javax.swing.JComboBox<>();

        timePicker.setEditor(jftfEditorReloj);

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbSeleccion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbSeleccion.setForeground(new java.awt.Color(255, 255, 254));
        jcbSeleccion.setMaximumRowCount(5);
        jcbSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrar", "Modificar" }));
        jcbSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 254)), "Que desea hacer?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jcbSeleccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionActionPerformed(evt);
            }
        });
        add(jcbSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 330, 169, 40));

        jbRegistrar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(255, 255, 254));
        jbRegistrar.setText("Registrar");
        jbRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(178, 144, 73), java.awt.Color.black, java.awt.Color.lightGray));
        jbRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });
        add(jbRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 100, 30));

        jbActualizar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(255, 255, 254));
        jbActualizar.setText("Actualizar");
        jbActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(178, 144, 73), java.awt.Color.black, java.awt.Color.lightGray));
        jbActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });
        add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 100, 30));

        jtfCodigoDepartamento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jtfCodigoDepartamento.setForeground(new java.awt.Color(255, 255, 254));
        jtfCodigoDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 254)), "Codigo de la Asignatura", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
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
        jLabel3.setText("Aquí podrá registrar y actualizar Asignaturas");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 380, 40));

        jLabel4.setBackground(new java.awt.Color(242, 242, 150));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("digite numero de Asignaturas para ver si existe");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 400, 40));

        jtfNombreAsignatura.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtfNombreAsignatura.setForeground(new java.awt.Color(255, 255, 254));
        jtfNombreAsignatura.setToolTipText("");
        jtfNombreAsignatura.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 254)), "Nombre de la Asignatura", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jtfNombreAsignatura.setOpaque(true);
        add(jtfNombreAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 160, -1));

        jcbSemestre.setBackground(new java.awt.Color(166, 181, 167));
        jcbSemestre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbSemestre.setForeground(new java.awt.Color(0, 0, 1));
        jcbSemestre.setMaximumRowCount(5);
        jcbSemestre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Semestre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(0, 0, 1))); // NOI18N
        jcbSemestre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbSemestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSemestreItemStateChanged(evt);
            }
        });
        jcbSemestre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbSemestreFocusGained(evt);
            }
        });
        jcbSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSemestreActionPerformed(evt);
            }
        });
        add(jcbSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 80, 40));

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
        add(jcbProgramas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 220, 40));

        jcbCursos.setBackground(new java.awt.Color(166, 181, 167));
        jcbCursos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbCursos.setForeground(new java.awt.Color(0, 0, 1));
        jcbCursos.setMaximumRowCount(5);
        jcbCursos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Cursos Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(0, 0, 1))); // NOI18N
        jcbCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCursosActionPerformed(evt);
            }
        });
        add(jcbCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 220, 40));

        jcbCreditos.setBackground(new java.awt.Color(166, 181, 167));
        jcbCreditos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbCreditos.setForeground(new java.awt.Color(0, 0, 1));
        jcbCreditos.setMaximumRowCount(5);
        jcbCreditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        jcbCreditos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Creditos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(0, 0, 1))); // NOI18N
        jcbCreditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCreditosActionPerformed(evt);
            }
        });
        add(jcbCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, 70, 40));

        jftfEditorReloj.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 254)), "Hora de inicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jftfEditorReloj.setForeground(new java.awt.Color(255, 255, 254));
        jftfEditorReloj.setCaretColor(new java.awt.Color(255, 255, 255));
        jftfEditorReloj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftfEditorRelojFocusGained(evt);
            }
        });
        jftfEditorReloj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfEditorRelojActionPerformed(evt);
            }
        });
        add(jftfEditorReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 130, 40));
        add(jftfPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 152, 30, 30));

        jsCupos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jsCupos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 127, 1));
        jsCupos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Cupos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N
        jsCupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jsCupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, 40));

        jcbDiaSemana.setBackground(new java.awt.Color(166, 181, 167));
        jcbDiaSemana.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbDiaSemana.setForeground(new java.awt.Color(0, 0, 1));
        jcbDiaSemana.setMaximumRowCount(7);
        jcbDiaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" }));
        jcbDiaSemana.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Día de la semana", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(0, 0, 1))); // NOI18N
        jcbDiaSemana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbDiaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDiaSemanaActionPerformed(evt);
            }
        });
        add(jcbDiaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 120, 40));

        jcbProfesores.setBackground(new java.awt.Color(166, 181, 167));
        jcbProfesores.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbProfesores.setForeground(new java.awt.Color(255, 255, 255));
        jcbProfesores.setMaximumRowCount(5);
        jcbProfesores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Profesores Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 255, 254))); // NOI18N
        jcbProfesores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProfesoresActionPerformed(evt);
            }
        });
        add(jcbProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 220, 40));

        jcbSalones.setBackground(new java.awt.Color(166, 181, 167));
        jcbSalones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcbSalones.setForeground(new java.awt.Color(0, 0, 1));
        jcbSalones.setMaximumRowCount(7);
        jcbSalones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Salones Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(0, 0, 1))); // NOI18N
        jcbSalones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSalonesActionPerformed(evt);
            }
        });
        add(jcbSalones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarListas(){
        listaProgramas=programaRepository.listar();
        listaMultitablas=multitablasRepository.listar();
        listaPeriodos=periodoRepository.listar();
        listaCursos=cursoRepository.listar();
        listaProfesores=profesorRepository.listar();
        listaAsignaturas=asignaturaRepository.listar();
        listaSalones=salonRepository.listar();
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
    
    private int codigo_periodo(){
        TreeSet<Integer> listaIdPeriodos = new TreeSet<>();
        int codigo_periodo=0,codigo_programa=codigo_programa();
        String semestreString = (String) jcbSemestre.getSelectedItem();
        int semestreInt = Integer.parseInt(semestreString);
        byte numero_semestre = (byte) semestreInt;
        for (Periodo periodo : listaPeriodos) {
            if(periodo.getPeriodo_numero_semestre()==numero_semestre){
                listaIdPeriodos.add(periodo.getPeriodo_id());
            }
        }
        for (Pro_Per_Cur_Asig m : listaMultitablas) {
            for (Integer IdPeriodo : listaIdPeriodos) {
                if(m.getPrograma_id()==codigo_programa && IdPeriodo==m.getPeriodo_id()){
                    codigo_periodo=m.getPeriodo_id();
                }
            }
        }
        return codigo_periodo;
    }
    
    private int codigo_curso(){
        String nombre_curso=(String)jcbCursos.getSelectedItem();
        int codigo_curso=0;
        for (Curso c : listaCursos) {
            if(c.getCurso_nombre().equals(nombre_curso)){
                codigo_curso=c.getCurso_id();
                break;
            }
        }
        return codigo_curso;
    }
    
    private int codigo_salon(byte cupos){
        String nombre_salon=(String)jcbSalones.getSelectedItem();
        int codigo_salon=0;
        boolean encontrado=false;
        for (Salon s : listaSalones) {
            if(s.getNumero_especifico().equals(nombre_salon) && s.getCapacidad_alumnos()>=cupos){
                codigo_salon=s.getSalon_id();
                encontrado=true;
                break;
            }
        }
        
        if(!encontrado){
            JOptionPane.showMessageDialog(null, "Salón no encontrado\n"
                    + ",tal vez superó la cantidad de cupos,"
                    + "\nno se guardó asignatura.");
        }
        return codigo_salon;
    }
    
    private Asignatura datosAsignatura(){
        actualizarListas();
        
        Asignatura asignatura=new Asignatura();
        String nombre_asignatura=jtfNombreAsignatura.getText();
        
        Number cuposNumber = (Number) jsCupos.getValue();
        int cuposInt = cuposNumber.intValue();
        byte cupos = (byte) cuposInt;
        
        int codigo_programa=codigo_programa(),
                codigo_periodo=codigo_periodo(),
                codigo_curso=codigo_curso(),
                codigo_profesor=0,
                codigo_persona=0,
                codigo_salon=codigo_salon(cupos);
        
        if(codigo_salon==0){
            System.out.println("Salón no encontrado o supero cantidad de cupos");
            return null;
        }
        
        String nombre_completo="PR-"+codigo_programa+"-C-"+codigo_curso+"-PER-"+codigo_periodo+"-"+nombre_asignatura;
        LocalTime selectedTime = timePicker.getSelectedTime();
        asignatura.setHora_inicio(selectedTime);
        
        selectedTime= selectedTime.plusHours(1).plusMinutes(30);//agregamos hora y media
        asignatura.setHora_fin(selectedTime);
        
        String nombre_profesor=(String) jcbProfesores.getSelectedItem();
        for (Persona p : listaPersonas) {
            if(nombre_profesor.equals(p.getNombre())){
                codigo_persona=p.getId();
            }
        }
        for (Profesor p : listaProfesores) {
            if(p.getPersona_id()==codigo_persona){
                codigo_profesor=p.getProfesor_id();
            }
        }
        String dia_semana=(String) jcbDiaSemana.getSelectedItem();
        
        String creditosString = (String) jcbCreditos.getSelectedItem();
        int creditosInt = Integer.parseInt(creditosString);
        byte creditos = (byte) creditosInt;

        asignatura.setCupos_disponibles(cupos);
        asignatura.setCreditos(creditos);
        asignatura.setNombre_combinado(nombre_completo);
        asignatura.setDia_semana(dia_semana);
        asignatura.setProfesor_id(codigo_profesor);
        asignatura.setSalon_id(codigo_salon);
        //Hora de inicio
        //Hora de fin
        //cupos disponibles
        //creditos
        //nombre combinado
        //dia de la semana
        //codigo profesor
        //codigo salon
        return asignatura;
    }
    
    private Pro_Per_Cur_Asig datosMultitabla(){
        actualizarListas();
        Pro_Per_Cur_Asig m=new Pro_Per_Cur_Asig();

        int codigoPrograma=codigo_programa(),
                codigoCurso=codigo_curso(),
                codigoPeriodo=codigo_periodo(),
                codigoAsignatura=0;
        
        for (int i = listaAsignaturas.size()-1; i >= 0; i--) {
            Asignatura asignatura = listaAsignaturas.get(i);
            codigoAsignatura=asignatura.getAsignatura_id();
            break;
        }
        m.setCurso_id(codigoCurso);
        m.setPeriodo_id(codigoPeriodo);
        m.setPrograma_id(codigoPrograma);
        m.setAsignatura_id(codigoAsignatura);
        return m;
    }
    
    private void rellenarSemestres(){
        actualizarListas();
        String programa_seleccionado=(String) jcbProgramas.getSelectedItem();
        int codigo_programa=0;
        jcbSemestre.removeAllItems();
        TreeSet<Integer> listaIdPeriodos = new TreeSet<>();
        if(programa_seleccionado!=null){
            for (Programa programa : listaProgramas) {
                if(programa_seleccionado.equals(programa.getNombre())){
                    codigo_programa=programa.getPrograma_id();
                }
            }
            for (Pro_Per_Cur_Asig multi : listaMultitablas) {
                if(codigo_programa==multi.getPrograma_id()){
                    listaIdPeriodos.add(multi.getPeriodo_id());
                }
            }
            
            for (Periodo periodo : listaPeriodos) {
                for (Integer IdPeriodo : listaIdPeriodos) {
                    if (IdPeriodo.equals(periodo.getPeriodo_id())) {
                        jcbSemestre.addItem(String.valueOf(periodo.getPeriodo_numero_semestre()));
                    }
                }
            }
        }else if(programa_seleccionado==null){
            jcbSemestre.setVisible(false);
        }
    }
    
    private void rellenarCursos() {
        actualizarListas();
        HashSet<String> uniqueItems=new HashSet<>();
        String programa_seleccionado = (String) jcbProgramas.getSelectedItem();
        // Obtener el valor seleccionado del JComboBox como String
        String periodoSeleccionadoStr = (String) jcbSemestre.getSelectedItem();
        
        jcbCursos.removeAllItems();
        // Verificar si el valor seleccionado no es null antes de convertirlo a int
        if (periodoSeleccionadoStr != null) {
            // Convertir el valor String a int
            int periodoSeleccionadoInt = Integer.parseInt(periodoSeleccionadoStr);
            // Convertir el valor int a byte
            byte periodo_seleccionado = (byte) periodoSeleccionadoInt;

            int codigo_programa = 0, codigo_periodo = 0;
            TreeSet<Integer> listaIdCursos = new TreeSet<>();
            TreeSet<Integer> listaIdPeriodos = new TreeSet<>();

            for (Programa programa : listaProgramas) {
                if (programa_seleccionado.equals(programa.getNombre())) {
                    codigo_programa = programa.getPrograma_id();
                }
            }
            for (Periodo periodo : listaPeriodos) {
                if (periodo_seleccionado == periodo.getPeriodo_numero_semestre()) {
                    codigo_periodo = periodo.getPeriodo_id();
                    listaIdPeriodos.add(codigo_periodo);
                }
            }
            for (Pro_Per_Cur_Asig multi : listaMultitablas) {
                for (Integer IdPeriodo : listaIdPeriodos) {
                    if (codigo_programa == multi.getPrograma_id() && IdPeriodo == multi.getPeriodo_id()) {
                        listaIdCursos.add(multi.getCurso_id());
                    }
                }
            }

            for (Curso curso : listaCursos) {
                for (Integer idCurso : listaIdCursos) {
                    if (idCurso == curso.getCurso_id()) {
                        uniqueItems.add(String.valueOf(curso.getCurso_nombre()));
                        
                    }
                }
            }
            
            for (String uniqueItem : uniqueItems) {
                jcbCursos.addItem(uniqueItem);
            }
        }
    }

    private void rellenarProfesores(){
        actualizarListas();
        int codDepartamento=0;
        String nombreCurso=(String) jcbCursos.getSelectedItem();
        TreeSet<Integer> listaIdPersonas = new TreeSet<>();
        jcbProfesores.removeAllItems();
        for (Curso curso : listaCursos) {
            if(nombreCurso.equals(curso.getCurso_nombre())){
                codDepartamento=curso.getDepartamento_id();
            }
        }
        
        for (Profesor p : listaProfesores) {
            if(codDepartamento==p.getDepartamento_id()){
                listaIdPersonas.add(p.getPersona_id());
            }
        }
        
        for (Persona persona : listaPersonas) {
            for (Integer IdPersona : listaIdPersonas) {
                if(IdPersona==persona.getId()){
                    jcbProfesores.addItem(persona.getNombre());
                }
            }
        }
        
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
        
        asignaturaRepository.guardar(datosAsignatura());
        multitablasRepository.guardar(datosMultitabla());
        JOptionPane.showMessageDialog(null, "Datos guardados");
        
    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        cursoRepository.modificar(datosAsignatura());//falta el id que hay que modificar
//        lecturaModalCurso();
        JOptionPane.showMessageDialog(null, "Datos modificados");

    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jtfCodigoDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoDepartamentoActionPerformed

    private void jtfCodigoDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoDepartamentoKeyReleased
        
        if(jtfCodigoDepartamento.getText().equals("")){
//            jifDatosDepartamento.setVisible(false);
        }else{
//            lecturaModalCurso();
        }
        
        
    }//GEN-LAST:event_jtfCodigoDepartamentoKeyReleased

    private void jcbSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSemestreActionPerformed
        jcbCursos.setVisible(true);
        rellenarCursos();
    }//GEN-LAST:event_jcbSemestreActionPerformed

    private void jcbProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProgramasActionPerformed
        // TODO add your handling code here:
        rellenarSemestres();
    }//GEN-LAST:event_jcbProgramasActionPerformed

    private void jcbCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCursosActionPerformed
        // TODO add your handling code here:
        rellenarProfesores();
    }//GEN-LAST:event_jcbCursosActionPerformed

    private void jcbCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCreditosActionPerformed
        // TODO add your handling code here:
        actualizarListas();
        jcbSalones.removeAllItems();
        jcbSalones.setVisible(true);
        for (Salon s : listaSalones) {
            jcbSalones.addItem(s.getNumero_especifico());
        }
    }//GEN-LAST:event_jcbCreditosActionPerformed

    private void jftfEditorRelojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfEditorRelojActionPerformed
        // TODO add your handling code here:
        System.out.println(jftfEditorReloj.getText());
    }//GEN-LAST:event_jftfEditorRelojActionPerformed

    private void jftfEditorRelojFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfEditorRelojFocusGained
        // TODO add your handling code here:
        System.out.println(jftfEditorReloj.getText());
    }//GEN-LAST:event_jftfEditorRelojFocusGained

    private void jcbDiaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDiaSemanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDiaSemanaActionPerformed

    private void jcbProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProfesoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbProfesoresActionPerformed

    private void jcbSemestreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbSemestreFocusGained
        // TODO add your handling code here:
//        jcbCursos.setVisible(true);
//        rellenarCursos();
    }//GEN-LAST:event_jcbSemestreFocusGained

    private void jcbSemestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSemestreItemStateChanged
        // TODO add your handling code here:

//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            jcbCursos.setVisible(true);
//            rellenarCursos();          
//        }
    }//GEN-LAST:event_jcbSemestreItemStateChanged

    private void jcbSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSalonesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSalonesActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JComboBox<String> jcbCreditos;
    private javax.swing.JComboBox<String> jcbCursos;
    private javax.swing.JComboBox<String> jcbDiaSemana;
    private javax.swing.JComboBox<String> jcbProfesores;
    private javax.swing.JComboBox<String> jcbProgramas;
    private javax.swing.JComboBox<String> jcbSalones;
    private javax.swing.JComboBox<String> jcbSeleccion;
    private javax.swing.JComboBox<String> jcbSemestre;
    private javax.swing.JFormattedTextField jftfEditorReloj;
    private javax.swing.JFormattedTextField jftfPrueba;
    private javax.swing.JSpinner jsCupos;
    private javax.swing.JTextField jtfCodigoDepartamento;
    private javax.swing.JTextField jtfNombreAsignatura;
    private raven.datetime.component.time.TimePicker timePicker;
    // End of variables declaration//GEN-END:variables
}