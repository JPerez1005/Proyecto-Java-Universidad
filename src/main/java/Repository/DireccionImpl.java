package Repository;

/**
 * @author Julián <Julián at Google>
 */
import Model.*;
import Util.Conexion;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class DireccionImpl implements Repository<Direccion>{
    
    private static final Repository ciudadRepository= new CiudadImpl();
    
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Direccion crearDireccion(ResultSet rs) throws SQLException{
        Direccion direccion=new Direccion();
        direccion.setDirecion_id(rs.getInt("id"));
        direccion.setTipo(rs.getString("tipo"));
        direccion.setNumero(rs.getString("numero"));
        
        int ciudadId = rs.getInt("ciudad_id");
        Ciudad ciudad = (Ciudad) ciudadRepository.porCodigo(ciudadId); // Suponiendo que tengas un repositorio de ciudades
        direccion.setCiudad(ciudad);
        // Otra opción sería asignar solo el ID de la ciudad y luego obtener la ciudad completa cuando sea necesario

        return direccion;
    }

    @Override
    public List<Direccion> listar() {
        List<Direccion> listaDirecciones = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM direccion")) {
            while (rs.next()) {
                listaDirecciones.add(crearDireccion(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaDirecciones;
    }

    @Override
    public Direccion porCodigo(int id) {
        Direccion direccion = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Direccion WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                direccion = crearDireccion(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return direccion;
    }

    @Override
    public void guardar(Direccion entidad) {
        String sql = "INSERT INTO Direccion(tipo, numero, ciudad_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, entidad.getTipo());
            stmt.setString(2, entidad.getNumero());
            stmt.setInt(3, entidad.getCiudad().getCiudad_id());
            System.out.println(entidad.getCiudad().getCiudad_id()+" este es el id de la ciudad");
            System.out.println(entidad.getDirecion_id()+" esta es la direccion id");

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar la dirección, no se modificaron filas.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al guardar la dirección.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Direccion WHERE id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al eliminar la dirección, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al eliminar la dirección.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void modificar(Direccion entidad) {
        String sql = "UPDATE Direccion SET tipo = ?, numero = ?, ciudad_id = ? WHERE id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, entidad.getTipo());
            stmt.setString(2, entidad.getNumero());
            stmt.setInt(3, entidad.getCiudad().getCiudad_id());
            stmt.setInt(4, entidad.getDirecion_id());
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la dirección, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al modificar la dirección.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
