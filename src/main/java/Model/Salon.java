package Model;

/**
 * @author Julián <Julián at Google>
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salon{
    private int salon_id;
    private byte capacidad_alumnos;
    private byte piso;
    private String numero_especifico;
    private String nombre_edificio;
}
