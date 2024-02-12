package Model;

import java.time.LocalDateTime;

/**
 * @author Julián <Julián at Google>
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horario {
    private int id;
    private int asignatura_id;
    private int matricula_id;
}
