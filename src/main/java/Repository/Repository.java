package Repository;

import java.util.List;

/**
 * @author Julián <Julián at Google>
 */
public interface Repository<T> {
    List<T> listar();

    T porCodigo(int id);

    void guardar(T entidad);

    void eliminar(int id);
    
    void modificar(T entidad);
}
