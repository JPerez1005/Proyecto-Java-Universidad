package Model;

import java.time.LocalDate;

/**
 * @author Julián <Julián at Google>
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaCompleta {
    private int personaId;
    private String tipoDocumento;
    private int numeroDocumento;
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String genero;
    private int direccionId;
    private String tipoDireccion;
    private String numeroDireccion;
    private int ciudadId;
    private String nombreCiudad;
}
