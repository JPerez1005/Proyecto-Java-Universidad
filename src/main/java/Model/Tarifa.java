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
public class Tarifa{
    private int id;
    private double costo_credito;
    private int periodo_id;
    private int programa_id;
}
