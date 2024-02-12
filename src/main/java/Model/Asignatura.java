package Model;

/**
 * @author Julián <Julián at Google>
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura extends Curso{
    private int asignatura_id;
    private String nombre_combinado;
    private int creditos;
    private byte cupos_disponibles;
    private String dia_semana;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private int profesor_id;
    private int salon_id;
}
