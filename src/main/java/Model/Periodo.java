package Model;

/**
 * @author Julián <Julián at Google>
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Periodo extends Programa{
    private int periodo_id;
    private String periodo_codigo;
    private short periodo_anio;
    private byte periodo_numero_semestre;
}
