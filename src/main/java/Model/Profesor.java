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
public class Profesor extends Persona {
    private int profesor_id;
    private int departamento_id;
    private int persona_id;
}
