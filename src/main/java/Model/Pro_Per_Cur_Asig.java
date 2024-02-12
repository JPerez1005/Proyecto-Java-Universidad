package Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pro_Per_Cur_Asig {
    private int id_Pro_Per_Cur_Asig;
    private int programa_id;
    private int periodo_id;
    private int curso_id;
    private int asignatura_id;
}
