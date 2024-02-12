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

public class Persona {
    private int id;
    private String tipo_documento;
    private int numero_documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fecha_nacimiento;
    private String genero;
    private Direccion direccion;
}
