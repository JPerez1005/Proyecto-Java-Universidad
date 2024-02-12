    package Model;

    /**
     * @author Julián <Julián at Google>
     */

    import java.time.LocalDate;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.NoArgsConstructor;

    @Data
    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor
    @NoArgsConstructor

    public class Estudiante extends Persona{
        private int estudiante_id;
        private int persona_id;

//    public Estudiante(int estudiante_id, int id, String tipo_documento, int numero_documento, String nombre, String apellido, String telefono, LocalDate fecha_nacimiento, String genero, Direccion direccion) {
//        super(id, tipo_documento, numero_documento, nombre, apellido, telefono, fecha_nacimiento, genero, direccion);
//        this.estudiante_id = estudiante_id;
//    }
        
        
    }
