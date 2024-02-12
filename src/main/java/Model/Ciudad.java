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
public class Ciudad{
    private int ciudad_id;
    private String ciudad_nombre;
}
