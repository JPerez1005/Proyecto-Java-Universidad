package Repository;

/**
 * @author Julián <Julián at Google>
 */
import Model.Ciudad;
import Model.Persona;
import Util.Conexion;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CiudadImpl implements Repository<Ciudad>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Ciudad crearCiudad(ResultSet rs) throws SQLException {
        Ciudad ciudad = new Ciudad();
        ciudad.setCiudad_id(rs.getInt("id"));
        ciudad.setCiudad_nombre(rs.getString("nombre"));
        return ciudad;
    }
    
    @Override
    public List<Ciudad> listar() {
        List<Ciudad> listaCiudades = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ciudad ")) {
            while (rs.next()) {
                listaCiudades.add(crearCiudad(rs));
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

        return listaCiudades;
    }

    @Override
    public Ciudad porCodigo(int id) {
        Ciudad ciudad = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Ciudad WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ciudad = crearCiudad(rs);
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

        return ciudad;
    }

    @Override
    public void guardar(Ciudad entidad) {
        String sql;
        if (entidad.getCiudad_id()> 0) {
            // Si la entidad tiene un ID válido, se realiza una actualización
            sql = "UPDATE Ciudad\n" +
                  "SET nombre = ?\n" +
                  "WHERE id = ?;";
        } else {
            // Si la entidad no tiene un ID válido, se realiza una inserción
            sql = "INSERT INTO Ciudad(nombre) VALUES (?);";
        }

        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, entidad.getCiudad_nombre());

            if (entidad.getCiudad_id() > 0) {
                // Si la entidad ya tiene un ID, se establece el parámetro de actualización
                stmt.setInt(2, entidad.getCiudad_id());
            }

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar la ciudad, no se modificaron filas.");
            }

            if (entidad.getCiudad_id() <= 0) {
                // Si la entidad no tenía un ID previo, se obtiene el ID generado
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        entidad.setCiudad_id(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Fallo al guardar la ciudad, no se obtuvo el ID generado.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al guardar la ciudad.");
            e.printStackTrace();
        }finally {
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
    }

    @Override
    public void modificar(Ciudad entidad) {
        String sql = "UPDATE Ciudad\n" +
                        "SET nombre = ?\n" +
                        "WHERE id = ?;";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, entidad.getCiudad_nombre());
            stmt.setInt(2, entidad.getCiudad_id());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la ciudad, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al modificar la ciudad.");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
