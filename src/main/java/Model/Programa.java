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
public class Programa {
    private int programa_id;
    private String nombre;
    private String nivel;
    private byte cantidad_semestres;
}
